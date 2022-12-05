import java.util.ArrayList;

public class ShortFilm extends Films{
    private String genre;
    private String releaseDate;
    private String writers;
    private double rating;
    private ArrayList<Integer> rates = new ArrayList<>();/*rating list stores all the ratings so It can be calculated*/

    public ShortFilm(String ID, String title, String language, String directorID, int runtime, String country,
                     String performerID, String genre, String releaseDate, String writers) {
        super(ID, title, language, directorID, runtime, country, performerID);
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.writers = writers;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseDate() {
        return Integer.parseInt(releaseDate.substring(6, 10));
    }

    public String getWriters() {
        return writers;
    }


}
