package me.chdm.mathmicroservice.controller;

import lombok.AllArgsConstructor;
import me.chdm.mathmicroservice.model.Question;
import me.chdm.mathmicroservice.service.api.MathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MathController {

    private MathService mathService;

    @GetMapping("/questions")
    public List<Question> getRandomQuestions(@RequestParam int amount) {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            questions.add(mathService.getRandomQuestions());
        }
        return questions;
    }
}
