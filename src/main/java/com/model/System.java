package com.model;

import java.io.Serializable;

public class System implements Serializable {
    private String classNo;
    private String className;
    private String majorNo;
    private String majorName;

    public System() {
    }

    public System(String classNo, String className, String majorNo, String majorName) {
        this.classNo = classNo;
        this.className = className;
        this.majorNo = majorNo;
        this.majorName = majorName;
    }

    public System(String majorNo, String majorName) {
        this.majorNo = majorNo;
        this.majorName = majorName;
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
}
