package org.dataintegrationpatterns.model.edm;

import javax.money.MonetaryAmount;

public class Product extends ItemBase {

    private Producttype type;

    public Product(String id, String name, MonetaryAmount unitPrice, Producttype type) {
        super(id, name, unitPrice, ItemUnit.PIECE);
        this.type = type;
    }

    public Producttype getType() {
        return type;
    }

    public void setType(Producttype type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(", type=");
        builder.append(type);
        builder.append(", price=");
        builder.append(unitPrice);
        builder.append("]");
        return builder.toString();
    }
}
