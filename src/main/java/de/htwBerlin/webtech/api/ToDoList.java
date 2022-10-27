package de.htwBerlin.webtech.api;

import java.time.LocalDate;

public class ToDoList {

    private long id;
    private String ordnerName;
    private String aufgabenName;
    private boolean done;
    private LocalDate faelligkeitsdatum;

    public ToDoList(long id, String ordnerName, String aufgabenName, boolean done, LocalDate faelligkeitsdatum) {
        this.id = id;
        this.ordnerName = ordnerName;
        this.aufgabenName = aufgabenName;
        this.done = done;
        this.faelligkeitsdatum = faelligkeitsdatum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrdnerName() {
        return ordnerName;
    }

    public void setOrdnerName(String ordnerName) {
        this.ordnerName = ordnerName;
    }

    public String getAufgabenName() {
        return aufgabenName;
    }

    public void setAufgabenName(String aufgabenName) {
        this.aufgabenName = aufgabenName;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getFaelligkeitsdatum() {
        return faelligkeitsdatum;
    }

    public void setFaelligkeitsdatum(LocalDate faelligkeitsdatum) {
        this.faelligkeitsdatum = faelligkeitsdatum;
    }
}
