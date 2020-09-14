package com.control;

import com.dao.FindDao;
import com.model.Course;
import com.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/studentListServlet")
public class StudentListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        FindDao dao = new FindDao();
        String page = null;
        String no = request.getParameter("no");
        String role = request.getParameter("role");
        String query = request.getParameter("query");
        if ("grade".equals(query)) {
            ArrayList<Course> courseList = dao.findAllGrade();
            request.setAttribute("courseList", courseList);
            page = "/studentGradeList.jsp";
        }
        if ("gpa".equals(query)) {
            ArrayList<Student> studentGPAList = dao.findStudentGPA();
            request.setAttribute("studentGPAList", studentGPAList);
            page = "/gpaList.jsp";
        }
        if ("courseAvg".equals(query)) {
            ArrayList<Course> courseAvgList = dao.findAllCoursesAvg();
            request.setAttribute("courseAvgList", courseAvgList);
            page = "/coursesAvgList.jsp";
        }
        if ("classCourse".equals(query)) {
            ArrayList<Course> classCourseList = dao.findClassCourse();
            request.setAttribute("classCourseList", classCourseList);
            page = "/classesCourses.jsp";
        }
        request.setAttribute("no", no);
        request.setAttribute("role", role);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        FindDao dao = new FindDao();
        String page = null;
        String role = request.getParameter("role");
        String query = request.getParameter("query");
        Map<String, String[]> condition = request.getParameterMap();
        if ("condition".equals(query)) {
            ArrayList<Course> courseList = dao.findByGCondition(condition);
            request.setAttribute("courseList", courseList);
            page = "/studentGradeList.jsp";
        }
        request.setAttribute("role", role);
        request.setAttribute("condition", condition);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
        rd.forward(request, response);
    }
}
