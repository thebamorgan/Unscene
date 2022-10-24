package home;
import java.io.File;

// @author Zander

public class Media {
    private final String Title;           // Title
    private final String Genre;           // Genre of movie || Think about making it possible to have multiple genres
    private final String Description;     // Description of movie
    private final File Art;               // Thumbnail or artwork for the TV show episode || Can also be link to external media
    private boolean Viewed;         // Has the user seen this movie? 0 = No, 1 = Yes
    private boolean Interested;     // Is the user interested in this movie? 0 = No, 1 = Yes
    
    
    /**
     * Default Constructor
     */
    public Media(){
        Title = null;
        Genre = null;
        Description = null;
        Art = null;
        Viewed = false;
        Interested = false;
    }

    /**
     * Overloaded Constructor
     * 
     * @param Title
     * @param Genre
     * @param Description
     * @param Art
     * @param Viewed
     * @param Interested 
     */
    public Media(String Title, String Genre, String Description, File Art, boolean Viewed, boolean Interested){
        this.Title = Title;
        this.Genre = Genre;
        this.Description = Description;
        this.Art = Art;
        this.Viewed = Viewed;
        this.Interested = Interested;
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
     * Get Thumbnail
     * @return 
     */
    public File getArt(){
        return Art;
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
    public void setViewed(boolean Viewed){
        this.Viewed = Viewed;
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
}
