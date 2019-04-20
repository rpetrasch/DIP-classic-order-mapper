package org.dataintegrationpatterns.mapping;

import org.dataintegrationpatterns.model.edm.SalesOrder;
import org.dataintegrationpatterns.model.erp.Order;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class OrderProcessor implements Processor {

    private static Long id = 1L;

    public void process(Exchange exchange) {

        Order erpOrder = exchange.getIn().getBody(Order.class);
        SalesOrder salesOrder = new SalesOrder(id++);

        System.out.println("Process order: " + erpOrder.getId());

        salesOrder.setErpId(erpOrder.getId());

        salesOrder.setRemark("Data integration: ERP -> EDM");

        exchange.getIn().getHeaders().put("order", salesOrder);
    }
}
