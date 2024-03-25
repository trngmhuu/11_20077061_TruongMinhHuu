package com.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Entity
@Table(name = "mentors")
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter
@Data
public class Mentor implements Serializable {

    @Id
    @Indexed
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mentorName;
    private String mentorAddress;

}
