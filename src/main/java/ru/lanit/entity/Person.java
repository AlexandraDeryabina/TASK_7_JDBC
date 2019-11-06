package ru.lanit.entity;

import java.io.Serializable;
import java.time.LocalDate;


public class Person implements Serializable {
    private String name;
    private String surname;
    private String patronymic;
    private String date;

    public Person(String name, String surname, String patronymic, String date) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.date = LocalDate.parse(date).toString();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDate() {
        return date;
    }
}
