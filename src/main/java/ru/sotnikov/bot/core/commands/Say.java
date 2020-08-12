package ru.sotnikov.bot.core.commands;

import com.petersamokhin.vksdk.core.model.objects.Message;
import ru.sotnikov.bot.entity.Entity;

public class Say extends DefaultCommand{

    public Say(Entity entity) {
        super(entity);
    }

    public void testSay(){
        String msg = "";
        if (isSecondUser())
            msg =  msg.concat(getEntity().getFirstUser().getFirstName().concat(", Привет"));
        else
           msg = msg.concat(getEntity().getFirstUser().getFirstName()).concat(", переслал(а) сообщение ")
                .concat(getEntity().getSecondUser().getFirstName());
        sendMessage(msg);

    }
    public String sayAll(){
        return "позвал всех - @all";
    }
    public String sayOnline(){
        return "позвал людей находящихся онлайн - @online" + " \uD83D\uDE01";
    }
    public String sayAttack() {return "уебал ";}
    public String sayAttack(String name)
    {
        if(name.startsWith("[")&&name.endsWith("]")&&name.contains("@")&&name.contains("id")&&!name.contains(" ")) return "уебал" + name;
        return "Цель не найдена";
    }
    public String sayBite(){
        return "укусил ";
    }
    public String sayBite(String name){
        if(name.startsWith("[")&&name.endsWith("]")&&name.contains("@")&&name.contains("id")&&!name.contains(" ")) return "искусал всего" + name;
        return "Цель не найдена";
    }
    public String saySex() {return "Трахнул ";}
    public String saySex(String name)
    {
        if(name.startsWith("[")&&name.endsWith("]")&&name.contains("@")&&name.contains("id")&&!name.contains(" ")) return "Надругался" + name;
        return "Цель не найдена";
    }
    public String sayHome(){
        return " я тут, чего звал?";
    }
}
