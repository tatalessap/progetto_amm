<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--JSP per la visualizzazione dell'errore in caso si tenti di accedere ad il profilo o alla bacheca senza essere autenticati-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>MessaggioDiErrore</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h1 id="mexError">Non sei autenticato!</h1>
        <br>
        <div id="box">
            <p>per poter effettuare il Login, <a href="Login"> pigia qui! </a></p>
        </div>
        
    </body>
</html>
