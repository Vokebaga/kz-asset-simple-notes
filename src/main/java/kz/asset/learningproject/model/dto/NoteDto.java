package kz.asset.learningproject.model.dto;

import kz.asset.learningproject.model.Note;
import kz.asset.learningproject.service.NoteService;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto{

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
