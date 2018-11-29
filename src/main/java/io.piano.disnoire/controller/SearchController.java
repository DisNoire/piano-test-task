package io.piano.disnoire.controller;

import io.piano.disnoire.dto.ResponsesDto;
import io.piano.disnoire.param.Sort;
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

    @GetMapping
    public String redirectToSearch() {
        return "redirect:/search";
    }

    @GetMapping("search")
    public String getSearchPage(@RequestParam(value = "query", required = false) String query,
                                @RequestParam(value = "sort", required = false) String sort, Model model) {
        if (query == null) {
            return "search";
        }

        Sort sortValue;

        if (sort == null) {
            sortValue = Sort.ACTIVITY;
        } else {
            switch (sort) {
                case "activity":
                    sortValue = Sort.ACTIVITY;
                    break;
                case "votes":
                    sortValue = Sort.VOTES;
                    break;
                case "creation":
                    sortValue = Sort.CREATION;
                    break;
                case "relevance":
                    sortValue = Sort.RELEVANCE;
                    break;
                default:
                    sortValue = Sort.ACTIVITY;
                    break;
            }
        }

        ResponsesDto response = questionService.sendQuestionToStackoverflowAPI(query, sortValue);

        if (response.getResponses().size() > 0) {
            model.addAttribute("answers", response);
        }

        return "search";
    }
}
