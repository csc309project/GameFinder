package cscproject.gamefinder;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
@EnableJpaRepositories
@ContextConfiguration("/pom.xml")
public class JavaBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JavaBackendApplication.class, args);
    }

}
