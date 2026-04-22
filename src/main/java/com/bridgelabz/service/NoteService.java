package com.bridgelabz.service;

import com.bridgelabz.dto.request.NoteDTO;
import com.bridgelabz.entity.Note;

import java.util.List;

public interface NoteService {
    Note createNote(NoteDTO noteDTO, String tokenEmail);
    List<Note> getAllNotes(String tokenEmail);
}