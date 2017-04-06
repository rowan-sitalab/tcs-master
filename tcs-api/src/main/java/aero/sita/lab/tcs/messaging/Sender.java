package aero.sita.lab.tcs.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {

	@Value("${kafka.topic.json}")
	private String jsonTopic;

	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	@Autowired
	private KafkaTemplate<String, Car> kafkaTemplate;

	public void send(Car car) {
		LOGGER.info("sending car='{}'", car.toString());
		kafkaTemplate.send(jsonTopic, car);
	}
}
