package ru.sotnikov.bot.core.commands;

import com.petersamokhin.vksdk.core.http.Parameters;
import ru.sotnikov.bot.entity.Entity;

public class ReName extends DefaultCommand {

    public ReName(Entity entity) {
        super(entity);
    }

    public void newName() {
        getEntity().getVkApiClient().call("messages.editChat",
                Parameters.of("chat_id",
                        String.valueOf(getEntity().getPeerId() - 2000000000),
                        "title", getEntity().getTextMessage().substring(8)),
                false);
        sendMessage( getEntity().getFirstUser().getFirstNameID() + "Название беседы было изменено");
    }
}
