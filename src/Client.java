package src;


import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            InputStream in = socket.getInputStream();
        
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = bin.readLine()) != null) { 
                System.out.println(line);
            }
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}