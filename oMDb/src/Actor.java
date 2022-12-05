public class Actor extends Performers {
    private String height;
    public Actor(String ID, String name, String surname, String country, String height) {
        super(ID, name, surname, country);
        this.height = height;
    }
    //height is only special to Actors and stuntPerformers.
    // Program could use get methods for ID, name etc. because they were defined in the parent class
    //so, only one getter
    public String getHeight() {
        return height;
    }
}
