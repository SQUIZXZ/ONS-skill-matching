package com.nsa.ons.onsgroupproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "skill_name")
    private String name;

    @ManyToMany
    @JoinTable(name = "skill_hierarchy",
    joinColumns = {@JoinColumn(name = "parent_id")},
    inverseJoinColumns = {@JoinColumn(name = "child_id")})
    List<Skill> childSkills;

    @ManyToMany(mappedBy = "childSkills")
    List<Skill> parentSkills;

    public String searchable() {
        return String.join(";", name);
    }


    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
