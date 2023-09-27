package ru.javarush.tarasov.quest.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.javarush.tarasov.quest.entity.Question;
import ru.javarush.tarasov.quest.service.QuestionService;

import java.io.IOException;

@WebServlet(name = "question-servlet", value = "/question-servlet")
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId;
        RequestDispatcher requestDispatcher;
        if(request.getParameter("playerName") != null) {
            request.getSession().setAttribute("playerName", request.getParameter("playerName"));
        }
        if(request.getParameter("nextQuestionId") != null)
        {
            questionId = request.getParameter("nextQuestionId");
        }
        else {
            throw new RuntimeException("Cannot find the next question");
        }
        QuestionService questionService = new QuestionService();
        Question question = questionService.getQuestionById(Integer.parseInt(questionId));
        request.setAttribute("question", question);

        if(!question.getAnswers().isEmpty()) {
            requestDispatcher = request.getRequestDispatcher("WEB-INF/question.jsp");
        }
        else {
            requestDispatcher = request.getRequestDispatcher("WEB-INF/result.jsp");
        }
        requestDispatcher.forward(request, response);
    }

}