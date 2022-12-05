import java.io.FileWriter;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class Main {
    static DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.GERMANY);
    static DecimalFormat df = new DecimalFormat("#.0",symbols); //to print doubles with comma separated
    public static void successfulRate(String filename, String p1, String p2, String p3, Films p4){
        try {
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("RATE" + "\t" + p1 + "\t" + p2 + "\t" + p3 + "\t" + "\n" + "\n");
            myWriter.write("Film rated successfully" + "\n");
            if(p4.getClass().getSimpleName().equalsIgnoreCase("TVShows")){
                myWriter.write("Film type: TVSeries" + "\n");
            }
            else{
                myWriter.write("Film type: " + p4.getClass().getSimpleName() + "\n");
            }
            myWriter.write("Film title: " + p4.getTitle() + "\n");
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close();
        } catch (Exception e) { } }
    public static void rateFailed(String filename, String p1, String p2, String p3){
        try {
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("RATE" + "\t" + p1 + "\t" + p2 + "\t" + p3 + "\t" + "\n" + "\n");
            myWriter.write("Command Failed" + "\n");
            myWriter.write("User ID: " + p1 + "\n");
            myWriter.write("Film ID: " + p2 + "\n");
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close();
        } catch (Exception e) { } }
    public static void alreadyRated(String filename, String p1, String p2, String p3){
        try {
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("RATE" + "\t" + p1 + "\t" + p2 + "\t" + p3 + "\t" + "\n" + "\n");
            myWriter.write("This film was earlier rated" + "\n");
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close();
        } catch (Exception e) { } }
    public static void listUserFailed(String filename, String p1){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("LIST" + "\t" + "USER" + "\t" + p1 + "\t" + "RATES" + "\t" + "\n" + "\n");
            myWriter.write("Command Failed" + "\n");
            myWriter.write("User ID: " + p1 + "\n");
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close();
        } catch (Exception e) { }
    }
    public static void listUserEmpty(String filename, String p1){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("LIST" + "\t" + "USER" + "\t" + p1 + "\t" + "RATES" + "\t" + "\n" + "\n");
            myWriter.write("There is not any ratings so far" + "\n");
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close();
        } catch (Exception e) { }
    }
    public static void newRatingSuccess(String filename, String p1, String p2, String p3, Films film){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("EDIT" + "\t" + "RATE" + "\t" + p1 + "\t" + p2 + "\t" + p3 + "\t" + "\n" + "\n");
            myWriter.write("New ratings done successfully" + "\n");
            myWriter.write("Film title: " + film.getTitle() + "\n");
            myWriter.write("Your rating: " + p3 + "\n");
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close();
        } catch (Exception e) { }
    }
    public static void editFailed(String filename, String UserID, String FilmID, String Score){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("EDIT" + "\t" + "RATE" + "\t" + UserID + "\t" + FilmID + "\t" + Score + "\t" + "\n" + "\n");
            myWriter.write("Command Failed" + "\n");
            myWriter.write("User ID: " + UserID + "\n");
            myWriter.write("Film ID: " + FilmID + "\n");
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close();
        } catch (Exception e) { }

    }
    public static void removeRating(String filename, String UserID, Films film){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("REMOVE" + "\t" + "RATE" + "\t" + UserID + "\t" + film.getID() + "\t" + "\n" + "\n");
            myWriter.write("Your film rating was removed successfully" + "\n");
            myWriter.write("Film title: " + film.getTitle() + "\n");
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close();
        } catch (Exception e) { }

    }
    public static void removeFailed(String filename, String userID, String filmID){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("REMOVE" + "\t" + "RATE" + "\t" + userID + "\t" + filmID + "\t" + "\n" + "\n");
            myWriter.write("Command Failed" + "\n");
            myWriter.write("User ID: " + userID + "\n");
            myWriter.write("Film ID: " + filmID + "\n");
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close();
        } catch (Exception e) { }
    }
    /*takes y/n as first argument if yes prints successful operation message if no prints that the command has failed*/
    /*takes the commands string as second argument and prints the command given*/
    public static void addFeatureFilm(String filename, String successful, String[] command){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            for(int i=0; i<command.length; i++){
                /*after 12th word there is a newline*/
                if(i == 12){
                    myWriter.write(command[i] + "\n" + "\n");
                }
                else{
                    myWriter.write((command[i]) + "\t");
                } }
            if (successful.equals("yes")){myWriter.write("FeatureFilm added successfully" + "\n");}
            else if (successful.equals("no")){myWriter.write("Command Failed" + "\n");}
            myWriter.write("Film ID: " + command[2] + "\n");
            myWriter.write("Film title: " + command[3] + "\n");
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close();
        } catch (Exception e) { }

    }
    public static void viewFeatureFilm(String filename, FeatureFilm film, LinkedHashMap<String,Writer> writerList, LinkedHashMap<String,
            Director> directorsList, LinkedHashMap<String, Performers> castList){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("VIEWFILM" + "\t" + film.getID() + "\n" + "\n");
            myWriter.write(film.getTitle() + " (" + film.getReleaseDate() + ")" + "\n");
            myWriter.write(film.getGenre() + "\n");
            //creating String[] with writer IDs since I didn't split them while reading films.txt i'Ll do it now
            //Since person fields for film instances are strings I will get writers through for loop
            String[] writers = film.getWriters().split(",");
            String[] dir = film.getDirectorID().split(",");
            String[] stars = film.getPerformerID().split(",");
            myWriter.write("Writers: ");
            for(int i=0; i< writers.length; i++) {//gets writer object with given key from writerList
                if(i == (writers.length-1)){
                    myWriter.write(writerList.get(writers[i]).getFullName() + "\n");
                }
                else{
                    myWriter.write(writerList.get(writers[i]).getFullName() + "," + " ");
                }
            }
            myWriter.write("Directors: ");
            for(int i=0; i< dir.length; i++) {
                if(i == (dir.length-1)){
                    myWriter.write(directorsList.get(dir[i]).getFullName() + "\n");
                }
                else{
                    myWriter.write(directorsList.get(dir[i]).getFullName() + "," + " ");
                }
            }
            myWriter.write("Stars: ");
            for(int i=0; i< stars.length; i++) {
                if(i == stars.length-1){
                    myWriter.write(castList.get(stars[i]).getFullName() + "\n");
                }
                else{
                    myWriter.write(castList.get(stars[i]).getFullName() + "," + " ");
                }
            }
            if(!film.getRates().isEmpty()){
                if(!df.format(film.getRating()).substring(2).equals("0")){
                    myWriter.write("Ratings: " + df.format(film.getRating()) + "/10 from "
                            + film.getRates().size() + " users" + "\n");}
                else{
                    myWriter.write("Ratings: " + df.format(film.getRating()).charAt(0) + "/10 from "
                            + film.getRates().size() + " users" + "\n");
                }

            }
            if(film.getRates().isEmpty()){
                myWriter.write("Awaiting for votes" + "\n");
            }
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close(); } catch (Exception e) { }
    }

    public static void viewShortFilm(String filename, ShortFilm film, LinkedHashMap<String,Writer> writerList, LinkedHashMap<String,
            Director> directorsList, LinkedHashMap<String, Performers> castList){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("VIEWFILM" + "\t" + film.getID() + "\n" + "\n");
            myWriter.write(film.getTitle() + " (" + film.getReleaseDate() + ")" + "\n");
            myWriter.write(film.getGenre() + "\n");
            //creating String[] with writer IDs since I didn't split them while reading films.txt i'Ll do it now
            //Since person fields for film instances are strings I will get writers through for loop
            String[] writers = film.getWriters().split(",");
            String[] dir = film.getDirectorID().split(",");
            String[] stars = film.getPerformerID().split(",");
            myWriter.write("Writers: ");
            for(int i=0; i< writers.length; i++) {//gets writer object with given key from writerList
                if(i == (writers.length-1)){
                    myWriter.write(writerList.get(writers[i]).getFullName() + "\n");
                }
                else{
                    myWriter.write(writerList.get(writers[i]).getFullName() + "," + " ");
                }
            }
            myWriter.write("Directors: ");
            for(int i=0; i< dir.length; i++) {
                if(i == (dir.length-1)){
                    myWriter.write(directorsList.get(dir[i]).getFullName() + "\n");
                }
                else{
                    myWriter.write(directorsList.get(dir[i]).getFullName() + "," + " ");
                }
            }
            myWriter.write("Stars: ");
            for(int i=0; i< stars.length; i++) {
                if(i == stars.length-1){
                    myWriter.write(castList.get(stars[i]).getFullName() + "\n");
                }
                else{
                    myWriter.write(castList.get(stars[i]).getFullName() + "," + " ");
                }
            }
            if(!film.getRates().isEmpty()){
                if(!df.format(film.getRating()).substring(2).equals("0")){
                    myWriter.write("Ratings: " + df.format(film.getRating()) + "/10 from "
                            + film.getRates().size() + " users" + "\n");}
                else{
                    myWriter.write("Ratings: " + df.format(film.getRating()).charAt(0) + "/10 from "
                            + film.getRates().size() + " users" + "\n");
                }
            }
            if(film.getRates().isEmpty()){
                myWriter.write("Awaiting for votes" + "\n");
            }
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close(); } catch (Exception e) { }
    }

    public static void viewDocumentary(String filename, Documentary film, LinkedHashMap<String, Director> directorsList,
                                LinkedHashMap<String, Performers> castList){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("VIEWFILM" + "\t" + film.getID() + "\n" + "\n");
            myWriter.write(film.getTitle() + " (" + film.getReleaseDate() + ")" + "\n");
            //creating String[] with writer IDs since I didn't split them while reading films.txt i'Ll do it now
            //Since person fields for film instances are strings I will get writers through for loop
            String[] dir = film.getDirectorID().split(",");
            String[] stars = film.getPerformerID().split(",");
            myWriter.write("Directors: ");
            for(int i=0; i< dir.length; i++) {
                if(i == (dir.length-1)){
                    myWriter.write(directorsList.get(dir[i]).getFullName() + "\n");
                }
                else{
                    myWriter.write(directorsList.get(dir[i]).getFullName() + "," + " ");
                }
            }
            myWriter.write("Stars: ");
            for(int i=0; i< stars.length; i++) {
                if(i == stars.length-1){
                    myWriter.write(castList.get(stars[i]).getFullName() + "\n");
                }
                else{
                    myWriter.write(castList.get(stars[i]).getFullName() + "," + " ");
                }
            }
            if(!film.getRates().isEmpty()){
                if(!df.format(film.getRating()).substring(2).equals("0")){
                    myWriter.write("Ratings: " + df.format(film.getRating()) + "/10 from "
                            + film.getRates().size() + " users" + "\n");}
                else{
                    myWriter.write("Ratings: " + df.format(film.getRating()).charAt(0) + "/10 from "
                            + film.getRates().size() + " users" + "\n");
                }
            }
            if(film.getRates().isEmpty()){
                myWriter.write("Awaiting for votes" + "\n");
            }
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close(); } catch (Exception e) { }
    }

    public static void viewShow(String filename, TVShows show, LinkedHashMap<String,Writer> writerList, LinkedHashMap<String,
            Director> directorsList, LinkedHashMap<String, Performers> castList){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("VIEWFILM" + "\t" + show.getID() + "\n" + "\n");
            myWriter.write(show.getTitle() + " ");
            myWriter.write("(" + show.getStartDate() + "-");
            myWriter.write(show.getEndDate() + ")" + "\n");
            myWriter.write(show.getSeasons() + " seasons, ");
            myWriter.write(show.getEpisodes() + " episodes" + "\n");
            myWriter.write(show.getGenre() + "\n");
            //creating String[] with writer IDs since I didn't split them while reading films.txt i'Ll do it now
            //Since person fields for film instances are strings I will get writers through for loop
            String[] writers = show.getWriters().split(",");
            String[] dir = show.getDirectorID().split(",");
            String[] stars = show.getPerformerID().split(",");
            myWriter.write("Writers: ");
            for(int i=0; i< writers.length; i++) {//gets writer object with given key from writerList
                if(i == (writers.length-1)){
                    myWriter.write(writerList.get(writers[i]).getFullName() + "\n");
                }
                else{
                    myWriter.write(writerList.get(writers[i]).getFullName() + "," + " ");
                }
            }
            myWriter.write("Directors: ");
            for(int i=0; i< dir.length; i++) {
                if(i == (dir.length-1)){
                    myWriter.write(directorsList.get(dir[i]).getFullName() + "\n");
                }
                else{
                    myWriter.write(directorsList.get(dir[i]).getFullName() + "," + " ");
                }
            }
            myWriter.write("Stars: ");
            for(int i=0; i< stars.length; i++) {
                if(i == stars.length-1){
                    myWriter.write(castList.get(stars[i]).getFullName() + "\n");
                }
                else{
                    myWriter.write(castList.get(stars[i]).getFullName() + "," + " ");
                }
            }
            if(!show.getRates().isEmpty()){
                if(!df.format(show.getRating()).substring(2).equals("0")){
                    myWriter.write("Ratings: " + df.format(show.getRating()) + "/10 from "
                            + show.getRates().size() + " users" + "\n");}
                else{
                    myWriter.write("Ratings: " + df.format(show.getRating()).charAt(0) + "/10 from "
                            + show.getRates().size() + " users" + "\n");
                }
            }
            if(show.getRates().isEmpty()){
                myWriter.write("Awaiting for votes" + "\n");
            }
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close(); } catch (Exception e) { }
    }
    public static void viewFailed(String filename, String ID){
        try{
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("VIEWFILM" + "\t" + ID + "\n" + "\n");
            myWriter.write("Command Failed" + "\n");
            myWriter.write("Film ID: " + ID + "\n");
            myWriter.write("\n" + "-------------------------------------------------------------------------" +"\n");
            myWriter.close();
        } catch (Exception e) { }
    }//view film command failed
    public static void sortFeatureFilms(String filename, ArrayList<FeatureFilm> sortList){
        try {
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("LIST" + "\t" + "FILMS" + "\t" + "BY" + "\t" + "RATE" + "\t" + "DEGREE" + "\n" + "\n");
            myWriter.write("FeatureFilm:" + "\n");
            if(!sortList.isEmpty()){
                for (FeatureFilm film : sortList) {
                    myWriter.write(film.getTitle() + " (" + film.getReleaseDate() + ")");
                    if (!film.getRates().isEmpty()) {
                        if (!df.format(film.getRating()).substring(2).equals("0")) {
                            myWriter.write(" Ratings: " + df.format(film.getRating()) + "/10 from "
                                    + film.getRates().size() + " users" + "\n");
                        } else {
                            myWriter.write(" Ratings: " + df.format(film.getRating()).charAt(0) + "/10 from "
                                    + film.getRates().size() + " users" + "\n");
                        }
                    } else if (film.getRates().isEmpty()) {
                        myWriter.write(" Ratings: 0/10 from 0 users" + "\n");
                    }
                }
            }
            myWriter.write("\n");
            myWriter.close();
        } catch (Exception e) { }

    }//prints FeatureFilms sorted by rate
    public static void sortShortFilms(String filename, ArrayList<ShortFilm> sortList){
        try {
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("ShortFilm:" + "\n");
            if(!sortList.isEmpty()){
                for (ShortFilm shortFilm : sortList) {
                    myWriter.write(shortFilm.getTitle() + " (" + shortFilm.getReleaseDate() + ")");
                    if (!shortFilm.getRates().isEmpty()) {
                        if (!df.format(shortFilm.getRating()).substring(2).equals("0")) {
                            myWriter.write(" Ratings: " + df.format(shortFilm.getRating()) + "/10 from "
                                    + shortFilm.getRates().size() + " users" + "\n");
                        } else {
                            myWriter.write(" Ratings: " + df.format(shortFilm.getRating()).charAt(0) + "/10 from "
                                    + shortFilm.getRates().size() + " users" + "\n");
                        }
                    } else if (shortFilm.getRates().isEmpty()) {
                        myWriter.write(" Ratings: 0/10 from 0 users" + "\n");
                    }
                }
            }
            myWriter.write("\n");
            myWriter.close();
        } catch (Exception e) { }

    }//prints short films sorted by rate
    public static void sortDocumentary(String filename, ArrayList<Documentary> sortList){
        try {
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("Documentary:" + "\n");
            if(!sortList.isEmpty()){
                for (Documentary documentary : sortList) {
                    myWriter.write(documentary.getTitle() + " (" + documentary.getReleaseDate() + ")");
                    if (!documentary.getRates().isEmpty()) {
                        if (!df.format(documentary.getRating()).substring(2).equals("0")) {
                            myWriter.write(" Ratings: " + df.format(documentary.getRating()) + "/10 from "
                                    + documentary.getRates().size() + " users" + "\n");
                        } else {
                            myWriter.write(" Ratings: " + df.format(documentary.getRating()).charAt(0) + "/10 from "
                                    + documentary.getRates().size() + " users" + "\n");
                        }
                    } else if (documentary.getRates().isEmpty()) {
                        myWriter.write(" Ratings: 0/10 from 0 users" + "\n");
                    }
                }
            }
            myWriter.write("\n");
            myWriter.close();
        } catch (Exception e) { }

    }//prints documentaries sorted by rate
    public static void sortShows(String filename, ArrayList<TVShows> sortList){
        try {
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write("TVSeries:" + "\n");
            if(!sortList.isEmpty()){
                for (TVShows tvShows : sortList) {
                    myWriter.write(tvShows.getTitle() + " (" + tvShows.getStartDate() + "-");
                    myWriter.write(tvShows.getEndDate() + ")");
                    if (!tvShows.getRates().isEmpty()) {
                        if (!df.format(tvShows.getRating()).substring(2).equals("0")) {
                            myWriter.write(" Ratings: " + df.format(tvShows.getRating()) + "/10 from "
                                    + tvShows.getRates().size() + " users" + "\n");
                        } else {
                            myWriter.write(" Ratings: " + df.format(tvShows.getRating()).charAt(0) + "/10 from "
                                    + tvShows.getRates().size() + " users" + "\n");
                        }
                    } else if (tvShows.getRates().isEmpty()) {
                        myWriter.write(" Ratings: 0/10 from 0 users" + "\n");
                    }
                }
            }
            myWriter.write("\n");
            myWriter.write("-------------------------------------------------------------------------------" +
                    "----" +"\n");
            myWriter.close();
        } catch (Exception e) { }
    }//prints TV series sorted by rate

    public static void main(String[] args) {
        /*Hashmaps to store objects by their type*/
        LinkedHashMap<String, Stunts> stuntList = new LinkedHashMap<>();
        LinkedHashMap<String, Actor> actorList = new LinkedHashMap<>();
        LinkedHashMap<String, Writer> writerList = new LinkedHashMap<>();
        LinkedHashMap<String, Child> childList = new LinkedHashMap<>();
        LinkedHashMap<String, Director> directorsList = new LinkedHashMap<>();
        LinkedHashMap<String, User> userList = new LinkedHashMap<>();
        LinkedHashMap<String, Films> filmList = new LinkedHashMap<>();
        LinkedHashMap<String, FeatureFilm> featureList = new LinkedHashMap<>();
        LinkedHashMap<String, ShortFilm> shortFilmList = new LinkedHashMap<>();
        LinkedHashMap<String, TVShows> showList = new LinkedHashMap<>();
        LinkedHashMap<String, Documentary> docList = new LinkedHashMap<>();
        LinkedHashMap<String, Performers> castList = new LinkedHashMap<>();

        /*clears output file*/
        try {
            FileWriter myWriter = new FileWriter(args[3],false);
            myWriter.close();
        } catch (Exception e) {

        }

        /*READ PEOPLE FILE*/
        /*Adds person objects to their appropriate list*/
        try (Scanner scanner = new Scanner(Paths.get(args[0]))) {
            while (scanner.hasNextLine()) {
                String[] pm = scanner.nextLine().split("\t"); //pm = parameters
                switch (pm[0]) {
                    case "Actor:":
                        actorList.put(pm[1], new Actor(pm[1], pm[2], pm[3], pm[4], pm[5]));
                        castList.put(pm[1], new Actor(pm[1], pm[2], pm[3], pm[4], pm[5]));
                        break;
                    case "ChildActor:":
                        childList.put(pm[1], new Child(pm[1], pm[2], pm[3], pm[4], pm[5]));
                        castList.put(pm[1], new Child(pm[1], pm[2], pm[3], pm[4], pm[5]));
                        break;
                    case "Director:":
                        directorsList.put(pm[1],new Director(pm[1], pm[2], pm[3], pm[4], pm[5]));
                        break;
                    case "Writer:":
                        writerList.put(pm[1], new Writer(pm[1], pm[2], pm[3], pm[4], pm[5]));
                        break;
                    case "StuntPerformer:":
                        stuntList.put(pm[1], new Stunts(pm[1], pm[2], pm[3], pm[4], pm[5], pm[6]));
                        castList.put(pm[1], new Stunts(pm[1], pm[2], pm[3], pm[4], pm[5], pm[6]));
                        break;
                    case "User:":
                        userList.put(pm[1], new User(pm[1], pm[2], pm[3], pm[4]));
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*READING FILMS FILE*/
        /*Adds person objects to their appropriate list*/
        try (Scanner scanner = new Scanner(Paths.get(args[1]))) {
            while (scanner.hasNextLine()) {
                String[] pm = scanner.nextLine().split("\t");
                switch (pm[0]) {
                    case "FeatureFilm:":
                        filmList.put(pm[1], new FeatureFilm(pm[1], pm[2], pm[3], pm[4],
                                Integer.parseInt(pm[5]), pm[6],
                                pm[7], pm[8], pm[9], pm[10], pm[11]));
                        featureList.put(pm[1], new FeatureFilm(pm[1], pm[2], pm[3],
                                pm[4], Integer.parseInt(pm[5]), pm[6],
                                pm[7], pm[8], pm[9], pm[10], pm[11]));
                        break;
                    case "Documentary:":
                        filmList.put(pm[1], new Documentary(pm[1], pm[2], pm[3], pm[4],
                                Integer.parseInt(pm[5]), pm[6],
                                pm[7], pm[8]));
                        docList.put(pm[1], new Documentary(pm[1], pm[2], pm[3], pm[4], Integer.parseInt(pm[5]), pm[6],
                                pm[7], pm[8]));
                        break;
                    case "TVSeries:":
                        filmList.put(pm[1], new TVShows(pm[1], pm[2], pm[3], pm[4],
                                Integer.parseInt(pm[5]), pm[6], pm[7], pm[8], pm[9], pm[10], pm[11], pm[12], pm[13]));
                        showList.put(pm[1], new TVShows(pm[1], pm[2], pm[3], pm[4],
                                Integer.parseInt(pm[5]), pm[6], pm[7], pm[8], pm[9], pm[10], pm[11], pm[12], pm[13]));
                        break;
                    case "ShortFilm:":
                        if (Integer.parseInt(pm[5]) > 40) {
                            System.out.println("Short films cannot be longer than 40 minutes.");
                        } else {
                            filmList.put(pm[1], new ShortFilm(pm[1],pm[2],pm[3],pm[4],
                                    Integer.parseInt(pm[5]), pm[6], pm[7], pm[8], pm[9], pm[10]));
                            shortFilmList.put(pm[1], new ShortFilm(pm[1], pm[2], pm[3],pm[4],
                                    Integer.parseInt(pm[5]), pm[6], pm[7], pm[8], pm[9], pm[10]));
                        }
                        break;
                }

            }
        } catch (Exception e) { System.out.println(e.getMessage()); }




        /*READ COMMANDS*/
        try (Scanner scanner = new Scanner(Paths.get(args[2]))){
            while (scanner.hasNextLine()){
               String[] pm = scanner.nextLine().split("\t");
               switch (pm[0]) {
                   case "RATE":
                       if(userList.containsKey(pm[1]) && featureList.containsKey(pm[2]) &&
                               !userList.get(pm[1]).getRatingList().containsKey(pm[2]) &&
                               Integer.parseInt(pm[3]) <= 10 && Integer.parseInt(pm[3]) >= 1){
                           userList.get(pm[1]).getRatingList().put(pm[2],Integer.parseInt(pm[3]));
                           featureList.get(pm[2]).getRates().add(Integer.parseInt(pm[3]));
                           featureList.get(pm[2]).calculateRating();
                           successfulRate(args[3], pm[1], pm[2], pm[3], filmList.get(pm[2])); //method of print class
                       }
                       else if(userList.containsKey(pm[1]) && showList.containsKey(pm[2]) &&
                               !userList.get(pm[1]).getRatingList().containsKey(pm[2]) &&
                               Integer.parseInt(pm[3]) <= 10 && Integer.parseInt(pm[3]) >= 1){
                           userList.get(pm[1]).getRatingList().put(pm[2],Integer.parseInt(pm[3]));
                           showList.get(pm[2]).getRates().add(Integer.parseInt(pm[3]));
                           showList.get(pm[2]).calculateRating();
                           successfulRate(args[3], pm[1], pm[2], pm[3], filmList.get(pm[2]));
                       }
                       else if(userList.containsKey(pm[1]) && docList.containsKey(pm[2]) &&
                               !userList.get(pm[1]).getRatingList().containsKey(pm[2]) &&
                               Integer.parseInt(pm[3]) <= 10 && Integer.parseInt(pm[3]) >= 1){
                           userList.get(pm[1]).getRatingList().put(pm[2],Integer.parseInt(pm[3]));
                           docList.get(pm[2]).getRates().add(Integer.parseInt(pm[3]));
                           docList.get(pm[2]).calculateRating();
                           successfulRate(args[3], pm[1], pm[2], pm[3], filmList.get(pm[2]));
                       }
                       else if(userList.containsKey(pm[1]) && shortFilmList.containsKey(pm[2]) &&
                               !userList.get(pm[1]).getRatingList().containsKey(pm[2]) &&
                               Integer.parseInt(pm[3]) <= 10 && Integer.parseInt(pm[3]) >= 1){
                           userList.get(pm[1]).getRatingList().put(pm[2],Integer.parseInt(pm[3]));
                           shortFilmList.get(pm[2]).getRates().add(Integer.parseInt(pm[3]));
                           shortFilmList.get(pm[2]).calculateRating();
                           successfulRate(args[3], pm[1], pm[2], pm[3], filmList.get(pm[2]));
                       }
                       else if(!userList.containsKey(pm[1]) || !filmList.containsKey(pm[2])){
                           rateFailed(args[3], pm[1], pm[2], pm[3]); //user or film ID doesn't exist. Method of print class
                       }
                       else if(userList.get(pm[1]).getRatingList().containsKey(pm[2])){
                           alreadyRated(args[3], pm[1], pm[2], pm[3]);//film was rated earlier. Method of print class
                       }
                       break;
                   case "LIST":
                       switch (pm[1]){
                           case "USER":
                               if(!userList.containsKey(pm[2])){
                                   listUserFailed(args[3], pm[2]); //User is not in database. Method of print class
                               }
                               else if(userList.get(pm[2]).getRatingList().isEmpty()){
                                   listUserEmpty(args[3], pm[2]); //Users didn't rate any film yet. Method of print class
                               }
                               else {
                                   try{
                                       FileWriter myWriter = new FileWriter(args[3],true);
                                       myWriter.write("LIST" + "\t" + "USER" + "\t" + pm[2] + "\t" +
                                               "RATES" + "\t" + "\n" + "\n");
                                       /*creates set of keys for user's rated list to access all the films in a user
                                       rated. Since every film ID is stored in rating list it will get film objects
                                       through this loop*/
                                       for (String key : userList.get(pm[2]).getRatingList().keySet()) {
                                           myWriter.write(filmList.get(key).getTitle() + ": ");
                                           myWriter.write(userList.get(pm[2]).getRatingList().get(key) + "\n");
                                       }
                                       myWriter.write("\n" + "-------------------------------------------------" +
                                               "------------------------" +"\n");
                                       myWriter.close();
                                   } catch (Exception e) { }
                               }
                               break;
                           case "FILM":
                               if(!showList.isEmpty()){
                                   try{
                                       FileWriter myWriter = new FileWriter(args[3],true);
                                       myWriter.write("LIST" + "\t" + "FILM" + "\t" + "SERIES" + "\n" + "\n");
                                       for(String key: showList.keySet()){
                                           myWriter.write(showList.get(key).getTitle() + " (" +
                                                   showList.get(key).getStartDate() + "-" +
                                                   showList.get(key).getEndDate() + ")" + "\n");
                                           myWriter.write(showList.get(key).getSeasons() + " seasons and ");
                                           myWriter.write(showList.get(key).getEpisodes() + " episodes" + "\n"+"\n");
                                       }
                                       myWriter.write("-------------------------------------------------" +
                                               "------------------------" +"\n");
                                       myWriter.close();
                                   } catch (Exception e) { }
                               }
                               else{
                                   try{
                                       FileWriter myWriter = new FileWriter(args[3], true);
                                       myWriter.write("LIST" + "\t" + "FILM" + "\t" + "SERIES" + "\n" + "\n");
                                       myWriter.write("No result" + "\n");
                                       myWriter.write("\n" + "-------------------------------------------------" +
                                               "------------------------" +"\n");
                                       myWriter.close();
                                   } catch (Exception e) { }
                               }
                               break;
                           case "FILMS":
                               if(pm[3].equalsIgnoreCase("COUNTRY")){
                                   try{
                                       int empty = 1; //if no film was found program will execute 2nd conditional block
                                       FileWriter myWriter = new FileWriter(args[3],true);
                                       myWriter.write("LIST" + "\t" + "FILMS" + "\t" + "BY" + "\t" + "COUNTRY "
                                               + pm[4] + "\n" + "\n");
                                       for(String key: filmList.keySet()){
                                           if(filmList.get(key).getCountry().equalsIgnoreCase(pm[4])){
                                               myWriter.write("Film title: " + filmList.get(key).getTitle()+"\n");
                                               myWriter.write(filmList.get(key).getRuntime() + " min" +"\n");
                                               myWriter.write("Language: " + filmList.get(key).getLanguage() +"\n" + "\n");
                                               empty = 0;
                                           }
                                       }
                                       if(empty == 1){
                                           myWriter.write("No result" + "\n" + "\n");
                                       }
                                       myWriter.write("------------------------------------------------------" +
                                               "-------------------" +"\n");
                                       myWriter.close();
                                   } catch (Exception e) { } }
                               else if(pm[3].equalsIgnoreCase("RATE")){
                                   /*to sort the objects by values I grabbed each <film type> hashmap and converted them
                                   to arrayList in order to use my overridden comparator method*/
                                   ArrayList<FeatureFilm> feature = new ArrayList<FeatureFilm>(featureList.values());
                                   ArrayList<ShortFilm> shorts = new ArrayList<ShortFilm>(shortFilmList.values());
                                   ArrayList<Documentary> docs = new ArrayList<Documentary>(docList.values());
                                   ArrayList<TVShows> series = new ArrayList<TVShows>(showList.values());
                                   RatingComparator compareRating = new RatingComparator();
                                   Collections.sort(feature, compareRating.reversed());
                                   Collections.sort(shorts, compareRating.reversed());
                                   Collections.sort(docs, compareRating.reversed());
                                   Collections.sort(series, compareRating.reversed());
                                   sortFeatureFilms(args[3], feature);
                                   sortShortFilms(args[3], shorts);
                                   sortDocumentary(args[3], docs);
                                   sortShows(args[3], series);
                               }
                               break;
                           case "ARTISTS":
                               try{
                                   int empty = 1; //if no artist was found program will execute 2nd conditional block
                                   FileWriter myWriter = new FileWriter(args[3],true);
                                   myWriter.write("LIST" + "\t" + "ARTISTS" + "\t" + "FROM" + "\t" + pm[3] +
                                           "\n" + "\n");
                                   /*For loop is checking every artist in their list and if the country given
                                   matches prints asked details*/

                                   /*loop for directors*/
                                   myWriter.write("Directors:" +"\n");
                                   for(String key: directorsList.keySet()){
                                       if(directorsList.get(key).getCountry().equalsIgnoreCase(pm[3])){
                                           myWriter.write(directorsList.get(key).getName() + " ");
                                           myWriter.write(directorsList.get(key).getSurname() + " ");
                                           myWriter.write(directorsList.get(key).getAgent() + "\n");
                                           empty = 0;//setting empty to zero to prevent printing
                                           // no result so the if below won't get executed
                                       }
                                   }
                                   if(empty == 1){
                                       myWriter.write("No result" + "\n");
                                   }
                                   /*loop for writer*/
                                   empty = 1;
                                   myWriter.write("\n" + "Writers:" +"\n");
                                   for(String key: writerList.keySet()){
                                       if(writerList.get(key).getCountry().equalsIgnoreCase(pm[3])){
                                           myWriter.write(writerList.get(key).getName() + " ");
                                           myWriter.write(writerList.get(key).getSurname() + " ");
                                           myWriter.write(writerList.get(key).getType() + "\n");
                                           empty = 0;
                                       }
                                   }
                                   if(empty == 1){
                                       myWriter.write("No result" + "\n");
                                   }
                                   /*loop for actors*/
                                   empty = 1;
                                   myWriter.write("\n" +"Actors:" +"\n");
                                   for(String key: actorList.keySet()){
                                       if(actorList.get(key).getCountry().equalsIgnoreCase(pm[3])){
                                           myWriter.write(actorList.get(key).getName() + " ");
                                           myWriter.write(actorList.get(key).getSurname() + " ");
                                           myWriter.write(actorList.get(key).getHeight() + " cm" + "\n");
                                           empty = 0;
                                       }
                                   }
                                   if(empty == 1){
                                       myWriter.write("No result" + "\n");
                                   }
                                   /*loop for child actors*/
                                   empty = 1;
                                   myWriter.write("\n" + "ChildActors:" +"\n");
                                   for(String key: childList.keySet()){
                                       if(childList.get(key).getCountry().equalsIgnoreCase(pm[3])){
                                           myWriter.write(childList.get(key).getName() + " ");
                                           myWriter.write(childList.get(key).getSurname() + " ");
                                           myWriter.write(childList.get(key).getAge() + "\n");
                                           empty = 0;
                                       }
                                   }
                                   if(empty == 1){
                                       myWriter.write("No result" + "\n");
                                   }
                                   /*loop for stunts*/
                                   empty = 1;
                                   myWriter.write("\n" + "StuntPerformers:" +"\n");
                                   for(String key: stuntList.keySet()){
                                       if(stuntList.get(key).getCountry().equalsIgnoreCase(pm[3])){
                                           myWriter.write(stuntList.get(key).getName() + " ");
                                           myWriter.write(stuntList.get(key).getSurname() + " ");
                                           myWriter.write(stuntList.get(key).getHeight() + " cm" + "\n");
                                           empty = 0;
                                       }
                                   }
                                   if(empty == 1){
                                       myWriter.write("No result" + "\n");
                                   }
                                   myWriter.write("\n"+ "------------------------------------------------------" +
                                           "-------------------" +"\n");
                                   myWriter.close();
                               } catch (Exception e) { }
                               break;
                           case "FEATUREFILMS":
                               try{
                                   int empty = 1; //if no film was found program will execute 2nd conditional block
                                   FileWriter myWriter = new FileWriter(args[3],true);
                                   myWriter.write(pm[0] + "\t" + pm[1] + "\t" + pm[2] + "\t" + pm[3] + "\n" + "\n");
                                   for(String key: featureList.keySet()){
                                       if(pm[2].equals("BEFORE") &&
                                               featureList.get(key).getReleaseDate()<Integer.parseInt(pm[3]) ||
                                               pm[2].equals("AFTER") &&
                                                       featureList.get(key).getReleaseDate()>=Integer.parseInt(pm[3])){
                                           myWriter.write("Film title: " + featureList.get(key).getTitle()+" ");
                                           myWriter.write("("+ featureList.get(key).getReleaseDate() + ")" + "\n");
                                           myWriter.write(featureList.get(key).getRuntime() + " min" +"\n");
                                           myWriter.write("Language: " + featureList.get(key).getLanguage() +"\n" + "\n");
                                           empty = 0; //setting empty zero to because if program is here
                                           // there is a movie before specified year then no result shouldn't be printed
                                       }
                                   }
                                   if(empty == 1){
                                       myWriter.write("No result" + "\n" +"\n");
                                   }
                                   myWriter.write("------------------------------------------------------" +
                                           "-------------------" +"\n");
                                   myWriter.close();
                               } catch (Exception e) { }
                               break;
                       }
                       break;
                   case "EDIT":
                       if(userList.containsKey(pm[2]) && userList.get(pm[2]).getRatingList().containsKey(pm[3]) &&
                       Integer.parseInt(pm[4]) <= 10 && Integer.parseInt(pm[4]) >= 1){
                           /*remove old rating from rating list and add new one, then calculate overall rate again*/
                           if(featureList.containsKey(pm[3])){
                               featureList.get(pm[3]).getRates().remove(userList.get(pm[2]).getRatingList().get(pm[3]));
                               featureList.get(pm[3]).getRates().add(Integer.parseInt(pm[4]));
                               featureList.get(pm[3]).calculateRating();
                           }
                           else if(shortFilmList.containsKey(pm[3])){
                               shortFilmList.get(pm[3]).getRates().remove(userList.get(pm[2]).getRatingList().get(pm[3]));
                               shortFilmList.get(pm[3]).getRates().add(Integer.parseInt(pm[4]));
                               shortFilmList.get(pm[3]).calculateRating();

                           }
                           else if(showList.containsKey(pm[3])){
                               showList.get(pm[3]).getRates().remove(userList.get(pm[2]).getRatingList().get(pm[3]));
                               showList.get(pm[3]).getRates().add(Integer.parseInt(pm[4]));
                               showList.get(pm[3]).calculateRating();
                           }
                           else if(docList.containsKey(pm[3])){
                               docList.get(pm[3]).getRates().remove(userList.get(pm[2]).getRatingList().get(pm[3]));
                               docList.get(pm[3]).getRates().add(Integer.parseInt(pm[4]));
                               docList.get(pm[3]).calculateRating();
                           }
                           userList.get(pm[2]).getRatingList().put(pm[3], Integer.parseInt(pm[4]));
                           newRatingSuccess(args[3], pm[2], pm[3], pm[4], filmList.get(pm[3]));
                       }
                       else{
                           editFailed(args[3], pm[2],pm[3],pm[4]);
                       }
                       break;
                   case "REMOVE":
                       if(userList.containsKey(pm[2]) && userList.get(pm[2]).getRatingList().containsKey(pm[3])){
                           removeRating(args[3], pm[2], filmList.get(pm[3]));
                           /*remove said rating from a films rating list*/
                           if(filmList.get(pm[3]).getClass().getSimpleName().equals("FeatureFilm")){
                               featureList.get(pm[3]).getRates().remove(userList.get(pm[2]).getRatingList().get(pm[3]));
                               featureList.get(pm[3]).calculateRating();
                           }
                           else if(filmList.get(pm[3]).getClass().getSimpleName().equals("ShortFilm")){
                               shortFilmList.get(pm[3]).getRates().remove(userList.get(pm[2]).getRatingList().get(pm[3]));
                               shortFilmList.get(pm[3]).calculateRating();
                           }
                           else if(filmList.get(pm[3]).getClass().getSimpleName().equals("Documentary")){
                               docList.get(pm[3]).getRates().remove(userList.get(pm[2]).getRatingList().get(pm[3]));
                               docList.get(pm[3]).calculateRating();
                           }
                           else if(filmList.get(pm[3]).getClass().getSimpleName().equals("TVShows")){
                               showList.get(pm[3]).getRates().remove(userList.get(pm[2]).getRatingList().get(pm[3]));
                               showList.get(pm[3]).calculateRating();
                           }
                           /*remove film ID- its rating pair from users rating list*/
                           userList.get(pm[2]).getRatingList().remove(pm[3]);
                       }
                       else{
                           removeFailed(args[3], pm[2],pm[3]);//check printer class for details
                       }
                       break;
                   case "ADD":
                       /*Splits comma separated IDs for director cast and writer*/
                       String[] directors = pm[5].split(",");
                       String[] cast = pm[8].split(",");
                       String[] writer = pm[11].split(",");
                       if(!filmList.containsKey(pm[2])){
                           int boolD = 1; //boolean director, if person is in the list = 1, if not = 0
                           int boolC = 1; //boolean cast
                           int boolW = 1; //boolean writer
                           /*if given IDs are not existed in the database, then add feature film command should fail
                           so, loops below will set booleans to zero if a given ID couldn't be found in the database*/
                           for (String director : directors) {
                               if (!directorsList.containsKey(director)) {
                                   boolD = 0;
                                   break;
                               }
                           }
                           for (String value : cast) {
                               if (!castList.containsKey(value)) {
                                   boolC = 0;
                                   break;
                               }
                           }
                           for (String s : writer) {
                               if (!writerList.containsKey(s)) {
                                   boolW = 0;
                                   break;
                               }
                           }
                           // if every ID exists then sum of booleans must be 3. So, we create and add new
                           // FeatureFilm objects and add them to their appropriate lists
                           if (boolD + boolW + boolC == 3){
                               filmList.put(pm[2], new FeatureFilm(pm[2], pm[3], pm[4], pm[5],
                                       Integer.parseInt(pm[6]), pm[7],
                                       pm[8], pm[9], pm[10], pm[11], pm[12]));
                               featureList.put(pm[2], new FeatureFilm(pm[2], pm[3], pm[4], pm[5],
                                       Integer.parseInt(pm[6]), pm[7],
                                       pm[8], pm[9], pm[10], pm[11], pm[12]));
                               addFeatureFilm(args[3], "yes",pm);
                           }
                           else{
                               addFeatureFilm(args[3], "no",pm);
                           }
                       }
                       else{ addFeatureFilm(args[3], "no",pm);
                       }
                       break;
                   case "VIEWFILM":
                       if(featureList.containsKey(pm[1])){
                           viewFeatureFilm(args[3], featureList.get(pm[1]),writerList, directorsList, castList);
                       }
                       else if(shortFilmList.containsKey(pm[1])){
                           viewShortFilm(args[3], shortFilmList.get(pm[1]),writerList, directorsList, castList);
                       }
                       else if(docList.containsKey(pm[1])){
                           viewDocumentary(args[3], docList.get(pm[1]),directorsList,castList);
                       }
                       else if(showList.containsKey(pm[1])){
                           viewShow(args[3], showList.get(pm[1]), writerList, directorsList, castList);
                       }
                       else if(!filmList.containsKey(pm[1])){
                           viewFailed(args[3], pm[1]);
                       }
                       break;

               }


               } } catch (Exception e){}
    }
    }



