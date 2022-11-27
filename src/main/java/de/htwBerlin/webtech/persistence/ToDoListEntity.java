package de.htwBerlin.webtech.persistence;


import javax.persistence.*;
import java.time.LocalDate;
@Entity(name = "ToDos")
public class ToDoListEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "todoTitel", nullable = false)
    private String todoTitel;

    @Column(name = "beschreibung", nullable = false)
    private String beschreibung;

    @Column(name = "status")
    private boolean status;

    @Column(name = "faelligkeitsdatum")
    private LocalDate faelligkeitsdatum;

    public ToDoListEntity(String todoTitel, String beschreibung, boolean status, LocalDate faelligkeitsdatum) {
        this.todoTitel = todoTitel;
        this.beschreibung = beschreibung;
        this.status = status;
        this.faelligkeitsdatum = faelligkeitsdatum;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean done) {
        this.status = done;
    }

    public LocalDate getFaelligkeitsdatum() {
        return faelligkeitsdatum;
    }

    public void setFaelligkeitsdatum(LocalDate faelligkeitsdatum) {
        this.faelligkeitsdatum = faelligkeitsdatum;
    }
}
