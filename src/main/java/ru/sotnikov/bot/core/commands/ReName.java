package ru.sotnikov.bot.core.commands;

import com.petersamokhin.vksdk.core.client.VkApiClient;
import com.petersamokhin.vksdk.core.http.Parameters;

public class ReName {

    private static VkApiClient vkApiClient = null;

    public ReName(VkApiClient vkApiClient) {
        setVkApiClient(vkApiClient);
    }

    public static VkApiClient getVkApiClient() {
        return vkApiClient;
    }

    public static void setVkApiClient(VkApiClient vkApiClient) {
        ReName.vkApiClient = vkApiClient;
    }

    public String newName(String title,int chatid){
        title = title.substring(title.indexOf(" "));
        vkApiClient.call("messages.editChat", Parameters.of("chat_id",String.valueOf(chatid-2000000000),"title",title),false);
        return "Название беседы изменено";
    }
}
