package home;
import java.io.File;

// @author Zander

public class Movie {
    private String Title;           // Title
    private String RDate;           // Release Date
    private int RunT;               // Runtime in seconds
    private String Genre;           // Genre of movie || Think about making it possible to have multiple genres
    private String Description;     // Description of movie
    private File Art;               // Thumbnail or artwork for the TV show episode || Can also be link to external media
    private String Cast;            // A cast member in the movie || Definitely figure out how to make Cast into an array to store multiple cast members
    private String Rating;          // Content maturity rating of the movie || Look into how movie metadata stores rating. May need to change type
    private boolean Watched;        // Has the user seen this movie? 0 = No, 1 = Yes
    private boolean Interested;     // Is the user interested in this movie? 0 = No, 1 = Yes
    
    
    /**
     * Default Constructor
     */
    public Movie(){
        Title = null;
        RDate = null;
        RunT = 0;
        Genre = null;
        Description = null;
        Art = null;
        Cast = null;
        Rating = null;
        Interested = false;
        Watched = false;
    }

    /**
     * Overloaded Constructor
     * 
     * @param Title
     * @param RDate
     * @param RunT
     * @param Genre
     * @param Description
     * @param Art
     * @param Cast
     * @param Rating
     * @param Interested
     * @param Watched 
     */
    public Movie(String Title, String RDate, int RunT, String Genre, String Description, File Art, String Cast, String Rating, boolean Interested, boolean Watched){
        this.Title = Title;
        this.RDate = RDate;
        this.RunT = RunT;
        this.Genre = Genre;
        this.Description = Description;
        this.Art = Art;
        this.Cast = Cast;
        this.Rating = Rating;
        this.Interested = Interested;
        this.Watched = Watched;
    }

    void UpdateWatched(boolean InWatched){ // EXAMPLE: If{user clicks "Watched"}; Then{UpdateWatched(true)};
        // Update Watched Status
        Watched = InWatched;
    }

    void UpdateInterested(boolean InInterested){ // EXAMPLE: If{user clicks "Interested"}; Then{UpdateInterested(true)}:
        // Update Interest Status
        Interested = InInterested;
    }
}
