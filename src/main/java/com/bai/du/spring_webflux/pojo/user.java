package com.bai.du.spring_webflux.pojo;

public class user {
    public  user(){}
    public user(String name, int age, String sex, int id) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.id = id;
    }

    private String name;
    private int age;
    private String sex;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
