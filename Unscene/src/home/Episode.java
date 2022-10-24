package home;
import java.io.File;

// Episode is a subclass of TV_Show
public class Episode extends TV_Show {
    private String EpTitle;     // Title of Episode
    private int RunT;           // Run Time of Episode
    private boolean EpWatched;  // Episode Watch Status
    
    
    /**
     * Default Constructor
     */
    public Episode(){
        
        // Call superclass: TV_Show
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
     * @param Watched 
     */
    public Episode(String EpTitle, int RunT, boolean EpWatched, String Title, String RDate, String Genre, String Description, File Art, String Cast, String Rating, int NumEpT, int NumEpW, boolean Interested, boolean Watched){
        
        // Call superclass: TV_Show
        super(Title, RDate, Genre, Description, Art, Cast, Rating, NumEpT, NumEpW, Interested, Watched);
        
        // Initialize instance variables
        this.EpTitle = EpTitle;
        this.RunT = RunT;
        this.EpWatched = EpWatched;
    }
    
}
