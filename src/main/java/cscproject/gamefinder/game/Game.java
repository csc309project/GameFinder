package cscproject.gamefinder.game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gid;
    private String name;
    private String description;
    private String steamURL;
    private String reviews;
    private double price;

    public Game(String name, String description, String steamURL, String reviews, double price) {
        this.name = name;
        this.description = description;
        this.steamURL = steamURL;
        this.reviews = reviews;
        this.price = price;
    }

    public long getGid() {
        return this.gid;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSteamURL() {
        return this.steamURL;
    }

    public String getReviews() {
        return this.reviews;
    }

    public double getPrice() {
        return this.price;
    }

}
