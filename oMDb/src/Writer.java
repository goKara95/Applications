public class Writer extends Artist {
    private String type;
    public Writer(String ID, String name, String surname, String country, String type) {
        super(ID, name, surname, country);
        this.type = type;
    }
    //Type is only special to writers
    // Program could use get methods for ID, name etc. because they were defined in the parent class
    //so, only one getter
    public String getType() {
        return type;
    }

}
