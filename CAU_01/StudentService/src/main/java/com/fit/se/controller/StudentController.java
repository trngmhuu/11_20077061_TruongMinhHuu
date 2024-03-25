package com.fit.se.controller;

import com.fit.se.dto.ResponseDto;
import com.fit.se.entity.Student;
import com.fit.se.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;
//    @Autowired
//    private UserRedisRepository userRedisRepository;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        //userRedisRepository.saveUser(user);
        return new ResponseEntity(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getStudent(@PathVariable("id") int studentId){
        ResponseDto responseDto = studentService.getStudent(studentId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

//    @DeleteMapping("/{id}")
//    public void deleteUserById(@PathVariable("id") int userId) {
//        userRedisRepository.deleteById(userId);
//        userService.deleteUserById(userId);
//    }
//
//    @PutMapping("/{id}")
//    public void updateUserById(@PathVariable("id") int userId, @RequestBody Student newUser) {
//        userRedisRepository.update(newUser);
//        userService.updateUserById(userId, newUser);
//    }

}
