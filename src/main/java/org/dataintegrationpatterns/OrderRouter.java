package org.dataintegrationpatterns;

import org.apache.camel.InvalidPayloadException;
import org.apache.camel.ValidationException;
import org.apache.camel.builder.RouteBuilder;
import org.dataintegrationpatterns.mapping.*;
import org.dataintegrationpatterns.model.edm.Producttype;


public class OrderRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:processOrderList")
                .split(body())
                .doTry()
                  .process(new OrderProcessor())
                    .to("direct:processOrder")
                .doCatch(ValidationException.class)
                    .to("direct:processError")
                .end();

        from("direct:processOrder")
                .split(body().method("getItems"), new OrderItemAggregationStrategy())
                .to("direct:processItem")
                .end();

        from("direct:processItem")
                .choice()
                    .when(body().method("getType").in(Producttype.getAllProductTypeNames()))
                        .to("bean:itemService?method=processProduct")
                    .when(body().method("getType").isEqualTo("Service"))
                        .to("bean:itemService?method=processService").
                    otherwise()
                        .to("bean:itemService?method=processUnknownItem")
                .endChoice()
;

        from("direct:processError")
                .process(e -> {
                    System.out.println("ERROR: Cannot process order/item: " + e.getIn().getBody().toString());
                });
    }
}
