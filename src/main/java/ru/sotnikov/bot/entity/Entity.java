package ru.sotnikov.bot.entity;

import com.petersamokhin.vksdk.core.client.VkApiClient;
import com.petersamokhin.vksdk.core.model.event.MessageNew;

public class Entity {
    private User firstUser = null;
    private User secondUser = null;
    private MessageNew message = null;
    private VkApiClient vkApiClient = null;

    public Entity() {
    }

    public Entity(User firstUser,User secondUser,MessageNew message,VkApiClient vkApiClient){
        setFirstUser(firstUser);
        setSecondUser(secondUser);
        setMessage(message);
        setVkApiClient(vkApiClient);
    }

    public String getTextMessage(){
        return getMessage().getMessage().getText();
    }
    public String[] getTextMessageSplit(){
        return getTextMessage().split(" ");
    }
    public String getTextMessageSplit(int index){
        return getTextMessageSplit()[index];
    }
    public int getPeerId(){
       return message.getMessage().getPeerId();
    }
    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public MessageNew getMessage() {
        return message;
    }

    public void setMessage(MessageNew message) {
        this.message = message;
    }

    public VkApiClient getVkApiClient() {
        return vkApiClient;
    }

    public  void setVkApiClient(VkApiClient vkApiClient) {
        this.vkApiClient = vkApiClient;
    }
}
