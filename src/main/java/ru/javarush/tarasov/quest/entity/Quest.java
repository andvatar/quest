package ru.javarush.tarasov.quest.entity;

public class Quest {
    private int id;
    private String name;
    private String description;
    private int startQuestionId;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStartQuestionId() {
        return startQuestionId;
    }
}
