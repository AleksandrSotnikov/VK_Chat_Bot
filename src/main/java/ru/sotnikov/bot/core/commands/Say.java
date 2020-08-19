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
        sayRPCommand("ударил(а) ","","пустоту","👊");
    }
    public void sayKiss(){
        sayRPCommand("поцеловал(а) ","","воздух","😘");
    }
    public void sayMurder(){
        sayRPCommand("убил(а) ","","муху","\uD83E\uDD21\uD83D\uDD2A");
    }
    public void sayRape(){
        sayRPCommand("надругался(ась) над ","","рукой","\uD83D\uDC49\uD83D\uDC4C\uD83D\uDE01");
    }
    public void saySex(){
        sayRPCommand("принудил(а) к жесткому интиму ","","бутылку","\uD83D\uDC49\uD83D\uDC4C");
    }
    public void sayBurt(){
        sayRPCommand("сжёг(сожгла) ","","дрова в печке","🔥🌚");
    }
    public void sayShake(){
        sayRPCommand("пожал(а) руку ","","незнакомцу","🤝");
    }
    public void sayDrown(){
        sayRPCommand("утопил(а) ","","камень ","🌊🤡");
    }
    public void sayGive_five(){
        sayRPCommand("дал(а) пять ","","себе ","🖐");
    }
    public void sayScare(){
        sayRPCommand("испугал(а) ","","кошку ","😱");
    }
    public void sayApologize(){
        sayRPCommand("извинился(ась) перед ","","зеркалом ","🙏");
    }
    public void sayKus(){
        sayRPCommand("укусил(а) ","","себя за руку ","😬😝");
    }
    public void sayCastrate(){
        sayRPCommand("кастрировал(а) ","","бедного котика ","✂😎");
    }
    public void saySniff(){
        sayRPCommand("понюхал(а) ","","горлышко бутылки ","👃");
    }
    public void sayGive_myself(){
        sayRPCommand("отдался(ась) ","","воздуху ","🔞😏");
    }
    public void sayPraise(){
        sayRPCommand("похвалил(а) ","","себя лучшего(ую) ","☺");
    }
    public void sayPoison(){
        sayRPCommand("отравил(а) ","","демона ","🍄🐍");
    }
    public void sayHug(){
        sayRPCommand("обнял(а) ","","кошечку ","🤗");
    }
    public void sayLick(){
        sayRPCommand("лизнул(а) ","","ножечку ","👅");
    }
    public void sayTouch(){
        sayRPCommand("потрогал(а) ","","себя за 5-ю точку ","✋");
    }
    public void sayPin(){
        sayRPCommand("прижал(а) ","","подушку к себе ","👐");
    }
    public void sayCongratulate(){
        sayRPCommand("поздравил(а) ","","семя родного(ую) ","🎁🎉🥳");
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
