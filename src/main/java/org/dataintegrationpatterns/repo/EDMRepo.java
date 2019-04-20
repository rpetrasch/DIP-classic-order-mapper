package org.dataintegrationpatterns.repo;

import org.dataintegrationpatterns.model.edm.ItemBase;
import org.dataintegrationpatterns.model.edm.ItemUnit;
import org.dataintegrationpatterns.model.edm.SalesOrder;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EDMRepo {

    public static final Logger LOG = LoggerFactory.getLogger(EDMRepo.class.getName());

    public static final EDMRepo INSTANCE = new EDMRepo();

    public final CurrencyUnit defaultCurrency;
    public final ItemUnit defaultProductUnit;
    public final ItemUnit  defaultServiceUnit;

    protected List<SalesOrder> salesOrders = new ArrayList<>();
    protected List<ItemBase> items = new ArrayList<>();

    private EDMRepo() {
        defaultCurrency = Monetary.getCurrency("USD");
        defaultProductUnit = ItemUnit.PIECE;
        defaultServiceUnit = ItemUnit.HOUR;
    }

    public List<SalesOrder> getSalesOrders() {
        return salesOrders;
    }

    public void setSalesOrders(List<SalesOrder> salesOrders) {
        this.salesOrders = salesOrders;
    }

    public void addOrders(List<SalesOrder> salesOrders) {
        this.salesOrders.addAll(salesOrders);
    }

    public void addOrder(SalesOrder salesOrder) {
        this.salesOrders.add(salesOrder);
    }

    public List<? extends ItemBase> getItems() { return items; }

    public void addItems(List<ItemBase> newItemBases) {
        this.items.addAll(newItemBases);
    }

    public void addItem(ItemBase item) {
        this.items.add(item);
    }

    public ItemBase findItem(String name) {
        return this.items.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst().orElse(null);
    }
}
