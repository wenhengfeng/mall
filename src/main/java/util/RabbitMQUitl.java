package util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMQ连接工具类
 */
public class RabbitMQUitl {
    private static final String host="192.168.0.108";
    private static final int port =5672;

    /**
     * 获取RabbitMQ Connection连接
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    public static Connection getConnection() throws IOException,TimeoutException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername("wenqp");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("/");

        return connectionFactory.newConnection();
    }
}
