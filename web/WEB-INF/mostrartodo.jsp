<%-- 
    Author     : Melani
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    
    <body >
        <h1>Todos los registros</h1>
       
    <c:forEach var="listaTotal" items="${sessionScope.personas}">
        DUI:${listaTotal.dui}<br>
         Apellidos:${listaTotal.dui}<br>
          Nombres:${listaTotal.dui}<br>
                   
    </c:forEach>
    </body>
</html>
