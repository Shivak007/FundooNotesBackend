package com.bridgelabz.service.impl;

import com.bridgelabz.dto.request.NoteDTO;
import com.bridgelabz.entity.Note;
import com.bridgelabz.entity.User;
import com.bridgelabz.exception.UserException;
import com.bridgelabz.repository.NoteRepository;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Override
    public Note createNote(NoteDTO noteDTO, String tokenEmail) {
        User user = userRepository.findByEmail(tokenEmail)
                .orElseThrow(() -> new UserException("User associated with token not found!"));

        Note note = new Note();
        note.setTitle(noteDTO.getTitle());
        note.setDescription(noteDTO.getDescription());

        note.setColor(noteDTO.getColor() != null ? noteDTO.getColor() : "#FFFFFF");

        note.setUserId(user.getId());

        return noteRepository.save(note);
    }
    @Override
    public List<Note> getAllNotes(String tokenEmail) {
        User user = userRepository.findByEmail(tokenEmail)
                .orElseThrow(() -> new UserException("User not found!"));

        return noteRepository.findAllByUserId(user.getId());
    }
}