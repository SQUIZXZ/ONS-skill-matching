package com.nsa.ons.onsgroupproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "privacy")
    private boolean privacy;

//    @ManyToMany
//    @JoinTable(name = "user_skill",)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
