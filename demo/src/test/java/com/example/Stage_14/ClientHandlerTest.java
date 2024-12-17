package com.example.Stage_14;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClientHandlerTest {

    private Socket clientSocket;
    private Map<String, ClientHandler> clients;
    private ClientHandler clientHandler;
    private ByteArrayOutputStream outputStream;
    private ExecutorService executorService;

    @BeforeEach
    void setUp() throws IOException {
        clientSocket = Mockito.mock(Socket.class);
        clients = new HashMap<>();
        outputStream = new ByteArrayOutputStream();
        when(clientSocket.getOutputStream()).thenReturn(outputStream);
        executorService = Executors.newSingleThreadExecutor(); // Для управления потоками
        clientHandler = new ClientHandler(clientSocket, clients);
    }

    private void startClientHandler(ClientHandler clientHandler, InputStream inputStream) throws IOException, InterruptedException {
        when(clientSocket.getInputStream()).thenReturn(inputStream);
        Future<?> future = executorService.submit(clientHandler);

        // Подождать немного, пока обработчик установит соединение
        Thread.sleep(100);

    }

    @Test
    void testClientRegistration() throws IOException, ClassNotFoundException, InterruptedException {
        // Arrange
        Message initialMessage = new Message("user1", null, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(initialMessage);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        startClientHandler(clientHandler, byteArrayInputStream);

        // Assert
        assertEquals("user1", clientHandler.getClientName());
        assertEquals(1, clients.size());
        assertEquals(clientHandler, clients.get("user1"));
    }

    @Test
    void testHandleTextMessageToExistingClient() throws IOException, ClassNotFoundException, InterruptedException {
        // Arrange
        //Set up client "user1"
        Message initialMessage = new Message("user1", null, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(initialMessage);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        startClientHandler(clientHandler, byteArrayInputStream);

        Socket receiverSocket = Mockito.mock(Socket.class);
        ByteArrayOutputStream receiverOutputStream = new ByteArrayOutputStream();
        when(receiverSocket.getOutputStream()).thenReturn(receiverOutputStream);
        ClientHandler receiverHandler = new ClientHandler(receiverSocket, clients);


        //Set up client "user2"
        Message initialMessage2 = new Message("user2", null, null);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        ObjectOutputStream oos2 = new ObjectOutputStream(byteArrayOutputStream2);
        oos2.writeObject(initialMessage2);
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream2.toByteArray());

        when(receiverSocket.getInputStream()).thenReturn(byteArrayInputStream2);
        startClientHandler(receiverHandler, byteArrayInputStream2);


        //Send message
        Message messageToSend = new Message("user1", "user2", "Hello user2");

        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        ObjectOutputStream oos3 = new ObjectOutputStream(byteArrayOutputStream3);
        oos3.writeObject(messageToSend);
        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(byteArrayOutputStream3.toByteArray());

        when(clientSocket.getInputStream()).thenReturn(byteArrayInputStream3);
        Future<?> future = executorService.submit(clientHandler);
        // Wait for the message to be processed
        Thread.sleep(100);

        // Verify
        assertEquals(2, clients.size()); // Both clients should be registered.
        verify(receiverSocket, times(1)).getOutputStream();
        future.cancel(true);

    }
    @Test
    void testHandleMessageToNonExistingClient() throws IOException, ClassNotFoundException, InterruptedException {
        // Arrange
        //Set up client "user1"
        Message initialMessage = new Message("user1", null, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(initialMessage);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        startClientHandler(clientHandler, byteArrayInputStream);
        Message messageToSend = new Message("user1", "user3", "Hello user3");

        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        ObjectOutputStream oos2 = new ObjectOutputStream(byteArrayOutputStream2);
        oos2.writeObject(messageToSend);
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream2.toByteArray());

        when(clientSocket.getInputStream()).thenReturn(byteArrayInputStream2);
        Future<?> future = executorService.submit(clientHandler);

        Thread.sleep(100);

        // Verify
        assertEquals(1, clients.size());
        verify(clientSocket, times(2)).getOutputStream();
        future.cancel(true);
    }
    @Test
    void testHandleUserListRequest() throws IOException, ClassNotFoundException, InterruptedException {
        // Arrange
        //Set up client "user1"
         Message initialMessage = new Message("user1", null, null);
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(initialMessage);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        startClientHandler(clientHandler, byteArrayInputStream);


        //Set up client "user2"
        Socket receiverSocket = Mockito.mock(Socket.class);
        ByteArrayOutputStream receiverOutputStream = new ByteArrayOutputStream();
        when(receiverSocket.getOutputStream()).thenReturn(receiverOutputStream);
        ClientHandler receiverHandler = new ClientHandler(receiverSocket, clients);

        Message initialMessage2 = new Message("user2", null, null);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        ObjectOutputStream oos2 = new ObjectOutputStream(byteArrayOutputStream2);
        oos2.writeObject(initialMessage2);
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream2.toByteArray());

        when(receiverSocket.getInputStream()).thenReturn(byteArrayInputStream2);
        startClientHandler(receiverHandler, byteArrayInputStream2);


         //Send user list request
         Message messageToSend = new Message("user1", Message.MessageType.USER_LIST_REQUEST);

         ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
         ObjectOutputStream oos3 = new ObjectOutputStream(byteArrayOutputStream3);
         oos3.writeObject(messageToSend);
         ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(byteArrayOutputStream3.toByteArray());
          when(clientSocket.getInputStream()).thenReturn(byteArrayInputStream3);
        Future<?> future = executorService.submit(clientHandler);
         Thread.sleep(100);


         // Verify
          assertEquals(2, clients.size());
        verify(clientSocket, times(2)).getOutputStream();
        future.cancel(true);
    }
}
