package de.htwBerlin.webtech.service;

import de.htwBerlin.webtech.persistence.ToDoListEntity;
import de.htwBerlin.webtech.persistence.ToDoListRepository;
import de.htwBerlin.webtech.web.api.ToDoList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoList> findAll(){
        List<ToDoListEntity> toDoLists = toDoListRepository.findAll();
        return toDoLists.stream()
                .map(toDoListEntity -> new ToDoList(toDoListEntity.getId(),
                        toDoListEntity.getOrdnerName(),
                        toDoListEntity.getAufgabenName(),
                        toDoListEntity.isDone(),
                        toDoListEntity.getFaelligkeitsdatum()))
                .collect(Collectors.toList());

    }
}
