package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RestRepository extends CrudRepository<Skill, Long> {

    // Returns a list of object SKILL as opposed to an iterable
    @Override
    List<Skill> findAll();

}
