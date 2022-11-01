package de.htwBerlin.webtech.service;

import de.htwBerlin.webtech.persistence.ToDoListEntity;
import de.htwBerlin.webtech.persistence.ToDoListRepository;
import de.htwBerlin.webtech.web.api.ToDoList;
import de.htwBerlin.webtech.web.api.ToDoListCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoList> findAll() {
        List<ToDoListEntity> toDoLists = toDoListRepository.findAll();
        return toDoLists.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public ToDoList create(ToDoListCreateRequest request) {
        //Ohne Id, weil es automatisch generiert wird
        var toDoListEntity = new ToDoListEntity(request.getOrdnerName(),
                request.getAufgabenName(),
                request.isDone(),
                request.getFaelligkeitsdatum());
        //Speichert die ToDOListEntity zurück
        toDoListEntity = toDoListRepository.save(toDoListEntity);
        return transformEntity(toDoListEntity);
    }

    private ToDoList transformEntity(ToDoListEntity toDoListEntity) {
        return new ToDoList(
                toDoListEntity.getId(),
                toDoListEntity.getOrdnerName(),
                toDoListEntity.getAufgabenName(),
                toDoListEntity.isDone(),
                toDoListEntity.getFaelligkeitsdatum());


}
}
