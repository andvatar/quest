package ru.javarush.tarasov.quest.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.tarasov.quest.entity.Quest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class QuestRepository implements Repository<Quest> {
    @Override
    public List<Quest> getAll() {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Quest> questList;
        try {
            URL url = this.getClass().getClassLoader().getResource("quests.json");
            if(url == null) {
                throw new RuntimeException("Cannot get quests list");
            }
            Path path = Paths.get(url.toURI());
            String quests = Files.readString(path);

            questList = objectMapper.readValue(quests, new TypeReference<>() {});
        }
        catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return questList;
    }

    @Override
    public Quest getById(long id) {
        return getAll()
                .stream()
                .filter(quest -> quest.getId() == id)
                .findAny()
                .orElse(null);
    }
}
