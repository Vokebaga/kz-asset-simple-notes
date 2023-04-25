package kz.asset.learningproject.controller;

import kz.asset.learningproject.exeption.ResourceNotFoundException;
import kz.asset.learningproject.model.Note;
import kz.asset.learningproject.model.dto.NoteDto;
import kz.asset.learningproject.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/all")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public Note createNote(@Valid @RequestBody NoteDto dto) {
        return noteService.createNote(dto);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteService.getNoteById(noteId);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                                           @Valid @RequestBody NoteDto dto) {
        return noteService.updateNote(noteId, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        noteService.deleteNote(noteId);

        return ResponseEntity.ok().build();
    }
}
