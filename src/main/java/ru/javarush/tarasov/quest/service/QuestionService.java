package ru.javarush.tarasov.quest.service;

import ru.javarush.tarasov.quest.entity.Question;
import ru.javarush.tarasov.quest.repository.QuestionRepository;
import ru.javarush.tarasov.quest.repository.Repository;

public class QuestionService {
    private final Repository<Question> questionRepository = new QuestionRepository();

    public Question getQuestionById(int id) {
        return questionRepository.getById(id);
    }
}
