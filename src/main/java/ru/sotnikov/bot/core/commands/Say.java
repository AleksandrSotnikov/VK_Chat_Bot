package ru.sotnikov.bot.core.commands;

import ru.sotnikov.bot.entity.Entity;

public class Say extends DefaultCommand {

    String msg = "";

    public Say(Entity entity) {
        super(entity);
    }

    public void testSay() {
        if (isSecondUser())
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
}
