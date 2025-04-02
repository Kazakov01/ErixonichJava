package org.example.reflection;

import java.time.LocalDate;

public class TestEntity {
    private int id;
    private String name;
    private LocalDate birthday;

    private TestEntity(int id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    private TestEntity(int id, LocalDate birthday, String name) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
