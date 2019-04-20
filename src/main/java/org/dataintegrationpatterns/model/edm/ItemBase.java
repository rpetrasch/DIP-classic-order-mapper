package org.dataintegrationpatterns.model.edm;

import javax.money.MonetaryAmount;

public abstract class ItemBase {

    private static Long autoId = 1L;

    protected Long id;

    protected String erpId;

    protected String name;

    protected MonetaryAmount unitPrice;

    protected ItemUnit unitOfMeasure;

    public ItemBase() {
    }

    public ItemBase(String erpId, String name, MonetaryAmount unitPrice) {
        this.id = autoId++;
        this.erpId = erpId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public ItemBase(String erpId, String name, MonetaryAmount unitPrice, ItemUnit unitOfMeasure) {
        this(erpId, name, unitPrice);
        this.unitOfMeasure = unitOfMeasure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getErpId() {
        return erpId;
    }

    public void setErpId(String erpId) {
        this.erpId = erpId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonetaryAmount getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(MonetaryAmount unitPrice) {
        this.unitPrice = unitPrice;
    }

    public ItemUnit getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(ItemUnit unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nItem [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", unitPrice=");
        builder.append(unitPrice.toString());
        builder.append(", unitOfMeasure=");
        builder.append(unitOfMeasure.toString());
        return builder.toString();
    }
}
