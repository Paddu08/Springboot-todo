package com.example.springboottodolist.repositories;

import com.example.springboottodolist.models.Todoitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Todoitemrepository extends JpaRepository<Todoitem,Long>
{
}
