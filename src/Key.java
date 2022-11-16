import java.util.ArrayList;
import java.util.Random;

public class Key {

    public ArrayList<Integer> Keys = new ArrayList<>();
    public Key(){
        addKeys();
    };


    public String check_key(int key){
        if (Keys.contains(key)){
            return("yes");
        }
        else {
            return ("not");
        }
    }
    public void add_key(int key) throws Exception {
        if (check_key(key) == "yes"){
            Keys.add(key);
        }
    }
    public void addKeys(){
        for (int i = 0; i < 10; i++){
            Random random = new Random();
            int value = random.nextInt((999999999) + 100000000);
            Keys.add(value);
        }
    }
}
