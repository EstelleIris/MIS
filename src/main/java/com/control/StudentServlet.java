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

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
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
        Map<String, String[]> condition = request.getParameterMap();
        Student student = dao.findBySNO(no);
        request.setAttribute("student", student);
        if ("info".equals(query)) {
            page = "/studentMes.jsp";
        }
        if ("grade".equals(query)) {
            ArrayList<Course> courseList = dao.findGradeBySNO(no);
            request.setAttribute("courseList", courseList);
            page = "/studentGrade.jsp";
        }
        if ("yearTerm".equals(query)) {
            ArrayList<Course> courseList = dao.findByGCondition(condition);
            request.setAttribute("courseList", courseList);
            page = "/studentGrade.jsp";
        }
        request.setAttribute("no", no);
        request.setAttribute("role", role);
        request.setAttribute("condition", condition);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
        rd.forward(request, response);
    }
}
