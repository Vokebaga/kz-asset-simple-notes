package kz.asset.learningproject.service;

import kz.asset.learningproject.model.Note;
import kz.asset.learningproject.model.dto.NoteDto;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();

    Note createNote(NoteDto dto);

    Note getNoteById(Long id);
    Note updateNote(Long id, NoteDto dto);
    void deleteNote(Long id);
}
