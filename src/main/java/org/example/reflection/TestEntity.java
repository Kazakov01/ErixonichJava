package org.example.reflection;

import java.beans.ConstructorProperties;
import java.time.LocalDate;


public class TestEntity {
    private int id;
    private String name;
    private LocalDate birthday;

    private long balance;

    @ConstructorProperties({"id", "name", "birthday", "balance"})
    private TestEntity(@PlusOneAnno int id, String name, LocalDate birthday,@PlusOneAnno long balance) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    private TestEntity(int id, LocalDate birthday, String name, long balance) {
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
