import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class RequestBuilder {
    private static Scanner userInputKey = new Scanner(System.in);
    private static Scanner userInputPassword = new Scanner(System.in);
    private static String request;
    public static void key_in(ObjectOutputStream outputStream){
        int key;
        String password;
        String request = setRequest();

        switch (request){
            case "get":
                System.out.println("Check if following key exists: ");
                key = userInputKey.nextInt();
                try {
                    outputStream.writeObject("key_in-get: " + key);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "set":
                System.out.println("Add a key to database: ");
                System.out.println("Key: ");
                key = userInputKey.nextInt();
                System.out.println("Password: ");
                password = userInputPassword.nextLine();
                try {
                    outputStream.writeObject("key_in-set: " + key + password);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    outputStream.writeObject("exit");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }
    public static String setRequest(){
        System.out.println("What request you want to make: get / set ?");
        request = userInputKey.nextLine();
        return request;
    }
}
