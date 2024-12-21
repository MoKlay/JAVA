package com.example.Stage_14;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {
    private String sender;
    private String receiver;
    private String content;

    private MessageType type;

    private List<String> userList;

     public Message(String sender, String receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
         this.type = MessageType.TEXT;

    }
    public Message(String sender,  MessageType type) {
         this.sender = sender;
         this.type = type;
    }

    public Message(String sender, List<String> userList) {
         this.sender = sender;
         this.userList = userList;
         this.type = MessageType.USER_LIST_RESPONSE;
    }


    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }
    public MessageType getType() {
        return type;
    }
    public List<String> getUserList() {
        return userList;
    }

    @Override
    public String toString() {
      if (type == MessageType.USER_LIST_RESPONSE) {
            return "Users connected: " + userList.toString();
        }
        return sender + " -> " + receiver + ": " + content;

    }
    public static enum MessageType {
         TEXT, USER_LIST_REQUEST, USER_LIST_RESPONSE
    }
}
