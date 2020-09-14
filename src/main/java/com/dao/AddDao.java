package com.dao;

import com.model.Student;
import com.model.System;
import com.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddDao extends BaseDao {
    /**
     * 添加教师
     *
     * @param teacher
     * @return
     */
    public boolean addTeacher(Teacher teacher) {
        String sql = "INSERT INTO chengj_Teachers02 VALUES(?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, teacher.getNo());
            pstmt.setString(2, teacher.getName());
            pstmt.setString(3, teacher.getSex());
            pstmt.setInt(4, teacher.getAge());
            pstmt.setString(5, teacher.getTitle());
            pstmt.setString(6, teacher.getPhone());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    /**
     * 批量添加教师
     *
     * @param teacherList
     * @return
     */
    public boolean addTeacherList(ArrayList<Teacher> teacherList) {
        for (Teacher teacher : teacherList) {
            String sql = "INSERT INTO chengj_Teachers02 VALUES(?,?,?,?,?,?)";
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, teacher.getNo().trim());
                pstmt.setString(2, teacher.getName().trim());
                pstmt.setString(3, teacher.getSex().trim());
                pstmt.setInt(4, teacher.getAge());
                pstmt.setString(5, teacher.getTitle().trim());
                pstmt.setString(6, teacher.getPhone().trim());
                pstmt.executeUpdate();
            } catch (SQLException se) {
                se.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    public boolean addStudent(Student student) {
        String sql_major = "INSERT INTO chengj_Major02 VALUES(?,?)";
        String sql_class = "INSERT INTO chengj_Classes02 VALUES(?,?,?)";
        String sql_student = "INSERT INTO chengj_Students02 VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt_major = conn.prepareStatement(sql_major);
             PreparedStatement pstmt_class = conn.prepareStatement(sql_class);
             PreparedStatement pstmt_student = conn.prepareStatement(sql_student)) {
            pstmt_major.setString(1, student.getMajorNo().trim());
            pstmt_major.setString(2, student.getMajorName().trim());
            pstmt_major.executeUpdate();
            pstmt_class.setString(1, student.getClassNo().trim());
            pstmt_class.setString(2, student.getClassName().trim());
            pstmt_class.setString(3, student.getMajorNo().trim());
            pstmt_class.executeUpdate();
            pstmt_student.setString(1, student.getNo().trim());
            pstmt_student.setString(2, student.getName().trim());
            pstmt_student.setString(3, student.getSex().trim());
            pstmt_student.setInt(4, student.getAge());
            pstmt_student.setString(5, student.getPlace().trim());
            pstmt_student.setInt(6, student.getCredit());
            pstmt_student.setString(7, student.getClassNo().trim());
            pstmt_student.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    /**
     * 批量添加学生
     *
     * @param studentList
     * @return
     */
    public boolean addStudentList(ArrayList<Student> studentList) {
        for (Student student : studentList) {
            String sql_major = "INSERT INTO chengj_Major02 VALUES(?,?)";
            String sql_class = "INSERT INTO chengj_Classes02 VALUES(?,?,?)";
            String sql_student = "INSERT INTO chengj_Students02 VALUES(?,?,?,?,?,?,?)";
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement pstmt_major = conn.prepareStatement(sql_major);
                 PreparedStatement pstmt_class = conn.prepareStatement(sql_class);
                 PreparedStatement pstmt_student = conn.prepareStatement(sql_student)) {
                pstmt_major.setString(1, student.getMajorNo().trim());
                pstmt_major.setString(2, student.getMajorName().trim());
                pstmt_major.executeUpdate();
                pstmt_class.setString(1, student.getClassNo().trim());
                pstmt_class.setString(2, student.getClassName().trim());
                pstmt_class.setString(3, student.getMajorNo().trim());
                pstmt_class.executeUpdate();
                pstmt_student.setString(1, student.getNo().trim());
                pstmt_student.setString(2, student.getName().trim());
                pstmt_student.setString(3, student.getSex().trim());
                pstmt_student.setInt(4, student.getAge());
                pstmt_student.setString(5, student.getPlace().trim());
                pstmt_student.setInt(6, student.getCredit());
                pstmt_student.setString(7, student.getClassNo().trim());
                pstmt_student.executeUpdate();
            } catch (SQLException se) {
                se.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * 添加班级、专业
     *
     * @param system
     * @return
     */
    public boolean addSystem(System system) {
        String sql_major = "INSERT INTO chengj_Major02 VALUES(?,?)";
        String sql_class = "INSERT INTO chengj_Classes02 VALUES(?,?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt_major = conn.prepareStatement(sql_major);
             PreparedStatement pstmt_class = conn.prepareStatement(sql_class)) {
            pstmt_major.setString(1, system.getMajorNo().trim());
            pstmt_major.setString(2, system.getMajorName().trim());
            pstmt_major.executeUpdate();
            pstmt_class.setString(1, system.getClassNo().trim());
            pstmt_class.setString(2, system.getClassName().trim());
            pstmt_class.setString(3, system.getMajorNo().trim());
            pstmt_class.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    /**
     * 添加专业
     *
     * @param major
     * @return
     */
    public boolean addMajor(System major) {
        String sql_major = "INSERT INTO chengj_Major02 VALUES(?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt_major = conn.prepareStatement(sql_major)) {
            pstmt_major.setString(1, major.getMajorNo().trim());
            pstmt_major.setString(2, major.getMajorName().trim());
            pstmt_major.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

}
