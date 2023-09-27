<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <title>JSP - Hello World</title>
</head>
<body>
  <h1><%= "Квесты" %></h1>
  <br/>
  <form class="form-horizontal" action="quest-servlet" method="get">
    <input type="hidden" name="nextQuestionId" value="1"/>
    <fieldset>

      <!-- Form Name -->
      <legend>Выберете квест</legend>

      <div class="form-group">
        <div class="col-md-4">
          <select id="questId" name="questId" class="form-control">
            <c:forEach var="quest" items="${requestScope.questList}">
              <option value=${quest.getId()}>${quest.getName()}</option>
            </c:forEach>
          </select>
        </div>
      </div>

      <!-- Button -->
      <div class="form-group">
        <label class="col-md-4 control-label" for="StartButton"></label>
        <div class="col-md-4">
          <button id="StartButton" name="StartButton" class="btn btn-primary">Начать квест</button>
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