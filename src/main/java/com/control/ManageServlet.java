package com.control;

import com.dao.FindDao;
import com.model.Course;
import com.model.Student;
import com.model.System;
import com.model.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manageServlet")
public class ManageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String role = request.getParameter("role");
        String manage = request.getParameter("manage");
        FindDao dao = new FindDao();
        String page = null;
        if ("classes".equals(manage)) {
            ArrayList<System> systemList = dao.findAllClasses();
            request.setAttribute("systemList", systemList);
            page = "/manage.jsp";
        }
        if ("major".equals(manage)) {
            ArrayList<System> systemList = dao.findAllMajor();
            request.setAttribute("systemList", systemList);
            page = "/manage.jsp";
        }
        if ("course".equals(manage)) {
            ArrayList<Course> courseList = dao.findAllCourses();
            request.setAttribute("courseList", courseList);
            page = "/manage.jsp";
        }
        if ("teacher".equals(manage)) {
            ArrayList<Teacher> teacherList = dao.findAllTeacher();
            request.setAttribute("teacherList", teacherList);
            page = "/teacherMesList.jsp";
        }
        if ("student".equals(manage)) {
            ArrayList<Student> studentList = dao.findAllStudent();
            request.setAttribute("studentList", studentList);
            page = "/studentMesList.jsp";
        }
        request.setAttribute("role", role);
        request.setAttribute("manage", manage);
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }
}
