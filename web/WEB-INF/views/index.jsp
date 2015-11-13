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
    <div id="test">
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
    </div>

    <script>
      document.body.addEventListener("keydown", function(e) {

        var xhr = new XMLHttpRequest();

        var body = 'option=' + encodeURIComponent("" + e.keyCode);

        xhr.open("POST", "/", true)
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')

        xhr.onreadystatechange = function()
        {
          if (xhr.readyState == 4 && xhr.status == 200)
          {

          }
        }

        xhr.send(body);

        console.log(e.keyCode);
      });
    </script>
  </body>
</html>
