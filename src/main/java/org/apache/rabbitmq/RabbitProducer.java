package org.apache.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: RabbitProducer
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/26 9:49
 * @Version: V0.1
 */
public class RabbitProducer {
	private static final String EXCHANGE_NAME = "exchange_demo";
	private static final String ROUTING_KEY = "routingkey_demo";
	private static final String QUEUE_NAME = "queue_demo";
	private static final String IP_ADDRESS = "127.0.0.1";
	private static final int PORT = 5672;	// RabbitMQ服务端默认端口号为5672

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(IP_ADDRESS);
		factory.setPort(PORT);
		factory.setUsername("guest");
		factory.setPassword("guest");
		Connection connection = factory.newConnection();    // 建立连接
		Channel channel = connection.createChannel();        // 创建信道
		// 创建一个type="direct"、持久化的、非自动删除的交换器
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout", true, false, null);
		// 创建一个持久化、非排他的、非自动删除的队列
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		// 创建一个持久化、非排他的、非自动删除的队列
		channel.queueDeclare("another_queue", true, false, false, null);
		// 将交换器和队列通过路由绑定
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
		channel.queueBind("another_queue", EXCHANGE_NAME, "another_queue");
		// 发送一条持久化的消息：hello world!
		String message = "hello,world!";
		channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY,
				MessageProperties.PERSISTENT_TEXT_PLAIN,
				message.getBytes());
		// 关闭资源
		channel.close();
		connection.close();
	}
}
