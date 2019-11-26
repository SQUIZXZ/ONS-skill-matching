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
    public int id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "surname")
    public String surname;

    @Column(name = "email")
    public String email;

    @Column(name = "privacy")
    public boolean privacy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
