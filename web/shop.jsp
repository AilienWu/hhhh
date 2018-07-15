<%-- 
    Document   : shop
    Created on : 2018-7-6, 3:41:19
    Author     : 淡色Ailien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome</title>
    </head>
    <body>
        <h1>Welcome my hero!</h1>
        <%
            String user=(String)request.getAttribute("us");
            String pass=(String)request.getAttribute("pa");
            String name=(String)request.getAttribute("na");
        %>
        <h2>my hero's name is <%=name%><br>    
        </h2>
        
        <h3>
            <form action="order" method="post">
            选购sss的数量：<input type="text" name="numsss"/><br>
            选购xxx的数量：<input type="text" name="numxxx"/><br>
            选购hhh的数量：<input type="text" name="numhhh"/><br>
            <input type="submit" value="确认添加到购物车"/>
            </form>
        </h3>
        
    </body>
</html>
