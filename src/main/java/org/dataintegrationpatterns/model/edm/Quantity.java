package org.dataintegrationpatterns.model.edm;

public class Quantity {

    ItemUnit unit;
    Float amount;

    public Quantity(ItemUnit itemUnit, Float amount) {
        this.unit = itemUnit;
        this.amount = amount;
    }


    public static Quantity of(Float amount, ItemUnit itemUnit) {
        return new Quantity(itemUnit, amount);
    }

    public ItemUnit getUnit() {
        return unit;
    }

    public void setUnit(ItemUnit unit) {
        this.unit = unit;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
