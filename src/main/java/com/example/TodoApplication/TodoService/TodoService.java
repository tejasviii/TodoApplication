package com.example.TodoApplication.TodoService;

import com.example.TodoApplication.Todo.Todo;
import com.example.TodoApplication.TodoDao.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;
    public List<Todo> getTodos() {
        return todoDao.getTodos();
    }

    public String saveTodo(Todo todo) {
        Boolean status = todoDao.saveTodo(todo);
        if(status){
            return "Todo get Added!!";
        }else{
            return "TOdo did Not Added!!";
        }
    }

    public String delete(String id) {
        if(id != null){
            List<Todo> listRightNow =  todoDao.getTodos();
            for(Todo todo :listRightNow){
                if(todo.getId().equals(id)){
                    Boolean status = todoDao.remove(todo);

                    if(status){
                        return "Todo get deleted Successfully!!";
                    }
                }
            }
        }
        return "Todo did not get Deleted !!";
    }

    public String update(String id , String status) {
        boolean updateStatus = todoDao.update(id , Boolean.parseBoolean(status));
        if(updateStatus){
            return "Todo get Updated Successfully !!";
        }else{
            return "Todo did not get Updated !!";
        }
    }

    public Todo getTodoBasedOnId(String id) {
        List<Todo> todoListRightNow = todoDao.getTodos();

        for(Todo todo : todoListRightNow){
            if(todo.getId().equals(id)){
                return todo;
            }
        }
        return null;
    }
}

