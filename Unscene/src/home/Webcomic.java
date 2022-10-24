package home;
import java.io.File;
import java.util.ArrayList;


public class Webcomic extends Media {
    private final String Artist;        // Think about making it possible to store multiple artists. Temporary solution: "John Doe & Jane Doe"
    private final int NumPagT;          // The total number of pages in a webcomic
    private int NumPagR;                // The number of pages the user has read in this webcomic
    private final ArrayList<Page> Pages;  // List of pages in comic

    
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
        this.Pages = new ArrayList();
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
        this.Pages = new ArrayList();
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
        updateNumPagR();
        return NumPagR;
    }
    
    
    /**
     * Recalculate Number of Pages Read
     */
    public void updateNumPagR(){
        int tempCount = 0;      // Temporary count of read pages
        
        for (Page e : Pages){
            if(e.getPageRead())
                tempCount++;
        }
        
        NumPagR = tempCount;     // Update number of pages read
    }
    
    /**
     * Get Full List of All Pages in Comic
     * @return 
     */
    public ArrayList<Page> getAllPages(){
        return Pages;
    }
    
    /**
     * Get Specific Page by Index
     * @param idx
     * @return 
     */
    public Page getPage(int idx){
        return Pages.get(idx);
    }
    
    /**
     * Add a New Page to Pages List
     * @param PageTitle
     * @param PageRead
     */
    public void addPage(String PageTitle, boolean PageRead){
        Pages.add(new Page(PageTitle, PageRead, this.Artist, this.NumPagT, this.NumPagR, super.getTitle(), super.getGenre(), super.getDescription(), super.getArt(), super.getViewed(), super.getInterested()));
    }
}
