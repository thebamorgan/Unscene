package home;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class TVJSONEditor {
    private String DataFile;                        // Datafile to read
    private ArrayList<TVShow> InterestedShows;      // ArrayList of ineterested shows
    private ArrayList<TVShow> AllShows;             // ArrayList of all shows
    
    
    /**
     * Default Constructor
     */
    public TVJSONEditor() {
        this.DataFile = null;
        this.InterestedShows = new ArrayList();
        this.AllShows = new ArrayList();
    }
    
    /**
     * Overloaded Constructor
     * 
     * @param filename to read from
     * @throws Exception
     */
    public TVJSONEditor(String filename) throws Exception {
        this.DataFile = filename;
        this.InterestedShows = new ArrayList();
        this.AllShows = new ArrayList();
        
        // Automatically read file
        readFile();
    }
    
    
    /**
     * Read JSON file, load data into InterestedShows list and AllShows list
     * 
     * @throws Exception 
     */
    private void readFile() throws Exception {
        
        // Reset Arrays
        InterestedShows.clear();
        AllShows.clear();
        
        // Fetch tv array from JSON file
        Object obj = new JSONParser().parse(new FileReader(DataFile));
        JSONObject jo = (JSONObject) obj;
        JSONArray showslist = (JSONArray) jo.get("tv");
        
        // Read each show in array
        for(Object s : showslist) {
            
            // Convert show to JSONObject
            JSONObject show = (JSONObject) s;
            
            // Add show to AllShows list
            TVShow addShow = readShow(show);
            addShow.updateInterested();
            AllShows.add(addShow);
            
            // If interested, add to InterestedShows list
            if(addShow.getInterested())
                InterestedShows.add(addShow);
        }
    }
    
    /**
     * Read Show Object from JSONArray of TV Shows
     * 
     * @param show JSON object to read
     * @return TVShow object
     */
    private TVShow readShow(JSONObject show){
        
        // Read all relevant show information
        String OriginalRDate = (String) show.get("first_air_date");
        String Tagline = (String) show.get("tagline");
        int NumSeasons = (int) ((long)show.get("number_of_seasons"));
        String Title = (String) show.get("name");
        String Description = (String) show.get("overview");
        String Art = (String) show.get("poster_path");
        boolean Viewed = (boolean) show.get("viewed");
        boolean Interested = (boolean) show.get("interested");
        int ID = (int) ((long) show.get("id"));
        
        // Read genre array
        ArrayList<String> Genre = new ArrayList();
        JSONArray genreslist = (JSONArray) show.get("genres");
        for(Object g : genreslist) {
            JSONObject genreobj = (JSONObject) g;
            Genre.add((String) genreobj.get("name"));
        }
        
        // Read seasons
        JSONArray seasonslist = (JSONArray) show.get("seasons");
        ArrayList<Season> Seasons = readSeason(seasonslist);
        int SeasonsWatched = countSeasonsWatched(Seasons);

        // Create show object
        TVShow addShow = new TVShow(OriginalRDate, Tagline, Seasons, NumSeasons, SeasonsWatched, Title, Genre, Description, Art, Interested, Viewed, ID);
        
        return addShow;
    }
    
    /**
     * Read Season for JSONArray of Seasons
     * 
     * @param seasonslist JSON object to read
     * @return Seasons ArrayList
     */
    private ArrayList<Season> readSeason(JSONArray seasonslist){
        
        ArrayList<Season> Seasons = new ArrayList();
        
        // Read each season object
        for(Object s : seasonslist) {
            
            JSONObject seasonobj = (JSONObject) s;
            
            // Read season data
            String SeasonTitle = (String) seasonobj.get("name");
            
            // DO NOT ADD "SPECIALS" SEASON
            if(!SeasonTitle.contains("Specials")) {
                String SeasonDesc = (String) seasonobj.get("overview");
                String RDate = (String) seasonobj.get("air_date");
                int EpTotal = (int) ((long)seasonobj.get("episode_count"));
                int EpWatched = (int) ((long)seasonobj.get("eps_watched"));
                int SeasonID = (int) ((long)seasonobj.get("id"));

                Season addSeason = new Season(SeasonTitle, SeasonDesc, RDate, EpTotal, EpWatched, SeasonID);
                Seasons.add(addSeason);
            }
        }
        
        return Seasons;
    }
    
    /**
     * Count Number of Seasons Watched
     * 
     * @param seasons
     * @return Number of seasons watched
     */
    private int countSeasonsWatched(ArrayList<Season> seasons){
        
        int counter = 0;
        
        // Iterate through all seasons
        for(Season s: seasons) {
            if(s.getSeasonWatched())
                counter++;
        }
        
        return counter;
    }
    
    /**
     * Update JSON File with edited TV show object parameter
     * 
     * @param updateShow object to insert in data file
     * @throws Exception 
     */
    public void updateShow(TVShow updateShow) throws Exception {
        
        // Fetch tv array from JSON file
        Object obj = new JSONParser().parse(new FileReader(DataFile));
        JSONObject jo = (JSONObject) obj;
        JSONArray showslist = (JSONArray) jo.get("tv");
        
        // Read each movie in array
        for(Object s : showslist) {
            
            // Convert show to JSONObject
            JSONObject show = (JSONObject) s;
            int ID = (int) ((long)show.get("id"));
            
            // If matching ID, update fields
            if(ID == updateShow.getID()) {
                
                show.put("interested", updateShow.getInterested());
                show.put("viewed", updateShow.getViewed());
                
                // Get updated seasons and current JSONArray of seasons
                ArrayList<Season> updateSeasons = new ArrayList(updateShow.getSeasons());
                JSONArray seasonslist = (JSONArray) show.get("seasons");
                int updateCount = 0;
                
                // Read each season object
                // Deal with offset in counters due to "Specials" seasons
                for(int originalCount = 0; originalCount < seasonslist.size(); originalCount++) {
                    JSONObject seasonobj = (JSONObject) seasonslist.get(originalCount);
                    if( !((String) (seasonobj.get("name"))).contains("Special")) {
                        seasonobj.put("eps_watched", updateSeasons.get(updateCount).getEpWatched());
                        updateCount++;
                    }
                }
            }
        }
        
        // Write to data file
        PrintWriter pw = new PrintWriter(DataFile);
        pw.write(jo.toJSONString());
        
        pw.flush();
        pw.close();
    }
    
    /**
     * Get AllShows List
     * 
     * @return All Shows ArrayList
     */
    public ArrayList<TVShow> getAllShows() {
        return AllShows;
    }
    
    /**
     * Get InterestedShows List
     * 
     * @return Interested Shows ArrayList
     */
    public ArrayList<TVShow> getInterestedShows() {
        return InterestedShows;
    }
    
    
    /**
     * Get Number of Total Shows
     * 
     * @return Total Number of Shows
     */
    public int getNumAllShows() {
        return AllShows.size();
    }
    
    /**
     * Get Number of Interested Shows
     * 
     * @return Number of Interested Shows
     */
    public int getNumInterestedShows() {
        return InterestedShows.size();
    }
    
    /**
     * Get Number of Watched Shows
     * 
     * @return Number of Watched Shows
     */
    public int getNumWatchedShows() {
        try {
            readFile();
        } catch (Exception ex) {
            Logger.getLogger(MovieJSONEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int counter = 0;
        
        for(TVShow m : AllShows) {
            if(m.getViewed())
                counter++;
        }
        
        return counter;
    }
}