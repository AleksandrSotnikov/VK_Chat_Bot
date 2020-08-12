package ru.sotnikov.bot;

import com.google.gson.Gson;
import com.petersamokhin.vksdk.core.callback.Callback;
import com.petersamokhin.vksdk.core.client.VkApiClient;
import com.petersamokhin.vksdk.core.http.HttpClient;
import com.petersamokhin.vksdk.core.http.Parameters;
import com.petersamokhin.vksdk.core.model.VkSettings;
import com.petersamokhin.vksdk.core.model.objects.Message;
import com.petersamokhin.vksdk.http.VkOkHttpClient;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;
import ru.sotnikov.bot.core.MsgCheck;
import ru.sotnikov.bot.core.help.ReplyMessage;
import ru.sotnikov.bot.core.help.Users;

import java.io.*;
import java.util.Properties;

public class Starter{

    public void start(final int clientId, @NotNull final String accessToken) {
        if (accessToken.equals("fff")) throw new RuntimeException("Please, replace dummy access_token with yours in Launcher.kt");

        final HttpClient httpClient = new VkOkHttpClient();

        final VkSettings vkSettings = new VkSettings(httpClient, 5.122d,                // Woo-hoo! @JvmStatic
                 Parameters.of("lang", "ru"), 3);

        final VkApiClient vkApiClient = new VkApiClient(clientId, accessToken, VkApiClient.Type.Community, vkSettings);

        vkApiClient.onMessage(event -> {

            System.out.println(event);
            if (event.getMessage().getText().toLowerCase().startsWith("!репорт")){
                new Message()
                        .peerId(2000000004)
                        .text( "@" + "id" + event.getMessage().getFromId() + "(Чёрт), " +event.getMessage().getText())
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

    private static int GroupId;
    private static String AccessToken;

    public static void main(String[] args) {
        final Starter bot = new Starter();
        loadProperties();
        bot.start(GroupId, AccessToken);
    }

    public static void loadProperties()  {
        String pathToFile = "src/main/resources/config.properties";
        Properties properties = new Properties();
        File file  = new File(pathToFile);
        FileWriter fileWriter;
        BufferedReader fileReader;
        try {
            properties.load(new FileReader(pathToFile));
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось найти файл config.properties");
            System.out.println("Производится создание файла...");
            try {
                fileWriter = new FileWriter(file);
                fileWriter.write("AccessToken = Введите сюда ключ доступа группы\nGroupId = Введите сюда Id группы");
                fileWriter.flush();
                fileWriter.close();
            }catch (IOException exception){
                exception.printStackTrace();
                System.out.println("Возникла непредвиденная ошибка");
            }
            System.out.println("Создание файла config.properties завершено, заполните его нужными данными");
            System.exit(0);
        } catch (IOException e){
            System.out.println("Ошибка при выполнении метода load()");
        }
        try {
            AccessToken = properties.getProperty("AccessToken");
            GroupId = Integer.parseInt(properties.getProperty("GroupId"));
        } catch (NumberFormatException e){
            System.out.println("Ошибка конвертации в числовое значение");
            try {
                fileReader = new BufferedReader(new FileReader(file));
                if(fileReader.readLine().startsWith("AccessToken")&&fileReader.readLine().startsWith("GroupId")){
                    fileWriter = new FileWriter(file);
                    fileWriter.write("AccessToken = Введите сюда ключ доступа группы\nGroupId = Введите сюда Id группы");
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (NullPointerException exception) {
                try {
                fileWriter = new FileWriter(file);
                fileWriter.write("AccessToken = Введите сюда ключ доступа группы\nGroupId = Введите сюда Id группы");
                fileWriter.flush();
                fileWriter.close();
                } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            }catch (IOException fileNotFoundException) {
               fileNotFoundException.printStackTrace();
            }
            System.exit(0);
        } catch (IllegalArgumentException e){
            System.out.println("Не задан один из параметров");
            System.exit(0);
        }
    }
}
