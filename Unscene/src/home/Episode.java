package home;
import java.io.File;


// Episode is a subclass of TV_Show
public final class Episode extends TV_Show {
    private final String EpTitle;           // Title of Episode
    private final int RunT;                 // Run Time of Episode, in seconds
    private boolean EpWatched = false;      // Episode Watch Status
    
    
    /**
     * Default Constructor
     */
    public Episode(){
        // Call superclass TV_Show
        super();
        
        // Initialize default instance variables
        EpTitle = null;
        RunT = 0;
        EpWatched = false;
    }
    
    /**
     * Overloaded Constructor
     * 
     * @param EpTitle
     * @param RunT
     * @param EpWatched
     * @param Title
     * @param RDate
     * @param Genre
     * @param Description
     * @param Art
     * @param Cast
     * @param Rating
     * @param NumEpT
     * @param NumEpW
     * @param Interested
     * @param Viewed
     */
    public Episode(String EpTitle, int RunT, boolean EpWatched, String RDate, String Cast, String Rating, int NumEpT, int NumEpW, String Title, String Genre, String Description, File Art, boolean Viewed, boolean Interested){
        
        // Call superclass: TV_Show
        super(RDate, Cast, Rating, NumEpT, NumEpW, Title, Genre, Description, Art, Viewed, Interested);
        
        // Initialize instance variables
        this.EpTitle = EpTitle;
        this.RunT = RunT;
        
        if(EpWatched)
            this.setEpWatched(EpWatched);
    }
    
    /**
     * Get Episode Title
     * @return 
     */
    public String getEpTitle(){
        return EpTitle;
    }
    
    /**
     * Get Run Time
     * @return 
     */
    public int getRunT(){
        return RunT;
    }
    
    /**
     * Get Episode Watched Status
     * @return 
     */
    public boolean getEpWatched(){
        return EpWatched;
    }
    
    /**
     * Set Episode Watched Status
     * @param EpWatched
     */
    public void setEpWatched(boolean EpWatched){
        
        // Currently false, setting to true
        if(!this.EpWatched && EpWatched){
            this.EpWatched = true;
        }
        // Curently true, setting to false
        else if(this.EpWatched && !EpWatched){
            this.EpWatched = false;
        }
        // Otherwise, no change in status
    }
}
