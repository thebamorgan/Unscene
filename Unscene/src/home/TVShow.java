package home;
import java.io.File;
import java.util.ArrayList;


public class TVShow extends Media {
    private final String OriginalRDate;         // Release Date
    private final int NumSeasons;
    private int SeasonsWatched;
    private ArrayList<Season> Seasons;    // List of seasons in show
    
    
    /**
    * Default Constructor
    */
    public TVShow(){
        // Call superclass Media
        super();
        
        // Initialize instance variables
        this.OriginalRDate = null;
        this.NumSeasons = 0;
        this.SeasonsWatched = 0;
        this.Seasons = new ArrayList();
    }

    /**
     * Overloaded Constructor
     * 
     * @param OriginalRDate
     * @param Tagline
     * @param Seasons
     * @param NumSeasons
     * @param SeasonsWatched
     * @param Title
     * @param Genre
     * @param Description
     * @param Art
     * @param Interested
     * @param Viewed
     * @param ID 
     */
    public TVShow(String OriginalRDate, String Tagline, ArrayList<Season> Seasons, int NumSeasons, int SeasonsWatched, String Title, ArrayList<String> Genre, String Description, String Art, boolean Interested, boolean Viewed, int ID){
        // Call superclass Media
        super(Title, Genre, Description, Tagline, Art, Interested, Viewed, ID);

        // Initialize instance variables
        this.OriginalRDate = OriginalRDate;
        this.NumSeasons = NumSeasons;
        this.SeasonsWatched = SeasonsWatched;
        this.Seasons = new ArrayList(Seasons);
    }
    
    
    /**
     * Get Original Release Date
     * @return 
     */
    public String getOriginalRDate(){
        return OriginalRDate;
    }
    
    /**
     * Get Original Release Date as Formatted String
     * @return 
     */
    public String getOriginalRDateString(){
        String year = OriginalRDate.substring(0, 4);
        String month = OriginalRDate.substring(5, 7);
        String day = OriginalRDate.substring(8);
        return month + "/" + day + "/" + year;
    }
    
    /**
     * Get Number of Seasons Total
     * @return 
     */
    public int getNumSeasons(){
        return NumSeasons;
    }
    
    /**
     * Get Number of Seasons Watched Status
     * @return 
     */
    public int getSeasonsWatched(){
        return SeasonsWatched;
    }
    
    /**
     * Update Number of Seasons Watched
     */
    public void setSeasonsWatched(){
        int counter = 0;
        for(Season s : Seasons){
            if(s.getSeasonWatched())
                counter++;
        }
        SeasonsWatched = counter;
    }
    
    /**
     * Get ArrayList of Season Objects
     * @return 
     */
    public ArrayList<Season> getSeasons(){
        return Seasons;
    }
    
    /**
     * Set ArrayList of Season Objects for Updates
     * @param Seasons 
     */
    public void setSeasons(ArrayList<Season> Seasons){
        this.Seasons = Seasons;
    }
    
    /**
     * Set Viewed Status
     * @param Viewed 
     */
    public void setViewed(boolean Viewed){
        this.Viewed = Viewed;
        
        for(Season s: Seasons){
            s.setSeasonWatched(Viewed);
        }
    }
    
}
