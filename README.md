# TodoApplication
##### :green_square: Its a TodoApplication
## :hash: Frameworks and Languages Used -
    1. SpringBoot
    2. JAVA
    3. Postman
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :hash: Dataflow (Functions Used In)
### :green_square: 1. Model - I have used one model which is Todo.java
#### :large_orange_diamond: Todo.java
java
package com.example.TodoApplication.Todo;

public class Todo {
    private String id;
    private String todoName;
    private Boolean todoStatus;

    public Todo(String id, String todoName, Boolean todoStatus) {
        this.id = id;
        this.todoName = todoName;
        this.todoStatus = todoStatus;
    }

    public Todo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public Boolean getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(Boolean todoStatus) {
        this.todoStatus = todoStatus;
    }
}

##### To See Model
:heavy_check_mark: [Model](https://github.com/tejasviii/TodoApplication/tree/master/src/main/java/com/example/TodoApplication/Todo)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
### :green_square: 2. Service - I have used one service which is TodoService.java
#### :large_orange_diamond: TodoService.java
java
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
    public List<Todo> getAllTodos() {
        return todoDao.getAllTodos();
    }

    public String addTodo(Todo todo) {
        Boolean status = todoDao.addTodo(todo);
        if(status){
            return "Yes added";
        }else{
            return "Not added";
        }
    }

    public String deleteTodoById(String id) {
        if(id != null){
            List<Todo> listRightNow =  todoDao.getAllTodos();
            for(Todo todo :listRightNow){
                if(todo.getId().equals(id)){
                    Boolean status = todoDao.remove(todo);

                    if(status){
                        return "Deleted";
                    }
                }
            }
        }
        return "Not Deleted";
    }

    public String updateTodo(String id , String status) {
        boolean updateStatus = todoDao.update(id , Boolean.parseBoolean(status));
        if(updateStatus){
            return "Updated...";
        }else{
            return "Not Updated...";
        }
    }

    public Todo getTodoBasedOnId(String id) {
        List<Todo> todoListRightNow = todoDao.getAllTodos();

        for(Todo todo : todoListRightNow){
            if(todo.getId().equals(id)){
                return todo;
            }
        }
        return null;
    }
}

#### To See Service
:heavy_check_mark: [Service](https://github.com/tejasviii/TodoApplication/tree/master/src/main/java/com/example/TodoApplication/TodoService)
-----------------------------------------------------------------------------------------------------------------------------------------------------------

### :green_square: 3. Controller - I have used one controller which is TodoController.java
#### :large_orange_diamond: TodoController.java
java
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
    private List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping(value = "/todo")
    private String addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @PutMapping(value = "/updateTodoById/{id}/{status}")
    private String updateTodo(@PathVariable String id , @PathVariable String status){
        return todoService.updateTodo(id , status);
    }

    @DeleteMapping(value = "/delete/todo/by/id/{id}")
    private String deleteTodo(@PathVariable String id){
        return todoService.deleteTodoById(id);
    }

    @RequestMapping(value = "/getTodoById/{id}" , method = RequestMethod.GET)
    public Todo getTodoById(@PathVariable String id){
        return todoService.getTodoBasedOnId(id);
    }

}

#### To See Controller
:heavy_check_mark: [Controller](https://github.com/tejasviii/TodoApplication/tree/master/src/main/java/com/example/TodoApplication/TodoController)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
### :green_square: 4. Controller - I have used one Dao which is TodoDao.java
#### :large_orange_diamond: TodoDao.java
java
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
    public List<Todo> getAllTodos() {
        return list;
    }

    public Boolean addTodo(Todo todo) {
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

                    addTodo(todo);
                }
            }
        }
        return true;
    }
}

#### To See Dao
:heavy_check_mark: [Dao](https://github.com/tejasviii/TodoApplication/tree/master/src/main/java/com/example/TodoApplication/TodoDao)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :hash: DataStructures Used in Project
    1. ARRAYLIST
    2. List
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :hash: Project Summary
### :large_orange_diamond: Project result 

### :green_square: Get All Todos By Browser - https://localhost:8080/todos
#### :small_blue_diamond: Image after hitting the GetMapping on Brower.
![ss1](https://github.com/harshsikarwar20/TodoApplication/assets/123385605/0c81b72a-cfef-4868-aa28-4370914ba935)
### :green_square: Added Todo By Postman - https://localhost:8080/todos

#### :small_blue_diamond: Image after hitting the PostMapping on Postman.
![ss2](https://github.com/harshsikarwar20/TodoApplication/assets/123385605/c598a5bf-371f-42af-a002-57a504a6c2cb)
#### :small_blue_diamond: Image after hitting the GetMapping on Brower, we can see one post.
![ss3](https://github.com/harshsikarwar20/TodoApplication/assets/123385605/66503896-5fde-4b01-a635-4acd6873883d)
### :green_square: Update Todo By Postman - https://localhost:8080/updateTodoById/{id}/{status}

#### :small_blue_diamond: Image after hitting the PutMapping on Postman.
![ss7](https://github.com/harshsikarwar20/TodoApplication/assets/123385605/20d5ce7f-b971-4d4a-b186-382068ef0392)
#### :small_blue_diamond: Image after hitting the GetMapping on Brower, we can see one updation at id : 4.
![ss8](https://github.com/harshsikarwar20/TodoApplication/assets/123385605/dfb18c77-300a-4ff2-89da-ab8339907233)
### :green_square: Delete User By Postman - https://localhost:8080/delete/todo/by/id/{id}

#### :small_blue_diamond: Image after hitting the DeleteMapping on Postman.
![ss4](https://github.com/harshsikarwar20/TodoApplication/assets/123385605/46541b7e-91d9-4921-b6fb-39f631f7814d)
#### :small_blue_diamond: Image after hitting the GetMapping on Brower, we can see id : 2 has been deleted.
![ss5](https://github.com/harshsikarwar20/TodoApplication/assets/123385605/98101c9f-fa34-4c60-843d-3ff306a5abd0)
