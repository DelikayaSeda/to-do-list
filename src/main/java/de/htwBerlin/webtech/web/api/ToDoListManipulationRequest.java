package de.htwBerlin.webtech.web.api;

import java.time.LocalDate;

public class ToDoListManipulationRequest {

    private String ordnerName;
    private String aufgabenName;
    private boolean done;
    private LocalDate faelligkeitsdatum;

    public ToDoListManipulationRequest(String ordnerName, String aufgabenName, boolean done, LocalDate faelligkeitsdatum) {
        this.ordnerName = ordnerName;
        this.aufgabenName = aufgabenName;
        this.done = done;
        this.faelligkeitsdatum = faelligkeitsdatum;
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
