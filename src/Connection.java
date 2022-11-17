import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Connection {

    public Connection(){
        try {
            connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Socket socket;
    static ObjectOutputStream outputStream;
    static ObjectInputStream inputStream;

    public void connect() throws IOException {
        socket = new Socket(InetAddress.getLocalHost(), 2011);
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject("Hello :3");
        inputStream = new ObjectInputStream(socket.getInputStream());
    }
}
