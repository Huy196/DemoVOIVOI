package com.example.java_web_sql.controller;

import com.example.java_web_sql.model.User;
import com.example.java_web_sql.service.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.ListUI;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = " ";
        }

        switch (action) {
            case "add":
                try {
                    addUserData(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    editUserData(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case "search":
                searchUserName(req, resp);
                break;
        }
    }

    private void editUserData(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("nameEdit");
        String email = req.getParameter("emailEdit");
        String country = req.getParameter("countryEdit");

        userDAO.updateUser(new User(id, name, email, country));

        listUser(req, resp);
    }

    private void addUserData(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        User newUser = new User(name, email, country);
        userDAO.insertUser(newUser);
        listUser(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "add":
                addUser(req, resp);
                break;
            case "list":
                listUser(req, resp);
                break;
            case "edit":
                editUser(req, resp);
                break;
            case "delete":
                try {
                    deleteUsers(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            default:
                break;
        }
    }

    private void searchUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameUser");
        List<User> users = userDAO.searchUserName(name);

        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/List.jsp");
        dispatcher.forward(req, resp);
    }
    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        User user = userDAO.selectUser(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/Edit.jsp");
        req.setAttribute("user", user);

        dispatcher.forward(req, resp);
    }
    private void deleteUsers(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(req.getParameter("id"));
        userDAO.deleteUser(id);
        listUser(req, resp);
    }
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/AddUser.jsp");
        dispatcher.forward(req, resp);
    }
    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDAO.selectAllUser();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/List.jsp");
        dispatcher.forward(req, resp);
    }
}
