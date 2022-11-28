package Server;

import java.util.ArrayList;


public class KeyService {
    public ArrayList<Key> keys = new ArrayList<>();
    public KeyService(){
        addKeys();
    }
    public boolean check_key(int key){
        for (Key klucz : keys){
            if(klucz.getIndex() == key){
                return  true;
            }
        }
        return false;
    }
    public void add_key(int key) throws Exception {
        if (!check_key(key)) {
            Key newKey = new Key(key);
            keys.add(newKey);
        }
    }
    public void addKeys(){
        Key key1 = new Key(669987963);
        Key key2 = new Key(669987964);
        Key key3 = new Key(669987965);
        Key key4 = new Key(669987966);
        Key key5 = new Key(669987967);
        Key key6 = new Key(669987968);
        Key key7 = new Key(669987969);
        Key key8 = new Key(669987962);

        keys.add(key1);
        keys.add(key2);
        keys.add(key3);
        keys.add(key4);
        keys.add(key5);
        keys.add(key6);
        keys.add(key7);
        keys.add(key8);
    }
}
