package controller;

import DTO.UserDTO;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/Registration")
public class Registration extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String passWord = request.getParameter("passWord");

        UserDTO userDTO = UserDTO.builder()
                .registrationTime(LocalDateTime.now())
                .build();

        HttpSession session = request.getSession();
        session.setAttribute("dateTimeOfRegistration",userDTO.getRegistrationTime());
        request.setAttribute("user",userDTO);

        String context = request.getContextPath();
        userService.register(login, passWord);
        response.sendRedirect(context + "/RegisterForm.jsp");
    }
}
