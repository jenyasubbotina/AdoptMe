package com.jenyasubbotina.adoptme.ui.home;

import android.content.Intent;
import android.location.Location;

public class PetModel {
    Location location;
    String name;
    String breed;
    Integer sex;
    Integer age;

    public PetModel(String name, String breed, Integer sex, Integer age) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
    }

    public PetModel(Location location, String name, String breed, Integer sex, Integer age) {
        this.location = location;
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
