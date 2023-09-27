package ru.javarush.tarasov.quest.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.javarush.tarasov.quest.entity.Quest;
import ru.javarush.tarasov.quest.service.QuestService;

import java.io.IOException;

@WebServlet(name = "quest-servlet", value = "/quest-servlet")
public class QuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestService questService = new QuestService();
        Quest quest =  questService.getById(Integer.parseInt(request.getParameter("questId")));
        request.setAttribute("quest", quest);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/quest.jsp");
        requestDispatcher.forward(request, response);
    }
}