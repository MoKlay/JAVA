package com.example.Stage_14;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class UtilsTest {

  @Test
  void testSendMessageAndReceiveTextMessage() throws IOException, ClassNotFoundException {
      Socket socket = Mockito.mock(Socket.class);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      ByteArrayInputStream byteArrayInputStream = null;

      Message sentMessage = new Message("sender", "receiver", "content");
      
      when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);
      Utils.sendMessage(socket, sentMessage);


      byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
      when(socket.getInputStream()).thenReturn(byteArrayInputStream);
      Message receivedMessage = Utils.receiveMessage(socket);

      assertEquals(sentMessage.getSender(), receivedMessage.getSender());
      assertEquals(sentMessage.getReceiver(), receivedMessage.getReceiver());
      assertEquals(sentMessage.getContent(), receivedMessage.getContent());
  }
  @Test
  void testSendMessageAndReceiveUserListMessage() throws IOException, ClassNotFoundException {
      Socket socket = Mockito.mock(Socket.class);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      ByteArrayInputStream byteArrayInputStream = null;
      List<String> userList = Arrays.asList("user1", "user2", "user3");
      Message sentMessage = new Message("Server",userList);


      when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);
      Utils.sendMessage(socket, sentMessage);


      byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
      when(socket.getInputStream()).thenReturn(byteArrayInputStream);
      Message receivedMessage = Utils.receiveMessage(socket);
      assertEquals(sentMessage.getSender(), receivedMessage.getSender());
      assertEquals(sentMessage.getUserList(), receivedMessage.getUserList());
      assertEquals(sentMessage.getType(), receivedMessage.getType());

  }


  @Test
  void testSendMessage() throws IOException {
      Socket socket = Mockito.mock(Socket.class);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

      when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);
      Message message = new Message("sender", "receiver", "content");
      Utils.sendMessage(socket, message);

      ObjectOutputStream oos = new ObjectOutputStream(new ByteArrayOutputStream());
      oos.writeObject(message);
      ByteArrayOutputStream expectedOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream expectedOos = new ObjectOutputStream(expectedOutputStream);
      expectedOos.writeObject(message);
      byte[] actual = byteArrayOutputStream.toByteArray();
      byte[] expected = expectedOutputStream.toByteArray();

      // Check the streams have the same size
       assertEquals(actual.length, expected.length);
      // Optional: Add a more detailed comparison if needed

  }


  @Test
  void testReceiveMessage() throws IOException, ClassNotFoundException {
      Socket socket = Mockito.mock(Socket.class);
      Message message = new Message("sender", "receiver", "content");
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
      oos.writeObject(message);
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

      when(socket.getInputStream()).thenReturn(byteArrayInputStream);

      Message receivedMessage = Utils.receiveMessage(socket);

      assertEquals(message.getSender(), receivedMessage.getSender());
      assertEquals(message.getReceiver(), receivedMessage.getReceiver());
      assertEquals(message.getContent(), receivedMessage.getContent());

  }

}
