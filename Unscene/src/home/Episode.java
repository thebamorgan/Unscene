package home;
import java.io.File;

 // @author ultra

// Episode is a subclass of TV_Show
public class Episode extends TV_Show {
    String Title;
    String RDate; // RDate - Release Date
    String Description; // Optional Description
    File Thumbnail; // Thumbnail of recent page
    String Characters; // Characters who appear in this page - optional
    String ContentRating;
    int PageNum; // The number of the page so it can be stored and referenced easily
    boolean Viewed; //Has the user viewed this episode? 0 = No, 1 = Yes
}
