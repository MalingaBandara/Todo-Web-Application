package com.bitlord.springboottodoapp.controllers;

import com.bitlord.springboottodoapp.models.TodoItem;
import com.bitlord.springboottodoapp.services.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TodoFormController {

    @Autowired
    private TodoItemService todoItemService;

    // create new to item
    @GetMapping( "/create-todo" )
    public String showCreateForm( TodoItem todoItem ){
        return "new-todo-item";
    }


    // Create Todo Item
    @PostMapping( "/todo" )
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {

        TodoItem item = new TodoItem();

        item.setDescription( todoItem.getDescription() ); // set item description
        item.setIsComplete( todoItem.getIsComplete() ); // set item status(Complete)

        todoItemService.save( todoItem ); // save item

        return "redirect:/";

    }


    // delete item
    @GetMapping( "/delete/{id}" )
    public String deleteTodoItem(@PathVariable("id") Long id, Model model ) {

        // orElseThrow using cuz this is Optional it can contain val or not
        TodoItem todoItem = todoItemService.getById(id).orElseThrow( () -> new IllegalArgumentException( "TodoItem Id: " + id + "not found!" ) ); // find item

        todoItemService.delete(todoItem);

        return "redirect:/";
    }


    @GetMapping( "/edit/{id}" )
    public String showUpdateForm( @PathVariable("id") Long id, Model model ) {

        // orElseThrow using cuz this is Optional it can contain val or not
        TodoItem todoItem = todoItemService.getById(id).orElseThrow( () -> new IllegalArgumentException( "TodoItem Id: " + id + "not found!" ) ); // find item

        model.addAttribute( "todo", todoItem ); // set mode of todo item

        return "edit-todo-item";

    }


    // save and show after edit todo item
    @PostMapping( "/todo/{id}" )
    public String updateTodoItem( @PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model ) {

        // orElseThrow using cuz this is Optional it can contain val or not
        TodoItem item = todoItemService.getById(id).orElseThrow( () -> new IllegalArgumentException( "TodoItem Id: " + id + "not found!" ) ); // find item

        item.setIsComplete( todoItem.getIsComplete() ); // set new status
        item.setDescription( todoItem.getDescription() ); // set new description

        todoItemService.save( item );

        return "redirect:/";

    }


}
