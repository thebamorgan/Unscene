package home;
import java.io.File;

// @author Zander

public class TV_Show {
    private String Title;           // Show Title
    private String RDate;           // Release Date
    private String Genre;           // Genre of Show
    private String Description;     // Description of TV show series
    private File Art;               // Thumbnail or artwork for the TV show episode || Can also be link to external media
    private String Cast;            // A cast member in the movie || Definitely figure out how to make Cast into an array to store multiple cast members
    private String Rating;          // Content maturity rating of the movie || Look into how movie metadata stores rating. May need to change type
    private int NumEpT;             // Number of episodes in the series total
    private int NumEpW;             // Number of episodes in this series the user has watched
    private boolean Interested;     // Is the user interested in this TV show series? 0 = No, 1 = Yes
    private boolean Watched;        // Has the user watched this entire series? 0 = No, 1 = Yes
    
    
    /**
    * Default Constructor
    */
    public TV_Show(){
        Title = null;
        RDate = null;
        Genre = null;
        Description = null;
        Art = null;
        Cast = null;
        Rating = null;
        NumEpT = 0;
        NumEpW = 0;
        Interested = false;
        Watched = false;
    }

    /**
    * Overloaded Constructor
    * 
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
    public TV_Show(String Title, String RDate, String Genre, String Description, File Art, String Cast, String Rating, int NumEpT, int NumEpW, boolean Interested, boolean Watched){
        this.Title = Title;
        this.RDate = RDate;
        this.Genre = Genre;
        this.Description = Description;
        this.Art = Art;
        this.Cast = Cast;
        this.Rating = Rating;
        this.NumEpT = NumEpT;
        this.NumEpW = NumEpW;
        this.Interested = Interested;
        this.Watched = Watched;
    }
    
    void UpdateEpisodes(int episodes){ // EXAMPLE: if{user enters "69" in 'current episode' entry box in GUI}; then{UpdateEpisodes(69)};
        // Update Episodes Watched
        NumEpW = episodes;
    }

    void UpdateWatched(boolean inWatched){ // EXAMPLE: if{user clicks "Watched"}; then{UpdateWatched(true)};
        // Update Watched Status
        Watched = inWatched;
    }

    void UpdateInterest(boolean inInterested){ // EXAMPLE: if{user clicks "Interest"}; then{UpdateInterest(true)};
        // Update wether the user is interested in this TV Show series
        Interested = inInterested;
    }
}
