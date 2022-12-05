public class Person {
    private String ID;
    private String name;
    private String surname;
    private String country;
    public Person(String ID, String name, String surname, String country) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
    /*Methods below are pretty self explanatory*/
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCountry() {
        return country;
    }
    public String getFullName(){
        return name + " " + surname;
    }
}
