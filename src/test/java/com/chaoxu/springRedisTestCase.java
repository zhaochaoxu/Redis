package com.chaoxu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dell on 2016/7/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class springRedisTestCase {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSet(){
        redisTemplate.opsForValue().set("name:1","Tom");
    }

    @Test
    public void testGet(){
        String name= (String) redisTemplate.opsForValue().get("name:1");
        System.out.println(name);
    }

    @Test
    public void testIncr(){
        redisTemplate.opsForValue().increment("post:6:viewnum",1);
        System.out.println(redisTemplate.opsForValue().get("post:6:viewnum"));
    }

    public void testGetIncr(){
        System.out.println(redisTemplate.opsForValue().get("bookprice"));
    }
}
