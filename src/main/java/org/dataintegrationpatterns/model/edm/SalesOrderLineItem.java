package org.dataintegrationpatterns.model.edm;

import javax.money.MonetaryAmount;

public class SalesOrderLineItem {

    private static Long autoId = 1L;

    protected Long id;

    protected Integer lineNo;

    protected MonetaryAmount unitPrice;

    protected Quantity quantity;

    protected ItemBase item;

    protected String comment;

    public SalesOrderLineItem() {
    }

    public SalesOrderLineItem(Integer lineNo, MonetaryAmount unitPrice, Quantity quantity, ItemBase item) {
        this.id = autoId++;
        this.lineNo = lineNo;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }

    public MonetaryAmount getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(MonetaryAmount unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public ItemBase getItem() {
        return item;
    }

    public void setItem(ItemBase item) {
        this.item = item;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Float calcTotalPrice() {
        if (this.quantity != null && this.getUnitPrice() != null && this.quantity.getAmount() != null && this.getUnitPrice().getNumber() != null)
            return this.quantity.getAmount() * this.getUnitPrice().getNumber().floatValue();
        else
            return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nItem [id=");
        builder.append(id);
        builder.append(", lineNo=");
        builder.append(lineNo);
        builder.append(", unitPrice=");
        builder.append(unitPrice.toString());
        builder.append(", quantity=");
        builder.append(quantity.toString());
        builder.append(", item=");
        builder.append(item.getId());
        builder.append(" / ");
        builder.append(item.getName());
        return builder.toString();
    }
}
