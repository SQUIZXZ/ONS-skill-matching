package com.nsa.ons.onsgroupproject.service;

import java.util.Optional;

public interface SkillRequestFinder {
    public Optional findSkillRequestByFurl(String furl);

}
