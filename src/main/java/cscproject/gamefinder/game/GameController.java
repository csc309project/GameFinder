package cscproject.gamefinder.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/game")
    Collection<Game> games() {
        return gameRepository.findAll();
    }

    @GetMapping("/game/{gid}")
    @ResponseBody
    public ResponseEntity getGamesWithName(@RequestParam String name) {
        Future<Game> game = gameRepository.findGameByName(name);

        try {
            game.get().getName();
            return ResponseEntity.status(HttpStatus.OK).body(game.get());
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not be found");
        }
    }

    @PostMapping("/game")
    public ResponseEntity post(@RequestBody Game game) {
        gameRepository.save(game);

        return ResponseEntity.status(HttpStatus.OK).body("Posted");
    }

    @PutMapping("/game")
    public ResponseEntity put(@RequestBody Game game) {
        gameRepository.save(game);

        return ResponseEntity.status(HttpStatus.OK).body("Edited");
    }

    @DeleteMapping("/game")
    public ResponseEntity delete(@RequestBody Game game) {
        ResponseEntity res = getGamesWithName(game.getName());

        if(res.getStatusCode() == HttpStatus.OK) {
            Game temp = (Game) res.getBody();
            gameRepository.deleteById(temp.getGid());
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find game to delete");
    }
}
