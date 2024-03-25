package com.fit.se.service;

import com.fit.se.entity.Mentor;

import java.util.List;

public interface MentorService {

    Mentor saveMentor(Mentor mentor);

    Mentor getMentorById(int mentorId);

    List<Mentor> getAllMentors();

}
