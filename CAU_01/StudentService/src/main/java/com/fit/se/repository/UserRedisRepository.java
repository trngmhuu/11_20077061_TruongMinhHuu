package com.fit.se.repository;

import com.fit.se.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRedisRepository {

    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    @Autowired
    public UserRedisRepository(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void saveUser(Student user) {
        hashOperations.put("USER", user.getId(), user);
    }

    public List<Student> findAll() {
        return hashOperations.values("USER");
    }

    @Cacheable(value = "users", key = "#id")
    public Student findById(int id) {
        return (Student) hashOperations.get("USER", id);
    }

    public void update(Student user) {
        saveUser(user);
    }

    public void deleteById(Integer id) {
        hashOperations.delete("USER", id);
    }

}
