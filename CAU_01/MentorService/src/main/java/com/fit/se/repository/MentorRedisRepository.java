package com.fit.se.repository;

import com.fit.se.entity.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MentorRedisRepository {

    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    @Autowired
    public MentorRedisRepository(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void saveMentor(Mentor mentor) {
        hashOperations.put("MENTOR", mentor.getId(), mentor);
    }

    public List<Mentor> findAll() {
        return hashOperations.values("MENTOR");
    }

    @Cacheable(value = "mentors", key = "#id")
    public Mentor findById(int id) {
        return (Mentor) hashOperations.get("MENTOR", id);
    }

//    public void update(Mentor mentor) {
//        saveMentor(mentor);
//    }
//
//    public void deleteById(Integer id) {
//        hashOperations.delete("MENTOR", id);
//    }

}
