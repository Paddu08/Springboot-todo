package com.example.springboottodolist.controllers;

import com.example.springboottodolist.models.Todoitem;
import com.example.springboottodolist.services.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class TodoFormController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("create-todo")
    public String showCreateForm(Model model) {
        model.addAttribute("todoItem", new Todoitem());
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid Todoitem todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-todo-item";
        }

        todoItemService.save(todoItem);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        Todoitem todoItem = todoItemService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        todoItemService.delete(todoItem);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Todoitem todoItem = todoItemService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todoItem", todoItem);
        return "edit-todo-item";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid Todoitem todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-todo-item";
        }

        Todoitem item = todoItemService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        item.setIsComplete(todoItem.getIsComplete());
        item.setDescription(todoItem.getDescription());

        todoItemService.save(item);

        return "redirect:/";
    }

}
