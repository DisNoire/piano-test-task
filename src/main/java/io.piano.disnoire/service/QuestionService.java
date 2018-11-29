package io.piano.disnoire.service;

import io.piano.disnoire.dto.ResponsesDto;
import io.piano.disnoire.param.Sort;

public interface QuestionService{

    ResponsesDto sendQuestionToStackoverflowAPI(String question, Sort sort);

}