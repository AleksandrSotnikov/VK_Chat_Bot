package ru.sotnikov.bot.core.commands;

import com.petersamokhin.vksdk.core.http.Parameters;
import ru.sotnikov.bot.entity.Entity;
import ru.sotnikov.bot.entity.PunishmentUser;

import java.util.ArrayList;

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

    public PunishmentUser punish(ArrayList<PunishmentUser> punishing){
        PunishmentUser pun = new PunishmentUser(getEntity().getPeerId(),getEntity().getSecondUser().getId());
        if(punishing.contains(pun)){
            if(punishing.get(punishing.indexOf(pun)).getPunishmentCount()==5){
                kick();
                pun.setPunishmentCount(0);
                return pun;
            }else{
                return punishing.get(punishing.indexOf(pun));
            }
        }
        return pun;
    }
}
