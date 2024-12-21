package com.example.Stage_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String DEFAULT_SERVER_ADDRESS = "localhost";
    private static final int DEFAULT_SERVER_PORT = 12345;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String serverAddress;

        System.out.print("Enter server address (or leave empty for localhost): ");
        String inputAddress = scanner.nextLine().trim();
        serverAddress = inputAddress.isEmpty() ? DEFAULT_SERVER_ADDRESS : inputAddress;

        boolean serverCreated = false;
        Socket socket = null;
        try {
            socket = new Socket(serverAddress, DEFAULT_SERVER_PORT);
            System.out.println("Connected to server at " + serverAddress + ":" + DEFAULT_SERVER_PORT);
        } catch (ConnectException e) {
            // Если не удалось подключится к серверу, запускаем сервер на localhost
            System.out.println("Could not connect to the specified address, attempting to start server on localhost.");
            new Thread(() -> Server.main(null)).start(); // Запуск сервера в отдельном потоке
            try {
                Thread.sleep(1000); // Подождем секунду, пока запуститься сервер
                socket = new Socket(DEFAULT_SERVER_ADDRESS, DEFAULT_SERVER_PORT);
                serverCreated = true;
                System.out.println("Connected to server at " + DEFAULT_SERVER_ADDRESS + ":" + DEFAULT_SERVER_PORT + " (Server Created)");
            } catch (IOException | InterruptedException ex) {
                System.out.println("Error connecting to server: " + ex.getMessage());
                return;
            }
        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
            return;
        }


        try {
            System.out.println("Connected to server.");

            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            // Отправляем имя пользователя на сервер
            Utils.sendMessage(socket, new Message(username, null, null));

            // Запускаем поток для прослушивания сообщений от сервера
            Socket finalSocket = socket;
            new Thread(() -> {
                try {
                    while (true) {
                        Message message =  Utils.receiveMessage(finalSocket);
                        if (message == null) {
                            break;
                        }
                       if (message.getType() == Message.MessageType.USER_LIST_RESPONSE) {
                           System.out.println("\n" + message);
                       } else if(message.getType() == Message.MessageType.TEXT){
                         System.out.println("\n" + message);
                       }
                        System.out.print("> ");
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error receiving message from server: " + e.getMessage());
                }
            }).start();

            // Отправляем сообщения на сервер
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("> ");
                String input = reader.readLine();
                 if (input.equals("/users")) {
                   Utils.sendMessage(socket, new Message(username,  Message.MessageType.USER_LIST_REQUEST));
                 }else if (input.equals("exit")) {
                    break;
                } else{
                    String[] parts = input.split(" ", 2);
                    if (parts.length == 2) {
                        String receiver = parts[0];
                        String content = parts[1];
                        Utils.sendMessage(socket, new Message(username, receiver, content));
                    } else {
                        System.out.println("Invalid command. Usage: <receiver> <message>");
                    }
                }

            }
            socket.close();
        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }
}