package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client
{
    private static Socket clientSocket;


    public static void main(String[] args) throws IOException
    {
        clientSocket = new Socket("192.168.0.103" , 80);

        BufferedReader read = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        String str = "hello server!";

        write.write(str + '\n');
        write.flush();

        System.out.println(read.readLine());

        clientSocket.close();
    }
}
