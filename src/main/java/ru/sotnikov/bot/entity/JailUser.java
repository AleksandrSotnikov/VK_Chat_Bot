package ru.sotnikov.bot.entity;

import java.util.Objects;

public class JailUser {
    private int id;
    private int countMine = 0;
    private int countCase = 0;

    public JailUser(int id,int countMine,int countCase) {
        setId(id);
        setCountMine(countMine);
        setCountCase(countCase);
    }

    public int getCountCase() {
        return countCase;
    }

    public void setCountCase(int countCase) {
        this.countCase = countCase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountMine() {
        return countMine;
    }

    public void setCountMine(int count) {
        this.countMine = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JailUser jailUser = (JailUser) o;
        return id == jailUser.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
