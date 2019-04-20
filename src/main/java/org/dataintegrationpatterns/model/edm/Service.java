package org.dataintegrationpatterns.model.edm;

import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.List;


public class Service extends ItemBase {

    protected Boolean remote;

    protected List<Product> servicedProducts = new ArrayList<>();

    public Service(String id, String name, MonetaryAmount unitPrice) {
        super(id, name, unitPrice, ItemUnit.DAY);
    }

    public Service(String id, String name, MonetaryAmount unitPrice, ItemUnit unitOfMeasure) {
        super(id, name, unitPrice,unitOfMeasure);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(", remote=");
        builder.append(remote);
        builder.append(", servicedProducts=");
        builder.append(servicedProducts.stream().map(p -> p.toString()));
        builder.append("]");
        return builder.toString();
    }
}
