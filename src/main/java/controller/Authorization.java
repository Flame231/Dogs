package controller;

import service.PasswordHasher;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/Authorization")
public class Authorization extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passWord = request.getParameter("passWord");
        String login = request.getParameter("login");

        String context = request.getContextPath();

            userService.login(login, passWord);

        response.sendRedirect(context + "/ShowDogList");
    }
}
