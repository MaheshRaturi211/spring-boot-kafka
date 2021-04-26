package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics="quickstart-events", groupId ="group_id")
    public void consume(User user){
        System.out.println("Consumed message :"+user.getName()+" age :"+user.getAge());
    }
}
