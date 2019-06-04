package cscproject.gamefinder.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Random;

@Service
public class GameService {
    @Autowired

    private GameRepository gameRepository;

    public Game getRecommendation(String name) {
        Random randInt = new Random();
        List<Game> allGames = getAllGames();
        Game currentGame;
        while(true) {
            int gameID = (randInt.nextInt() * ((allGames.size() - 1) + 1)) + 1;
            currentGame = gameRepository.findGameByGid(gameID);
            if (currentGame.getName().equals(name)) {
                break;
            }
        }
        return currentGame;
    }


    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public void insertGameList(List<Game> games) {
        for (Game game : games) {
            gameRepository.save(game);
        }
    }


}
