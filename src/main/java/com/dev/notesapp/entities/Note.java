package com.dev.notesapp.entities;
import com.dev.notesapp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;



import javax.persistence.*;

@Entity
@Table(name = "Notes")


public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")
    private String body;

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Note(NoteDto noteDto){
        if(noteDto.getBody() != null){
            this.body = noteDto.getBody();

        }
    }


    public Note(Long id, String body) {
        this.id = id;
        this.body = body;
    }

    @ManyToOne
    @JsonBackReference
    private User user;

    public void setUser(User user) {
    }
}
