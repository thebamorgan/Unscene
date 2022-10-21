package home;

// @author Zander

public class Movie {
    String Title; //Title - Title
    String RDate; // RDate - Release Date
    int RunT; // RunT - Runtime in seconds
    String Genre; // Genre - Genre of movie || Think about making it possible to have multiple genres
    String Desc; // Desc - Description of movie
    String Cast; // Cast - A cast member in the movie || Definitely figure out how to make Cast into an array to store multiple cast members
    String Rating; // Rating - Content maturity rating of the movie || Look into how movie metadata stores rating. May need to change type
    boolean Watched; // Watched - Has the user seen this movie? 0 = No, 1 = Yes
    boolean Interest; // Interest - Is the user interested in this movie? 0 = No, 1 = Yes
    /* Methods ****************************************************************************************
    * Update Watched Status
    * Update Interest Status
    */
        void UpdateWatched(boolean InWatched){ // EXAMPLE: If{user clicks "Watched"}; Then{UpdateWatched(true)};
            // Update Watched Status
            Watched = InWatched;
        }

        void UpdateInterested(boolean InInterested){ // EXAMPLE: If{user clicks "Interested"}; Then{UpdateInterested(true)}:
            // Update Interest Status
            Interest = InInterested;
        }
}
