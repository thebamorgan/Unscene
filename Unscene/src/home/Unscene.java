/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package home;
import java.io.File;


public class Unscene {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File poster = new File("godfather_art.jpeg");
        TV_Show mando = new TV_Show("2019", "Pedro Pascal", "TV-14", 16, 0, "The Mandalorian", "Sci-Fi", "A space cowboy rescuses a baby alien.", poster, false, true);
        
        System.out.println(mando.getTitle());
        System.out.println(mando.getAllEpisodes());
        
        mando.addEpisode("The Jedi", 50, false);
        Episode catching = mando.getEpisode(0);
        
        System.out.println(catching.getEpTitle());
        System.out.println(catching.getEpWatched());
        
        mando.getEpisode(0).setEpWatched(true);
        
        System.out.println(mando.getEpisode(0).getEpWatched());
        System.out.println(mando.getNumEpW());
        
        new HomePage().setVisible(true);
        
    }
    
}
