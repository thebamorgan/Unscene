/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package home;
import java.io.File;
import java.util.ArrayList;


public class Unscene {

    
    public static void printMovies(ArrayList<Movie> Movies){
        
        System.out.println("MOVIES");
        System.out.println("------------------------------------------");
        
        for(Movie m : Movies){
            System.out.println("Title: " + m.getTitle());
            System.out.println("Release Date: " + m.getRDate());
            System.out.println("Watched: " + m.getViewed());
            System.out.println("Interested: " + m.getInterested());
            System.out.println();
        }
    }
    
    public static void printShows(ArrayList<TV_Show> Shows){
        System.out.println("TV SHOWS");
        System.out.println("------------------------------------------");
        
        for(TV_Show s : Shows){
            System.out.println("Title: " + s.getTitle());
            System.out.println("Release Date: " + s.getRDate());
            System.out.println("Episodes Watched: " + s.getNumEpW());
            System.out.println("Watched: " + s.getViewed());
            System.out.println("Interested: " + s.getInterested());
            System.out.println();
        }
    }
    
    public static void printComics(ArrayList<Webcomic> Comics){
        System.out.println("WEBCOMICS");
        System.out.println("------------------------------------------");
        
        for(Webcomic c : Comics){
            System.out.println("Title: " + c.getTitle());
            System.out.println("Artist: " + c.getArtist());
            System.out.println("Pages Read: " + c.getNumPagR());
            System.out.println("Watched: " + c.getViewed());
            System.out.println("Interested: " + c.getInterested());
            System.out.println();
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Initialize Movie Objects
        File poster = new File("godfather_art.jpeg");
        Movie movie1 = new Movie("1980", 7204, "Mark Hamill, Harrison Ford, Carrie Fisher", "PG", "Star Wars - The Empire Strikes Back", "Sci-fi/Action", "The adventure continues in this \"Star Wars\" sequel. Luke Skywalker (Mark Hamill), Han Solo (Harrison Ford), Princess Leia (Carrie Fisher) and Chewbacca (Peter Mayhew) face attack by the Imperial forces and its AT-AT walkers on the ice planet Hoth. While Han and Leia escape in the Millennium Falcon, Luke travels to Dagobah in search of Yoda. Only with the Jedi master's help will Luke survive when the dark side of the Force beckons him into the ultimate duel with Darth Vader (David Prowse).", poster, false, true);
        Movie movie2 = new Movie("2001", 7258, "Elijah Wood, Viggo Mortensen, Cate Blanchett, Ian McKellen", "PG-13", "The Lord of the Rings - The Fellowship of the Ring", "Fantasy/Adventure", "The future of civilization rests in the fate of the One Ring, which has been lost for centuries. Powerful forces are unrelenting in their search for it. But fate has placed it in the hands of a young Hobbit named Frodo Baggins (Elijah Wood), who inherits the Ring and steps into legend. A daunting task lies ahead for Frodo when he becomes the Ringbearer - to destroy the One Ring in the fires of Mount Doom where it was forged.", poster, false, true);
        Movie movie3 = new Movie("1972", 7255, "Al Pacino, Marlon Brando, James Caan, Diane Keaton", "R", "The Godfather", "Crime/Drama", "Widely regarded as one of the greatest films of all time, this mob drama, based on Mario Puzo's novel of the same name, focuses on the powerful Italian-American crime family of Don Vito Corleone (Marlon Brando). When the don's youngest son, Michael (Al Pacino), reluctantly joins the Mafia, he becomes involved in the inevitable cycle of violence and betrayal. Although Michael tries to maintain a normal relationship with his wife, Kay (Diane Keaton), he is drawn deeper into the family business.", poster, false, true);
        
        // Make List of Movies
        ArrayList<Movie> Movies = new ArrayList();
        Movies.add(movie1);
        Movies.add(movie2);
        Movies.add(movie3);
        
        // Initialize TV Show Object
        TV_Show show1 = new TV_Show("2019", "Pedro Pascal, Carl Weathers, Giancarlo Esposito", "TV-14", 8, 0, "The Mandalorian - Season 1", "Space Western", "After the fall of the Galactic Empire, a lone gunfighter makes his way through the outer reaches of the lawless galaxy.", poster, false, true);
        show1.addEpisode("The Child", 1800, false);
        show1.addEpisode("The Sin", 2700, false);
        
        // Make List of Shows
        ArrayList<TV_Show> Shows = new ArrayList();
        Shows.add(show1);
        
        // Initialize Webcomic Object
        Webcomic comic1 = new Webcomic("Chris McCoy", 824, 0, "Safely Endangered", "Comedy", "Silly comics for silly people.", poster, false, true);
        comic1.addPage("Armageddon't'", false);
        comic1.addPage("Avada Catdavra", false);
        
        // Make List of Webcomics
        ArrayList<Webcomic> Comics = new ArrayList();
        Comics.add(comic1);
        
        
        /* DISPLAY DATA */
        printMovies(Movies);            // Movies
        printShows(Shows);              // TV Shows
        printComics(Comics);            // Webcomics
        
        /* DEMO DATA MANIPULATION */
        movie1.setViewed(true);
        show1.getEpisode(0).setEpWatched(true);
        comic1.getPage(0).setPageRead(true);
        
        printMovies(Movies);            // Movies
        printShows(Shows);              // TV Shows
        printComics(Comics);            // Webcomics
        
        
        // Display temporary home page
        //new HomePage().setVisible(true);
        //new testHome().setVisible(true);
        //testHome homePage = new testHome();
        //homePage.setVisible(true);
        //new testList(Movies).setVisible(true);
        
        new testHome(Movies).setVisible(true);
        
    }
    
}
