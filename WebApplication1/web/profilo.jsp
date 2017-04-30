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
                <form action="Profile.asp" method="get">
                    <!--Nome dell'utente -->
                    <div id="datiutente"> 
                        <div class="textareaa">
                                <label for="nome">Nome:</label>
                                <input type="text" name="nome" placeholder="Inserisci il tuo nome"
                                       id="nome"/>
                        </div>
                        <div class="textareaa">
                             <!--Cognome dell'utente-->
                                <label for="cognome">Cognome:</label>
                                <input type="text" name="cognome" placeholder="Inserisci il tuo cognome"
                                       id="cognome"/>
                        </div>
                                <!--Immagine profilo utente-->
                        <div class="textareaa">
                                <label for="urlImmagine">URL Immagine:</label> 
                                <input type="url" name="immagine" placeholder="Inserisci URL della tua immagine"
                                       id="urlImmagine" />
                        </div>
                                <!--Descrizione personale utente-->
                        <div class="textareaa">
                                <label for="fraseDescrizione">Biografia:</label>
                                <textarea rows="7" cols="20"
                                          name="fraseDescrizione"
                                          id="fraseDescrizione">
                                          
                                </textarea>
                        </div>
                                <!--Data di nascita-->
                        <div class="textareaa">
                                <label for="date">Data di nascita:</label>
                                <input type="date" name="date" id="date"/>
                        </div>
                        <div class="textareaa">
                                <!--Password utente -->
                                <label for="password">Password:</label>
                                <input type="password" name="pswd" placeholder="Inserisci la tua password"
                                       id="password" />
                        </div>
                        <div class="textareaa">
                                <label for="Confermapassword">Conferma password:</label>
                                <input type="password" name="Confermapswd" placeholder="Conferma la tua password"
                                       id="Confermapassword" />
                        </div>
                    </div>
                    
                    <div id="aggiorna"> <input type="submit" value="Aggiorna"/> </div>
                    
                </form>  
            </div>
    </body>
</html>
