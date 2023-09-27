package ru.javarush.tarasov.quest.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.javarush.tarasov.quest.entity.Quest;
import ru.javarush.tarasov.quest.service.QuestService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "start-servlet", value = "/start-servlet")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("gameCounter") == null) {
            session.setAttribute("gameCounter", 0);
        }
        else {
            session.setAttribute("gameCounter", (int)session.getAttribute("gameCounter") + 1);
        }

        QuestService questService = new QuestService();
        List<Quest> questList =  questService.getAll();
        request.setAttribute("questList", questList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/start.jsp");
        requestDispatcher.forward(request, response);
    }

}