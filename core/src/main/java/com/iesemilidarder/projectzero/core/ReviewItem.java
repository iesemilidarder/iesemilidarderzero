package com.iesemilidarder.projectzero.core;

/**
 * zero-project
 * com.iesemilidarder.projectzero.core
 * Created by ${User} in 26/1/2018
 * Description:
 **/
public class ReviewItem extends DBObject{
    private int id;
    private String name;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    protected void beforeSave() {
        doLog("todo!");
    }
}
