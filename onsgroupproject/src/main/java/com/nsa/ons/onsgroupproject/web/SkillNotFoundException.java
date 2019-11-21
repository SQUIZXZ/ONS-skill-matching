package com.nsa.ons.onsgroupproject.web;

class SkillNotFoundException extends RuntimeException {

    SkillNotFoundException(Long id) {
        super("Could not find skill " + id);
    }
}
