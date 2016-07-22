package com.chaoxu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by dell on 2016/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class redisTestCase {

    @Autowired
    private RedisTemplate redisTemplate;

    Jedis jedis = null;

    @Before
    public void open() {
        jedis = new Jedis("192.168.255.131");
    }

    @After
    public void close() {
        if (jedis != null) {
            jedis.close();
        }
    }

    @Test
    public void setTest() {
        jedis.set("name:6", "张三");
    }

    @Test
    public void testAppend() {
        jedis.append("name","想陈丽婷");
        System.out.println(jedis.get("name"));
    }

    @Test
    public void testGet() {
        String name = jedis.get("name:6");
        System.out.println(name);
    }

    @Test
    public void testIncr() {
        jedis.incr("post:1viewnum");
    }

    @Test
    public void testIncrby() {
        jedis.incrBy("post1:viewnum", 99);

    }

    @Test
    public void testIncrByFloat() {
        jedis.incrByFloat("post1:viewnum", 1.5);
    }

    @Test
    public void testIncrFloat() {
        String str = jedis.get("post1:viewnum");
        System.out.println(str);
    }

    @Test
    public void testMset() {
        jedis.mset("name1", "陈丽婷", "name2", "赵朝旭","name3","牛丽娟");
    }

    @Test
    public void testMget() {
        List<String> list = jedis.mget("name1", "name2", "name3");
        for (String str : list) {
            System.out.println(str);
        }
    }

    @Test
    public void testhash() {

        String str = jedis.hget("user1:", "age");
        System.out.println(str);
    }

    @Test
    public void testSetHash() {
        redisTemplate.opsForHash().put("user2:", "name", "jack");
    }



}
