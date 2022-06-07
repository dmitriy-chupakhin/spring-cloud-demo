package me.chdm.mathmicroservice.controller;

import lombok.AllArgsConstructor;
import me.chdm.mathmicroservice.model.Question;
import me.chdm.mathmicroservice.service.api.MathService;
import org.springframework.web.bind.annotation.*;

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
            questions.add(mathService.getRandomQuestion());
        }
        return questions;
    }
}
