package com.chaoxu;

import com.chaoxu.pojo.User;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.Set;

/**
 * Created by dell on 2016/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class stringRedisTestCase {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet() {
        stringRedisTemplate.opsForSet().add("user:vote", "Tom", "Jack", "Jim", "Jarry", "Harry");
        Set<String> stringList = stringRedisTemplate.opsForSet().members("user:vote");
        for (String str : stringList) {
            System.out.println(str);

        }
    }

    @Test
    public void tsetHashSave() {

        Map<String, String> map = Maps.newHashMap();
        map.put("name", "牛丽娟");
        map.put("age", "26");
        map.put("addr", "聊城");
        stringRedisTemplate.opsForHash().putAll("user9:", map);
        Object name = stringRedisTemplate.opsForHash().get("user9:", "name");
        System.out.println(name);
    }


    @Test
    public void testGson(){
        User user2 = new User(65, "Tom", "USA", 26);
        stringRedisTemplate.opsForSet().add("user369",new Gson().toJson(user2));

        Set<String> json =stringRedisTemplate.opsForSet().members("user369");
        for (String js: json) {
            User user = new Gson().fromJson(js,User.class);
            System.out.println(user);
        }

    }


    @Test
    public void testHash() {

        Map<String, String> map = Maps.newHashMap();
        User user1 = new User(66, "赵玉静", "聊城", 26);
        /*User user2 = new User(67, "陈丽婷", "濮阳", 26);
        User user3 = new User(68, "牛丽娟", "聊城", 26);
        map.put("user1",new Gson().toJson(user1));
        map.put("user2",new Gson().toJson(user2));*/
        map.put("user3",new Gson().toJson(user1));

        stringRedisTemplate.opsForHash().putAll("user66", map);

        System.out.println(stringRedisTemplate.opsForHash().getOperations());
    }
}
