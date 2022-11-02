package de.htwBerlin.webtech.service;

import de.htwBerlin.webtech.persistence.ToDoListEntity;
import de.htwBerlin.webtech.persistence.ToDoListRepository;
import de.htwBerlin.webtech.web.api.ToDoList;
import de.htwBerlin.webtech.web.api.ToDoListManipulationRequest;
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

    //Liste wird per ID gesucht
    public ToDoList findById(Long id){
        var toDoListEntity = toDoListRepository.findById(id);
        //Es wird geguckt ib die Entity vorhanden ist
        // ,wenn ja wird die Entity zurückgegeben
        //wenn nein dann wird ein null zurückgegeben
        return toDoListEntity.map(this::transformEntity).orElse(null);
    }

    public ToDoList create(ToDoListManipulationRequest request) {
        //Ohne Id, weil es automatisch generiert wird
        var toDoListEntity = new ToDoListEntity(request.getOrdnerName(),
                request.getAufgabenName(),
                request.isDone(),
                request.getFaelligkeitsdatum());
        //Speichert die ToDOListEntity zurück
        toDoListEntity = toDoListRepository.save(toDoListEntity);
        return transformEntity(toDoListEntity);
    }

    public ToDoList update(Long id, ToDoListManipulationRequest request){
        var toDoListEntityOptional = toDoListRepository.findById(id);
        if (toDoListEntityOptional.isEmpty()){
            return null;
        }

        var toDoListEntity = toDoListEntityOptional.get();
                toDoListEntity.setOrdnerName(request.getOrdnerName());
                toDoListEntity.setAufgabenName(request.getAufgabenName());
                toDoListEntity.setDone(request.isDone());
                toDoListEntity.setFaelligkeitsdatum(request.getFaelligkeitsdatum());

        //Speichert die ToDOListEntity zurück
        toDoListEntity = toDoListRepository.save(toDoListEntity);
        return transformEntity(toDoListEntity);
    }

    public boolean deleteById(Long Id){
        if (!toDoListRepository.existsById(Id)){
            return false;
        }

        toDoListRepository.deleteById(Id);
        return true;
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
