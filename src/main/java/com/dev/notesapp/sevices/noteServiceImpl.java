package com.dev.notesapp.sevices;

import com.dev.notesapp.dtos.NoteDto;
import com.dev.notesapp.entities.Note;
import com.dev.notesapp.entities.User;
import com.dev.notesapp.repositories.NotesRepository;
import com.dev.notesapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class noteServiceImpl implements noteService  {
@Autowired
    private UserRepository userRepository;
@Autowired
    private NotesRepository noteRepository;
@Override
@Transactional
    public void deleteNoteById(Long noteId){
    Optional<Note> noteOptional = noteRepository.findById(noteId);
    noteOptional.ifPresent(note -> noteRepository.delete(note));
}

@Override
@Transactional
public void addNote(NoteDto noteDto, Long userId){
    Optional<User> userOptional = userRepository.findById(userId);
    Note note = new Note(noteDto);
    userOptional.ifPresent(note::setUser);
    /* this is created lol we dont have setUser*/
    noteRepository.saveAndFlush(note);
}

@Override
@Transactional
    public void  UpdateNoteById(NoteDto noteDto){
    Optional<Note> noteOptional = noteRepository.findById(noteDto.getId());
    noteOptional.ifPresent(note -> {
        note.setBody(noteDto.getBody());
    noteRepository.saveAndFlush(note);
    });
}

@Override
public List<NoteDto> getAllNotesByUserId(Long userId){
    Optional<User> userOptional = userRepository.findById(userId);
    if (userOptional.isPresent())
    {
        List<Note> noteList = noteRepository.findAllById((Iterable<Long>) userOptional.get());
       /* This is different noteList is suppose to equal
       * noteRepository.findAllByUserEquals(userOptional.get())
       * but findAllByUserEquals looks bugged its giving red wont compile
       *
       *
       * */



        return noteList.stream().map(note -> new NoteDto(note)).collect(Collectors.toList());
    }
    return Collections.emptyList();
}
@Override
public Optional<NoteDto> getNoteById(Long noteID){
    Optional<Note> noteOptional = noteRepository.findById(noteID);
    if(noteOptional.isPresent()){
        return  Optional.of(new NoteDto(noteOptional.get()));
    }
return Optional.empty();
}








}







