package com.control;

import com.dao.AddDao;
import com.model.Student;
import com.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        AddDao dao = new AddDao();
        String type = request.getParameter("type");
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String _age = request.getParameter("age");
        int age = Integer.parseInt(_age);
        if (type != null && "teacher".equals(type)) {
            String title = request.getParameter("title");
            String phone = request.getParameter("phone");
            Teacher teacher = new Teacher(no, name, sex, age, title, phone);
            boolean success = dao.addTeacher(teacher);
        }
        if (type != null && "student".equals(type)) {
            String place = request.getParameter("place");
            String _credit = request.getParameter("credit");
            int credit = Integer.parseInt(_credit);
            String classNo = request.getParameter("classNo");
            String className = request.getParameter("className");
            String majorNo = request.getParameter("majorNo");
            String majorName = request.getParameter("majorName");
            Student student = new Student(no, name, sex, age, place, credit, classNo, className, majorNo, majorName);
            boolean success = dao.addStudent(student);
        }
        type = URLEncoder.encode(type, "utf-8");
        response.sendRedirect(request.getContextPath() + "/manageServlet?manage=" + type);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
