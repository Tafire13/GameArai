package src;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        try{
           ServerSocket serverSocket = new ServerSocket(8080);
           System.out.println("Server started");
           while(true){
               Socket socket = serverSocket.accept();
               System.out.println("Client connected");
               BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
               PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
               out.println("Hello from server"+new java.util.Date());
               socket.close();
           }
        }
        catch(IOException ioe){
            System.err.println(ioe);
        }
    }
}
