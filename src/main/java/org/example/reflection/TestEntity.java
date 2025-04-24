package org.example.reflection;

import java.beans.ConstructorProperties;
import java.time.LocalDate;


public class TestEntity {
    private int id;
    private String name;
    private LocalDate birthday;

    private long balance;

    @ConstructorProperties({"id", "name", "birthday", "balance"})
    public TestEntity(@PlusOneAnno int id, String name, LocalDate birthday,@PlusOneAnno long balance) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    private TestEntity(int id, LocalDate birthday, String name, long balance) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    @LogAnno(lvl = "info")
    public int getId() {
        return id;
    }

    @LogAnno(lvl = "warn")
    public String getName() {
        return name;
    }

    @LogAnno(lvl = "error")
    public LocalDate getBirthday() {
        return birthday;
    }
}
