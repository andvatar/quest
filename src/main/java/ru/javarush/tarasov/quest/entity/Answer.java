package ru.javarush.tarasov.quest.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Answer {
    private final int id;
    private final String text;
    private final long nextQuestionId;

    public Answer(int id, String text, long nextQuestionId) {
        this.id = id;
        this.text = text;
        this.nextQuestionId = nextQuestionId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public long getNextQuestionId() {
        return nextQuestionId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("text", text)
                .append("nextQuestionId", nextQuestionId)
                .toString();
    }
}
