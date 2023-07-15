package org.example.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private Long id;
    private String userName;
    public Member(){
    }

    public Member(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}
