package com.fit.se.controller;

import com.fit.se.entity.Mentor;
import com.fit.se.repository.MentorRedisRepository;
import com.fit.se.service.MentorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentors")
@AllArgsConstructor
public class MentorController {

    private MentorService mentorService;

    @Autowired
    private MentorRedisRepository mentorRedisRepository;

    @PostMapping
    public ResponseEntity<Mentor> saveMentor(@RequestBody Mentor mentor) {
        Mentor savedMentor = mentorService.saveMentor(mentor);
        mentorRedisRepository.saveMentor(mentor);
        return new ResponseEntity<>(savedMentor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllMentors() {
        List<Mentor> mentors = mentorRedisRepository.findAll();
        return ResponseEntity.ok(mentors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mentor> getMentorById(@PathVariable("id") int mentorId) {
        Mentor mentor = mentorRedisRepository.findById(mentorId);
        return ResponseEntity.ok(mentor);
    }

//    @DeleteMapping("/{id}")
//    public void deleteDeparmentById(@PathVariable("id") int departmentId) {
//        departmentService.deleteDepartmentById(departmentId);
//        mentorRedisRepository.deleteById(departmentId);
//    }
//
//    @PutMapping("/{id}")
//    public void updateDepartmentById(@PathVariable("id") int departmentId, @RequestBody Mentor newDepartment) {
//        departmentService.updateDepartmentById(departmentId, newDepartment);
//        mentorRedisRepository.update(newDepartment);
//    }
}
