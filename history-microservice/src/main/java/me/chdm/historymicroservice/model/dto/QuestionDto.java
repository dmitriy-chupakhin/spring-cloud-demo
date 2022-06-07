package me.chdm.historymicroservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chdm.historymicroservice.model.Question;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    private String question;
    private String answer;

    public QuestionDto(Question question) {
        this.question = question.getQuestion();
        this.answer = question.getAnswer();
    }

    public Question fromDto() {
        return Question.builder().question(this.getQuestion()).answer(this.getAnswer()).build();
    }
}
