package ru.javarush.tarasov.quest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Question {
    private int id;
    private String text;
    private final List<Answer> answers = new ArrayList<>();

    @JsonProperty("answers")
    private void unpackAnswers(List<LinkedHashMap<String, Object>> answers) {
        for (var answer:answers) {
            this.answers.add(new Answer((int)answer.get("id"), (String)answer.get("text"), (int)answer.get("nextQuestionId")));
        }
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("text", text)
                .append("answers", answers)
                .toString();
    }
}
