package cscproject.gamefinder.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.concurrent.Future;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    @Async
    @Query("SELECT c FROM Game c where c.name = :name")
    Future<Game> findGameByName(@Param("name") String name);
}
