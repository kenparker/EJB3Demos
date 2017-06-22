<%-- 
    Document   : index
    Created on : 21.06.2017, 16:11:17
    Author     : maggioni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Names Example</h1>
        <form action="NamesServlet" method="get">
            name: <input type="text" name="name" /><br>
            <input type="submit" value="add Name" />
        </form>
    </body>
</html>
