package com.wen.mall.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wen.mall.dao.OrderMapper;
import com.wen.mall.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.RabbitMQUitl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Service
public class OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderService.class);
    private Map<String,Object> map;
    @Autowired
    private OrderMapper orderMapper;
    /**
     * @Method: order
     * @Description: 购物下单
     * @param userId, goodId, shopId, numbers
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     */
    public Map<String,Object> order(int userId,int goodId,int shopId,int number) throws IOException, TimeoutException {
        order(new Order(userId,shopId,goodId,number));
        return order(new Order(userId,shopId,goodId));
    }

    /**
     * 购物
     * @param order
     */
    public Map<String,Object> order(Order order) throws IOException, TimeoutException {
        map = new HashMap<>();
        String QUEUE_NAME = "order.b";
        int i = orderMapper.insert(order);
        if(i == 1){
            //获取连接
            Connection connection = RabbitMQUitl.getConnection();
            //打开连接通道
            Channel channel = connection.createChannel();
            //申明一个队列，没有就会创建
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String msg = "您有新的订单！！！";

            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

            logger.info("订单消息已发送...");
            channel.close();
            connection.close();
            map.put("msg","添加成功");
        }else {
            map.put("msg","添加失败");
        }
        return map;
    }
}
