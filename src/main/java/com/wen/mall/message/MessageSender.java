package com.wen.mall.message;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.RabbitMQUitl;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.TimeoutException;

public class MessageSender {
    private AmqpTemplate rabbitTemplate;

    private static final String QUEUE_NAME = "order.a";

    public static void main(String args[]) throws IOException, TimeoutException {
        //获取连接
        Connection connection = RabbitMQUitl.getConnection();
        //从连接开通一个通道
        Channel channel = connection.createChannel();
        //申明一个队列，没有就会创建
        // queue: 队列名称；
        // durable: 是否持久化，true表示rabbit重启后，队列已然村子；
        // exclusive：true表示当前连接的专用队列，在连接断开后，会自动删除该队列
        // autoDelete: true表示当没有任何消费者使用时，自动删除该队列
        // arguments: 该队列其他配置参数
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        String message = "新的订单!";
        //发送消息
        // exchange: 指定交换机，这里为简单队列，不需要使用，默认""即可，不能为null；
        // routingKey: 路由key，这里为队列名称
        // props: 其他消息属性，路由头信息等等
        // body: 消息byte内容
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

        System.out.println("消息已发送...");

        //关闭通道和连接
        channel.close();
        connection.close();


    }

}
