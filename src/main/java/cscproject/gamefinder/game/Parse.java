package cscproject.gamefinder.game;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parse {

    public List<Game> createGameList(String[] args) throws Exception {
        JSONParser parser = new JSONParser();
        ArrayList<Game> game_arr = new ArrayList<Game>();

        try {
            String fname = new File(".").getCanonicalPath();
            File file = new File(fname, "/src/main/resources/json/games.json");
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray JSONarr = (JSONArray) jsonObject.get("gamesList");
            Iterator iterator = JSONarr.iterator();

            while (iterator.hasNext()) {
                JSONObject arr_obj = (JSONObject) iterator.next();
                Game temp = new Game((String) arr_obj.get("name"), (String) arr_obj.get("description"),
                                     (String) arr_obj.get("steamURl"), (String) arr_obj.get("reviews"),
                                     (double) arr_obj.get("price"));
                game_arr.add(temp);
            }
            return game_arr;
        }
        catch (FileNotFoundException err) {err.printStackTrace();}
        //catch (IOException err) {err.printStackTrace();}
        //catch (ParseException err) {err.printStackTrace();}
        //catch (Exception err) {err.printStackTrace();}

        return game_arr;
        
    }

}
