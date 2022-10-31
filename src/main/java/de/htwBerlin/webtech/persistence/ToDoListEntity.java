package de.htwBerlin.webtech.persistence;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "ToDos")
public class ToDoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "ordnerName", nullable = false)
    private String ordnerName;

    @Column(name = "aufgabenName", nullable = false)
    private String aufgabenName;

    @Column(name = "done")
    private boolean done;

    @Column(name = "faelligkeitsdatum")
    private LocalDate faelligkeitsdatum;

    public ToDoListEntity(long id, String ordnerName, String aufgabenName, boolean done, LocalDate faelligkeitsdatum) {
        this.id = id;
        this.ordnerName = ordnerName;
        this.aufgabenName = aufgabenName;
        this.done = done;
        this.faelligkeitsdatum = faelligkeitsdatum;
    }

    public ToDoListEntity() {
    }

    public long getId() {
        return id;
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
