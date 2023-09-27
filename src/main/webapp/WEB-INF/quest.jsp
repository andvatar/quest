<%--
  Created by IntelliJ IDEA.
  User: antar
  Date: 27.09.2023
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
    <form class="form-horizontal"  action="question-servlet" method="get">
        <fieldset>

            <!-- Form Name -->
            <legend>${requestScope.quest.getDescription()}</legend>
            <input type="text" name="nextQuestionId" id="nextQuestionId" value=${requestScope.quest.getStartQuestionId()} hidden>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="playerName">Представьтесь</label>
                <div class="col-md-4">
                    <input id="playerName" name="playerName" type="text" class="form-control input-md" value=${sessionScope.playerName}>

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="startQuest"></label>
                <div class="col-md-4">
                    <button id="startQuest" name="startQuest" class="btn btn-primary">Начать</button>
                </div>
            </div>

        </fieldset>
    </form>

    Статистика: <br>
    Количество игр: ${sessionScope.gameCounter} <br>
    Имя игрока: ${sessionScope.playerName}

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
