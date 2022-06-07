package me.chdm.historymicroservice.controller;

import lombok.AllArgsConstructor;
import me.chdm.historymicroservice.model.dto.QuestionDto;
import me.chdm.historymicroservice.service.api.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping("/questions")
    public List<QuestionDto> getRandomQuestions(@RequestParam int amount) {
        return historyService.getRandomQuestions(amount);
    }

    @PostMapping("/questions")
    public void saveQuestion(@RequestBody QuestionDto questionDto) {
        historyService.saveQuestion(questionDto);
    }
}
