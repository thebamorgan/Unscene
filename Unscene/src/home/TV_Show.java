package home;
import java.io.File;
import java.util.ArrayList;

// @author Zander

public class TV_Show extends Media {
    private final String RDate;           // Release Date
    private final String Cast;            // A cast member in the movie || Definitely figure out how to make Cast into an array to store multiple cast members
    private final String Rating;          // Content maturity rating of the movie || Look into how movie metadata stores rating. May need to change type
    private final int NumEpT;             // Number of episodes in the series total
    private int NumEpW;                   // Number of episodes in this series the user has watched
    private final ArrayList<Episode> Episodes;  // List of episodes in show
    
    
    /**
    * Default Constructor
    */
    public TV_Show(){
        // Call superclass Media
        super();
        
        // Initialize instance variables
        this.RDate = null;
        this.Cast = null;
        this.Rating = null;
        this.NumEpT = 0;
        this.NumEpW = 0;
        this.Episodes = new ArrayList();
    }

    /**
     * Overloaded Constructor
     * 
     * @param RDate
     * @param Cast
     * @param Rating
     * @param NumEpT
     * @param NumEpW
     * @param Title
     * @param Genre
     * @param Description
     * @param Art
     * @param Viewed
     * @param Interested 
     */
    public TV_Show(String RDate, String Cast, String Rating, int NumEpT, int NumEpW, String Title, String Genre, String Description, File Art, boolean Viewed, boolean Interested){
        // Call superclass Media
        super(Title, Genre, Description, Art, Viewed, Interested);

        // Initialize instance variables
        this.RDate = RDate;
        this.Cast = Cast;
        this.Rating = Rating;
        this.NumEpT = NumEpT;
        this.NumEpW = NumEpW;
        this.Episodes = new ArrayList();
    }
    
    /**
     * Get Release Date
     * @return 
     */
    public String getRDate(){
        return RDate;
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
    
    /**
     * Get Total Number of Episodes
     * @return 
     */
    public int getNumEpT(){
        return NumEpT;
    }
    
    /**
     * Get Number of Episodes Watched
     * @return 
     */
    public int getNumEpW(){
        updateNumEpW();
        return NumEpW;
    }
    
    /**
     * Recalculate Number of Episodes Watched
     */
    public void updateNumEpW(){
        int tempCount = 0;      // Temporary count of watched episodes
        
        for (Episode e : Episodes){
            if(e.getEpWatched())
                tempCount++;
        }
        
        NumEpW = tempCount;     // Update number of episodes watched
    }
    
    /**
     * Get Full List of All Episodes in Show
     * @return 
     */
    public ArrayList<Episode> getAllEpisodes(){
        return Episodes;
    }
    
    /**
     * Get Specific Episode by Index
     * @param idx
     * @return 
     */
    public Episode getEpisode(int idx){
        return Episodes.get(idx);
    }
    
    /**
     * Add a New Episode to Episodes List
     * @param EpTitle
     * @param RunT
     * @param EpWatched 
     */
    public void addEpisode(String EpTitle, int RunT, boolean EpWatched){
        Episodes.add(new Episode(EpTitle, RunT, EpWatched, this.RDate, this.Cast, this.Rating, this.NumEpT, this.NumEpW, super.getTitle(), super.getGenre(), super.getDescription(), super.getArt(), super.getViewed(), super.getInterested()));
    }
}
