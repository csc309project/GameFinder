package cscproject.gamefinder.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findGameByName(String name);
    Game findGameByGid(int gid);
}
