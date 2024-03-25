package com.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Entity
@Table(name = "students")
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter
@Data
public class Student implements Serializable {

    @Id
    //@Indexed
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String studentName;
    private int age;
    private String mentorId;

//    @Column(nullable = false, unique = true)
//    private String email;
//    private String departmentId;

}
