package com.example.springboottodolist.services;

import com.example.springboottodolist.models.Todoitem;
import com.example.springboottodolist.repositories.Todoitemrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service

public class TodoItemService {
    @Autowired
    private Todoitemrepository todoitemrepository;

    public Iterable<Todoitem>getAll(){
        return todoitemrepository.findAll();
    }
    public Optional<Todoitem>getById(long id){
        return todoitemrepository.findById(id);
    }

    public Todoitem save(Todoitem todoItem) {
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(Instant.now());

        }
        todoItem.setUpdatedAt(Instant.now());
        return todoitemrepository.save(todoItem);


    }
    public void delete(Todoitem todoItem){
        todoitemrepository.delete(todoItem);
    }

}
