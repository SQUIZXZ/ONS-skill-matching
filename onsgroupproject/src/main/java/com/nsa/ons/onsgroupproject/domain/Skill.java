package com.nsa.ons.onsgroupproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skill_name")
    private String name;

    @Column(name = "skill_desc")
    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "skill_hierarchy",
    joinColumns = {@JoinColumn(name = "parent_id")},
    inverseJoinColumns = {@JoinColumn(name = "child_id")})
    List<Skill> childSkills;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "skill_hierarchy",
            joinColumns = {@JoinColumn(name = "child_id")},
            inverseJoinColumns = {@JoinColumn(name = "parent_id")})
    List<Skill> parentSkills;

    @ManyToMany(mappedBy = "userSkills")
    List<User> userSkills;

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
