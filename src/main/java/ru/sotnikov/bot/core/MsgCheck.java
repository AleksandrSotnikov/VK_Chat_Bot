package ru.sotnikov.bot.core;

import com.petersamokhin.vksdk.core.client.VkApiClient;
import com.petersamokhin.vksdk.core.model.event.MessageNew;
import ru.sotnikov.bot.core.commands.CourseBitcoin;
import ru.sotnikov.bot.core.commands.ReName;
import ru.sotnikov.bot.core.commands.Say;

import java.util.ArrayList;

public class MsgCheck {
    private static MessageNew message = null;
    private static ArrayList<String> command = new ArrayList<>();
    private static VkApiClient vkApiClient = null;

    public MsgCheck(MessageNew message, VkApiClient vkApiClient) {
        setMessage(message);
        setVkApiClient(vkApiClient);
        updateCommand();
    }

    public boolean getIsCommand(String command){
        return MsgCheck.command.contains(command);
    }

    public String getResponse(boolean secondUser, String name2) {
        String response = "";
        String[] text =  message.getMessage().getText().split(" ");
        String fullText = message.getMessage().getText();
        switch (text[0].toLowerCase()){
            case "курс":
                response = new CourseBitcoin().getCourse();
                break;
            case "позвать":
                //response = new Say().sayAll();
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
    }

    public MessageNew getMessage() {
        return message;
    }

    public void setMessage(MessageNew message) {
        MsgCheck.message = message;
    }

    public static ArrayList<String> getCommand() {
        return command;
    }

    public static void setCommand(ArrayList<String> command) {
        MsgCheck.command = command;
    }

    public static VkApiClient getVkApiClient() {
        return vkApiClient;
    }

    public static void setVkApiClient(VkApiClient vkApiClient) {
        MsgCheck.vkApiClient = vkApiClient;
    }

    public void updateCommand(){
        command.add("курс");
        command.add("позвать");
        command.add("бот");
        command.add("уебать");
        command.add("укусить");
        command.add("название");
        command.add("трахнуть");
    }

}
