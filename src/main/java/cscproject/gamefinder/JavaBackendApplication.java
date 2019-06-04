package cscproject.gamefinder;

import cscproject.gamefinder.game.Game;
import cscproject.gamefinder.game.GameRepository;
import cscproject.gamefinder.game.GameService;
import cscproject.gamefinder.game.Parse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class JavaBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JavaBackendApplication.class, args);
    }

}
