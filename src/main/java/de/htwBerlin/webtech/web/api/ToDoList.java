package de.htwBerlin.webtech.web.api;

import java.time.LocalDate;

public class ToDoList {

    private long id;
    private String todoTitel;
    private String beschreibung;
    private boolean status;
    private LocalDate faelligkeitsdatum;


    public ToDoList(long id, String todoTitel, String beschreibung, boolean status, LocalDate faelligkeitsdatum) {
        this.id = id;
        this.todoTitel = todoTitel;
        this.beschreibung = beschreibung;
        this.status = status;
        this.faelligkeitsdatum = faelligkeitsdatum;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getFaelligkeitsdatum() {
        return faelligkeitsdatum;
    }

    public void setFaelligkeitsdatum(LocalDate faelligkeitsdatum) {
        this.faelligkeitsdatum = faelligkeitsdatum;
    }
}
