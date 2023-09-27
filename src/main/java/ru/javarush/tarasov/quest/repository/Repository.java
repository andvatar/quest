package ru.javarush.tarasov.quest.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    T getById(long id);
}
