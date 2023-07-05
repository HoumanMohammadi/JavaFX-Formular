package com.example.demojavafx.model;

public record Student(String matriculationNumber, String firstName, String lastName, String email, String courseOfStudies) {

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + courseOfStudies;
    }
}