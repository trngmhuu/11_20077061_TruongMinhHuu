package com.fit.se.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class GatewayController {

    @Autowired
    private RestTemplate restTemplate;

    //Call Department Project
    @GetMapping("/mentors")
    public Object getForObjectMentors() {
        String apiUrl = "http://localhost:8080/mentors";
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @GetMapping("/mentors/{id}")
    public Object getForObjectMentorById(@PathVariable("id") int mentorId) {
        String apiUrl = "http://localhost:8080/mentors/" + Integer.toString(mentorId);
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @PostMapping("/mentors")
    public Object saveObjectMentor(@RequestBody Object object) {
        String apiUrl = "http://localhost:8080/mentors";
        return restTemplate.postForObject(apiUrl, object, Object.class);
    }

//    @DeleteMapping("/departments/{id}")
//    public ResponseEntity<Object> deleteObjectDepartmentById(@PathVariable("id") int departmentId) {
//        String apiUrl = "http://localhost:8080/departments/" + Integer.toString(departmentId);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Object> requestEntity = new HttpEntity<>(null, headers);
//
//        ResponseEntity<Object> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.DELETE, requestEntity, Object.class);
//
//        return responseEntity;
//    }
//
//    @PutMapping("/departments/{id}")
//    public ResponseEntity<Object> updateObjectDepartmentById(@PathVariable("id") int departmentId, @RequestBody Object updatedObject) {
//        String apiUrl = "http://localhost:8080/departments/" + Integer.toString(departmentId);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Object> requestEntity = new HttpEntity<>(updatedObject, headers);
//
//        ResponseEntity<Object> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.PUT, requestEntity, Object.class);
//
//        return responseEntity;
//    }


    // Call Student Project
    @GetMapping("/students")
    public Object getForAllObjectStudents() {
        String apiUrl = "http://localhost:8081/students";
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @GetMapping("/students/{id}")
    public Object getForObjectStudentById(@PathVariable("id") int studentId) {
        String apiUrl = "http://localhost:8081/students/" + Integer.toString(studentId);
        return restTemplate.getForObject(apiUrl, Object.class);
    }

    @PostMapping("/students")
    public Object saveObjectUser(@RequestBody Object object) {
        String apiUrl = "http://localhost:8080/students";
        return restTemplate.postForObject(apiUrl, object, Object.class);
    }

//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<Object> deleteObjectUserById(@PathVariable("id") int userId) {
//        String apiUrl = "http://localhost:8080/users/" + Integer.toString(userId);
//
//        ResponseEntity<Object> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.DELETE, null, Object.class);
//
//        return responseEntity;
//    }
//
//    @PutMapping("/users/{id}")
//    public ResponseEntity<Object> updateObjectUserById(@PathVariable("id") int userId, @RequestBody Object updatedObject) {
//        String apiUrl = "http://localhost:8080/users/" + Integer.toString(userId);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Object> requestEntity = new HttpEntity<>(updatedObject, headers);
//
//        ResponseEntity<Object> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.PUT, requestEntity, Object.class);
//
//        return responseEntity;
//    }

    // Call Employee Project
//    @GetMapping("/employees")
//    public Object getForObjectEmployees() {
//        String apiUrl = "http://localhost:8082/employees";
//        return restTemplate.getForObject(apiUrl, Object.class);
//    }


}
