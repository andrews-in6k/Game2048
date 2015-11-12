<%@ page import="game2048.gameFieldHandling.GameField" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/12/15
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Game 2048</title>
  </head>
  <body>
    <%GameField gameField = (GameField)session.getAttribute("gameField");%>
      <table>
      <%
      for (int i = 0; i < 4; i++) {
      %>
        <tr>
        <%
        for (int j = 0; j < 4; j++) {
        %>
            <td>
              <%=gameField.getCells()[i][j].getCellValue()%>
            </td>
        <%
        }
        %>
        </tr>
        <%
      }
      %>
      </table>

    <a href="/action/1">new</a>
    <a href="/action/8">up</a>
    <a href="/action/5">down</a>
    <a href="/action/4">left</a>
    <a href="/action/6">right</a>
  </body>
</html>
