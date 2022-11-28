package home;

import java.io.File;
import java.util.ArrayList;


abstract class Media {
    private final String Title;             // Title
    private final ArrayList<String> Genre;  // Genre of movie || Think about making it possible to have multiple genres
    private final String Description;       // Description of movie
    private final String Tagline;         // A cast member in the movie || Definitely figure out how to make Cast into an array to store multiple cast members
    private final String Art;               // Thumbnail or artwork for the TV show episode || Can also be link to external media
    private final int ID;
    private boolean Interested;     // Is the user interested in this movie? 0 = No, 1 = Yes
    protected boolean Viewed;         // Has the user seen this movie? 0 = No, 1 = Yes

    
    
    /**
     * Default Constructor
     */
    public Media(){
        this.Title = null;
        this.Genre = new ArrayList();
        this.Description = null;
        this.Tagline = null;
        this.Art = null;
        this.ID = 0;
        this.Interested = false;
        this.Viewed = false;
    }

    /**
     * 
     * @param Title
     * @param Genre
     * @param Description
     * @param Tagline
     * @param Art
     * @param Interested
     * @param Viewed
     * @param ID 
     */
    public Media(String Title, ArrayList<String> Genre, String Description, String Tagline, String Art, boolean Interested, boolean Viewed, int ID){
        
        this.Title = Title;
        
        this.Genre = new ArrayList();
        for(String g : Genre) {
            this.Genre.add(g);
        }
        
        this.Description = Description;
        this.Tagline = Tagline;
        this.Art = Art;
        this.ID = ID;
        this.Interested = Interested;
        this.Viewed = Viewed;
    }
    
    /**
     * Get Title
     * @return 
     */
    public String getTitle(){
        return Title;
    }
    
    /**
     * Get Genre
     * @return 
     */
    public String getGenre(){
        
        String GenreList = "";
        
        for(String g : Genre) {
            GenreList += g + ", ";
        }
        
        GenreList = GenreList.substring(0, GenreList.length()-2);
        return GenreList;
    }
    
    public ArrayList<String> getGenreArray() {
        return Genre;
    }
    
    /**
     * Get Description
     * @return 
     */
    public String getDescription(){
        return Description;
    }
    
    /**
     * Get Tagline
     * @return 
     */
    public String getTagline(){
        return Tagline;
    }
    
    /**
     * Get Thumbnail
     * @return 
     */
    public String getArt(){
        return Art;
    }
    
    /**
     * Get Object's Unique ID
     * @return 
     */
    public int getID(){
        return ID;
    }
    
    /**
     * Get Interest Status
     * @return 
     */
    public boolean getInterested(){
        return Interested;
    }

    /**
     * Get Interest Status
     * @param Interested 
     */
    public void setInterested(boolean Interested){
        this.Interested = Interested;
    }
    
    /**
     * Get Viewed Status
     * @return 
     */
    public boolean getViewed(){
        return Viewed;
    }
    
    /**
     * Set Viewed Status
     * @param Viewed 
     */
    public abstract void setViewed(boolean Viewed);
    
}
