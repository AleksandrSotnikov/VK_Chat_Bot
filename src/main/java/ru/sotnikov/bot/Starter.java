package ru.sotnikov.bot;

import com.google.gson.Gson;
import com.petersamokhin.vksdk.core.api.VkApi;
import com.petersamokhin.vksdk.core.callback.Callback;
import com.petersamokhin.vksdk.core.client.VkApiClient;
import com.petersamokhin.vksdk.core.http.HttpClient;
import com.petersamokhin.vksdk.core.http.Parameters;
import com.petersamokhin.vksdk.core.model.VkSettings;
import com.petersamokhin.vksdk.core.model.objects.Message;
import com.petersamokhin.vksdk.http.VkOkHttpClient;
import kotlinx.serialization.json.JsonElement;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import ru.sotnikov.bot.core.MsgCheck;
import ru.sotnikov.bot.core.help.ReplyMessage;
import ru.sotnikov.bot.core.help.Users;

public class Starter{

    public static final String access_token = "7b9d794cab8017af2a6d2003da20e28abe26e3c83dd50be3ea2f3a91a7ef2cb9d72a9f63dc3067314ae9d";
    public static final int group_id = 197613406;

    public void start(final int clientId, @NotNull final String accessToken) {
        if (accessToken.equals("fff")) throw new RuntimeException("Please, replace dummy access_token with yours in Launcher.kt");

        final HttpClient httpClient = new VkOkHttpClient();

        final VkSettings vkSettings = new VkSettings(httpClient, 5.122d,                // Woo-hoo! @JvmStatic
                 Parameters.of("lang", "ru"), 3);

        final VkApiClient vkApiClient = new VkApiClient(clientId, accessToken, VkApiClient.Type.Community, vkSettings);
        /*vkApiClient.call("messages.pin", Parameters.of("peer_id",String.valueOf(2000000004),"message_id",String.valueOf(3628713)), false, new Callback<JsonElement>() {
            @Override
            public void onResult(@NotNull JsonElement jsonElement) {
                System.out.println(jsonElement);
            }

            @Override
            public void onError(@NotNull Exception e) {

            }
        });*/

        // Woo-hoo! SAM! As you can see, callbacks are more pretty in Java.
        vkApiClient.onMessage(event -> {

            System.out.println(event);
            if (event.getMessage().getText().toLowerCase().startsWith("!репорт")){
                new Message()
                        .peerId(2000000004)
                        .text( "@" + "id" + event.getMessage().getFromId() + "(Баянщик), " +event.getMessage().getText())
                        .sendFrom(vkApiClient)
                        .execute();
                return;
            }
            ReplyMessage replyMessage = new Gson().fromJson(String.valueOf(event.getMessage().component15()),ReplyMessage.class);
            String string = "";
            boolean seconduser = replyMessage!=null && event.getMessage().getFromId() != replyMessage.getFromId();
            if(!seconduser){
             string += event.getMessage().getFromId();
            }else {
                string += event.getMessage().getFromId()+","+replyMessage.getFromId();
            }
            try {
                vkApiClient.call("users.get", Parameters.of("user_ids",string), false, new Callback<JsonElement>() {
                    @Override
                    public void onResult(@NotNull final JsonElement jsonElement) {
                        MsgCheck msgCheck = new MsgCheck(event,vkApiClient);
                        String name;
                        String name2 = "";
                        try {
                            name = new Gson().fromJson(String.valueOf(jsonElement), Users.class)
                                    .getResponse().get(0).getFirstName();
                            if(seconduser)
                                try {
                                    name2 = new Gson().fromJson(String.valueOf(jsonElement), Users.class)
                                            .getResponse().get(1).getFirstName();
                                }catch (IndexOutOfBoundsException e){
                                    return;
                                }
                        } catch (NullPointerException e) {
                            return;
                        }
                        name = "@" + "id" + event.getMessage().getFromId() + "(" + name + "), ";
                        if(seconduser)
                        name2 = "@" + "id" + replyMessage.getFromId()  + "(" + name2 + ")";
                        if (msgCheck.getIsCommand(event.getMessage().getText().split(" ")[0].toLowerCase()))
                            new Message()
                                    .peerId(event.getMessage().getPeerId())
                                    .text(name + msgCheck.getResponse(seconduser,name2))
                                    .sendFrom(vkApiClient)
                                    .execute();
                    }

                    @Override
                    public void onError(@NotNull Exception e) {
                        e.getStackTrace();
                    }

                });
            }catch (NullPointerException e){
                e.getStackTrace();
            }
        });
        vkApiClient.startLongPolling();
    }

    public static void main(String[] args) {
        final Starter bot = new Starter();
        bot.start(group_id, access_token);
    }



}
