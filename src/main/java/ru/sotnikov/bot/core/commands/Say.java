package ru.sotnikov.bot.core.commands;

import ru.sotnikov.bot.entity.Entity;

public class Say extends DefaultCommand {

    String msg = "";

    public Say(Entity entity) {
        super(entity);
    }

    public void testSay() {
        if (isNotSecondUser())
            msg = msg.concat(getEntity().getFirstUser().getFirstNameIDs().concat("Привет"));
        else
            msg = msg.concat(getEntity().getFirstUser().getFirstNameIDs()).concat("переслал(а) сообщение ")
                    .concat(getEntity().getSecondUser().getFirstNameID());
        sendMessage(msg);
    }

    public void sayAll() {
        msg = msg.concat(getEntity().getFirstUser().getFirstNameIDs()).concat("позвал(а) всех - @all");
        sendMessage(msg);
    }

    public void sayOnline() {
        msg = msg.concat(getEntity().getFirstUser().getFirstNameIDs()).concat("позвал(а) всех, кто находился онлайн - @online");
        sendMessage(msg);
    }

    public boolean isContainsID(){
       return getEntity().getTextMessageSplit(1).contains("[")&&getEntity().getTextMessageSplit(1)
               .contains("]")&&getEntity().getTextMessageSplit(1)
               .contains("|")&&getEntity().getTextMessageSplit(1)
               .contains("id");
    }

    public void sayHit(){
        sayRPCommand("ударил(а) ","неизвестую цель","пустоту","👊");
    }
    public void sayKiss(){
        sayRPCommand("поцеловал(а) ","неизвестую цель","воздух","😘");
    }
    public void sayMurder(){
        sayRPCommand("убил(а) ","неизвестую цель","муху","\uD83E\uDD21\uD83D\uDD2A");
    }
    public void sayRape(){
        sayRPCommand("надругался(ась) над ","неизвестной целью","рукой","\uD83D\uDC49\uD83D\uDC4C\uD83D\uDE01");
    }
    public void saySex(){
        sayRPCommand("принудил(а) к жесткому интиму ","неизвестую цель","бутылку","\uD83D\uDC49\uD83D\uDC4C");
    }
    public void sayBurt(){
        sayRPCommand("сжёг(сожгла) ","неизвестую цель","дрова в печке","🔥🌚");
    }
    public void sayShake(){
        sayRPCommand("пожал(а) руку ","непонятно кому)","незнакомцу","🤝");
    }

    public void sayRPCommand(String first,String second,String three,String four){
        msg = msg.concat(getEntity().getFirstUser().getFirstNameIDs().concat(first));
        if(isNotSecondUser()){
            if(getEntity().getTextMessageSplit().length>1){
                if(isContainsID()){
                    msg = msg.concat(getEntity().getTextMessageSplit(1));
                }else{
                    msg = msg.concat(second);
                }
            }else{
                msg = msg.concat(three);
            }
        }else {
            msg = msg.concat(getEntity().getSecondUser().getFirstNameID());
        }
        sendMessage(msg + four);
    }

    public void Command() {
        sendMessage("https://sites.google.com/view/dayandnight0");
    }


}
