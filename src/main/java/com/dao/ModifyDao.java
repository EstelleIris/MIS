package com.dao;

import com.model.Student;
import com.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyDao extends BaseDao {
    /**
     * 根据工号修改教师信息
     *
     * @param teacher
     * @return
     */
    public boolean modifyTeacher(Teacher teacher) {
        String sql = "UPDATE chengj_Teachers02\n" +
                "SET cj_Tname02=?,cj_Tsex02=?,cj_Tage02=?,cj_Ttitle02=?,cj_Tphone02=? \n" +
                "WHERE cj_Tno02=?";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getSex());
            pstmt.setInt(3, teacher.getAge());
            pstmt.setString(4, teacher.getTitle());
            pstmt.setString(5, teacher.getPhone());
            pstmt.setString(6, teacher.getNo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    /**
     * 根据学号修改学生信息
     *
     * @param student
     * @return
     */
    public boolean modifyStudent(Student student) {
        String sql = "UPDATE chengj_Students02\n" +
                "SET cj_Sname02=?,cj_Ssex02=?,cj_Sage02=?,cj_Splace02=?,cj_SCredit02=?,cj_ClassNo02=?\n" +
                "WHERE cj_Sno02=?";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName().trim());
            pstmt.setString(2, student.getSex().trim());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getPlace().trim());
            pstmt.setInt(5, student.getCredit());
            pstmt.setString(6, student.getClassNo().trim());
            pstmt.setString(7, student.getNo().trim());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    /*public boolean modifySystem(System system) {
        String sql = "update dbt_system set major=?,institute=? where sclass=?";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, system.getMajor());
            pstmt.setString(2, system.getInstitute());
            pstmt.setString(3, system.getSclass());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }*/
}
