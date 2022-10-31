package de.htwBerlin.webtech;

import de.htwBerlin.webtech.service.ToDoListService;
import de.htwBerlin.webtech.web.api.ToDoList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoListRestController {

 private final ToDoListService toDoListService;

    public ToDoListRestController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }


    @GetMapping(path = "/api/v1/todolist")
    public ResponseEntity<List<ToDoList>> fetchToDoList(){
       return ResponseEntity.ok(toDoListService.findAll());
    }
}
