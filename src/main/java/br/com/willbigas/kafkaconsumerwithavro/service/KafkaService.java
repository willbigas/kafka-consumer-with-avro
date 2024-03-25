package br.com.willbigas.kafkaconsumerwithavro.service;

import br.com.willbigas.kafkaconsumerwithavro.models.User;
import br.com.willbigas.kafkaconsumerwithavro.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import br.com.willbigas.avro.UserAvro;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaService {

	private final UserRepository userRepository;

    public KafkaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "${kafka.topic}",groupId = "group-1")
    public void consumer(ConsumerRecord<String, UserAvro> userAvro){
        User user = new User();
        UserAvro value = userAvro.value();
        user.setDocumentNumber(value.getDocumentNumber());
        user.setName(value.getName());
        user.setPhone(value.getPhone());
        userRepository.save(user);
        log.info("{}",user);
    }

}
