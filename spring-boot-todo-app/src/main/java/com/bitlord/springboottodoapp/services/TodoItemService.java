package com.bitlord.springboottodoapp.services;

import com.bitlord.springboottodoapp.models.TodoItem;
import com.bitlord.springboottodoapp.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    // Iterable use iterate data inside list (like for each)
    public Iterable<TodoItem> getAll(){
        return todoItemRepository.findAll();
    }


    // get one item
    public Optional<TodoItem> getById( Long id ){
        return todoItemRepository.findById(id);
    }


    // save todo item (new or old item)
    public TodoItem save( TodoItem todoItem ){

        // check is this update todo item (cuz there have id it already in db)
        if( todoItem.getId() == null ) {
            todoItem.setCreatedAt(Instant.now()); // new item create time
        }
        todoItem.setUpdatedAt(Instant.now()); // old item update time

        return todoItemRepository.save( todoItem );
    }


    // delete
    public void delete( TodoItem todoItem ) {
        todoItemRepository.delete( todoItem );
    }

}
