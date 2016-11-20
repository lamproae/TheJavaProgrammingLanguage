package server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ServerMain extends JFrame {
    private JTextArea jta = new JTextArea();
    public static void main(String[] args) {
        new ServerMain();
    }

    public ServerMain () {
        setLayout(new BorderLayout());
        add(new JScrollPane(jta), BorderLayout.CENTER);
        setTitle("Server");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("Server started at " + new Date() + "\n");
            Socket socket = serverSocket.accept();

            DataInputStream inputFromClient = new DataInputStream(
                    socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(
                    socket.getOutputStream());

            while (true) {
                double radius = inputFromClient.readDouble();
                double area = radius * radius * Math.PI;

                outputToClient.writeDouble(area);
                jta.append("Radius recevied from client: " + radius + "\n");
                jta.append("Area found: " + area + "\n");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    } 
}
