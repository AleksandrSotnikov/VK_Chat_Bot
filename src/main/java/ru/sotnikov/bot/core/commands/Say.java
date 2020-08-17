package ru.sotnikov.bot.core.commands;

import ru.sotnikov.bot.entity.Entity;

public class Say extends DefaultCommand {

    String msg = "";

    public Say(Entity entity) {
        super(entity);
    }

    public void testSay() {
        if (isNotSecondUser())
            msg = msg.concat(getEntity().getFirstUser().getFirstName().concat(", Привет"));
        else
            msg = msg.concat(getEntity().getFirstUser().getFirstName()).concat(", переслал(а) сообщение ")
                    .concat(getEntity().getSecondUser().getFirstName());
        sendMessage(msg);
    }

    public void sayAll() {
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID()).concat("позвал всех - @all");
        sendMessage(msg);
    }

    public void sayOnline() {
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID()).concat("позвал всех, кто находился онлайн - @online");
        sendMessage(msg);
    }

    public boolean isContainsID(){
       return getEntity().getTextMessageSplit(1).contains("[")&&getEntity().getTextMessageSplit(1)
               .contains("]")&&getEntity().getTextMessageSplit(1)
               .contains("|")&&getEntity().getTextMessageSplit(1)
               .contains("id");
    }

    //RolePlay [id546127280|𝙸𝚖𝚙𝚎𝚛𝚊𝚝𝚘𝚛 𝚖𝚜𝚝𝚒𝚝𝚎lе𝚒]
    public void sayHit(){
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID().concat("ударил "));
        if(isNotSecondUser()){
            if(getEntity().getTextMessageSplit().length>1){
                if(isContainsID()){
                    msg = msg.concat(getEntity().getTextMessageSplit(1));
                }else{
                   msg = msg.concat("неизвестую цель");
                }
            }else{
                msg = msg.concat("пустоту");
            }
        }else {
            msg = msg.concat(getEntity().getSecondUser().getFirstNameID());
        }
        sendMessage(msg);
    }


}
