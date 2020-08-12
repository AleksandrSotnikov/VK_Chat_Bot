package ru.sotnikov.bot.core.commands;

import com.petersamokhin.vksdk.core.model.objects.Message;
import ru.sotnikov.bot.entity.Entity;

public class DefaultCommand {
    private Entity entity;

    public DefaultCommand(Entity entity) {
        this.entity = entity;
    }
    public void sendMessage(String msg){
        new Message()
                .peerId(entity.getMessage().getMessage().getPeerId())
                .text(msg)
                .sendFrom(entity.getVkApiClient())
                .execute();
    }

    public Entity getEntity() {
        return entity;
    }

    public boolean isSecondUser(){
        return getEntity().getSecondUser()==null;
    }
}
