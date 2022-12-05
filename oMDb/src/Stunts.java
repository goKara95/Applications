import java.util.ArrayList;

public class Stunts extends Performers{
    private String height;
    private String actors;/*List of ID's of the actors a stuntPerformer
     works with since the problem doesn't involve anything do with it, it's never used */

    public Stunts(String ID, String name, String surname, String country, String height, String actors) {
        super(ID, name, surname, country);
        this.height = height;
        this.actors = actors;
    }

    //height is only special to Actors and stuntPerformers.
    // Program could use get methods for ID, name etc. because they were defined in the parent class
    //so, only one getter
    public String getHeight() {
        return height;
    }
}
