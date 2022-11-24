import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Connection {

    private static Socket socket;

    private static RequestBuilder requestBuilder;
    static ObjectOutputStream outputStream;
    static ObjectInputStream inputStream;

    public void connect() throws IOException, ClassNotFoundException {
        socket = new Socket(InetAddress.getLocalHost(), 2011);
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        requestBuilder.key_in(outputStream);
        inputStream = new ObjectInputStream(socket.getInputStream());
        String answer = (String) inputStream.readObject();
        System.out.println("Mesage received: " + answer);
        socket.close();
    }
}
