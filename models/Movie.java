package models;

import java.util.List;

public class Movie {

    private String name;
    private List<Actor> actors;

    public Movie(List<Actor> actors, String name) {
        this.actors = actors;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}