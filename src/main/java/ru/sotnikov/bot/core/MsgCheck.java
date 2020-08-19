package ru.sotnikov.bot.core;

import ru.sotnikov.bot.core.commands.*;
import ru.sotnikov.bot.entity.Entity;
import ru.sotnikov.bot.entity.JailUser;
import ru.sotnikov.bot.entity.PunishmentUser;

import java.util.ArrayList;

public class MsgCheck {
    private static final ArrayList<String> command = new ArrayList<>();
    //private static ArrayList<JailUser> jail = new ArrayList<>();
    private static ArrayList<PunishmentUser> punish = new ArrayList<>();

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
                    break;
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
            case "утопить":
                new Say(entity).sayDrown();
                break;
            case "дать":
                switch (entity.getTextMessageSplit(1).toLowerCase()) {
                    case "пять":
                            new Say(entity).sayGiveFive();
                        break;
                    case "шесть":
                            new Say(entity).sayGiveSix();
                        break;
                }
                break;
            case "испугать":
                new Say(entity).sayScare();
                break;
            case "извиниться":
                new Say(entity).sayApologize();
                break;
            case "кусь":
                new Say(entity).sayKus();
                break;
            case "кастрировать":
                new Say(entity).sayCastrate();
                break;
            case "выебать":
                new Say(entity).saySex();
                break;
            case "поздравить":
                new Say(entity).sayCongratulate();
                break;
            case "прижать":
                new Say(entity).sayPin();
                break;
            case "потрогать":
                new Say(entity).sayTouch();
                break;
            case "похвалить":
                new Say(entity).sayPraise();
                break;
            case "понюхать":
                new Say(entity).saySniff();
                break;
            case "пожать":
                switch (entity.getTextMessageSplit(1).toLowerCase()) {
                    case "руку":
                            new Say(entity).sayShake();
                        break;
                    case "лапу":
                            new Say(entity).sayShake();
                        break;
                    }
                break;
            case "команды":
                new Say(entity).Command();
                break;
            case "лизнуть":
                new Say(entity).sayLick();
                break;
            case "лизь":
                new Say(entity).sayLick();
                break;
            case "обнять":
                new Say(entity).sayHug();
                break;
            case "отравить":
                new Say(entity).sayPoison();
                break;
            case "отдаться":
                new Say(entity).sayGive_myself();
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
            case "пред":
                if (entity.getFirstUser().getId() == 383119183|| entity.getFirstUser().getId() == 301418543)
                   punish.add(new Punishment(entity).punish(punish).updatePunishmentCount());
                break;
            case "test":
                if (entity.getFirstUser().getId() == 383119183|| entity.getFirstUser().getId() == 301418543) {
                    new Say(entity).sendMessage("дрочи стоя пока тема не видит а как увидет беги т.к он присоединится");
                }
                break;
        }
    }
}
