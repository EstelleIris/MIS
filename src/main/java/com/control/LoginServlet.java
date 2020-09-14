package com.control;

import com.dao.FindDao;
import com.model.Student;
import com.model.Teacher;
import com.model.User;
import com.utils.Sha256;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        FindDao dao = new FindDao();
        String loginMessage = null;
        String page = null;
        String type = request.getParameter("type");
        String no = request.getParameter("no");
        String password = request.getParameter("password");
        password = Sha256.getSHA256(password);
        User user = dao.findByNO(no);
        if (user != null && password.equals(user.getPassword().trim())) {
            page = "/index.jsp";
            if ("教师".equals(user.getRole().trim())) {
                Teacher teacher = dao.findByTNO(no);
                request.getSession().setAttribute("teacher", teacher);
            }
            if ("学生".equals(user.getRole().trim())) {
                Student student = dao.findBySNO(no);
                request.getSession().setAttribute("student", student);
            }
        } else {
            loginMessage = "登录失败！";
            page = "/login.jsp";
        }
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("loginMessage", loginMessage);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
        rd.forward(request, response);
    }
}
