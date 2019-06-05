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
    
    Random randInt = new Random();

    public Game getRecommendation(String name) {
        List<Game> allGames = getAllGames();
        Game currentGame;
        while (true) {
            int gameID = abs(randInt.nextInt()) % allGames.size();
            if (gameID < 0) {
                gameID = gameID * -1;
            }
            currentGame = allGames.get(gameID);
            if (!currentGame.getName().equalsIgnoreCase(name)) {
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
