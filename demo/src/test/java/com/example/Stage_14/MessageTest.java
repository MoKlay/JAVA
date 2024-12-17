package com.example.Stage_14;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MessageTest {

  @Test
  void testTextMessageCreation() {
      Message message = new Message("sender", "receiver", "content");
      assertEquals("sender", message.getSender());
      assertEquals("receiver", message.getReceiver());
      assertEquals("content", message.getContent());
      assertEquals(Message.MessageType.TEXT, message.getType());
  }
  @Test
  void testUserListRequestMessageCreation() {
      Message message = new Message("sender",  Message.MessageType.USER_LIST_REQUEST);
      assertEquals("sender", message.getSender());
      assertEquals(Message.MessageType.USER_LIST_REQUEST, message.getType());
  }

  @Test
  void testUserListResponseMessageCreation() {
      List<String> userList = Arrays.asList("user1", "user2", "user3");
      Message message = new Message("Server", userList);
       assertEquals("Server", message.getSender());
       assertEquals(userList, message.getUserList());
       assertEquals(Message.MessageType.USER_LIST_RESPONSE, message.getType());
  }

  @Test
  void testTextMessageToString() {
      Message message = new Message("sender", "receiver", "content");
      assertEquals("sender -> receiver: content", message.toString());
  }

  @Test
  void testUserListMessageToString() {
      List<String> userList = Arrays.asList("user1", "user2", "user3");
      Message message = new Message("Server", userList);
      assertEquals("Users connected: [user1, user2, user3]", message.toString());
  }
}
