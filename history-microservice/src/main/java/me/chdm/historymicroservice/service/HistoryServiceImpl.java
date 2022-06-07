package me.chdm.historymicroservice.service;

import lombok.AllArgsConstructor;
import me.chdm.historymicroservice.model.Question;
import me.chdm.historymicroservice.model.dto.QuestionDto;
import me.chdm.historymicroservice.model.repository.QuestionRepository;
import me.chdm.historymicroservice.service.api.HistoryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final QuestionRepository questionRepository;


    @Override
    public void saveQuestion(QuestionDto questionDto) {
        questionRepository.save(questionDto.fromDto());
    }

    @Override
    public List<QuestionDto> getRandomQuestions(int amount) {
        // TODO: 08.06.2022 сделать запрос на рандомные вопросы на уровне базы
        List<Question> questions = questionRepository.findAll();
        Collections.shuffle(questions);
        return questions.stream().limit(amount).map(QuestionDto::new).collect(Collectors.toList());
    }
}
