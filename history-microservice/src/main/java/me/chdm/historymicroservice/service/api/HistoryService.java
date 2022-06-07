package me.chdm.historymicroservice.service.api;

import me.chdm.historymicroservice.model.dto.QuestionDto;

import java.util.List;

public interface HistoryService {
    void saveQuestion(QuestionDto questionDto);
    List<QuestionDto> getRandomQuestions(int amount);
}
