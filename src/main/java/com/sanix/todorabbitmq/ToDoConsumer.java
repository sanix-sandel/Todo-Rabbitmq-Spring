package com.sanix.todorabbitmq;

import com.sanix.todorabbitmq.domain.ToDo;
import com.sanix.todorabbitmq.repository.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ToDoConsumer {
    private Logger log=LoggerFactory.getLogger(ToDoConsumer.class);
    private ToDoRepository repository;

    public ToDoConsumer(ToDoRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues="${todorabbitmq.amqp.queue}")
    public void processToDo(ToDo todo){
        log.info("Consumer > "+todo);
        log.info("ToDo created > "+this.repository.save(todo));
    }
}
