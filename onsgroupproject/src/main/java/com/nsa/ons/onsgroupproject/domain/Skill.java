package com.nsa.ons.onsgroupproject.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "skill_name")
    private String name;

    public String searchable() {
        return String.join(";", name);
    }


}
