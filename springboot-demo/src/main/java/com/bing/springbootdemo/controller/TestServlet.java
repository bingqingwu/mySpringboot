package com.bing.springbootdemo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/myServlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String userId = req.getParameter("userId");
        String classId = req.getParameter("classId");
        resp.getWriter().write("userId=" + userId + ",classId=" + classId);
    }
}
