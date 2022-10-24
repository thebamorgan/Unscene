package home;
import java.io.File;

// @author Zander
public class Webcomic {
    private String Title;           // Title
    private String Genre;           // Genre of webcomic || Think about making it possible to have multiple genres
    private String Artist;          // Think about making it possible to store multiple artists. Temporary solution: "John Doe & Jane Doe"
    private String Description;     // Description of webcomic
    private File Art;               // General Thumbnail or artwork for the entire webcomic
    private int NumPagT;            // The total number of pages in a webcomic
    private int NumPagR;            // The number of pages the user has read in this webcomic
    private boolean Viewed;         // Has the user seen the most recent page or upload? 0 = No, 1 = Yes
    private boolean Interested;     // Is the user interested in this webcomic? 0 = No, 1 = Yes
    
    
    /**
     * Default Constructor
     */
    public Webcomic(){
        Title = null;
        Genre = null;
        Artist = null;
        Description = null;
        Art = null;
        NumPagT = 0;
        NumPagR = 0;
        Viewed = false;
        Interested = false;
    }

    /**
     * Overloaded Constructor
     * 
     * @param Title
     * @param Genre
     * @param Artist
     * @param Description
     * @param Art
     * @param NumPagT
     * @param NumPagR
     * @param Viewed
     * @param Interested 
     */
    public Webcomic(String Title, String Genre, String Artist, String Description, File Art, int NumPagT, int NumPagR, boolean Viewed, boolean Interested){
            this.Title = Title;
            this.Genre = Genre;
            this.Artist = Artist;
            this.Description = Description;
            this.Art = Art;
            this.NumPagT = NumPagT;
            this.NumPagR = NumPagR;
            this.Viewed = Viewed;
            this.Interested = Interested;   
        }
    
    void UpdateViewed(boolean inViewed){ // EXAMPLE: if{user clicks "Viewed"}; then{UpdateViewed(true);}
        // Update Viewed Status of most recent webcomic page
        Viewed = inViewed;
    }

    void UpdateRead(int currentPage){ // EXAMPLE: if{user enters "69" in 'current page' entry box in GUI}; then{UpdateRead(69)};
        // Update the number of pages the user has read
        NumPagR = currentPage;
    }

    void UpdateInterest(boolean inInterested){ // EXAMPLE: if{user clicks "Interested"}; then{UpdateInterest(true)};
        // Update wether the user is interested in this webcomic series
        Interested = inInterested;
    }
}
