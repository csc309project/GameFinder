package cscproject.gamefinder.game;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.util.Iterator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parse {

    public static void main(String[] args) throws Exception {
        JSONParser parser = new JSONParser();

        try {
            String fname = new File(".").getCanonicalPath();
            File file = new File(fname, "/src/main/resources/json/games.json");
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray arr = (JSONArray) jsonObject.get("gamesList");
            Iterator iterator = arr.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            //String description = (String) jsonObject.get("description");
            //String steamURL = (String) jsonObject.get("steamURl");
            //String reviews = (String) jsonObject.get("reviews");
            //String price = (String) jsonObject.get("price");

        }
        catch (FileNotFoundException err) {err.printStackTrace();}
        catch (IOException err) {err.printStackTrace();}
        catch (ParseException err) {err.printStackTrace();}
        catch (Exception err) {err.printStackTrace();}
        
    }

}
