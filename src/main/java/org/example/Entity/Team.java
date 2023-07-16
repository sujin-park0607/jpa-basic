package org.example.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
