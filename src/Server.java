import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static ServerSocket serverSocket;
    private static int port = 2011;




    public static void main(String[] args) throws Exception {
        Key key = new Key();
        for (Integer integer : key.Keys) {
           System.out.println(integer);
        }
        key.add_key(669987963);
        key.check_key(669987963);
        connection();
    }

    public static void connection() throws IOException, ClassNotFoundException {
        serverSocket = new ServerSocket(port);
        while (true){
            System.out.println("Waiting for client ...");
            Socket socket = serverSocket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            String message = (String) inputStream.readObject();
            System.out.println("Mesage received: " + message);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject("Hello");
            inputStream.close();
            outputStream.close();
            socket.close();
            if(message.equals("exit")) break;
        }
        System.out.println("Closing connection");
        serverSocket.close();
    }
}
