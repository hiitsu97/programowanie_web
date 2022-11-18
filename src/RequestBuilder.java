import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class RequestBuilder {
    private static Scanner userInput = new Scanner(System.in);
    private static String request;

    public static void key_in(String request, ObjectOutputStream outputStream){
        int key;

        switch (request){
            case "get":
                System.out.println("Check if following key exists: ");
                key = userInput.nextInt();
                try {
                    outputStream.writeObject("key_in-get: " + key);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "set":
                System.out.println("Add a key to database: ");
                key = userInput.nextInt();
                try {
                    outputStream.writeObject("key_in-set: " + key);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }

    }
    public static String setRequest(){
        System.out.println("What request you want to make: get / set ?");
        request = userInput.nextLine();
        return request;
    }
}
