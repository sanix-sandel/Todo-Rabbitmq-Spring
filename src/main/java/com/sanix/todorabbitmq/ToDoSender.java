package com.sanix.todorabbitmq;

import com.sanix.todorabbitmq.domain.ToDo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoSender {

    @Bean
    public CommandLineRunner sendToDos(@Value("${todorabbitmq.amqp.queue}")String
                                       destination, ToDoProducer producer){
        return args->{
            producer.sendTo(destination, new ToDo("Workout tomorrow morning !"));
        };
    }
}
