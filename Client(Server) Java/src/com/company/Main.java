package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main
{
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static String str = "";

    public static void main(String[] args)
    {
        try
        {
            server = new ServerSocket(4004);
            System.err.println("Start server");

            while(!str.equals("exit")) {
                clientSocket = server.accept();

                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    str = in.readLine();
                    System.out.println(str);

                    out.write("FROM SERVER: " + str + ";");
                    out.flush();

                }
                finally
                {
                    System.err.println("ClientSocket close");
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try
            {
                System.err.println("Server close");
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
