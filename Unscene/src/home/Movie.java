package home;

import java.io.File;
import java.util.ArrayList;


public class Movie extends Media {
    private final String RDate;           // Release Date
    private final int RunT;               // Runtime in seconds    
    
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
     * @param RDate
     * @param RunT
     * @param Title
     * @param Genre
     * @param Description
     * @param Tagline
     * @param Art
     * @param Interested
     * @param Viewed
     * @param ID 
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
     * @return 
     */
    public String getRDate(){
        return RDate;
    }
    
    /**
     * Get Release Date as Formatted String
     * MM/DD/YYYY
     * YYYY-MM-DD
     * @return 
     */
    public String getRDateString(){
        String year = RDate.substring(0, 4);
        String month = RDate.substring(5, 7);
        String day = RDate.substring(8);
        return month + "/" + day + "/" + year;
    }
    
    /**
     * Get Run Time
     * @return 
     */
    public int getRunT(){
        return RunT;
    }
    
    /**
     * Get Run Time as Formatted String
     * @return 
     */
    public String getRunTString(){
        int hr = RunT / 60;
        int min = RunT % 60;
        return Integer.toString(hr) + "h " + Integer.toString(min) + "m";
    }
    
    /**
     * Set Viewed Status
     * @param Viewed 
     */
    public void setViewed(boolean Viewed){
        this.Viewed = Viewed;
    }
    
}
