package de.htwBerlin.webtech.web.api;

import java.time.LocalDate;
import java.util.Date;

public class ToDoListManipulationRequest {

    private String todoTitel;
    private String beschreibung;
    private boolean status;
    private Date faelligkeitsdatum;

    public ToDoListManipulationRequest(String todoTitel, String beschreibung, boolean status, Date faelligkeitsdatum) {
        this.todoTitel = todoTitel;
        this.beschreibung = beschreibung;
        this.status = status;
        this.faelligkeitsdatum = faelligkeitsdatum;
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

    public Date getFaelligkeitsdatum() {
        return faelligkeitsdatum;
    }

    public void setFaelligkeitsdatum(Date faelligkeitsdatum) {
        this.faelligkeitsdatum = faelligkeitsdatum;
    }
}
