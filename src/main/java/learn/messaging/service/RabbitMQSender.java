package learn.messaging.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import learn.messaging.model.Employee;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate rabbitMQTemplate;

	@Value("${learn.rabbitmq.exchange}")
	private String exchange;

	@Value("${learn.rabbitmq.routingKey}")
	private String routingkey;

	public void send(Employee company) {
		rabbitMQTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);

	}
}
