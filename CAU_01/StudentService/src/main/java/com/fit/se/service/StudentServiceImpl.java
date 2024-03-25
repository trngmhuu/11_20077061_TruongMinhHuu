package com.fit.se.service;

import com.fit.se.dto.MentorDto;
import com.fit.se.dto.ResponseDto;
import com.fit.se.dto.StudentDto;
import com.fit.se.entity.Student;
import com.fit.se.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private RestTemplate restTemplate;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public ResponseDto getStudent(int studentId) {
        ResponseDto responseDto = new ResponseDto();
        Student student = studentRepository.findById(studentId).get();
        StudentDto studentDto = mapToStudent(student);
        ResponseEntity<MentorDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/mentors/" + student.getMentorId(), MentorDto.class);
        MentorDto mentorDto = responseEntity.getBody();
        System.out.println(responseEntity.getStatusCode());
        responseDto.setStudentDto(studentDto);
        responseDto.setMentorDto(mentorDto);
        return responseDto;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

//    @Override
//    public void deleteUserById(int userId) {
//        userRepository.deleteById(userId);
//    }
//
//    @Override
//    public Student updateUserById(int userId, Student newUser) {
//        Student tempUser = userRepository.findById(userId).get();
//        // Update firstName
//        if (
//                Objects.nonNull(newUser.getFirstName()) &&
//                        !"".equalsIgnoreCase(newUser.getFirstName())
//        )
//        {
//            tempUser.setFirstName(newUser.getFirstName());
//        }
//
//        // Update lastName
//        if (
//                Objects.nonNull(newUser.getLastName()) &&
//                        !"".equalsIgnoreCase(newUser.getLastName())
//        )
//        {
//            tempUser.setLastName(newUser.getLastName());
//        }
//
//        // Update email
//        if (
//                Objects.nonNull(newUser.getEmail()) &&
//                        !"".equalsIgnoreCase(newUser.getEmail())
//        )
//        {
//            tempUser.setEmail(newUser.getEmail());
//        }
//
//        // Update departmentId
//        tempUser.setDepartmentId(newUser.getDepartmentId());
//        return userRepository.save(tempUser);
//    }

    private StudentDto mapToStudent(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setStudentName(student.getStudentName());
        return studentDto;
    }
}
