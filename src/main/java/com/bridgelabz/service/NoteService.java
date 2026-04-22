package com.bridgelabz.service;

import com.bridgelabz.dto.request.NoteDTO;
import com.bridgelabz.entity.Note;

public interface NoteService {
    Note createNote(NoteDTO noteDTO, String tokenEmail);
}