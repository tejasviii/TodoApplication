package com.example.TodoApplication.TodoDao;

import com.example.TodoApplication.Todo.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDao {

    static ArrayList<Todo> list = new ArrayList<>();

    static {
        list.add(new Todo("1" ,"Todo1" , true));
        list.add(new Todo("2" ,"Todo2" , false));
        list.add(new Todo("3" ,"Todo3" , true));
    }
    public List<Todo> getTodos() {
        return list;
    }

    public Boolean saveTodo(Todo todo) {
        list.add(todo);
        return true;
    }

    public Boolean remove(Todo todo) {
        list.remove(todo);
        return true;
    }

    public Boolean update(String id , Boolean status) {
        if(id != null){
            for(Todo todo : list){
                if(todo.getId().equals(id)){
                    remove(todo);

                    todo.setTodoStatus(status);

                    saveTodo(todo);
                }
            }
        }
        return true;
    }
}
