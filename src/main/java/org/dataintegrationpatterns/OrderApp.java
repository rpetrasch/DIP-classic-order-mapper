package org.dataintegrationpatterns;

import org.dataintegrationpatterns.model.edm.SalesOrder;
import org.dataintegrationpatterns.repo.ERPRepo;
import org.dataintegrationpatterns.repo.EDMRepo;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Currency;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OrderApp {

    private static final Logger LOG = LoggerFactory.getLogger(OrderApp.class.getName());

    public static void main(String[] args) {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                    "camel-context.xml");

            CamelContext camelContext = applicationContext.getBean("orderCtx",
                    CamelContext.class);

            camelContext.start();

            ProducerTemplate producerTemplate = camelContext.createProducerTemplate();

            List<SalesOrder> edmSalesOrders = producerTemplate.requestBody(
                    "direct:processOrderList", ERPRepo.INSTANCE.getOrders(), List.class);

            edmSalesOrders.forEach(System.out::println);

            EDMRepo.INSTANCE.getItems();

            camelContext.stop();

        } catch (Exception e) {

            LOG.error(e.getMessage());

        }

    }

}
