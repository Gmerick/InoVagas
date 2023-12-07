<%-- 
    Document   : resultado
    Created on : 6 de dez. de 2023, 18:35:26
    Author     : stock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resultado</title>
    <script src="main.js"></script>
</head>
<body>
    <div>
        <h1>Resultado:</h1>
        <p><%= request.getAttribute("msg") %></p>
    </div>
</body>
</html>
