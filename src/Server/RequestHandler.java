package Server;

public class RequestHandler {
    KeyService keyService = new KeyService();
    String mainPassword = "haslo123";
    String existing = "yes";
    String not_existing = "not";
    String error = "error";
    public String getKey(int key){
        System.out.println(key);
        if(keyService.check_key(key)){
            return existing;
        } else {
            return not_existing;
        }
    }

    public String handleRequest(String request){
        StringBuilder response = new StringBuilder();
        String substrRequest = request.substring(0,10);
        String keyStr = null;
        String password;
        int key;
        response.append("key-out- { ");
        switch (substrRequest) {
            case "key_in-get":
                keyStr = request.substring(14, request.length() - 3);
                key = Integer.parseInt(keyStr);
                String answer = getKey(key);
                response.append(key + " : " + answer + " } ");
            case "key_in-set":
                password = request.substring(13, request.length() - 15);
                keyStr = request.substring(request.length() - 12, request.length() - 3);
                System.out.println(keyStr);
                System.out.println(password);
                key = Integer.parseInt(keyStr);
                if(password.equals(mainPassword)){
                    try {
                        keyService.add_key(key);
                        response.append(key + " : " + existing + " } ");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    response.append(key + " : " + error + " } ");
                }
        }
        return response.toString();
    }
}
