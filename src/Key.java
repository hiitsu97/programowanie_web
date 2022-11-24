import java.util.ArrayList;
import java.util.Random;

public class Key {
    private int index;
    private String password;
    public Key(int index, String password){
        this.index = index;
        this.password = password;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public void setPassword(String password){
        this. password = password;
    }
    public int getIndex(){
        return index;
    }
    public String getPassword(){
        return password;
    }
}
