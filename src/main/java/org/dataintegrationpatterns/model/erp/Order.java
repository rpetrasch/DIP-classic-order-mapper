package org.dataintegrationpatterns.model.erp;

import java.util.List;

public class Order {

    private String id;

    private List<Item> items;

    private double totalPrice;

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nSalesOrder [id=");
        builder.append(id);
        builder.append(", items=");
        builder.append(items);
        builder.append(",\ntotalPrice=");
        builder.append(totalPrice);
        builder.append("]");
        return builder.toString();
    }
}
