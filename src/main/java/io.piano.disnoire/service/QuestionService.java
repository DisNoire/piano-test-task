package io.piano.disnoire.service;

import io.piano.disnoire.dto.ResponsesDto;

public interface QuestionService{

    ResponsesDto sendQuestionToStackoverflowAPI(String question);

}