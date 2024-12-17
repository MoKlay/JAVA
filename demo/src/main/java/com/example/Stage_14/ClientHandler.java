package com.example.Stage_14;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private String clientName;
    private Map<String, ClientHandler> clients;

    public ClientHandler(Socket clientSocket, Map<String, ClientHandler> clients) {
        this.clientSocket = clientSocket;
        this.clients = clients;
    }

    public String getClientName() {
        return clientName;
    }


    @Override
    public void run() {
        try {
            // Получаем имя клиента
            Message initialMessage = Utils.receiveMessage(clientSocket);
            this.clientName = initialMessage.getSender();
            clients.put(clientName, this);
            System.out.println("Client " + clientName + " connected.");

            while (true) {
                Message message = Utils.receiveMessage(clientSocket);
                if (message == null) {
                   break;
                }
                if (message.getType().equals(Message.MessageType.TEXT)){
                  System.out.println("Received message: " + message);
                }
                handleMessage(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error handling client " + clientName + ": " + e.getMessage());
        } finally {
            try {
                clients.remove(clientName);
                clientSocket.close();
                System.out.println("Client " + clientName + " disconnected.");
            } catch (IOException e) {
               // ignored
            }
        }
    }

     private void handleMessage(Message message) throws IOException {
        if (message.getType() == Message.MessageType.USER_LIST_REQUEST) {
            sendUserList(message.getSender());
            return;
        }
        if (message.getType() != Message.MessageType.TEXT) {
             return;
        }
        String receiver = message.getReceiver();
        if (clients.containsKey(receiver)) {
            ClientHandler receiverHandler = clients.get(receiver);
            Utils.sendMessage(receiverHandler.clientSocket, message);
        } else {
           Utils.sendMessage(clientSocket, new Message("Server", message.getSender(), "User " + receiver + " not found."));
        }
    }


    private void sendUserList(String sender) throws IOException {
         if (!clients.containsKey(sender)){
            return;
         }
        List<String> userList = new ArrayList<>(clients.keySet());
         ClientHandler clientHandler = clients.get(sender);
        Utils.sendMessage(clientHandler.clientSocket, new Message("Server", userList));
    }
}
