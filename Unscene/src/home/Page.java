package home;
import java.io.File;


// Page is a subclass of Wecomic
public final class Page extends Webcomic {
    private final String PageTitle;       // Title of page
    private boolean PageRead;       // Read status of page
    
    
    /**
     * Default Constructor
     */
    public Page(){
        // Call superclass Webcomic
        super();
        
        // Initialize instance variables
        this.PageTitle = null;
        this.PageRead = false;
    }
    
    /**
     * Overloaded Constructor
     * 
     * @param PageTitle
     * @param PageRead
     * @param Artist
     * @param NumPagT
     * @param NumPagR
     * @param Title
     * @param Genre
     * @param Description
     * @param Art
     * @param Viewed
     * @param Interested 
     */
    public Page(String PageTitle, boolean PageRead, String Artist, int NumPagT, int NumPagR, String Title, String Genre, String Description, File Art, boolean Viewed, boolean Interested){
        // Call superclass Webcomic
        super(Artist, NumPagT, NumPagR, Title, Genre, Description, Art,  Viewed, Interested);
        
        // Initialize instance variables
        this.PageTitle = PageTitle;
        
        if(PageRead)
            this.setPageRead(PageRead);
    }
    
    /**
     * Get Page Title
     * @return 
     */
    public String getPageTitle(){
        return PageTitle;
    }
    
    /**
     * Get Page Read Status
     * @return 
     */
    public boolean getPageRead(){
        return PageRead;
    }
    
    /**
     * Set Page Read Status
     * @param PageRead 
     */
    public void setPageRead(boolean PageRead){
        
        // Currently false, setting to true
        if(!this.PageRead && PageRead){
            this.PageRead = true;
        }
        // Curently true, setting to false
        else if(this.PageRead && !PageRead){
            this.PageRead = false;
        }
        // Otherwise, no change in status
    }
    
}
