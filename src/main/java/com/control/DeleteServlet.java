package com.control;

import com.dao.DeleteDao;
import com.dao.FindDao;
import com.model.Course;
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

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeleteDao deleteDao = new DeleteDao();
        FindDao findDao = new FindDao();
        String type = request.getParameter("type");
        String page = null;
        if ("teacher".equals(type)) {
            String cj_Tno02 = request.getParameter("cj_Tno02");
            boolean success = deleteDao.deleteTeacher(cj_Tno02);
            ArrayList<Teacher> teacherList = findDao.findAllTeacher();
            request.setAttribute("teacherList", teacherList);
            page = "/teacherMesList.jsp";
        }
        if ("student".equals(type)) {
            String cj_Sno02 = request.getParameter("cj_Sno02");
            boolean success = deleteDao.deleteStudent(cj_Sno02);
            ArrayList<Student> studentList = findDao.findAllStudent();
            request.setAttribute("studentList", studentList);
            page = "/studentMesList.jsp";
        }
        if ("classes".equals(type)) {
            String cj_ClassNo02 = request.getParameter("cj_ClassNo02");
            boolean success = deleteDao.deleteSclass(cj_ClassNo02);
            ArrayList<com.model.System> systemList = findDao.findAllClasses();
            request.setAttribute("systemList", systemList);
            page = "/manage.jsp?manage=classes";
        }
        if ("major".equals(type)) {
            String cj_MajorNo02 = request.getParameter("cj_MajorNo02");
            boolean success = deleteDao.deleteMajor(cj_MajorNo02);
            ArrayList<com.model.System> systemList = findDao.findAllMajor();
            request.setAttribute("systemList", systemList);
            page = "/manage.jsp?manage=major";
        }
        if ("classes".equals(type)) {
            String cj_ClassNo02 = request.getParameter("cj_ClassNo02");
            boolean success = deleteDao.deleteCourse(cj_ClassNo02);
            ArrayList<Course> courseList = findDao.findAllCourses();
            request.setAttribute("courseList", courseList);
            page = "/manage.jsp?manage=course";
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
        rd.forward(request, response);
    }
}
