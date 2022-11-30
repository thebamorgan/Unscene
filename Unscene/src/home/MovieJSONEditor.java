package home;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class MovieJSONEditor {
    private final String DataFile;                  // Datafile to read
    private ArrayList<Movie> InterestedMovies;      // ArrayList of interested movies
    private ArrayList<Movie> AllMovies;             // ArrayList of all movies
    
    
    /**
     * Default Constructor
     */
    public MovieJSONEditor() {
        this.DataFile = null;
        this.InterestedMovies = new ArrayList();
        this.AllMovies = new ArrayList();
    }
    
    /**
     * Overloaded Constructor
     * 
     * @param filename to read from
     * @throws Exception 
     */
    public MovieJSONEditor(String filename) throws Exception {
        this.DataFile = filename;
        this.InterestedMovies = new ArrayList();
        this.AllMovies = new ArrayList();
        
        // Automatically read file
        readFile();
    }
    
    
    /**
     * Read JSON file, load data in InterestedMovies list and AllMovies list
     * 
     * @throws Exception 
     */
    private void readFile() throws Exception {
        
        // Reset Arrays
        InterestedMovies.clear();
        AllMovies.clear();
        
        // Fetch movie array from JSON file
        Object obj = new JSONParser().parse(new FileReader(DataFile));
        JSONObject jo = (JSONObject) obj;
        JSONArray movieslist = (JSONArray) jo.get("movies");
        
        // Read each movie in array
        for(Object m : movieslist) {
            
            // Convert movie to JSONObject
            JSONObject movie = (JSONObject) m;
            
            // Add movie to AllMovies list
            Movie addMovie = readMovie(movie);
            addMovie.updateInterested();
            AllMovies.add(addMovie);
            
            // If interested, add to InterestedMovies list
            if(addMovie.getInterested())
                InterestedMovies.add(addMovie);
        }
    }
    
    /**
     * Read Movie Object from JSONArray of Movies
     * 
     * @param movie JSON object to read
     * @return Movie object
     */
    private Movie readMovie(JSONObject movie){
        
        // Read all relevant movie information
        String RDate = (String) movie.get("release_date");
        int RunT = (int) ((long)movie.get("runtime"));
        String Tagline = (String) movie.get("tagline");
        String Title = (String) movie.get("title");
        String Description = (String) movie.get("overview");
        String Art = (String) movie.get("poster_path");
        boolean Viewed = (boolean) movie.get("viewed");
        boolean Interested = (boolean) movie.get("interested");
        int ID = (int) ((long)movie.get("id"));
        
        // Read genre array
        ArrayList<String> Genre = new ArrayList();
        JSONArray genreslist = (JSONArray) movie.get("genres");
        for(Object g : genreslist) {
            JSONObject genreobj = (JSONObject) g;
            Genre.add((String) genreobj.get("name"));
        }

        // Create movie object
        Movie addMovie = new Movie(RDate, RunT, Title, Genre, Description, Tagline, Art, Interested, Viewed, ID);
        
        return addMovie;
    }
    
    /**
     * Update JSON File with edited movie object parameter
     * 
     * @param updateMovie object to insert in data file
     * @throws Exception 
     */
    public void updateMovie(Movie updateMovie) throws Exception {
        
        // Fetch movie array from JSON file
        Object obj = new JSONParser().parse(new FileReader(DataFile));
        JSONObject jo = (JSONObject) obj;
        JSONArray movieslist = (JSONArray) jo.get("movies");
        
        // Read each movie in array
        for(Object m : movieslist) {
            
            // Convert movie to JSONObject
            JSONObject movie = (JSONObject) m;
            int ID = (int) ((long)movie.get("id"));
            
            // If matching ID, update fields
            if(ID == updateMovie.getID()) {
                movie.put("interested", updateMovie.getInterested());
                movie.put("viewed", updateMovie.getViewed());
            }
        }
        
        // Write to data file
        PrintWriter pw = new PrintWriter(DataFile);
        pw.write(jo.toJSONString());
        
        pw.flush();
        pw.close();
        
    }
    
    /**
     * Get AllMovies List
     * 
     * @return All Movies ArrayList
     */
    public ArrayList<Movie> getAllMovies() {
        try {
            readFile();
        } catch (Exception ex) {
            Logger.getLogger(MovieJSONEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AllMovies;
    }
    
    /**
     * Get InterestedMovies List
     * 
     * @return Interested Movies ArrayList
     */
    public ArrayList<Movie> getInterestedMovies() {
        try {
            readFile();
        } catch (Exception ex) {
            Logger.getLogger(MovieJSONEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return InterestedMovies;
    }
    
    /**
     * Get Number of Total Movies
     * 
     * @return Total Number of Movies
     */
    public int getNumAllMovies() {
        return AllMovies.size();
    }
    
    /**
     * Get Number of Interested Movies
     * 
     * @return Number of Interested Movies
     */
    public int getNumInterestedMovies() {
        return InterestedMovies.size();
    }
    
    /**
     * Get Number of Watched Movies by reading through AllMovies list
     * 
     * @return Number of Watched Movies
     */
    public int getNumWatchedMovies() {
        try {
            readFile();
        } catch (Exception ex) {
            Logger.getLogger(MovieJSONEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int counter = 0;
        
        for(Movie m : AllMovies) {
            
            if(m.getViewed())
                counter++;
        }
        
        return counter;
    }
    
}