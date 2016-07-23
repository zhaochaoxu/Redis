package com.chaoxu;

import com.chaoxu.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dell on 2016/7/23.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JackSongtestCase {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Before
    public void setUp() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
    }

    @Test
    public void testSet() {
        User user = new User(1, "牛丽娟", "聊城", 23);
        redisTemplate.opsForValue().set("user1", user);
    }

    @Test
    public void testGet(){
        User user = redisTemplate.opsForValue().get("user1");
        System.out.println(user.getName());
    }
}
