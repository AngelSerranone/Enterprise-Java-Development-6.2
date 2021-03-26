package com.ironhack.ShippingOrders.controller.impl;
import com.ironhack.ShippingOrders.controller.Dto.ProductDto;
import com.ironhack.ShippingOrders.controller.Dto.ShippingOrderDto;
import com.ironhack.ShippingOrders.model.ShippingOrder;
import com.ironhack.ShippingOrders.repository.ShippingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ShippingOrderController {

    @Autowired
    private ShippingOrderRepository shippingOrderRepository;
    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/shipping-order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShippingOrder getShippingOrderById(@PathVariable Integer id) {
        Optional<ShippingOrder> shippingOrder = shippingOrderRepository.findById(id);
        if (shippingOrder.isPresent()) {
            return shippingOrder.get();
        } else {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "The shipping order you are looking for doesn't exists");
        }
    }

    @PostMapping("/shipping-order")
    @ResponseStatus(HttpStatus.CREATED)
    public ShippingOrder registerProduct(@RequestBody @Valid ShippingOrderDto shippingOrderDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        String url = discoveryClient.getInstances("product-service").get(0).getUri().toString() + "/product/"+shippingOrderDto.getProductId();
        ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);

        assert productDto != null;
        if (productDto.getInventoryCount() < shippingOrderDto.getQuantity()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "We dont have enough stock");
        }
        productDto.setProductId(shippingOrderDto.getProductId());
        productDto.setInventoryCount(productDto.getInventoryCount()-shippingOrderDto.getQuantity());


        url = discoveryClient.getInstances("product-service").get(0).getUri().toString() + "/product-update/"+shippingOrderDto.getProductId();
        HttpEntity<ProductDto> httpEntity = new HttpEntity<>(productDto, headers);
        restTemplate.put(url, httpEntity, ProductDto.class);

        ShippingOrder shippingOrder = new ShippingOrder();
        shippingOrder.setProductId(shippingOrderDto.getProductId());
        shippingOrder.setQuantity(shippingOrderDto.getQuantity());

        return shippingOrderRepository.save(shippingOrder);

    }
}
