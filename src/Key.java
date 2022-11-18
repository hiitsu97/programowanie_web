import java.util.ArrayList;
import java.util.Random;

public class Key {

    public ArrayList<Integer> Keys = new ArrayList<>();
    public Key(){
        addKeys();
    };


    public boolean check_key(int key){
        return (Keys.contains(key));
    }
    public boolean add_key(int key) throws Exception {
        if (check_key(key)){
            Keys.add(key);
            return true;
        } else {
            return false;
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
