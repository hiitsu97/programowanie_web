import java.io.IOException;
import java.util.Scanner;

public class Client {

    private static Scanner userInput = new Scanner(System.in);
    private static String request;
    private static Connection connection = new Connection();

    public static void main(String[] args) throws IOException {
        connection.connect();
        System.out.println("What request you want to make? get / set : ");
        request = userInput.nextLine();
        key_in(request);
    }

    public static void key_in(String request){
        int key;
        switch (request){
        case "get":
            System.out.println("Check if following key exists: ");
            key = userInput.nextInt();
            try {
                connection.outputStream.writeObject("key_in-get: " + key);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            break;
        case "set":
            System.out.println("Add a key to database: ");
            key = userInput.nextInt();
            try {
                connection.outputStream.writeObject("key_in-set: " + key);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            break;
        }

    }
}
