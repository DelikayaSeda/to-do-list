package de.htwBerlin.webtech.web.api;

import java.util.Date;

public class ToDoListManipulationRequest {

    private String todoTitel;
    private String beschreibung;
    private boolean status;
    private Date datum;

    public ToDoListManipulationRequest(String todoTitel, String beschreibung, boolean status, Date datum) {
        this.todoTitel = todoTitel;
        this.beschreibung = beschreibung;
        this.status = status;
        this.datum = datum;
    }

    public ToDoListManipulationRequest() {
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

    public boolean isStatus() {
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
