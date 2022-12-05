public class Director extends Artist{
    private String agent;
    public Director(String ID, String name, String surname, String country, String agent) {
        super(ID, name, surname, country);
        this.agent=agent;
    }
    //Agent is special to directors.
    // Program could use get methods for ID, name etc. because they were defined in the parent class
    //so, only one getter
    public String getAgent() {
        return agent;
    }
}
