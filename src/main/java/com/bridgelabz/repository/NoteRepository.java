package com.bridgelabz.repository;

import com.bridgelabz.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUserId(Long userId);
    Optional<Note> findByIdAndUserId(Long id, Long userId);
}