package src;


import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client{

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //to server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//from server
            System.out.print("Input Name :");
            String name = sc.nextLine();
            System.out.print("Input Student ID :");
            String sid = sc.nextLine();
            out.println(name);
            out.println(sid);
            System.out.println("Sending to server");
            String callbackName = in.readLine();
            String callbackSid = in.readLine();
            String callbackServerName = in.readLine();
            String callbackDate = in.readLine();
            System.out.println("RECEIVED FROM SERVER ");
            System.out.println("Name :"+callbackName);
            System.out.println("Student ID :"+callbackSid);
            System.out.println("Server Name :"+callbackServerName);
            System.out.println("Date :"+callbackDate);
            socket.close();
            sc.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}