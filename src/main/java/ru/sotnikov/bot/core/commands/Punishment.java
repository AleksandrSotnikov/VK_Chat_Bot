package ru.sotnikov.bot.core.commands;

import com.petersamokhin.vksdk.core.http.Parameters;
import ru.sotnikov.bot.entity.Entity;

public class Punishment extends DefaultCommand {
    public Punishment(Entity entity) {
        super(entity);
    }
    public void kick(){
        getEntity().getVkApiClient().call("messages.removeChatUser",
                Parameters.of("chat_id",
                        String.valueOf(getEntity().getPeerId() - 2000000000),
                        "member_id", String.valueOf(getEntity().getSecondUser().getId())),
                false);
    }
}
