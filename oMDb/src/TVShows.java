import java.util.ArrayList;

public class TVShows extends Films {
    private String genre;
    private String startDate;
    private String endDate;
    private String seasons;
    private String episodes;
    private double rating;
    private String writers;
    private ArrayList<Integer> rates = new ArrayList<>();/*rating list*/

    public TVShows(String ID, String title, String language, String directorID, int runtime, String country,
                   String performerID, String genre, String writers, String startDate,
                   String endDate, String seasons, String episodes) {
        super(ID, title, language, directorID, runtime, country, performerID);
        this.writers = writers;
        this.startDate = startDate;
        this.endDate = endDate;
        this.genre = genre;
        this.seasons = seasons;
        this.episodes = episodes;
    }

    /*returns year from whole date*/
    public String getStartDate() {
        return startDate.substring(6,10);
    }

    public String getEndDate() {
        return endDate.substring(6,10);
    }

    public String getSeasons() {
        return seasons;
    }

    public String getEpisodes() {
        return episodes;
    }

    public String getGenre() {
        return genre;
    }

    public String getWriters() {
        return writers;
    }
}
