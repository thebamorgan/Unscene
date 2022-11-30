
package home;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class Unscene {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        // Read settings.json
        Object obj = new JSONParser().parse(new FileReader("src/data/settings.json"));
        JSONObject jo = (JSONObject) obj;
        
        // Read Settings
        String UserName = (String) jo.get("username");
        String Display = (String) jo.get("display");

        // Setup Display Mode
        if(Display.contains("dark"))
            FlatDarkLaf.setup();
        else if(Display.contains("light"))
            FlatLightLaf.setup();
        
        // Initialize JSON Data Readers
        MovieJSONEditor movieReader = new MovieJSONEditor("src/data/movietest.json");
        TVJSONEditor showReader = new TVJSONEditor("src/data/tvtest.json");
        
        // DISPLAY MAINFRAME
        new UnsceneGUI(movieReader, showReader, UserName).setVisible(true);
    }
    
}
