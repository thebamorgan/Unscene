package home;

import java.util.ArrayList;

public class Movie extends Media {
    private final String RDate;           // Release Date of movie
    private final int RunT;               // Runtime of movie in minutes 
    
    /**
     * Default Constructor
     */
    public Movie(){
        // Call superclass Media
        super();
        
        // Initialize instance variables
        this.RDate = null;
        this.RunT = 0;
    }
    
    /**
     * Overloaded Constructor
     * 
     * @param RDate of movie
     * @param RunT of movie
     * @param Title of movie
     * @param Genre of movie
     * @param Description of movie
     * @param Tagline for movie
     * @param Art for movie
     * @param Interested status
     * @param Viewed status
     * @param ID unique to movie
     */
    public Movie(String RDate, int RunT, String Title, ArrayList<String> Genre, String Description, String Tagline, String Art, boolean Interested, boolean Viewed, int ID){
        // Call superclass Media
        super(Title, Genre, Description, Tagline, Art, Interested, Viewed, ID);
        
        // Initialize instance variables
        this.RDate = RDate;
        this.RunT = RunT;
    }
    
    
    /**
     * Get Release Date
     * @return RDate
     */
    public String getRDate(){
        return RDate;
    }
    
    /**
     * Get Release Date as Formatted String
     * YYYY-MM-DD -> MM/DD/YYYY
     * @return Formatted Release Date
     */
    public String getRDateString(){
        String year = RDate.substring(0, 4);
        String month = RDate.substring(5, 7);
        String day = RDate.substring(8);
        return month + "/" + day + "/" + year;
    }
    
    /**
     * Get Run Time
     * @return RunT
     */
    public int getRunT(){
        return RunT;
    }
    
    /**
     * Get Run Time as Formatted String
     * @return Formatted Run Time
     */
    public String getRunTString(){
        int hr = RunT / 60;
        int min = RunT % 60;
        return Integer.toString(hr) + "h " + Integer.toString(min) + "m";
    }
    
    /**
     * Get Viewed Status
     * @return Viewed
     */
    public boolean getViewed(){
        return this.Viewed;
    }
    
    /**
     * Set Viewed Status
     * @param Viewed status
     */
    public void setViewed(boolean Viewed){
        this.Viewed = Viewed;
    }
    
}
