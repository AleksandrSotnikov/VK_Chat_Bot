package ru.sotnikov.bot.core;

import ru.sotnikov.bot.core.commands.CaseKick;
import ru.sotnikov.bot.core.commands.CourseBitcoin;
import ru.sotnikov.bot.core.commands.MinerKick;
import ru.sotnikov.bot.core.commands.Say;
import ru.sotnikov.bot.entity.Entity;
import ru.sotnikov.bot.entity.JailUser;

import java.util.ArrayList;

import static ru.sotnikov.bot.core.commands.MinerKick.getJSON;

public class MsgCheck {
    private static ArrayList<String> command = new ArrayList<>();
    private static ArrayList<JailUser> jail = new ArrayList<>();

    public MsgCheck() {
    }

    public boolean getIsCommand(String command){
        return MsgCheck.command.contains(command);
    }

    public void getResponse(Entity entity){
        switch (entity.getTextMessageSplit(0).toLowerCase()) {
            case "тест":
                //new Say(entity).testSay();
                break;
            case "курс":
                new CourseBitcoin(entity).getCourse();
                break;
            case "название":
                //new ReName(entity).newName();
                break;
            case "копать":
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
            case "кнопки":
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
                break;
            case "test":
                if (entity.getFirstUser().getId() == 383119183) {
                    new Say(entity).sendMessage("test");
                }
                break;
        }
    }

    /*public String getResponse(boolean secondUser, String name2) {
        String response = "";
        String[] text =  message.getMessage().getText().split(" ");
        String fullText = message.getMessage().getText();
        switch (text[0].toLowerCase()){
            case "курс":
                response = new CourseBitcoin().getCourse();
                break;
            case "позвать":
                if (text.length>1)
                switch (text[1].toLowerCase()){
                    case "всех":
                        response = new Say().sayAll();
                        break;
                    case "онлайн":
                        response = new Say().sayOnline();
                        break;
                    default: response = "Введите правильный параметр:\n\tвсех/онлайн";
                }
                else{
                    response = "Не найден параметр:\n\tвсех/онлайн";
                }
                break;
            case "бот":
                response = new Say().sayHome();
                break;
            case "уебать":
                try {
                    response = !secondUser? new Say().sayAttack(text[1]):new Say().sayAttack().concat(" ").concat(name2);
                }catch (ArrayIndexOutOfBoundsException e){
                    response = "Бить себя не самая лучшая идея";
                }
                break;
            case "укусить":
                try {
                    response = !secondUser? new Say().sayBite(text[1]):new Say().sayBite().concat(" ").concat(name2);
                }catch (ArrayIndexOutOfBoundsException e){
                    response = "Кусать себя не самая лучшая идея";
                }
                break;
            case "трахнуть":
                try {
                    response = !secondUser? new Say().saySex(text[1]):new Say().saySex().concat(" ").concat(name2);
                }catch (ArrayIndexOutOfBoundsException e){
                    response = "Ну не надо же себя";
                }
                break;
            case "название":
                if (message.getMessage().getPeerId() == message.getMessage().getFromId()) response = "Вы не можете изменить название сообщества с ботом";
                else  response = new ReName(getVkApiClient()).newName(fullText,message.getMessage().getPeerId());
                break;
        }
        return response;
    }*/

    //public static ArrayList<String> getCommand() {
    //    return command;
    //}
//
    //public static void setCommand(ArrayList<String> command) {
    //    MsgCheck.command = command;
    //}

   //public void updateCommand(){
   //    command.add("курс");
   //    command.add("позвать");
   //    command.add("бот");
   //    command.add("уебать");
   //    command.add("укусить");
   //    command.add("название");
   //    command.add("трахнуть");
   //    command.add("тест");
   //}

}
