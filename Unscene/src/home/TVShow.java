package home;

import java.util.ArrayList;

public class TVShow extends Media {
    private final String OriginalRDate;     // Release Date of show
    private final int NumSeasons;           // Number of seasons in show
    private int SeasonsWatched;             // Number of seasons watched
    private ArrayList<Season> Seasons;      // List of seasons in show
    
    
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
     * @return OriginalRDate
     */
    public String getOriginalRDate(){
        return OriginalRDate;
    }
    
    /**
     * Get Original Release Date as Formatted String
     * @return Formatted Original Release Date
     */
    public String getOriginalRDateString(){
        String year = OriginalRDate.substring(0, 4);
        String month = OriginalRDate.substring(5, 7);
        String day = OriginalRDate.substring(8);
        return month + "/" + day + "/" + year;
    }
    
    /**
     * Get Number of Seasons Total
     * @return Total Number of Seasons
     */
    public int getNumSeasons(){
        return NumSeasons;
    }
    
    /**
     * Get Number of Seasons Watched Status
     * Then check for update in seasons watched status
     * @return Number of Seasons Watched
     */
    public int getSeasonsWatched(){
        updateSeasonsWatched();
        return SeasonsWatched;
    }
    
    /**
     * Update Number of Seasons Watched
     */
    public void updateSeasonsWatched(){
        int counter = 0;
        for(Season s : Seasons){
            if(s.getSeasonWatched())
                counter++;
        }
        SeasonsWatched = counter;
    }
    
    /**
     * Get ArrayList of Season Objects
     * Then check for update in seasons watched status
     * @return Seasons ArrayList
     */
    public ArrayList<Season> getSeasons(){
        updateSeasonsWatched();
        return Seasons;
    }
    
    /**
     * Set ArrayList of Season Objects for Updates
     * Then check for update in seasons watched status
     * @param Seasons
     */
    public void setSeasons(ArrayList<Season> Seasons){
        this.Seasons = Seasons;
        updateSeasonsWatched();
    }
    
    /**
     * Get Viewed Status
     * @return Viewed status
     */
    public boolean getViewed(){
        updateSeasonsWatched();
        
        if(SeasonsWatched == NumSeasons)
            this.Viewed = true;
        else
            this.Viewed = false;
        
        return this.Viewed;
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
