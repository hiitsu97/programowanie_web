package Client;

import java.util.Scanner;

public class RequestBuilder {
    private static Scanner userInputKey = new Scanner(System.in);
    private static Scanner userInputPassword = new Scanner(System.in);
    private StringBuilder request = new StringBuilder();


    public String buildRequest(){
        System.out.println("What request you want to make: get : 1, set : 2 ");
        int option = userInputKey.nextInt();
        int key;
        request.append("key_in-");
        String question = null;
        String password = null;
        switch (option){
            case 1:
                question ="get";
                key = readKey();
                request.append(question + " { " + key + " } ");
                break;
            case 2:
                question = "set";
                key = readKey();
                password = readPassword();
                request.append(question + " { " + password + " : " + key + " } ");
                break;
        }
        return request.toString();
    }

    public int readKey() {
        System.out.println("Key: ");
        int key = userInputKey.nextInt();
        return key;
    }
    public String readPassword() {
        System.out.println("Password: ");
        String password = userInputPassword.nextLine();
        return password;
    }
}
