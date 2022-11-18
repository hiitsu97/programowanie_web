import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Connection {

    private static Socket socket;

    private static RequestBuilder requestBuilder;
    static ObjectOutputStream outputStream;
    static ObjectInputStream inputStream;

    public void connect() throws IOException {
        socket = new Socket(InetAddress.getLocalHost(), 2011);
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        System.out.println(1);
        inputStream = new ObjectInputStream(socket.getInputStream());
        System.out.println(2);
        String request = requestBuilder.setRequest();
        System.out.println(3);
        requestBuilder.key_in(request, outputStream);
    }
}
