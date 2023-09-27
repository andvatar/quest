package ru.javarush.tarasov.quest.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.tarasov.quest.entity.Question;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class QuestionRepository implements Repository<Question> {
    @Override
    public List<Question> getAll() {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Question> questionList;
        try {
            URL url = this.getClass().getClassLoader().getResource("questions.json");
            if(url == null) {
                throw new RuntimeException("Cannot get questions list");
            }
            Path path = Paths.get(url.toURI());
            String questions = Files.readString(path);

            questionList = objectMapper.readValue(questions, new TypeReference<>() {});
        }
        catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return questionList;
    }

    @Override
    public Question getById(long id) {
        return getAll()
                .stream()
                .filter(question -> question.getId() == id)
                .findAny()
                .orElse(null);

    }
}
