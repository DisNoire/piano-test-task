package io.piano.disnoire.controller.rest;

import io.piano.disnoire.dto.QuestionDto;
import io.piano.disnoire.dto.ResponsesDto;
import io.piano.disnoire.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api")
public class QuestionRestController {

    private final QuestionService questionService;

    @Autowired
    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("ask/question")
    public ResponsesDto askQuestion(@RequestBody QuestionDto questionDto){
        return questionService.sendQuestionToStackoverflowAPI(questionDto.getQuestion());
    }
}
