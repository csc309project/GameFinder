package cscproject.gamefinder.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    GameRepository gameRepository;
    @Autowired
    GameService gameService;

    @GetMapping("/recommendations")
    public ResponseEntity getRecommendation(@RequestBody String gameName) {
        Game recommendation = gameService.getRecommendation(gameName);
        return ResponseEntity.status(HttpStatus.OK).body(recommendation);
    }

    @GetMapping("/game")
    public List<Game> getGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/game/{name}")
    @ResponseBody
    public ResponseEntity getGamesWithName(@PathVariable String name) {
        Game game = gameRepository.findGameByName(name);
        try {
            game.getName();
            return ResponseEntity.status(HttpStatus.OK).body(game);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not be found");
        }
    }

    @PostMapping("/game")
    public ResponseEntity post(@RequestBody Game game) {
        gameRepository.save(game);
        return ResponseEntity.status(HttpStatus.OK).body("Posted " + game.getName());
    }

    @PutMapping("/game")
    public ResponseEntity put(@RequestBody Game game) {
        gameRepository.save(game);
        return ResponseEntity.status(HttpStatus.OK).body("Edited " + game.getName());
    }

    @DeleteMapping("/game/{name}")
    public ResponseEntity delete(@PathVariable String name) {
        ResponseEntity res = getGamesWithName(name);

        if(res.getStatusCode() == HttpStatus.OK) {
            Game temp = (Game) res.getBody();
            gameRepository.deleteById(temp.getGid());
            return ResponseEntity.status(HttpStatus.OK).body("Deleted " + name);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find game to delete");
    }
}
