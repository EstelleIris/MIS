package com.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String no;
    private String name;
    private String sex;
    private int age;
    private String place;//生源地
    private int credit;//已修学分总数
    private String classNo;
    private String className;
    private String majorNo;
    private String majorName;
    private Double gpa;

    public Student() {
    }

    public Student(String no, String name, String sex, int age, String place, int credit, String classNo, String className, String majorNo, String majorName) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.place = place;
        this.credit = credit;
        this.classNo = classNo;
        this.className = className;
        this.majorNo = majorNo;
        this.majorName = majorName;
    }

    public Student(String no, String name, String sex, int age, String place, int credit, String classNo, String className, String majorNo, String majorName, Double gpa) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.place = place;
        this.credit = credit;
        this.classNo = classNo;
        this.className = className;
        this.majorNo = majorNo;
        this.majorName = majorName;
        this.gpa = gpa;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajorNo() {
        return majorNo;
    }

    public void setMajorNo(String majorNo) {
        this.majorNo = majorNo;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
}
