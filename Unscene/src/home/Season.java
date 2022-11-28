package home;
import java.io.File;
import java.util.ArrayList;


// Season is a subclass of TV_Show
public class Season{
    private final String SeasonTitle;       // Title of Season
    private final String SeasonDesc;
    private final String RDate;
    private final int EpTotal;              // Number of episodes total in the season
    private int EpWatched;                  // Number of episodes watched in the season
    private final int SeasonID;             // Season Unique ID
    private boolean SeasonWatched;
    
    /**
     * Default Constructor
     */
    public Season(){
        // Initialize default instance variables
        this.SeasonTitle = null;
        this.SeasonDesc = null;
        this.RDate = null;
        this.EpTotal = 0;
        this.EpWatched = 0;
        this.SeasonID = 0;
        this.SeasonWatched = false;
    }
    
    /**
     * Overloaded Constructor
     * 
     * @param SeasonTitle
     * @param SeasonDesc
     * @param RDate
     * @param EpTotal
     * @param EpWatched
     * @param ID 
     */
    public Season(String SeasonTitle, String SeasonDesc, String RDate, int EpTotal, int EpWatched, int ID){
        this.SeasonTitle = SeasonTitle;
        this.SeasonDesc = SeasonDesc;
        this.EpTotal = EpTotal;
        this.EpWatched = EpWatched;
        this.SeasonID = ID;
        this.SeasonWatched = false;
        
        if(RDate == null)
            this.RDate = "";
        else
            this.RDate = RDate;
        
        updateSeasonWatched();
    }
    
    /**
     * Get Season Title
     * @return 
     */
    public String getSeasonTitle(){
        return SeasonTitle;
    }
    
    /**
     * Get Season Description
     * @return 
     */
    public String getSeasonDesc(){
        return SeasonDesc;
    }
    
    /**
     * Get Season Release Date
     * @return 
     */
    public String getRDate(){
        return RDate;
    }
    
    /**
     * Get Season Release Date as Formatted String
     * @return 
     */
    public String getRDateString(){
        if(RDate == "")
            return "";
        
        String year = RDate.substring(0, 4);
        String month = RDate.substring(5, 7);
        String day = RDate.substring(8);
        return month + "/" + day + "/" + year;
    }
    
    /**
     * Get Number of Episodes in Season Total
     * @return 
     */
    public int getEpTotal(){
        return EpTotal;
    }
    
    /**
     * Get Number of Episodes in Season Watched
     * @return 
     */
    public int getEpWatched(){
        return EpWatched;
    }
    
    /**
     * Update Number of Episodes in Season Watched by Increment
     * GIVEN: epWatchedValue is a valid input, aka (0 - epWatchedValue - Total Episodes)
     * @param epWatchedValue
     */
    public void setEpWatched(int epWatchedValue){
        EpWatched = epWatchedValue;
        updateSeasonWatched();     // Update Season Watched Status
    }
    
    /**
     * Get Parent Show's Unique ID
     * @return 
     */
    public int getSeasonID(){
        return SeasonID;
    }
    
    /**
     * Get Season Watched Status
     * @return 
     */
    public boolean getSeasonWatched(){
        updateSeasonWatched();
        return SeasonWatched;
    }
    
    /**
     * Update Season Watched Status based on EpWatched Count
     */
    public void updateSeasonWatched(){
        if(EpWatched == EpTotal)
            SeasonWatched = true;
        else
            SeasonWatched = false;
    }
    
    /**
     * Explicitly Set Season Watched Status
     * @param WatchedStatus 
     */
    public void setSeasonWatched(boolean WatchedStatus){
        SeasonWatched = WatchedStatus;
        
        if(SeasonWatched)
            EpWatched = EpTotal;    // Set to all Ep Watched
        else
            EpWatched = 0;          // Reset EpWatched
    }
    
}
