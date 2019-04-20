package org.dataintegrationpatterns.model.erp;

public class Item {

    public Item(String id, String name, String type, Float price, Float qty) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.qty = qty;
    }

    private String id;

    private String name;

    private String type;

    private Float price;

    private Float qty;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public Float getQty() {
        return qty;
    }

    public void setQty(Float qty) {
        this.qty = qty;
    }


    @Override
    public String toString() {
        return this.toString("");
    }

    public String toString(String indent) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n")
                .append(indent)
                .append("Item [id=").append(id)
                .append(", name=").append(name)
                .append(", type=").append(type)
                .append(", price=").append(price)
                .append(", qty=").append(qty)
                .append("]");
        return builder.toString();
    }
}
