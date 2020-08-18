package ru.sotnikov.bot.core;

import ru.sotnikov.bot.core.commands.*;
import ru.sotnikov.bot.entity.Entity;
import ru.sotnikov.bot.entity.JailUser;

import java.util.ArrayList;

public class MsgCheck {
    private static final ArrayList<String> command = new ArrayList<>();
    private static ArrayList<JailUser> jail = new ArrayList<>();

    public MsgCheck() {
    }

    public boolean getIsCommand(String command) {
        return MsgCheck.command.contains(command);
    }

    public void getResponse(Entity entity) {
        switch (entity.getTextMessageSplit(0).toLowerCase()) {
            case "тест":
                    new Say(entity).testSay();
                break;
            case "позвать":
                    switch (entity.getTextMessageSplit(1).toLowerCase()){
                        case "всех":
                                new Say(entity).sayAll();
                            break;
                        case "онлайн":
                                new Say(entity).sayOnline();
                            break;
                    }
            case "ударить":
                    new Say(entity).sayHit();
                break;
            case "поцеловать":
                new Say(entity).sayKiss();
                break;
            case "убить":
                new Say(entity).sayMurder();
                break;
            case "изнасиловать":
                new Say(entity).sayRape();
                break;
            case "трахнуть":
                new Say(entity).saySex();
                break;
            case "выебать":
                new Say(entity).saySex();
                break;
            case "пожать":
                switch (entity.getTextMessageSplit(1).toLowerCase()) {
                    case "руку":
                        new Say(entity).sayShake();
                        break;
                }
                break;
            case "команды":
                new Say(entity).Command();
                break;
            case "сжечь":
                new Say(entity).sayBurt();
                break;
            case "курс":
                    new CourseBitcoin(entity).getCourse();
                break;
            case "название":
                    new ReName(entity).newName();
                break;
            case "кик":
                if (entity.getFirstUser().getId() == 383119183|| entity.getFirstUser().getId() == 301418543)
                    new Punishment(entity).kick();
                break;
            case "test":
                if (entity.getFirstUser().getId() == 383119183) {
                    new Say(entity).sendMessage("test");
                }
                break;
        }
    }
}
