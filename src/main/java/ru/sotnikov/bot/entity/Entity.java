package ru.sotnikov.bot.entity;

import com.petersamokhin.vksdk.core.client.VkApiClient;
import com.petersamokhin.vksdk.core.model.event.MessageNew;

public class Entity {
    private static User firstUser;
    private static User secondUser;
    private static MessageNew message;
    private static VkApiClient vkApiClient;
}
