package com.chaoxu.service;

import com.chaoxu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2016/7/23.
 */
@Service
public class UserService {
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    public UserService() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
    }

    public User findUserById(Integer userId) {
        User user = redisTemplate.opsForValue().get(KeyUtil.userKey(userId));
        if(user==null){
            //find by jdbc
        }
        return user;
    }


}
