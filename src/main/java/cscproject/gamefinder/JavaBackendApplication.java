package cscproject.gamefinder;

import com.fasterxml.jackson.databind.ObjectMapper;
import cscproject.gamefinder.game.Game;
import cscproject.gamefinder.game.GameRepository;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JavaBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JavaBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(GameRepository gameRepository) {
        return args -> {
            // Add json files to the DB here
        };
    }
}
