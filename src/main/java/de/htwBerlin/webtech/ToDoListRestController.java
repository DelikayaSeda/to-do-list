package de.htwBerlin.webtech;

import de.htwBerlin.webtech.api.ToDoList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoListRestController {

    private List<ToDoList> toDoList;

    public ToDoListRestController() {
       toDoList = new ArrayList<>();
       toDoList.add(new ToDoList(1, "Uni", "Prog erledigen", false, LocalDate.of(2022, 11, 14)));
    }

    @GetMapping(path = "/api/v1/todolist")
    public ResponseEntity<List<ToDoList>> fetchToDoList(){
        return ResponseEntity.ok(toDoList);
    }
}
