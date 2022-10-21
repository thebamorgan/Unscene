package home;
import java.io.File;

// @author Zander

public class TV_Show {
    String Title;
    String RDate;
    int RunT; // RunT - Runtime
    String Genre; // Figure out how to store multiple genres
    String Desc; // Desc - Description of TV show series
    File Art; // Art - Thumbnail or artwork for the TV show episode || Can also be link to external media
    String Cast; // Cast - A cast member in the movie || Definitely figure out how to make Cast into an array to store multiple cast members
    String Rating; // Rating - Content maturity rating of the movie || Look into how movie metadata stores rating. May need to change type
    int NumEpT; // NumEpT - Number of episodes in the series total
    int NumEpW; // NumEpW - Number of episodes in this series the user has watched
    boolean Interest; // Interest - Is the user interested in this TV show series? 0 = No, 1 = Yes
    boolean Watched; // Watched - Has the user watched this entire series? 0 = No, 1 = Yes
    /* Methods ******************************************************
    * Update Episodes Watched
    * Update Watched Status
    * Update Interest Status
    */
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
            Interest = inInterested;
        }
}
