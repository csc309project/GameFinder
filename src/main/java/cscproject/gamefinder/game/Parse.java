package cscproject.gamefinder.game;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import java.io.FileReader;
import java.io.IOException;

public class Parse {

    private Parse() {};

    public static List<Game> createGameList() throws ParseException {
        JSONParser parser = new JSONParser();
        ArrayList<Game> gameArr = new ArrayList<>();

        try {
            String fname = new File(".").getCanonicalPath();
            String  loc = "/src/main/resources/json/games.json";
            File file = new File(fname, loc);
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray arrJSON = (JSONArray) jsonObject.get("gamesList");
            Iterator iterator = arrJSON.iterator();

            while (iterator.hasNext()) {
                JSONObject arrObj = (JSONObject) iterator.next();
                Game temp = new Game((String) arrObj.get("name"), (String) arrObj.get("description"),
                                     (String) arrObj.get("steamURl"), (String) arrObj.get("reviews"),
                                     (double) arrObj.get("price"));
                gameArr.add(temp);
            }

            return gameArr;
        }

        catch (IOException | ParseException err) {err.printStackTrace();}

        return gameArr;
        
    }

}
