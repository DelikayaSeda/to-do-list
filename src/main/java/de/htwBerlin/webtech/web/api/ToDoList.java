package de.htwBerlin.webtech.web.api;

import java.util.Date;

public class ToDoList {

    private long id;
    private String todoTitel;
    private String beschreibung;
    private boolean status;
    private Date datum;


    public ToDoList(long id, String todoTitel, String beschreibung, boolean status, Date datum) {
        this.id = id;
        this.todoTitel = todoTitel;
        this.beschreibung = beschreibung;
        this.status = status;
        this.datum = datum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTodoTitel() {
        return todoTitel;
    }

    public void setTodoTitel(String todoTitel) {
        this.todoTitel = todoTitel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
