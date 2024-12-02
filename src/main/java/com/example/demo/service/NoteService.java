package com.example.demo.service;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
@AllArgsConstructor
public class NoteService {
    @Autowired
private final NoteRepository noteRepository;

public List<Note> listAll() {
    List<Note> noteList = noteRepository.findAll();
    for (Note note : noteList) {
        System.out.println(note);
    }
    return noteList;
}

public Note add (Note note) {
    noteRepository.save(note);
    return note;
}

public void deleteById(Long id) {
    if(noteRepository.existsById(id)) {
        noteRepository.deleteById(id);
    }
    else {
        throw new IllegalArgumentException("Note not found");
    }
}

public void update(Note note) {
    if(noteRepository.existsById(note.getId())) {
        noteRepository.save(note);
    }
    else {
        throw new IllegalArgumentException("Note not found");
    }
}

public Note getById(Long id) {
    if(noteRepository.existsById(id)) {
        Object note = noteRepository.findById(id).get();
        return (Note) note;
    }
    else {
        throw new IllegalArgumentException("Note not found");
    }
}
}
