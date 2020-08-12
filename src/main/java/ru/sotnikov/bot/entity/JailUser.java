package ru.sotnikov.bot.entity;

import java.util.Objects;

public class JailUser {
    private int id;
    private int count = 0;

    public JailUser(int id,int count) {
        setId(id);
        setCount(count);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
