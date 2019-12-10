package com.nsa.ons.onsgroupproject.web;


public class user  {

    private long level1;
    private String skill;
    private  boolean privacy ;

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public long getLevel1() {
        return level1;
    }

    public void setLevel1(long level) {
        this.level1 = level;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

}