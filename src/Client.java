import java.io.IOException;
import java.util.Scanner;

public class Client {
    private static Connection connection;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        connection = new Connection();
        connection.connect();
    }
}
