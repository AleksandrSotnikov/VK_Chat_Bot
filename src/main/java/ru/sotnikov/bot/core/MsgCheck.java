package ru.sotnikov.bot.core;

import ru.sotnikov.bot.core.commands.*;
import ru.sotnikov.bot.entity.Entity;
import ru.sotnikov.bot.entity.JailUser;

import java.util.ArrayList;

import static ru.sotnikov.bot.core.commands.MinerKick.getJSON;

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
            case "курс":
                    new CourseBitcoin(entity).getCourse();
                break;
            case "название":
                    new ReName(entity).newName();
                break;
           /* case "копать":
                if (entity.getPeerId() == 2000000007)
                    jail = new MinerKick(entity, jail).minerDefend();
                break;
            case "кейс":
                if (entity.getPeerId() == 2000000007)
                    if (entity.getTextMessageSplit(1).equals("открыть") && entity.getTextMessageSplit(2).equals("1"))
                        jail = new CaseKick(entity, jail).caseDefend();
                break;
            case "[club171493284|@gorillabot]":
                if (entity.getPeerId() == 2000000007) {
                    if (entity.getTextMessageSplit(1).equals("⛏"))
                        jail = new MinerKick(entity, jail).minerDefend();
                    if (entity.getTextMessageSplit(1).equals("\uD83C\uDF81") && entity.getTextMessage().contains("1"))
                        jail = new CaseKick(entity, jail).caseDefend();
                }
                break;
           /* case "кнопки":
                if ((entity.getTextMessageSplit(1).toLowerCase().equals("вкл") || entity.getTextMessageSplit(1).toLowerCase().equals("включить")) && entity.getPeerId() == 2000000007) {
                    String msg = "https://api.vk.com/method/messages.send?peer_id=2000000310&message="
                            .concat("пред%20")
                            .concat(entity.getFirstUser().getFirstNameID().replace(", ", ""))
                            .concat("&v=5.38&access_token=").concat(entity.getAccessTokens());
                    getJSON(msg);
                    msg = "https://api.vk.com/method/messages.send?peer_id=2000000310&message="
                            .concat("кнопки%20выкл")
                            .concat("&v=5.38&access_token=").concat(entity.getAccessTokens());
                    getJSON(msg);
                    msg = "https://api.vk.com/method/messages.send?peer_id=2000000310&message="
                            .concat("мут%20")
                            .concat(entity.getFirstUser().getFirstNameID().replace(", ", ""))
                            .concat("&v=5.38&access_token=").concat(entity.getAccessTokens());
                    getJSON(msg);
                }
                break;*/
            case "test":
                if (entity.getFirstUser().getId() == 383119183) {
                    new Say(entity).sendMessage("test");
                }
                break;
        }
    }
}
