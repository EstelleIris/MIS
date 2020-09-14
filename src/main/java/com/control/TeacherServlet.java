package com.control;

import com.dao.FindDao;
import com.model.Course;
import com.model.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/teacherServlet")
public class TeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        FindDao dao = new FindDao();
        String page = null;
        String no = request.getParameter("no");
        String role = request.getParameter("role");
        String query = request.getParameter("query");
        Teacher teacher = dao.findByTNO(no);
        request.setAttribute("teacher", teacher);
        if ("info".equals(query)) {
            page = "/teacherMes.jsp";
        }
        if ("teach".equals(query)) {
            ArrayList<Course> courseList = dao.findCourseByTNO(no);
            request.setAttribute("courseList", courseList);
            page = "/teacherCourse.jsp";
        }
        request.setAttribute("role", role);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
        rd.forward(request, response);
    }
}
