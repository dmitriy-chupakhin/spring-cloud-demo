package me.chdm.mathmicroservice.service;

import me.chdm.mathmicroservice.model.Question;
import me.chdm.mathmicroservice.service.api.MathService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MathServiceImpl implements MathService {
    private final Random random = new Random();

    @Override
    public Question getRandomQuestions() {
        int max = 10;
        int a = random.nextInt(max);
        int b = random.nextInt(max);
        return Question.builder().question(String.format("%d + %d = ?", a, b)).answer(String.valueOf(a + b)).build();
    }
}
