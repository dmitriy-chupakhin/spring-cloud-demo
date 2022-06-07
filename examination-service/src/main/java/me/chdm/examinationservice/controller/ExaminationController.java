package me.chdm.examinationservice.controller;

import lombok.AllArgsConstructor;
import me.chdm.examinationservice.model.Examination;
import me.chdm.examinationservice.model.Question;
import me.chdm.examinationservice.model.Section;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ExaminationController {

    private final RestTemplate restTemplate;

    @PostMapping("/examination")
    public Examination getExamination(@RequestBody Map<String, Integer> specification) {
        List<Section> sections = specification.entrySet().stream()
                .map(this::getUrl)
                .map(url -> restTemplate.getForObject(url, Question[].class))
                .map(Arrays::asList)
                .map(Section::new)
                .toList();

        return Examination.builder().title("Examination").sections(sections).build();
    }

    private String getUrl(Map.Entry<String, Integer> entry) {
        return String.format("http://%s/api/questions?amount=%d", entry.getKey(), entry.getValue());
    }
}
