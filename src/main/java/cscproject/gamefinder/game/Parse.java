package cscproject.gamefinder.game;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parse {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("games.json"));
            JSONObject jsonObject = (JSONObject) obj;
            

        }
        catch (FileNotFoundException err) {err.printStackTrace();}
        catch (IOException err) {err.printStackTrace();}
        catch (ParseException err) {err.printStackTrace();}
        catch (Exception err) {err.printStackTrace();}
        
    }

}
