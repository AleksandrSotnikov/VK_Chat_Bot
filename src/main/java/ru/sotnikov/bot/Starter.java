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
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import ru.sotnikov.bot.core.MsgCheck;
import ru.sotnikov.bot.core.help.ReplyMessage;
import ru.sotnikov.bot.core.help.Response;
import ru.sotnikov.bot.core.help.Users;
import ru.sotnikov.bot.entity.Entity;
import ru.sotnikov.bot.entity.User;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Starter {

    private static int GroupId;
    private static String AccessToken;
    private static String AccessTokens;

    public static void main(String[] args) {
        final Starter bot = new Starter();
        loadProperties();
        System.out.println("property start");
        bot.start(GroupId, AccessToken);
    }

    public static void loadProperties() {
        String pathToFile = "src/main/resources/config.properties";
        Properties properties = new Properties();
        File file = new File(pathToFile);
        System.out.println(new File("src/main/resources").mkdir());
        FileWriter fileWriter;
        BufferedReader fileReader;
        try {
            properties.load(new FileReader(pathToFile));
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось найти файл config.properties");
            System.out.println("Производится создание файла...");
            try {
                fileWriter = new FileWriter(file);
                fileWriter.write("AccessToken = Введите сюда ключ доступа группы\nGroupId = Введите сюда Id группы\nAccessTokens = Токен от аккаунта вк");
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException exception) {
                exception.printStackTrace();
                System.out.println("Возникла непредвиденная ошибка");
            }
            System.out.println("Создание файла config.properties завершено, заполните его нужными данными");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Ошибка при выполнении метода load()");
        }
        try {
            AccessToken = properties.getProperty("AccessToken");
            GroupId = Integer.parseInt(properties.getProperty("GroupId"));
            AccessTokens = properties.getProperty("AccessTokens");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка конвертации в числовое значение");
            try {
                fileWriter = new FileWriter(file);
                fileWriter.write("AccessToken = Введите сюда ключ доступа группы\nGroupId = Введите сюда Id группы\nAccessTokens = Токен от аккаунта вк");
                fileWriter.flush();
                fileWriter.close();
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Не задан один из параметров");
            System.exit(0);
        }
    }

    public void start(final int clientId, @NotNull final String accessToken) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();


        final HttpClient httpClient = new VkOkHttpClient(okHttpClient);

        // final HttpClient httpClient = new VkOkHttpClient();

        final VkSettings vkSettings = new VkSettings(httpClient, 5.122d,                // Woo-hoo! @JvmStatic
                Parameters.of("lang", "ru"), 1);

        final VkApiClient vkApiClient = new VkApiClient(clientId, accessToken, VkApiClient.Type.Community, vkSettings);

        MsgCheck msgCheck = new MsgCheck();
        vkApiClient.onMessage(event -> {
            System.out.println(event);
            if (event.getMessage().getFromId() < 0) return;
            if (event.getMessage().getText().toLowerCase().startsWith("!репорт") || event.getMessage().getText().toLowerCase().startsWith("репорт")) {
                new Message()
                        .peerId(2000000009)
                        .text("@" + "id" + event.getMessage().getFromId() + "(People), " + event.getMessage().getText().substring(event.getMessage().getText().indexOf("т") + 1))
                        .sendFrom(vkApiClient)
                        .execute();
                return;
            }
            ReplyMessage replyMessage = new Gson().fromJson(String.valueOf(event.getMessage().component15()), ReplyMessage.class);
            String string = "";
            boolean seconduser = replyMessage != null && event.getMessage().getFromId() != replyMessage.getFromId();
            if (!seconduser) {
                string += event.getMessage().getFromId();
            } else {
                string += event.getMessage().getFromId() + "," + replyMessage.getFromId();
            }
            try {
                vkApiClient.call("users.get", Parameters.of("user_ids", string), false, new Callback<JsonElement>() {
                    @Override
                    public void onResult(@NotNull final JsonElement jsonElement) {
                        Entity entity = new Entity();
                        entity.setMessage(event);
                        entity.setVkApiClient(vkApiClient);
                        entity.setAccessTokens(AccessTokens);
                        User firstUser;
                        User secondUser;
                        Response response;
                        try {
                            response = new Gson().fromJson(String.valueOf(jsonElement), Users.class)
                                    .getResponse().get(0);
                            firstUser = new User(response.getFirstName(), response.getLastName(), response.getFirstName(), response.getId());
                            entity.setFirstUser(firstUser);
                            if (seconduser)
                                try {
                                    response = new Gson().fromJson(String.valueOf(jsonElement), Users.class)
                                            .getResponse().get(1);
                                    secondUser = new User(response.getFirstName(), response.getLastName(), response.getFirstName(), response.getId());
                                    entity.setSecondUser(secondUser);
                                } catch (IndexOutOfBoundsException e) {
                                    return;
                                }
                        } catch (NullPointerException e) {
                            return;
                        }
                        msgCheck.getResponse(entity);
                    }

                    @Override
                    public void onError(@NotNull Exception e) {
                        e.getStackTrace();
                    }

                });
            } catch (NullPointerException e) {
                e.getStackTrace();
            }
        });

        vkApiClient.startLongPolling();
    }
}
