package home;
import java.io.File;

// @author Zander

public class Movie extends Media {
    private final String RDate;           // Release Date
    private final int RunT;               // Runtime in seconds
    private final String Cast;            // A cast member in the movie || Definitely figure out how to make Cast into an array to store multiple cast members
    private final String Rating;          // Content maturity rating of the movie || Look into how movie metadata stores rating. May need to change type
    
    
    /**
     * Default Constructor
     */
    public Movie(){
        // Call superclass Media
        super();
        
        // Initialize instance variables
        this.RDate = null;
        this.RunT = 0;
        this.Cast = null;
        this.Rating = null;
    }
    
    /**
     * Overloaded Constructor
     * 
     * @param RDate
     * @param RunT
     * @param Cast
     * @param Rating
     * @param Title
     * @param Genre
     * @param Description
     * @param Art
     * @param Viewed
     * @param Interested 
     */
    public Movie(String RDate, int RunT, String Cast, String Rating, String Title, String Genre, String Description, File Art, boolean Viewed, boolean Interested){
        // Call superclass Media
        super(Title, Genre, Description, Art, Viewed, Interested);
        
        // Initialize instance variables
        this.RDate = RDate;
        this.RunT = RunT;
        this.Cast = Cast;
        this.Rating = Rating;
    }
    
    
    /**
     * Get Release Date
     * @return 
     */
    public String getRDate(){
        return RDate;
    }
    
    /**
     * Get Run Time
     * @return 
     */
    public int getRunT(){
        return RunT;
    }
    
    /**
     * Get Cast
     * @return 
     */
    public String getCast(){
        return Cast;
    }
    
    /**
     * Get Rating
     * @return 
     */
    public String getRating(){
        return Rating;
    }
}
