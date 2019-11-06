package ru.lanit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import ru.lanit.entity.Person;
import ru.lanit.service.PersonActions;

@WebServlet("/fullName")
public class FullNameServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        String dateOfBirth = request.getParameter("dateOfBirth");

        try {
            PersonActions.insert(new Person(name, surname, patronymic, dateOfBirth));
            response.getWriter().println("<h1>Пользователь сохранен успешно</h1>");
        } catch (Exception e) {
            response.getWriter().println("<h1>Ошибки</h1>");
            response.getWriter().println(e.getMessage());
        }
    }
}