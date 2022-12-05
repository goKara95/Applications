import java.util.HashMap;
import java.util.LinkedHashMap;

public class User extends Person{
    private LinkedHashMap<String, Integer> ratingList = new LinkedHashMap<>(); //List of rated films.
    // Each object starts with a null arraylist.
    public User(String ID, String name, String surname, String country) {
        super(ID, name, surname, country);
    }

    public LinkedHashMap<String, Integer> getRatingList() {
        return ratingList;
    }
}
