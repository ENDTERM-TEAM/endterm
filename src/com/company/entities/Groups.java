package com.company.entities;

public class Groups {
    private int g_id;
    private String name;
    private String level;
    private int mentor_id;

    public Groups () {}

    public Groups (int g_id, String name, String level, int mentor_id) {
        setG_id(g_id);
        setName(name);
        setLevel(level);
        setMentor_id(mentor_id);
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getMentor_id() {
        return mentor_id;
    }

    public void setMentor_id(int mentor_id) {
        this.mentor_id = mentor_id;
    }

    @Override
    public String toString() {
        return "Group " + getG_id() + ", with subject " + getName() + ", level is " + getLevel() + ", mentor: ";
    }
}
