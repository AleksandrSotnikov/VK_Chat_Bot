package ru.sotnikov.bot.entity;

import com.petersamokhin.vksdk.core.client.VkApiClient;
import com.petersamokhin.vksdk.core.model.event.MessageNew;

public class Entity {
    private static User firstUser;
    private static User secondUser;
    private static MessageNew message;
    private static VkApiClient vkApiClient;

    public Entity() {
    }

    public Entity(User firstUser,User secondUser,MessageNew message,VkApiClient vkApiClient){
        setFirstUser(firstUser);
        setSecondUser(secondUser);
        setMessage(message);
        setVkApiClient(vkApiClient);
    }

    public static User getFirstUser() {
        return firstUser;
    }

    public static void setFirstUser(User firstUser) {
        Entity.firstUser = firstUser;
    }

    public static User getSecondUser() {
        return secondUser;
    }

    public static void setSecondUser(User secondUser) {
        Entity.secondUser = secondUser;
    }

    public static MessageNew getMessage() {
        return message;
    }

    public static void setMessage(MessageNew message) {
        Entity.message = message;
    }

    public static VkApiClient getVkApiClient() {
        return vkApiClient;
    }

    public static void setVkApiClient(VkApiClient vkApiClient) {
        Entity.vkApiClient = vkApiClient;
    }
}
