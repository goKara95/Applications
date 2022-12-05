import java.util.ArrayList;

public class Documentary extends Films{
    private String releaseDate;
    private double rating;
    private ArrayList<Integer> rates = new ArrayList<>();/*rating list*/

    public Documentary(String ID, String title, String language, String directorID, int runtime, String country,
                       String performerID, String releaseDate) {
        super(ID, title, language, directorID, runtime, country, performerID);
        this.releaseDate = releaseDate;
    }

    /*returns only the year from release date*/
    public int getReleaseDate() {
        return Integer.parseInt(releaseDate.substring(6, 10));
    }
}
