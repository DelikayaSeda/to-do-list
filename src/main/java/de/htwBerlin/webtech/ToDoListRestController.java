package de.htwBerlin.webtech;

import de.htwBerlin.webtech.service.ToDoListService;
import de.htwBerlin.webtech.web.api.ToDoList;
import de.htwBerlin.webtech.web.api.ToDoListCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping(path = "/api/v1/todolist")
    public ResponseEntity<Void> createToDOList(@RequestBody ToDoListCreateRequest request) throws URISyntaxException {
       var toDoList= toDoListService.create(request);
       URI uri = new URI("/api/v1/todolist/" + toDoList.getId());
       return ResponseEntity.created(uri).build();
    }
}
