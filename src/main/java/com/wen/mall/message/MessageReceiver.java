package com.wen.mall.message;

import com.rabbitmq.client.*;
import com.sun.org.apache.bcel.internal.generic.FADD;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import util.RabbitMQUitl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageReceiver {
    private static final String QUEUE_NAME = "order.a";

    public static void main(String args[]) throws IOException, TimeoutException {
        //获取连接
        Connection connection = RabbitMQUitl.getConnection();
        //打开通道
        Channel channel = connection.createChannel();
        //申明要消费的队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //创建一个回调的消费者处理类
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                //接收到的消息
                String msg = new String(body);
                System.out.println("接受消息："+msg);
                try {
                    channel.close();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                connection.close();
                new MessageReceiver().info(msg);
            }
        };
        //消费消息
        // queue: 队列名称
        // autoAck: 是否自动应答，即生产者发送消息即认为该消息被消费
        // callback: 回调处理类，即消息被消费时进行回调处理
        channel.basicConsume(QUEUE_NAME,true,consumer);

       /* channel.close();
        connection.close();*/
    }

    public void info(String info){
        System.out.println("info="+info);
    }

}
