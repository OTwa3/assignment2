package com.assign2.assignment2.models;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private int weight;
    private int height;
    private String haircolour;
    private double gpa;
    private String favcolour;
    public Student() {
    }
    public Student(String name, int weight, int height, String haircolour, double gpa, String favcolour) {
        this.name = name;
        this.weight = weight;
        this.haircolour = haircolour;
        this.gpa = gpa;
        this.height = height;
        this.favcolour = favcolour;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getHaircolour() {
        return haircolour;
    }
    public void setHaircolour(String haircolour) {
        this.haircolour = haircolour;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getFavcolour() {
        return favcolour;
    }
    public void setFavcolour(String favcolour) {
        this.favcolour = favcolour;
    }
    
}
