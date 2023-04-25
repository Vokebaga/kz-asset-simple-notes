package kz.asset.learningproject.service.impl;

import kz.asset.learningproject.exeption.ResourceNotFoundException;
import kz.asset.learningproject.model.Note;
import kz.asset.learningproject.model.dto.NoteDto;
import kz.asset.learningproject.repository.NoteRepository;
import kz.asset.learningproject.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return Collections.emptyList();
    }
    @Override
    public Note createNote(NoteDto dto) {
        // todo can be refactored using Converter (check Baeldung, Geeksfogeeks, StackOverflow)
        Note note = new Note();
        note.setContent(dto.getContent());
        note.setTitle(dto.getTitle());
        //
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(Long noteId) {
                return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @Override
    public Note updateNote(Long noteId, NoteDto dto) {
                Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());

        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long noteId) {
                Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);

    }
}
