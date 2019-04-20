package org.dataintegrationpatterns.mapping;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.dataintegrationpatterns.model.edm.SalesOrder;
import org.dataintegrationpatterns.model.edm.SalesOrderLineItem;

public class OrderItemAggregationStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        SalesOrder currentOrder;
        SalesOrderLineItem lineItem = newExchange.getIn().getBody(SalesOrderLineItem.class);

        if (oldExchange == null) {
            currentOrder = newExchange.getIn().getHeader("order", SalesOrder.class);
            System.out.println(String.format("    -> Aggregate (first time) for order (%s / %s)", currentOrder.getId(), currentOrder.getErpId()));

            currentOrder.addItem(lineItem);
            currentOrder.setTotalPrice(lineItem.calcTotalPrice());

            newExchange.getIn().setBody(currentOrder);

            // first time aggregation: only new exchange exist
            return newExchange;
        }

        currentOrder = oldExchange.getIn().getBody(SalesOrder.class);

        if (lineItem != null) {
            System.out.println(String.format("    -> Aggregate for order (%s / %s) and item (%s / %s)", currentOrder.getId(), currentOrder.getErpId(), lineItem.getItem().getId(), lineItem.getItem().getErpId()));

            currentOrder.getItems().add(lineItem);

//            double totalPrice = currentOrder.getTotalPrice() + lineItem.calcTotalPrice();
//            currentOrder.setTotalPrice(currentOrder.getTotalPrice()+totalPrice);

            // oldExchange.getIn().setBody(currentOrder); // ???
        }
        return oldExchange;
    }


}
