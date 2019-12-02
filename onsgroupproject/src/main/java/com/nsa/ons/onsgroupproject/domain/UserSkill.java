package com.nsa.ons.onsgroupproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_skill")
public class UserSkill {
    @Id
    @Column(name = "User_id")
    private long User_id;

    @Column(name = "Skill_id")
    private long Skill_id;

    @Column(name = "level")
    private long level;

    @Column(name = "privacy")
    private boolean privacy;

}
