package cscproject.gamefinder.game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gid;
    private String name;
    private String description;
    private String steamURL;
    private String reviews;

    public Game(String name, String description, String steamURL, String reviews) {
        this.name = name;
        this.description = description;
        this.steamURL = steamURL;
        this.reviews = reviews;
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

}
