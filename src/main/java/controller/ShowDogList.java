package controller;

import DTO.DogDTO;
import service.DogService;
import service.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowDogList")
public class ShowDogList extends HttpServlet {
    public static final int DOGS_PER_PAGE= 10;
    DogService dogService = new DogServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer dogsCount = dogService.dogsCount();
        request.setAttribute("dogsCount", dogsCount);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        request.setAttribute("currentPage",currentPage);
        List<DogDTO> list = dogService.getAllDogs(currentPage, DOGS_PER_PAGE);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/DogsList.jsp").forward(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
