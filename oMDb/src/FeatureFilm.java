import java.io.FileWriter;
import java.util.ArrayList;

public class FeatureFilm extends Films {
    private String genre;
    private String releaseDate;
    private String writers;
    private String budget;
    private double rating;
    private int intRating;
    private ArrayList<Integer> rates = new ArrayList<>();/*rating list*/

    public FeatureFilm(String ID, String title, String language, String directorID, int runtime,
                       String country, String performerID, String genre,
                       String releaseDate, String writers, String budget) {
        super(ID, title, language, directorID, runtime, country, performerID);
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.writers = writers;
        this.budget = budget;
    }

    /*gets year from release date string and returns it as an integer */
    public int getReleaseDate() {
        return Integer.parseInt(releaseDate.substring(6, 10));
    }

    public String getGenre() {
        return genre;
    }

    public String getWriters() {
        return writers;
    }

}
