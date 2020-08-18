package ru.sotnikov.bot.core.commands;

import ru.sotnikov.bot.core.modules.CourseBitcoinParser;
import ru.sotnikov.bot.entity.Entity;

import java.io.IOException;

public class CourseBitcoin extends DefaultCommand {

    public CourseBitcoin(Entity entity) {
        super(entity);
    }

    public void getCourse() {
        String course;
        try {
            course = new CourseBitcoinParser().getCourseOnline();
            course = "Текущий курс биткоина - " + course + "$";
        } catch (IOException e) {
            course = "Не удалось получить текущий курс";
        }
        sendMessage(getEntity().getFirstUser().getFirstNameIDs().concat(course));
    }
}
