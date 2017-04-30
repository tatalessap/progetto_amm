<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="Modelli.UtentiRegistrati"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Bacheca-NerdBook</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Marta Pibiri">
        <meta name="keywords" content="bachecaNerdbook">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>

    <body>
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>

        <jsp:include page="latosx.jsp"/>


        <div class="bacheca">
            <!--Esempi-->
            <div id="posts"
                 <c:forEach var="post" items="${posts}">
                     <div class="post">
                         <div id="${post.utente.nome}" class="profilo">
                             <img title="profilo${post.utente.nome}" alt="Foto${post.utente.nome}" src="${post.utente.url}" width="630" height="400">
                             <h2><a href="#indirizzo_Hackerino">${post.utente.nome} ${post.utente.cognome} </a></h2>
                         </div>
                         <div class="post_testo">
                             <c:if test="${not empty post.image}"><img title="im" alt="imm"
                                  src="${post.image}" width="480" height="360"> </c:if>
                             <p>${post.content}</p>
                         </div>
                     </div>
                 </c:forEach>
            </div>     
        </div>
    </body>
</html>


