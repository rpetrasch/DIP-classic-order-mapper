package org.dataintegrationpatterns;

import org.dataintegrationpatterns.model.edm.SalesOrder;
import org.dataintegrationpatterns.repo.ERPRepo;
import org.dataintegrationpatterns.repo.EDMRepo;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.endpoint.LambdaEndpointRouteBuilder;

import java.lang.reflect.Type;
import java.util.Currency;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class OrderApp {

    private static final Logger LOG = LoggerFactory.getLogger(OrderApp.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
/*    public static void main_(String[] args) {
//        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                    "camel-context.xml");
            CamelContext camelContext = applicationContext.getBean("orderCtx",
                    CamelContext.class);
            camelContext.start();
            ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
//          Google Giava  Type salesOrderListType = new TypeToken<List<SalesOrder>>(){}.getType()
            Class<List<SalesOrder>> salesOrderListType = (Class<List<SalesOrder>>)(Object)List.class;
            List<SalesOrder> edmSalesOrders = producerTemplate.requestBody(
                    "direct:processOrderList", ERPRepo.INSTANCE.getOrders(), salesOrderListType);

//            edmSalesOrders.forEach(System.out::println);
//
//            EDMRepo.INSTANCE.getItems();
//
//            camelContext.stop();
//
//        } catch (Exception e) {
//
//            LOG.error(e.getMessage());
//
//        }
//
//    }
 */

    @Bean
    public LambdaEndpointRouteBuilder timerRoute() {
        return rb -> rb
                .from(rb.timer("timer").period(2000))
                .process(msg -> msg.getIn().setBody(ERPRepo.INSTANCE.getOrders()))
                .to("direct:processOrderList")
//                .to(rb.bean("myBean").method("saySomething"))
                .log("${body}");
    }


}
