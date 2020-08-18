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
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID()).concat("позвал(а) всех - @all");
        sendMessage(msg);
    }

    public void sayOnline() {
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID()).concat("позвал(а) всех, кто находился онлайн - @online");
        sendMessage(msg);
    }

    public boolean isContainsID(){
       return getEntity().getTextMessageSplit(1).contains("[")&&getEntity().getTextMessageSplit(1)
               .contains("]")&&getEntity().getTextMessageSplit(1)
               .contains("|")&&getEntity().getTextMessageSplit(1)
               .contains("id");
    }

    public void sayHit(){
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID().concat("ударил(а) "));
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
        sendMessage(msg+"👊");
    }
    public void sayKiss(){
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID().concat("поцеловал(а) "));
        if(isNotSecondUser()){
            if(getEntity().getTextMessageSplit().length>1){
                if(isContainsID()){
                    msg = msg.concat(getEntity().getTextMessageSplit(1));
                }else{
                    msg = msg.concat("неизвестую цель");
                }
            }else{
                msg = msg.concat("воздух");
            }
        }else {
            msg = msg.concat(getEntity().getSecondUser().getFirstNameID());
        }
        sendMessage(msg+"😘");
    }
    public void sayMurder(){
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID().concat("убил(а) "));
        if(isNotSecondUser()){
            if(getEntity().getTextMessageSplit().length>1){
                if(isContainsID()){
                    msg = msg.concat(getEntity().getTextMessageSplit(1));
                }else{
                    msg = msg.concat("неизвестую цель");
                }
            }else{
                msg = msg.concat("муху");
            }
        }else {
            msg = msg.concat(getEntity().getSecondUser().getFirstNameID());
        }
        sendMessage(msg+"🤡🔪");
    }
    public void sayRape(){
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID().concat("надругался(ась) над "));
        if(isNotSecondUser()){
            if(getEntity().getTextMessageSplit().length>1){
                if(isContainsID()){
                    msg = msg.concat(getEntity().getTextMessageSplit(1));
                }else{
                    msg = msg.concat("неизвестую цель");
                }
            }else{
                msg = msg.concat("руку");
            }
        }else {
            msg = msg.concat(getEntity().getSecondUser().getFirstNameID());
        }
        sendMessage(msg+"👉👌😁");
    }
    public void saySex(){
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID().concat("принудил(а) к жесткому интиму "));
        if(isNotSecondUser()){
            if(getEntity().getTextMessageSplit().length>1){
                if(isContainsID()){
                    msg = msg.concat(getEntity().getTextMessageSplit(1));
                }else{
                    msg = msg.concat("неизвестую цель");
                }
            }else{
                msg = msg.concat("бутылку");
            }
        }else {
            msg = msg.concat(getEntity().getSecondUser().getFirstNameID());
        }
        sendMessage(msg+"👉👌");
    }
    public void sayBurt(){
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID().concat("сжёг(сожгла) "));
        if(isNotSecondUser()){
            if(getEntity().getTextMessageSplit().length>1){
                if(isContainsID()){
                    msg = msg.concat(getEntity().getTextMessageSplit(1));
                }else{
                    msg = msg.concat("неизвестую цель");
                }
            }else{
                msg = msg.concat("дрова в печке");
            }
        }else {
            msg = msg.concat(getEntity().getSecondUser().getFirstNameID());
        }
        sendMessage(msg+"🔥🌚");
    }
    public void sayShake(){
        msg = msg.concat(getEntity().getFirstUser().getFirstNameID().concat("пожал(а) руку "));
        if(isNotSecondUser()){
            if(getEntity().getTextMessageSplit().length>1){
                if(isContainsID()){
                    msg = msg.concat(getEntity().getTextMessageSplit(1));
                }else{
                    msg = msg.concat("непонятно кому)");
                }
            }else{
                msg = msg.concat("незнакомцу");
            }
        }else {
            msg = msg.concat(getEntity().getSecondUser().getFirstNameID());
        }
        sendMessage(msg+"🤝");
    }
    public void Command() {
        sendMessage("https://sites.google.com/view/dayandnight0");
    }


}
