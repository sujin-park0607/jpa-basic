package org.example.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Movie extends Item{
    private String director;
    private String actor;

    public String getDirector() {
        return director;
    }

    public String getActor() {
        return actor;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

}
