package ru.javarush.tarasov.quest.service;

import ru.javarush.tarasov.quest.entity.Quest;
import ru.javarush.tarasov.quest.repository.QuestRepository;
import ru.javarush.tarasov.quest.repository.Repository;

import java.util.List;

public class QuestService {
    private final Repository<Quest> questRepository = new QuestRepository();

    public List<Quest> getAll() {
        return questRepository.getAll();
    }

    public Quest getById(int id){
        return questRepository.getById(id);
    }
}
