package io.piano.disnoire.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnswerDto {

    private List<String> tags;
    private Owner owner;
    private String is_answered;
    private String view_count;
    private String answer_count;
    private String score;
    private String last_activity_date;
    private String creation_date;
    private String last_edit_date;
    private String question_id;
    private String link;
    private String title;

}
