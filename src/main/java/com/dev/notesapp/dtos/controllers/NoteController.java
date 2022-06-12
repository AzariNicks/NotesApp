package com.dev.notesapp.dtos.controllers;

import com.dev.notesapp.dtos.NoteDto;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    @Autowired
    private com.dev.notesapp.sevices.noteService noteService;
    @GetMapping("/user/{userId}")
    public List<NoteDto> getNotesByUser(@PathVariable Long userId){
        return  noteService.getAllNotesByUserId(userId);

    }

    @PostMapping("user/{userId}")
    public void addNote(@RequestBody NoteDto noteDto,@PathVariable Long userId){

    noteService.addNote(noteDto , userId);

    }
    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@RequestBody NoteDto noteDto,@PathVariable Long userId){
        noteService.deleteNoteById(noteDto.getId());
    }
    @PutMapping()
    public void updateNote(@RequestBody NoteDto noteDto){
        noteService.UpdateNoteById(noteDto);
    }
    @GetMapping("/{noteId}")
    public Optional<NoteDto> getNodeById(@PathVariable Long noteId){
        return noteService.getNoteById(noteId);

    }


}
