package org.example.Entity;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String userName;

    @ManyToOne
    @JoinColumn(name= "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Team getTeam() {
        return team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
