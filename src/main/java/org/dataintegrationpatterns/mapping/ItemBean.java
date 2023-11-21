package org.dataintegrationpatterns.mapping;

import org.apache.camel.ValidationException;
import org.dataintegrationpatterns.model.edm.*;
import org.dataintegrationpatterns.model.erp.Item;
import org.dataintegrationpatterns.repo.EDMRepo;
import org.javamoney.moneta.Money;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component("itemBean")
public class ItemBean {

    public SalesOrderLineItem processProduct(Item item) throws ValidationException {

        System.out.println("*** Handle product:" + item.toString("    "));
        // if (item.getQty() == null || item.getQty() < 0) throw new ValidationException(null, "Item quantity is null");

        ItemBase edmItem = EDMRepo.INSTANCE.findItem(item.getName());
        Product product;

        if (edmItem == null) {
            Money unitPrice = Money.of(item.getPrice(), EDMRepo.INSTANCE.defaultCurrency);
            product = new Product(item.getId(), item.getName(), unitPrice, Producttype.fromString(item.getType()));
            EDMRepo.INSTANCE.addItem(product);
        } else if (edmItem instanceof Product){
            product = (Product) edmItem;
        } else {
            throw new ValidationException(null, "Item is not a valid product: " + item.toString());
        }

        Quantity quantity = Quantity.of(item.getQty(), EDMRepo.INSTANCE.defaultProductUnit);
        SalesOrderLineItem salesOrderLineItem = new SalesOrderLineItem(null, product.getUnitPrice(), quantity, product);
        salesOrderLineItem.setComment("Auto created by data integration from ERP -> EDM");

        return salesOrderLineItem;
    }

    public SalesOrderLineItem processService(Item item) throws ValidationException {

        System.out.println("*** Handle service:" + item.toString("    "));
        // if (item.getQty() == null || item.getQty() < 0) throw new ValidationException(null, "item quantity is null");

        ItemBase edmItem = EDMRepo.INSTANCE.findItem(item.getName());
        Service service = null;

        // ToDo what is happening here?
        if (edmItem == null) {
            Money unitPrice = Money.of(item.getPrice(), EDMRepo.INSTANCE.defaultCurrency);
            service = new Service(item.getId(), item.getName(), unitPrice, EDMRepo.INSTANCE.defaultServiceUnit);
            EDMRepo.INSTANCE.addItem(service);
        } else if (edmItem instanceof Product){
            service = (Service) edmItem;
        } else {
            throw new ValidationException(null, "Item is not a valid service: " + item.toString());
        }

        Quantity quantity = Quantity.of(item.getQty(), EDMRepo.INSTANCE.defaultServiceUnit);
        SalesOrderLineItem salesOrderLineItem = new SalesOrderLineItem(null, service.getUnitPrice(), quantity, service);
        salesOrderLineItem.setComment("Auto created by data integration from ERP -> EDM");
        // ToDo products

        return salesOrderLineItem;
    }


    public SalesOrderLineItem processUnknownItem(Item item) throws ValidationException {
        System.out.println("*** Handle unknown item:" + item.toString("    "));
        return null;
    }

}
