package com.control;

import com.dao.FindDao;
import com.model.Student;
import com.model.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/queryServlet")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        FindDao dao = new FindDao();
        String page = null;
        String type = request.getParameter("type");
        String role = request.getParameter("role");
        Map<String, String[]> condition = request.getParameterMap();
        /*遍历key*/
        /*for (String key : condition.keySet()) {
            System.out.println(key);
        }*/
        /*遍历value*/
        /*for (String[] value : condition.values()) {
            System.out.println(value[0]);
        }*/
        if ("teacher".equals(type)) {
            ArrayList<Teacher> teacherList = dao.findByTCondition(condition);
            request.setAttribute("teacherList", teacherList);
            page = "/teacherMesList.jsp";
        }
        if ("student".equals(type)) {
            ArrayList<Student> studentList = dao.findBySCondition(condition);
            request.setAttribute("studentList", studentList);
            page = "/studentMesList.jsp";
        }
        request.setAttribute("condition", condition);
        request.setAttribute("role", role);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
