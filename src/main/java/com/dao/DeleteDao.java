package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDao extends BaseDao {

    /**
     * 根据工号删除教师
     *
     * @param no
     * @return
     */
    public boolean deleteTeacher(String no) {
        String sql = "delete from chengj_Teachers02 WHERE cj_Tno02=?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, no);
            if (pstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException se) {
            return false;
        }
        return false;
    }

    /**
     * 根据学号删除学生
     *
     * @param no
     * @return
     */
    public boolean deleteStudent(String no) {
        String sql = "delete from chengj_Students02 WHERE cj_Sno02=?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, no);
            if (pstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException se) {
            return false;
        }
        return false;
    }

    /**
     * 删除班级
     *
     * @param sclass
     * @return
     */
    public boolean deleteSclass(String sclass) {
        String sql = "delete from chengj_Classes02 where cj_ClassNo02=?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sclass);
            if (pstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException se) {
            return false;
        }
        return false;
    }


    /**
     * 删除专业
     *
     * @param major
     * @return
     */
    public boolean deleteMajor(String major) {
        String sql = "delete from chengj_Major02 WHERE cj_MajorNo02=?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, major);
            if (pstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException se) {
            return false;
        }
        return false;
    }

    /**
     * 删除课程
     *
     * @param course
     * @return
     */
    public boolean deleteCourse(String course) {
        String sql = "delete from chengj_Courses02 WHERE cj_Cno02=?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, course);
            if (pstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException se) {
            return false;
        }
        return false;
    }

}
