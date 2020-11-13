package com.sanix.todorabbitmq.repository;

import com.sanix.todorabbitmq.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, String> {
}
