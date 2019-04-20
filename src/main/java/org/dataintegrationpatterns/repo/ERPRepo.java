package org.dataintegrationpatterns.repo;

import org.dataintegrationpatterns.model.erp.Item;
import org.dataintegrationpatterns.model.erp.Order;

import java.util.ArrayList;
import java.util.List;

public class ERPRepo {

    public static final ERPRepo INSTANCE = new ERPRepo();

    protected List<Order> orders = new ArrayList<Order>();

    private ERPRepo() {

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("1", "Camel in Action", "Book", 50F, 1F));
        items.add(new Item("2", "Pear XPhone8", "Phone", 300F, 1F));

        Order order = new Order("Test1");
        order.setItems(items);
        orders.add(order);

        items = new ArrayList<Item>();
        items.add(new Item("1", "EIP in Action", "Book", 20.5F, 2F));
        items.add(new Item("2", "Sumsum Sum11+", "Phone", 200F, 1F));
        items.add(new Item("3", "Another Book", "Book", -10F, null));
        items.add(new Item("4", "Dress for More", "Fashion", 10.5F, 3F));

        order = new Order("Test2");
        order.setItems(items);
        orders.add(order);

        items = new ArrayList<Item>();
        items.add(new Item("1", "Data Integration", "Book", 12.40F, 10F));
        items.add(new Item("2", "SumSum Sum11+", "Phone", 1140F, -1F));
        items.add(new Item("3", "Another Product", "Something", null, 100F));

        order = new Order("Test3");
        order.setItems(items);
        orders.add(order);

        items = new ArrayList<Item>();
        items.add(new Item("1", "Phone Repair", "Service", 52.40F, 13F));
        items.add(new Item("1", "Sweing Service", "Service", 42.40F, 2F));

        order = new Order("Test4");
        order.setItems(items);
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
