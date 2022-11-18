public class RequestHandler {
    Key key = new Key ();

    String existing = "yes";
    String not_existing = "no";
    public String handleRequest(String request){
        String substringRequest = request.substring(0,9);
        String key = request.substring(10);


        switch(substringRequest){
            case "key_in-get":
                System.out.println("Acquired key: " + key);
                System.out.println("Checking if key is in collection ...");
                return getKey(Integer.parseInt(key));
            case "key_in-set":
                try {
                    setKey(Integer.parseInt(key));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        return "Placeholder";

    }
    public String getKey(int klucz){
        if(key.check_key(klucz)){
            return existing;
        } else {
            return not_existing;
        }

    }
    public boolean setKey(int klucz) throws Exception {
        key.add_key(klucz);
        return true;
    }
}
