package com.example.springboottodolist.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name="todo_item")

public class Todoitem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private Boolean isComplete;

    private Instant createdAt;

    private Instant UpdatedAt;

    @Override
    public String toString(){
        return String.format("TodoItem{id=%d,description='%s',isComplete='%s',createdAt='%s',updatedAt='%s'}",id,description,isComplete,createdAt,UpdatedAt);
    }


}
