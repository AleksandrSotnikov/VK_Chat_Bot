package ru.sotnikov.bot.core.commands;

import ru.sotnikov.bot.core.modules.CourseBitcoinParser;

import java.io.IOException;

public class CourseBitcoin {

    public String getCourse(){
        String course;
        try {
            course = new CourseBitcoinParser().getCourseOnline();
            course = "Текущий курс биткоина - " + course + "$";
        } catch (IOException e) {
            course = "Не удалось получить курс";
        }

        return course;
    }
}
