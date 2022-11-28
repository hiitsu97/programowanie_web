package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static ServerSocket serverSocket;
    private static RequestHandler requestHandler = new RequestHandler();
    private static int port = 2011;
    public static void main(String[] args) throws Exception {
        connection();

    }

    public static void connection() throws IOException, ClassNotFoundException {
        serverSocket = new ServerSocket(port);
        while (true){
            System.out.println("Waiting for client ...");
            Socket socket = serverSocket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            try{
            String request = (String) inputStream.readObject();
            String answer = requestHandler.handleRequest(request);
            System.out.println("Mesage received: " + request);
            System.out.println("Mesage sent: " + answer);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(answer);
            inputStream.close();
            outputStream.close();
            socket.close();
            if(request.equals("exit")) break;
            }catch (IOException e){
                System.out.println("Wrong request, connection refused");
            }
        }
        System.out.println("Closing connection");
        serverSocket.close();
    }


}
