package io.piano.disnoire.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Setter
@Getter
public class ResponseDto {

    private Date queryDate;
    private String title;
    private String userLink;
    private Boolean answered;
    private String ownerName;
    private String link;
    private String answersCount;
    private String viewCount;

    public ResponseDto(AnswerDto answerDTO) {
        this.queryDate = Date.from(Instant.ofEpochSecond(Long.parseLong(answerDTO.getCreation_date())));
        this.title = answerDTO.getTitle();
        this.userLink = answerDTO.getOwner().getLink();
        this.answered = Boolean.valueOf(answerDTO.getIs_answered());
        this.ownerName = answerDTO.getOwner().getDisplay_name();
        this.link = answerDTO.getLink();
        this.answersCount = answerDTO.getAnswer_count();
        this.viewCount = answerDTO.getView_count();
    }
}
