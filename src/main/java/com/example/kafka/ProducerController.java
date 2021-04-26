package com.example.kafka;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProducerController {

    private KafkaTemplate kafkaTemplate;

    public ProducerController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/publish/{name}/{age}/")
    public ResponseEntity saveMessage(@PathVariable("name") String name,
                                      @PathVariable("age") int age){
        User user=new User();
        user.setName(name);
        user.setAge(age);

        kafkaTemplate.send("quickstart-events",user);
        return new ResponseEntity("published", HttpStatus.OK);
    }



}
