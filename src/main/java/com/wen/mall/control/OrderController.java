package com.wen.mall.control;

import com.wen.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@RestController("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
   /* @RequestMapping(value = "/order/{userId}/{goodId}/{shopId}")
    public Map<String, Object> order(@PathVariable Integer userId, @PathVariable Integer goodId, @PathVariable Integer shopId) throws IOException, TimeoutException {
        return orderService.order(userId,goodId,shopId);
    }*/
}
