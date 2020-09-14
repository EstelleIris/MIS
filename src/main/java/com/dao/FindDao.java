package com.dao;

import com.model.Course;
import com.model.Student;
import com.model.System;
import com.model.Teacher;
import com.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class FindDao extends BaseDao {
    /**
     * 登录验证：根据用户名查找用户
     *
     * @param no
     * @return
     */
    public User findByNO(String no) {
        String sql = "SELECT * FROM chengj_User02 WHERE cj_No02=?";
        User user = new User();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, no);
            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {
                    user.setNo(rst.getString("cj_No02").trim());
                    user.setRole(rst.getString("cj_Role02").trim());
                    user.setPassword(rst.getString("cj_Password02").trim());
                } else {
                    return null;
                }
            }
        } catch (Exception se) {
            return null;
        }
        return user;
    }

    /**
     * 根据教师编号查找教师
     *
     * @param no
     * @return
     */
    public Teacher findByTNO(String no) {
        String sql = "SELECT * FROM chengj_Teachers02 WHERE cj_Tno02=?";
        Teacher teacher = new Teacher();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, no);
            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {
                    teacher.setNo(rst.getString("cj_Tno02").trim());
                    teacher.setName(rst.getString("cj_Tname02").trim());
                    teacher.setSex(rst.getString("cj_Tsex02").trim());
                    teacher.setAge(rst.getInt("cj_Tage02"));
                    teacher.setTitle(rst.getString("cj_Ttitle02").trim());
                    teacher.setPhone(rst.getString("cj_Tphone02").trim());
                } else {
                    return null;
                }
            }
        } catch (Exception se) {
            return null;
        }
        return teacher;
    }

    /**
     * 根据学生编号查找学生
     *
     * @param no
     * @return
     */
    public Student findBySNO(String no) {
        String sql = "SELECT * FROM StudentsInfo WHERE cj_Sno02=?";
        Student student = new Student();
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, no);
            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {
                    student.setNo(rst.getString("cj_Sno02").trim());
                    student.setName(rst.getString("cj_Sname02").trim());
                    student.setSex(rst.getString("cj_Ssex02").trim());
                    student.setAge(rst.getInt("cj_Sage02"));
                    student.setPlace(rst.getString("cj_Splace02").trim());
                    student.setCredit(rst.getInt("cj_Scredit02"));
                    student.setClassNo(rst.getString("cj_ClassNo02").trim());
                    student.setClassName(rst.getString("cj_ClassName02").trim());
                    student.setMajorNo(rst.getString("cj_MajorNo02").trim());
                    student.setMajorName(rst.getString("cj_MajorName02").trim());
                } else {
                    return null;
                }
            }
        } catch (SQLException se) {
            return null;
        }
        return student;
    }

    /**
     * 根据教师编号查找教师任课
     *
     * @param no
     * @return
     */
    public ArrayList<Course> findCourseByTNO(String no) {
        String sql = "SELECT * FROM Teaching WHERE cj_Tno02=?";
        ArrayList<Course> courseList = new ArrayList<Course>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, no);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Course course = new Course();
                    course.setCourseNo(rst.getString("cj_Cno02").trim());
                    course.setCourseName(rst.getString("cj_Cname02").trim());
                    course.setHour(rst.getInt("cj_Hour02"));
                    course.setType(rst.getString("cj_Type02").trim());
                    course.setCredit(rst.getInt("cj_Credit02"));
                    course.setAvg(rst.getDouble("avg_Tno_Cno"));
                    courseList.add(course);
                }
                return courseList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据学生编号查找学生成绩
     *
     * @param no
     * @return
     */
    public ArrayList<Course> findGradeBySNO(String no) {
        String sql = "SELECT * FROM Grades WHERE cj_Sno02=?";
        ArrayList<Course> courseList = new ArrayList<Course>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, no);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Course course = new Course();
                    course.setCourseNo(rst.getString("cj_Cno02").trim());
                    course.setCourseName(rst.getString("cj_Cname02").trim());
                    course.setHour(rst.getInt("cj_Hour02"));
                    course.setType(rst.getString("cj_Type02").trim());
                    course.setCredit(rst.getInt("cj_Credit02"));
                    course.setPoint(rst.getDouble("Point"));
                    course.setYear(rst.getString("cj_Year02").trim());
                    course.setTerm(rst.getInt("cj_Term02"));
                    course.setGrade(rst.getInt("cj_Grade02"));
                    courseList.add(course);
                }
                return courseList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查找所有学生成绩
     *
     * @return
     */
    public ArrayList<Course> findAllGrade() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        String sql = "SELECT * FROM Grades";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while (rst.next()) {
                Course course = new Course();
                course.setNo(rst.getString("cj_Sno02").trim());
                course.setName(rst.getString("cj_Sname02").trim());
                course.setCourseNo(rst.getString("cj_Cno02").trim());
                course.setCourseName(rst.getString("cj_Cname02").trim());
                course.setHour(rst.getInt("cj_Hour02"));
                course.setType(rst.getString("cj_Type02").trim());
                course.setCredit(rst.getInt("cj_Credit02"));
                course.setPoint(rst.getDouble("Point"));
                course.setYear(rst.getString("cj_Year02").trim());
                course.setTerm(rst.getInt("cj_Term02"));
                course.setGrade(rst.getInt("cj_Grade02"));
                courseList.add(course);
            }
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询所有教师的基本信息
     *
     * @return
     */
    public ArrayList<Teacher> findAllTeacher() {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        String sql = "SELECT * FROM chengj_Teachers02";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while (rst.next()) {
                Teacher teacher = new Teacher();
                teacher.setNo(rst.getString("cj_Tno02").trim());
                teacher.setName(rst.getString("cj_Tname02").trim());
                teacher.setSex(rst.getString("cj_Tsex02").trim());
                teacher.setAge(rst.getInt("cj_Tage02"));
                teacher.setTitle(rst.getString("cj_Ttitle02").trim());
                teacher.setPhone(rst.getString("cj_Tphone02").trim());
                teacherList.add(teacher);
            }
            return teacherList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询所有学生的基本信息
     *
     * @return
     */
    public ArrayList<Student> findAllStudent() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        String sql = "SELECT * FROM StudentsInfo";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while (rst.next()) {
                Student student = new Student();
                student.setNo(rst.getString("cj_Sno02").trim());
                student.setName(rst.getString("cj_Sname02").trim());
                student.setSex(rst.getString("cj_Ssex02").trim());
                student.setAge(rst.getInt("cj_Sage02"));
                student.setPlace(rst.getString("cj_Splace02").trim());
                student.setCredit(rst.getInt("cj_Scredit02"));
                student.setClassNo(rst.getString("cj_ClassNo02").trim());
                student.setClassName(rst.getString("cj_ClassName02").trim());
                student.setMajorNo(rst.getString("cj_MajorNo02").trim());
                student.setMajorName(rst.getString("cj_MajorName02").trim());
                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询所有学生的基本信息(包括GPA)
     *
     * @return
     */
    public ArrayList<Student> findStudentGPA() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        String sql = "SELECT * FROM StudentsInfoGPA ORDER BY GPA DESC";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while (rst.next()) {
                Student student = new Student();
                student.setNo(rst.getString("cj_Sno02").trim());
                student.setName(rst.getString("cj_Sname02").trim());
                student.setSex(rst.getString("cj_Ssex02").trim());
                student.setAge(rst.getInt("cj_Sage02"));
                student.setPlace(rst.getString("cj_Splace02").trim());
                student.setCredit(rst.getInt("cj_Scredit02"));
                student.setClassNo(rst.getString("cj_ClassNo02").trim());
                student.setClassName(rst.getString("cj_ClassName02").trim());
                student.setMajorNo(rst.getString("cj_MajorNo02").trim());
                student.setMajorName(rst.getString("cj_MajorName02").trim());
                student.setGpa(rst.getDouble("GPA"));
                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查找所有班级
     *
     * @return
     */
    public ArrayList<com.model.System> findAllClasses() {
        ArrayList<com.model.System> systemList = new ArrayList<com.model.System>();
        String sql = "SELECT cj_ClassNo02,cj_ClassName02,chengj_Classes02.cj_MajorNo02,cj_MajorName02 \n" +
                "FROM chengj_Classes02,chengj_Major02 \n" +
                "WHERE chengj_Classes02.cj_MajorNo02=chengj_Major02.cj_MajorNo02";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while (rst.next()) {
                com.model.System system = new com.model.System();
                system.setClassNo(rst.getString("cj_ClassNo02").trim());
                system.setClassName(rst.getString("cj_ClassName02").trim());
                system.setMajorNo(rst.getString("cj_MajorNo02").trim());
                system.setMajorName(rst.getString("cj_MajorName02").trim());
                systemList.add(system);
            }
            return systemList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查找所有专业
     *
     * @return
     */
    public ArrayList<com.model.System> findAllMajor() {
        ArrayList<com.model.System> systemList = new ArrayList<com.model.System>();
        String sql = "SELECT cj_MajorNo02,cj_MajorName02 FROM chengj_Major02";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while (rst.next()) {
                com.model.System system = new System();
                system.setMajorNo(rst.getString("cj_MajorNo02").trim());
                system.setMajorName(rst.getString("cj_MajorName02").trim());
                systemList.add(system);
            }
            return systemList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查找所有课程
     *
     * @return
     */
    public ArrayList<Course> findAllCourses() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        String sql = "SELECT * FROM chengj_Courses02";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while (rst.next()) {
                Course course = new Course();
                course.setCourseNo(rst.getString("cj_Cno02").trim());
                course.setCourseName(rst.getString("cj_Cname02").trim());
                course.setHour(rst.getInt("cj_Hour02"));
                course.setType(rst.getString("cj_Type02").trim());
                course.setCredit(rst.getInt("cj_Credit02"));
                courseList.add(course);
            }
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查找所有课程信息(包括平均成绩)
     *
     * @return
     */
    public ArrayList<Course> findAllCoursesAvg() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        String sql = "SELECT chengj_Courses02.cj_Cno02,cj_Cname02,cj_Hour02,cj_Credit02,cj_Type02,avg_Cno\n" +
                "FROM chengj_Courses02,Cno_Avg\n" +
                "WHERE chengj_Courses02.cj_Cno02=Cno_Avg.cj_Cno02";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while (rst.next()) {
                Course course = new Course();
                course.setCourseNo(rst.getString("cj_Cno02").trim());
                course.setCourseName(rst.getString("cj_Cname02").trim());
                course.setHour(rst.getInt("cj_Hour02"));
                course.setType(rst.getString("cj_Type02").trim());
                course.setCredit(rst.getInt("cj_Credit02"));
                course.setAvg(rst.getInt("avg_Cno"));
                courseList.add(course);
            }
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 班级开设课程
     *
     * @return
     */
    public ArrayList<Course> findClassCourse() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        String sql = "SELECT * FROM ClassesCourses";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while (rst.next()) {
                Course course = new Course();
                course.setClassNo(rst.getString("cj_ClassNo02").trim());
                course.setClassName(rst.getString("cj_ClassName02").trim());
                course.setCourseNo(rst.getString("cj_Cno02").trim());
                course.setCourseName(rst.getString("cj_Cname02").trim());
                course.setHour(rst.getInt("cj_Hour02"));
                course.setType(rst.getString("cj_Type02").trim());
                course.setCredit(rst.getInt("cj_Credit02"));
                courseList.add(course);
            }
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 组合条件模糊查询教师
     *
     * @param condition
     * @return
     */
    public ArrayList<Teacher> findByTCondition(Map<String, String[]> condition) {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        String sql = "SELECT * FROM chengj_Teachers02 where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            //排除type条件参数
            if ("type".equals(key)) {
                continue;
            }
            //排除role条件参数
            if ("role".equals(key)) {
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ?");
            }
        }
        sql = sb.toString();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int i = 1;
            for (String key : keySet) {
                //排除type条件参数
                if ("type".equals(key)) {
                    continue;
                }
                //排除role条件参数
                if ("role".equals(key)) {
                    continue;
                }
                String value = condition.get(key)[0];
                if (value != null && !"".equals(value)) {
                    pstmt.setString(i++, "%" + value + "%");
                }
            }
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setNo(rst.getString("cj_Tno02").trim());
                    teacher.setName(rst.getString("cj_Tname02").trim());
                    teacher.setSex(rst.getString("cj_Tsex02").trim());
                    teacher.setAge(rst.getInt("cj_Tage02"));
                    teacher.setTitle(rst.getString("cj_Ttitle02").trim());
                    teacher.setPhone(rst.getString("cj_Tphone02").trim());
                    teacherList.add(teacher);
                }
            }
        } catch (SQLException se) {
            return null;
        }
        return teacherList;
    }

    /**
     * 组合条件模糊查询学生
     *
     * @param condition
     * @return
     */
    public ArrayList<Student> findBySCondition(Map<String, String[]> condition) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        String sql = "SELECT * FROM StudentsInfo where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            String value = condition.get(key)[0];
            //排除type条件参数
            if ("type".equals(key)) {
                continue;
            }
            //排除role条件参数
            if ("role".equals(key)) {
                continue;
            }
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ?");
            }
        }
        sql = sb.toString();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int i = 1;
            for (String key : keySet) {
                //排除type条件参数
                if ("type".equals(key)) {
                    continue;
                }
                //排除role条件参数
                if ("role".equals(key)) {
                    continue;
                }
                String value = condition.get(key)[0];
                if (value != null && !"".equals(value)) {
                    pstmt.setString(i++, "%" + value + "%");
                }
            }
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Student student = new Student();
                    student.setNo(rst.getString("cj_Sno02").trim());
                    student.setName(rst.getString("cj_Sname02").trim());
                    student.setSex(rst.getString("cj_Ssex02").trim());
                    student.setAge(rst.getInt("cj_Sage02"));
                    student.setPlace(rst.getString("cj_Splace02").trim());
                    student.setCredit(rst.getInt("cj_Scredit02"));
                    student.setClassNo(rst.getString("cj_ClassNo02").trim());
                    student.setClassName(rst.getString("cj_ClassName02").trim());
                    student.setMajorNo(rst.getString("cj_MajorNo02").trim());
                    student.setMajorName(rst.getString("cj_MajorName02").trim());
                    studentList.add(student);
                }
            }
        } catch (SQLException se) {
            return null;
        }
        return studentList;
    }

    /**
     * 组合条件查询学生成绩(根据成绩降序)
     *
     * @param condition
     * @return
     */
    public ArrayList<Course> findByGCondition(Map<String, String[]> condition) {
        ArrayList<Course> courseList = new ArrayList<Course>();
        String sql = "SELECT * FROM Grades where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            //排除role条件参数
            if ("role".equals(key)) {
                continue;
            }
            //排除query条件参数
            if ("query".equals(key)) {
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ?");
            }
        }
        sb.append(" ORDER BY cj_Grade02 DESC");
        sql = sb.toString();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int i = 1;
            for (String key : keySet) {
                if ("role".equals(key)) {
                    continue;
                }
                if ("query".equals(key)) {
                    continue;
                }
                String value = condition.get(key)[0];
                if (value != null && !"".equals(value)) {
                    pstmt.setString(i++, "%" + value + "%");
                }
            }
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Course course = new Course();
                    course.setNo(rst.getString("cj_Sno02").trim());
                    course.setName(rst.getString("cj_Sname02").trim());
                    course.setCourseNo(rst.getString("cj_Cno02").trim());
                    course.setCourseName(rst.getString("cj_Cname02").trim());
                    course.setHour(rst.getInt("cj_Hour02"));
                    course.setType(rst.getString("cj_Type02").trim());
                    course.setCredit(rst.getInt("cj_Credit02"));
                    course.setPoint(rst.getDouble("Point"));
                    course.setYear(rst.getString("cj_Year02").trim());
                    course.setTerm(rst.getInt("cj_Term02"));
                    course.setGrade(rst.getInt("cj_Grade02"));
                    courseList.add(course);
                }
            }
        } catch (SQLException se) {
            return null;
        }
        return courseList;
    }
}
