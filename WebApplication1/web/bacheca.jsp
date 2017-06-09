<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="Modelli.classi.UtentiRegistrati"%>

<!DOCTYPE html>
<!--Visualizzazione della bacheca con i propri post personali e possibilità di accedere alle bacheche degli altri-->

<html>
    <head>
        <title>Bacheca-NerdBook</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Marta Pibiri">
        <meta name="keywords" content="bachecaNerdbook">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/javascript.js"></script>
    </head>

    <body>
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="latosx.jsp"/>

        <div class="bacheca">
            <div class="post">
                <p>${post.utente.biografia}</p>
            </div>
            <div class="nuovopost">
                <jsp:include page="nuovopost.jsp"/>
            </div>
                   
            <!--            Ciclo per poter visualizzare i post del singolo utene o di altri utenti, dove vengono richiamati nome, cognome, immagine visualizzata in piccolo e post-->
            <div id="posts">
                 <c:forEach var="post" items="${posts}">
                     <div class="post">
                         <div id="${post.utente.nomeUtente}" class="profilo">
                             <img title="profilo${post.utente.nomeUtente}" alt="Foto${post.utente.nomeUtente}" src="${post.utente.url}" >
                             <h2><a href="#indirizzo_profilo">${post.utente.nomeUtente} ${post.utente.cognomeUtente} </a></h2>
                         </div>
                         <div class="post_testo">
                             <c:if test="${not empty post.allegato}"><img title="im" alt="imm"
                                  src="${post.allegato}" > </c:if>
                             <p>${post.content}</p>
                         </div>
                     </div>
                 </c:forEach>
            </div>     
        </div>
    </body>
</html>


