package cscproject.gamefinder.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game getRecommendation(String name) {
        Random randInt = new Random();
        List<Game> allGames = getAllGames();
        Game currentGame;
        while(true) {
            int gameID = abs(randInt.nextInt()) % allGames.size();
            currentGame = allGames.get(gameID);
            if (!currentGame.getName().equals(name)) {
                break;
            }
        }
        return currentGame;
    }

    public Game gameByName(String name) {
        return gameRepository.findGameByName(name);
    }

    public void insert(Game game) {
        gameRepository.save(game);
    }

    public Game gameById(long gid) {
        return gameRepository.findGameByGid(gid);
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
