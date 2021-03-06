package br.com.springcloudproducerrest.controller;

import br.com.springcloudproducerrest.dto.MessageDTO;
import br.com.springcloudproducerrest.message.RestProducer;
import br.com.springcloudproducerrest.message.RestSource;
import br.com.springcloudproducerrest.model.Product;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRestController {

    @Autowired
    RestSource restSource;

    @Autowired
    RestProducer restProducer;

    @PostMapping("/process")
    public ResponseEntity<MessageDTO> processProduct(@RequestBody Product product) {
        boolean result = restProducer.sendMessageProduct(product, restSource);

        MessageDTO messageResult = new MessageDTO("Operação realizada com sucesso? " + result);
        return ResponseEntity.ok(messageResult);
    }

}
