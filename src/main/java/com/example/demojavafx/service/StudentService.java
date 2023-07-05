package com.example.demojavafx.service;


import com.example.demojavafx.model.Student;
import com.example.demojavafx.model.StudentWithoutId;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import java.net.http.HttpClient;

public class StudentService {

    private static StudentService instance;
    private List<Student> students;

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;


    private StudentService() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        students = new ArrayList<>();
/*        students.addAll(Arrays.asList(
                new Student("1", "Max", "Mustermann", "max@jahoo.de", "Sport"),
                new Student("2", "Erika", "Mustermann", "erika@gmail.com", "Kunst"),
                new Student("3", "Willi", "Wichtig", "wiktiigg123@spammail.de", "Cybersecurity")
        ));*/
    }

    public static synchronized StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

/*    public Student createNewStudent(StudentWithoutId student) {
        Student studentWithId = new Student(
                UUID.randomUUID().toString(),
                student.firstName(),
                student.lastName(),
                student.email(),
                student.courseOfStudies()
        );

        students.add(studentWithId);
        return studentWithId;
    }*/

    public void updateStudent(Student student) {
        students.removeIf(studentFromList -> studentFromList.matriculationNumber().equals(student.matriculationNumber()));
        students.add(student);
    }

/*    public List<Student> getAllStudents() {
        return students;
    }*/
    public List<Student> getAllStudents(){
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("Accept", "application/json")
                .uri(URI.create("http://localhost:8080/api/students"))
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::mapToListStudent) // .thenApply(responseBody -> mapToStudent(responseBody))
                .join();
    }

    private List<Student> mapToListStudent(String responseBody) {
        try {
            return objectMapper.readValue(responseBody, new TypeReference<List<Student>>() {
            });
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    private Student mapToStudent(String json) {
        try {
            return objectMapper.readValue(json, Student.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to map student", e);
        }
    }
    public Student addStudent(StudentWithoutId student) throws JsonProcessingException {
            String requestBody= objectMapper.writeValueAsString(student);
            HttpRequest request= HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/students"))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::mapToStudent)
                    .join();

    }

    public void deleteStudent(String studentId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/students/" + studentId))
                .header("Accept", "application/json")
                .DELETE()
                .build();

        httpClient.send(request, HttpResponse.BodyHandlers.discarding());
    }

}
