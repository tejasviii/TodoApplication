package com.example.TodoApplication.TodoController;

import com.example.TodoApplication.Todo.Todo;
import com.example.TodoApplication.TodoService.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping(value = "/todos")
    private List<Todo> getTodos(){
        return todoService.getTodos();
    }

    @PostMapping(value = "/todo")
    private String saveTodo(@RequestBody Todo todo){
        return todoService.saveTodo(todo);
    }

    @PutMapping(value = "/updateTodoById/{id}/{status}")
    private String update(@PathVariable String id , @PathVariable String status){
        return todoService.update(id , status);
    }

    @DeleteMapping(value = "/delete/todo/by/id/{id}")
    private String delete(@PathVariable String id){
        return todoService.delete(id);
    }

    @RequestMapping(value = "/getTodoById/{id}" , method = RequestMethod.GET)
    public Todo getTodoById(@PathVariable String id){
        return todoService.getTodoBasedOnId(id);
    }

}
