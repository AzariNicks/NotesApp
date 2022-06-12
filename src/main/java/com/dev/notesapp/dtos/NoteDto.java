package com.dev.notesapp.dtos;

import com.dev.notesapp.entities.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto implements Serializable {
    private  Long id;
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private UserDto userDto;



    public NoteDto(Note note){
        if(note.getId() != null){
            this.id = note.getId();
        }
        if(note.getBody() != null){
            this.body  = note.getBody();

        }


    }



}
