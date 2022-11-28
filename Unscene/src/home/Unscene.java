/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package home;
import java.io.File;
import java.util.ArrayList;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.util.Iterator;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.*;
import javax.swing.*;


public class Unscene {

    public static void writeJSON() throws Exception {
        JSONObject jo = new JSONObject();
        
        jo.put("title", "The Godfather");
        jo.put("release", "1972");
        
        Map m = new LinkedHashMap(2);
        m.put("actor1", "Al Pacino");
        m.put("actor2", "Robert DeNiro");
        
        jo.put("",m);
        
        PrintWriter pw = new PrintWriter("src/data/movietest.json");
        pw.write(jo.toJSONString());
        
        pw.flush();
        pw.close();
    }
    
    public static void readJSON() throws Exception {
        
        // Fetch movie array from JSON file
        Object obj = new JSONParser().parse(new FileReader("src/data/movietest.json"));
        JSONObject jo = (JSONObject) obj;
        JSONArray movieslist = (JSONArray) jo.get("movies");
        
        // Read each movie in array
        for(Object m : movieslist) {
            
            // Convert movie to JSONObject
            JSONObject movie = (JSONObject) m;
            int ID = (int) ((long)movie.get("id"));
            System.out.println(ID);
            
            if(ID == 238)
                movie.put("id", 111);
        }
        
        PrintWriter pw = new PrintWriter("src/data/movietest.json");
        pw.write(jo.toJSONString());
        
        pw.flush();
        pw.close();
        
        
        /*
        Object obj = new JSONParser().parse(new FileReader("src/data/movietest.json"));
        JSONObject jo = (JSONObject) obj;
        JSONObject mo = (JSONObject) jo;
        JSONArray movies = (JSONArray) jo.get("movies");
        
        for(Object i : movies) {
            JSONObject m = (JSONObject) i;
            String title = (String) m.get("title");
            System.out.println(title);
            int runtime = (int) ((long)m.get("runtime"));
            System.out.println(runtime);
            boolean interest = (boolean) m.get("interested");
            System.out.println(interest);
            int ID = (int) ((long)m.get("id"));
            
            
            System.out.println(ID == 238);
            if(ID == 238)
                m.put("id",111);
            
        }
        */
        //String data1 = "\"actor1\", \"Al Pacino\"";
        //String data2 = "\"actor2\", \"Robert DeNiro\"";
        
        //movies.add("element1");
        //movies.add("element2");
        
        //PrintWriter pw = new PrintWriter("src/data/movietest.json");
        //pw.write(mo.toJSONString());
        
        //pw.flush();
        //pw.close();
        
    }
       
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
                
        FlatDarkLaf.setup();
        
        //readJSON();
        
        MovieJSONEditor movieReader = new MovieJSONEditor("src/data/movietest.json");
        //ArrayList<Movie> Movies = movieReader.getAllMovies();
        
        TVJSONEditor showReader = new TVJSONEditor("src/data/tvtest.json");
        //ArrayList<TVShow> Shows = showReader.getAllShows();
        
        ArrayList<String> Genre = new ArrayList();
        Genre.add("Crime");
        Genre.add("Drama");
        
        //Movie testMovie = new Movie("2022-02-02", 2, "TestMovie", Genre, "Something", "Something", " ", true, false, 238);
        //movieReader.updateMovie(testMovie);
        
        
        
        
        
        
        // Display temporary home page
        //new testHome(Movies, Shows).setVisible(true);
        new UnsceneGUI(movieReader, showReader).setVisible(true);
        //new UnsceneGUI(Movies, Shows).setVisible(true);
    }
    
}
