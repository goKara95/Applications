import java.util.ArrayList;

public class Films {
    public String getTitle() {
        return title;
    }
    private String ID;
    private String title;
    private String language;
    private String directorID;
    private int runtime;
    private String country;
    private String performerID;
    private double rating;
    private ArrayList<Integer> rates = new ArrayList<Integer>();/*rating hashmapi*/

    public Films(String ID, String title, String language, String directorID, int runtime, String country, String performerID) {
        this.ID = ID;
        this.title = title;
        this.language = language;
        this.directorID = directorID;
        this.runtime = runtime;
        this.country = country;
        this.performerID = performerID;
    }

    public String getCountry() {
        return country;
    }

    public String getID() {
        return ID;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getLanguage() {
        return language; }

    public String getDirectorID() {
        return directorID;
    }

    public ArrayList<Integer> getRates() {
        return rates;
    }

    public String getPerformerID() {
        return performerID;
    }

    public double getRating() {
        return rating;
    }

    /*methods above are pretty self explanatory*/

    /*takes a film objects rate list. Sums up all the ratings and divides it to size of rate list in
    order to get average rating*/
    public void calculateRating(){
        double allRates = 0;
        for(int i =0; i<rates.size(); i++){
            allRates += rates.get(i);
        }
        //reason for multiplying and dividing to ten is converting integer to double
        //because the ratings stored in the list were all integers
        this.rating = (Math.round(allRates / rates.size()*10.0))/10.0;
    }


    /*Since comparator doesn't compare doubles, we should compare integers. But, it is not possible to compare numbers
    with decimals if we convert them to integers directly. So, every rating is multiplied by 10. That way comparator
    can compare them as if they were decimals*/
    public int getRatingInteger(){
        return (int) (this.rating * 10);
    }
}
