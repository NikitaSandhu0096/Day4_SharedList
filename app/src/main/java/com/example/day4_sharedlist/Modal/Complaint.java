package com.example.day4_sharedlist.Modal;

import java.io.Serializable;

public class Complaint implements Serializable {
    private String title;
    private String firstName;
    private String lastName;
    private String empStatus;
    private String designation;
    private String location;
    private String email;
    private int country;
    private int date;
    private String issue;
    private String rating;
    private String description;

    public Complaint(String title, String firstName, String lastName, String empStatus,
                     String designation, String location, String email, int country,  int date,
                     String issue, String rating, String description){
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empStatus = empStatus;
        this.designation = designation;
        this.location = location;
        this.email = email;
        this.country = country;
        this.date = date;
        this.issue = issue;
        this.rating = rating;
        this.description = description;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmpStatus(){
        return empStatus;
    }

    public void setEmpStatus(String empStatus){
        this.empStatus = empStatus;
    }

    public String getDesignation(){
        return designation;
    }

    public void setDesignation(String designation){
        this.designation = designation;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getcountry(){
        return country;
    }

    public void setCountry(int country){
        this.country = country;
    }

    public int getDate(){
        return date;
    }

    public void setDate(int date){
        this.date = date;
    }

    public String getIssue(){
        return issue;
    }

    public void setIssue(String issue){
        this.issue = issue;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
