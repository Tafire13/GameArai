package src;
import java.io.*;
import java.net.*;
import java.util.*;
public class Server {
    public static void main(String[] args) throws IOException {
        try{
           ServerSocket serverSocket = new ServerSocket(8080);
           System.out.println("Server started");
           while(true){
               Socket socket = serverSocket.accept();
               System.out.println("Client connected");
               BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));// from client
               PrintWriter out = new PrintWriter(socket.getOutputStream(), true);// to server
               String name = in.readLine();
               String sid = in.readLine();
               String ServerName = InetAddress.getLocalHost().getHostName();
               String date = new Date().toString();
               System.out.println("Received name from client is "+name);
               System.out.println("Received student id from client is "+sid);
               out.println(name);
               out.println(sid);
               out.println(ServerName);
               out.println(date);
               System.out.println("Sending to client");
               socket.close();
           }
        }
        catch(IOException ioe){
            System.err.println(ioe);
        }
    }
}
