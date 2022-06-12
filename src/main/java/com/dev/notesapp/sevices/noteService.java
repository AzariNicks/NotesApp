package com.dev.notesapp.sevices;

import com.dev.notesapp.dtos.NoteDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface noteService {
    @Transactional
    void deleteNoteById(Long noteId);

    @Transactional
    void addNote(NoteDto noteDto, Long userId);

    @Transactional
    void UpdateNoteById(NoteDto noteDto);

    List<NoteDto> getAllNotesByUserId(Long userId);

    Optional<NoteDto> getNoteById(Long noteID);
}
