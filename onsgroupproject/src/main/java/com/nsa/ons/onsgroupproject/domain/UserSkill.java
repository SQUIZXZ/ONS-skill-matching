package com.nsa.ons.onsgroupproject.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class UserSkill {
    @Id
    @Column(name = "User_id")
    private int User_id;

    @Column(name = "Skill_id")
    private int Skill_id;

    @Column(name = "level")
    private int level;


}
