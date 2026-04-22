package com.bridgelabz.controller;

import com.bridgelabz.dto.request.NoteDTO;
import com.bridgelabz.dto.response.ResponseDTO;
import com.bridgelabz.entity.Note;
import com.bridgelabz.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@Slf4j
public class NoteController {

    private final NoteService noteService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createNote(@Valid @RequestBody NoteDTO noteDTO, Principal principal) {

        String userEmail = principal.getName();
        log.info("Request to create note received by: {}", userEmail);

        Note savedNote = noteService.createNote(noteDTO, userEmail);

        ResponseDTO responseDTO = new ResponseDTO("Note Created Successfully", savedNote.getId());
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);

        @GetMapping("/all")
        public ResponseEntity<ResponseDTO> getAllNotes(Principal principal) {
            String userEmail = principal.getName();
            log.info("Request to fetch all notes received from: {}", userEmail);

            List<Note> notesList = noteService.getAllNotes(userEmail);

            ResponseDTO responseDTO = new ResponseDTO("Notes Fetched Successfully", notesList);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
    }
}