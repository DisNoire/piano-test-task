package io.piano.disnoire.controller;

import io.piano.disnoire.dto.ResponsesDto;
import io.piano.disnoire.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    private final QuestionService questionService;

    @Autowired
    public SearchController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("search")
    public String getSearchPage(@RequestParam(value = "query", required = false) String query, Model model) {
        if (query == null) {
            return "search";
        }

        ResponsesDto response = questionService.sendQuestionToStackoverflowAPI(query);

        if (response.getResponses().size() > 0) {
            model.addAttribute("answers", response);
        }

        return "search";
    }
}
