package ru.sotnikov.bot.core.help;

import java.util.ArrayList;
import java.util.List;

public class ReplyMessage {

    private Integer date;
    private Integer from_id;
    private String text;
    private ArrayList<Object> attachments = null;
    private Integer conversation_message_id;
    private Integer peer_id;
    private Integer id;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getFromId() {
        return from_id;
    }

    public void setFromId(Integer fromId) {
        this.from_id = fromId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<Object> attachments) {
        this.attachments = attachments;
    }

    public Integer getConversationMessageId() {
        return conversation_message_id;
    }

    public void setConversationMessageId(Integer conversationMessageId) {
        conversation_message_id = conversationMessageId;
    }

    public Integer getPeerId() {
        return peer_id;
    }

    public void setPeerId(Integer peerId) {
        this.peer_id = peerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReplyMessage{" +
                "date=" + date +
                ", fromId=" + from_id +
                ", text='" + text + '\'' +
                ", attachments=" + attachments +
                ", conversationMessageId=" + conversation_message_id +
                ", peerId=" + peer_id +
                ", id=" + id +
                '}';
    }
}