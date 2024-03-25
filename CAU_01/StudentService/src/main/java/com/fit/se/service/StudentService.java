package com.fit.se.service;

import com.fit.se.dto.ResponseDto;
import com.fit.se.entity.Student;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);

    public ResponseDto getStudent(int studentId);

    public List<Student> getAllStudents();

//    public void deleteUserById(int userId);
//
//    public Student updateUserById(int userId, Student newUser);

}
