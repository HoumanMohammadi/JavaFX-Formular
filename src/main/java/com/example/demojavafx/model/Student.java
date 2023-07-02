package com.example.demojavafx.model;

public record Student(String id, String firstName, String lastName, String email, String courseOfStudies) {

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + courseOfStudies;
    }
}