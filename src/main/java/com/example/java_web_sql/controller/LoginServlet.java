package com.example.java_web_sql.controller;

import com.example.java_web_sql.service.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        Connection connection = null;
        String sql = "select * from users where email = ? and name =?";


        try {
            connection = UserDAO.connection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);

            ResultSet row = preparedStatement.executeQuery();
            if (row.next()){
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/Home.jsp");
                dispatcher.forward(req, resp);
            }else {
                req.setAttribute("error","Tên đăng nhập hoặc mật khẩu không đúng!");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/Login.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
