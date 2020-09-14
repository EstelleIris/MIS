package com.control;

import com.dao.AddDao;
import com.model.System;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/addSystemServlet")
public class AddSystemServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        AddDao dao = new AddDao();
        String manage = request.getParameter("manage");
        if ("classes".equals(manage)) {
            String classNo = request.getParameter("classNo");
            String className = request.getParameter("className");
            String majorNo = request.getParameter("majorNo");
            String majorName = request.getParameter("majorName");
            System system = new System(classNo, className, majorNo, majorName);
            boolean success = dao.addSystem(system);
        }
        if ("major".equals(manage)) {
            String majorNo = request.getParameter("majorNo");
            String majorName = request.getParameter("majorName");
            System major = new System(majorNo, majorName);
            boolean success = dao.addMajor(major);
        }
        manage = URLEncoder.encode(manage, "utf-8");
        response.sendRedirect(request.getContextPath() + "/manageServlet?manage=" + manage);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
