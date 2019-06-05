package cscproject.gamefinder.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game getRecommendation(String name) {
        Game currentGame = new Game("name", "description", "steam_url", "reviews", 0.0);
        List<Game> allGames = getAllGames();
        for (int index = 0; index < allGames.size(); index++) {
            if (allGames.get(index).getName().equalsIgnoreCase(name)) {
                currentGame = allGames.get(index);
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
