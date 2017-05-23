<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <title>Profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Marta Pibiri">
        <meta name="keywords" content="profilo profilonerdbook nerdbook datiNerdbook">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">

    </head>
    <!--    pagina profilo in cui si inseriscono i dati dell'utente e dove viene reinderizzato in caso non abbia compleato tutti i campi.-->
    <body>

        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="latosx.jsp"/>


        <div class="Pic">
            <img title="profiloTenente" alt="FotoDiTenente"
                 src="img/tenente_colombo.jpg" width="450" height="325">
        </div>


        <div class="login_profilo">
            <!--Informazioni personali dell'utente -->
            <form action="Profilo?salva=true" method="post">
                <div id="datiutente"> 
                    <div class="textareaa">
                        <!--                        inserimento dei dati dell'utente tramite Servlet-->
                        <label for="nomeUtente">Nome:</label>
                        <input type="text" name="nomeUtente" placeholder="Inserisci il tuo nome"
                               id="nomeUtente"
                               <c:if test="${not empty nome}">value="${nome}"</c:if>
                               <c:if test="${not empty utente.nomeUtente}">value="${utente.nomeUtente}"</c:if>>
                        </div>
                        <div class="textareaa">
                            <label for="cognome">Cognome:</label>
                            <input type="text" name="cognome" placeholder="Inserisci il tuo cognome"
                                   id="cognome"
                            <c:if test="${not empty cognome}">value="${cognome}"</c:if>
                            <c:if test="${not empty utente.cognomeUtente}">value="${utente.cognomeUtente}"</c:if>>

                        </div>

                        <div class="textareaa">
                            <label for="immagine">Url immagine profilo:</label>
                            <input type="text" name="immagine" placeholder="Inserisci URL della tua immagine"
                                   id="immagine"
                            <c:if test="${not empty immagine}">value="${immagine}"</c:if>
                            <c:if test="${not empty utente.url}">value="${utente.url}"</c:if>>

                        </div>
                        <!--Descrizione personale utente-->
                        <div class="textareaa">
                            <label for="biografia">Inserisci la tua biografia:</label>
                            <input type="textarea" name="biografia" placeholder="Inserisci la tua biografia"
                                   id="fraseDescrizione"
                            <c:if test="${not empty biografia}">value="${biografia}"</c:if>
                            <c:if test="${not empty utente.biografia}">value="${utente.biografia}"</c:if>>

                            </textarea>
                        </div>

                        <div class="textareaa">
                            <label for="date">Data di nascita:</label>
                            <input type="date" name="date" placeholder="Data di nascita:"
                                   id="date"
                            <c:if test="${not empty date}">value="${date}"</c:if>
                            <c:if test="${not empty utente.dataNascita}">value="${utente.dataNascita}"</c:if>>

                        </div>
                        <div class="textareaa">
                            <label for="password">Inserisci la tua password:</label>
                            <input type="password" name="password" placeholder="Inserisci la tua password"
                                   id="password"
                            <c:if test="${not empty password}">value="${password}"</c:if>
                            <c:if test="${not empty utente.password}">value="${utente.password}"</c:if>>
                        </div>
                        <div class="textareaa">
                            <label for="Confermapassword">Conferma password:</label>
                            <input type="password" name="Confermapswd" placeholder="Conferma la tua password"
                                   id="Confermapassword" />
                        </div>
                    </div>
                    <!--pulsante per l'aggiornamento dei dati-->
                    <div id="aggiorna"> <input type="submit" value="Aggiorna"/> </div>
                </form>
                        
                <div class="cancellazioneProfilo">
                    <div class="bottoni">
                        <form action="Profilo?cancellaProfilo=true" method="post">
                        <input type="submit" value="Elimina Profilo">
                    </form>
                    </div>
                    <div class="bottoni">
                        <form action="Profilo?cancellaBacheca=true" method="post">
                        <input type="submit" value="Elimina Bacheca">
                    </form>
                        
                    </div>
                    
                    
    
                </div>
            </div>
        <c:if test="${salva != null}"> <h2>conferma dati inviati</h2> </c:if>
    </body>
</html>
