public class RequestHandler {
    KeyService keyService = new KeyService();

    String existing = "yes";
    String not_existing = "no";
    public String handleRequest(String request){
        String response = null;
        if (request.length()>4){
        String substringRequest = request.substring(0,10);
        String key = request.substring(12,21);
        String password = null;
        if (request.length()>21){
            password = request.substring(request.length() - 8);
        }
        switch(substringRequest){
            case "key_in-get":
                System.out.println(substringRequest);
                System.out.println(key);
                System.out.println(password);
                System.out.println("Acquired key: " + key);
                System.out.println("Checking if key is in collection ...");
                return getKey(Integer.parseInt(key));
            case "key_in-set":
                try {
                    System.out.println(substringRequest);
                    System.out.println(key);
                    System.out.println(password);
                    setKey(Integer.parseInt(key), password);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                response = "key set";
                break;
            default:
                response = "Error: unknown response";
                return response;
        }
    }
        return response;
    }
    public String getKey(int key){
        System.out.println(key);
        if(keyService.check_key(key)){
            return existing;
        } else {
            return not_existing;
        }
    }
    public void setKey(int key, String password) throws Exception {
        keyService.add_key(key, password);
    }
}
