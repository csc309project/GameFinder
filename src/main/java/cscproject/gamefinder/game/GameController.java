package cscproject.gamefinder.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    GameRepository gameRepository;
    @Autowired
    GameService gameService;

    @GetMapping(path="/recommendations", produces="application/json")
    public ResponseEntity getRecommendation(@RequestBody String gameName) {
        Game recommendation = gameService.getRecommendation(gameName);
        return ResponseEntity.status(HttpStatus.OK).body(recommendation);
    }

    @GetMapping(path="/game", produces="application/json")
    public ResponseEntity getGames() {
        List<Game> allGames = gameService.getAllGames();
        return ResponseEntity.status(HttpStatus.OK).body(allGames);
    }

    @GetMapping("/game/{name}")
    @ResponseBody
    public ResponseEntity getGameWithName(@PathVariable String name) {
        try {
            Game game = gameRepository.findGameByName(name);
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

    @PutMapping("/game/{name}")
    public ResponseEntity put(@RequestBody Game game, @PathVariable String name) {
        try {
            Game temp = gameRepository.findGameByName(name);
            gameRepository.deleteById(temp.getGid());
            gameRepository.save(game);
            return ResponseEntity.status(HttpStatus.OK).body("Edited " + name);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find game to edit");
        }
    }

    @DeleteMapping("/game/{name}")
    public ResponseEntity delete(@PathVariable String name) {
        try {
            Game temp = gameRepository.findGameByName(name);
            gameRepository.deleteById(temp.getGid());
            return ResponseEntity.status(HttpStatus.OK).body("Deleted " + name);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find game to deleted");
        }
    }
}
