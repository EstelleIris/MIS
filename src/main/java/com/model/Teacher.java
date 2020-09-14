package com.model;

import java.io.Serializable;

public class Teacher implements Serializable {
    private String no;
    private String name;
    private String sex;
    private int age;
    private String title;
    private String phone;

    public Teacher() {
    }

    public Teacher(String no, String name, String sex, int age, String title, String phone) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.title = title;
        this.phone = phone;
    }

    public Teacher(String no, String name, String sex, String age, String title, String phone) {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
