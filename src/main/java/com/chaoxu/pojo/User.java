package com.chaoxu.pojo;

/**
 * Created by dell on 2016/7/23.
 */
public class User {
    private Integer id;
    private String name;
    private String addr;
    private Integer age;

    public User(Integer id, String name, String addr, Integer age) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", age=" + age +
                '}';
    }
}
