package home;
import java.io.File;

// @author Zander

public class Webcomic extends Media {
    private final String Artist;        // Think about making it possible to store multiple artists. Temporary solution: "John Doe & Jane Doe"
    private final int NumPagT;          // The total number of pages in a webcomic
    private int NumPagR;                // The number of pages the user has read in this webcomic
    
    
    /**
     * Default Constructor
     */
    public Webcomic(){
        // Call superclass Media
        super();
        
        // Initialize instance variables
        this.Artist = null;
        this.NumPagT = 0;
        this.NumPagR = 0;
    }
    
    /**
     * Overloaded Constructor
     * 
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
    public Webcomic(String Artist, int NumPagT, int NumPagR, String Title, String Genre, String Description, File Art, boolean Viewed, boolean Interested){
        // Call superclass Media
        super(Title, Genre, Description, Art, Viewed, Interested);

        // Initialize instance variables
        this.Artist = Artist;
        this.NumPagT = NumPagT;
        this.NumPagR = NumPagR;
    }
    
    /**
     * Get Artist
     * @return 
     */
    public String getArtist(){
        return Artist;
    }
    
    /**
     * Get Number of Pages Total
     * @return 
     */
    public int getNumPagT(){
        return NumPagT;
    }
    
    /**
     * Get Number of Pages Read
     * @return 
     */
    public int getNumPagR(){
        return NumPagR;
    }
    
    /**
     * Set Number of Pages Read
     * @param NumPagR 
     */
    public void setNumPagR(int NumPagR){
        this.NumPagR = NumPagR;
    }
}
