package br.com.springcloudproducerrest.message;

import br.com.springcloudproducerrest.model.Product;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestProducer {
    public boolean sendMessageProduct(Product payload, RestSource restSource) {
        Message<Product> message = MessageBuilder.withPayload(payload).build();
        return restSource.sendMessage().send(message);
    }
}
