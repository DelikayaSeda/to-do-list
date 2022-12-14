package de.htwBerlin.webtech.persistence;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "ToDos")
public class ToDoListEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "todoTitel")
    private String todoTitel;

    @Column(name = "beschreibung")
    private String beschreibung;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "datum")
    private Date datum;

    public ToDoListEntity(String todoTitel, String beschreibung, Boolean status, Date datum) {
        this.todoTitel = todoTitel;
        this.beschreibung = beschreibung;
        this.status = status;
        this.datum = datum;
    }

    public ToDoListEntity() {
    }

    public long getId() {
        return id;
    }


    public String getTodoTitel() {
        return todoTitel;
    }

    public void setTodoTitel(String ordnerName) {
        this.todoTitel = ordnerName;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String aufgabenName) {
        this.beschreibung = aufgabenName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
