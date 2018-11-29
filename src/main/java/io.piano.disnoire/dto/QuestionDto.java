package io.piano.disnoire.dto;

import io.piano.disnoire.param.Sort;
import lombok.*;

@Getter
@Setter
public class QuestionDto {
    String question;
    Sort sort;
}
