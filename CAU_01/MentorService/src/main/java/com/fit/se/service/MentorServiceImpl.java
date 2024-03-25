package com.fit.se.service;

import com.fit.se.entity.Mentor;
import com.fit.se.repository.MentorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public Mentor saveMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    public Mentor getMentorById(int mentorId) {
        return mentorRepository.findById(mentorId).get();
    }

    @Override
    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

//    @Override
//    public Mentor updateDepartmentById(int departmentId, Mentor newDepartment) {
//        Mentor tempDepartment = departmentRepository.findById(departmentId).get();
//        if (
//                Objects.nonNull(newDepartment.getDepartmentName()) &&
//                        !"".equalsIgnoreCase(newDepartment.getDepartmentName())
//        )
//        {
//            tempDepartment.setDepartmentName(newDepartment.getDepartmentName());
//        }
//        if (
//                Objects.nonNull(newDepartment.getDepartmentAddress()) &&
//                        !"".equalsIgnoreCase(newDepartment.getDepartmentAddress())
//        )
//        {
//            tempDepartment.setDepartmentAddress(newDepartment.getDepartmentAddress());
//        }
//        if (
//                Objects.nonNull(newDepartment.getDepartmentCode()) &&
//                        !"".equalsIgnoreCase(newDepartment.getDepartmentCode())
//        )
//        {
//            tempDepartment.setDepartmentCode(newDepartment.getDepartmentCode());
//        }
//        return departmentRepository.save(tempDepartment);
//    }
//
//    @Override
//    public void deleteDepartmentById(int departmentId) {
//        departmentRepository.deleteById(departmentId);
//    }
}
