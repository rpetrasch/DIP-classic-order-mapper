package org.dataintegrationpatterns.model.edm;

import java.util.ArrayList;
import java.util.List;

public class SalesOrder {

    private Long id;
    private String erpId;

    private String remark;

    private List<SalesOrderLineItem> items = new ArrayList<>();

    private double totalPrice;

    public SalesOrder(Long id) {
        this.id = id;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<SalesOrderLineItem> getItems() {
        return items;
    }

    public void setItems(List<SalesOrderLineItem> items) {
        this.items = items;
    }

    public void addItems(List<SalesOrderLineItem> items) {
        this.items.addAll(items);
    }

    public void addItem(SalesOrderLineItem item) {
        this.items.add(item);
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
        builder.append(", erpId=");
        builder.append(erpId);
        builder.append(", items=");
        builder.append(items);
        builder.append(",\ntotalPrice=");
        builder.append(totalPrice);
        builder.append("]");
        return builder.toString();
    }
}
