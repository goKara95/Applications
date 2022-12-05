public class Child extends Performers{
    private String age;
    public Child(String ID, String name, String surname, String country, String age) {
        super(ID, name, surname, country);
        this.age = age;
    }
    //age field is special to Child object
    // Program could use get methods for ID, name etc. because they were defined in the parent class so, only one getter
    public String getAge() {
        return age;
    }
}
