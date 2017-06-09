<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>NERDBOOK: senti la forza attraverso all'amicizia</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Marta Pibiri">
        <meta name="keywords" content="nerd amici starwars aminerd bruttomanerd nerdpower">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/javascript.js"></script>

    </head>
    <body>
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>
        <!--accoglienza utente-->
        <div class="welcome">
            <div id="top">
                <h2>Benvenuti:</h2>
                <!--collegamenti e navigazione ai link della pagina-->
                <div id="collegamentiinterni">
                    <!--collegamenti alle domande interne di questo documento-->
                    <nav>
                        <ul>
                            <li><a href="#CosaVuolDireNerdBook">Cosa vuol dire NerdBook?</a></li>
                            <li><a href="#ComeFunzionaNerdBook">Come funziona NerdBook?</a></li>
                            <li><a href="#ComeIscriversi">Come iscriversi?</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="descrizione">                
                <div class="paragrafo">
                    <div id="CosaVuolDireNerdBook">
                        <h3>Cosa vuol dire NerdBook?</h3>
                    </div>
                    <p>La traduzione più vicina a "NerdBook" è faccia da nerd; ma perchè questo nome? Sostanzialmente è una piattaforma in cui tutti i nerd del mondo, possono scambiare opinioni, dialoghi, commenti e tanto altro senza essere additati dalla società moderna che non capisce le nostre passioni.</p>
                </div>

                <div id="ComeFunzionaNerdBook">
                    <h3>Come funziona NerdBook?</h3>

                    <div class="paragrafo">
                        <p>Da una idea così semplice, si ricava un funzionamento altrettanto semplice:  </p>
                        <div class="lista">
                            <nav>
                                <ul>
                                    <li>Per poter accedere devi avere un profilo: puoi effettuare il login o iscriverti <strong>GRATUITAMENTE</strong></li>
                                    <li>Puoi creare e gestire gruppi</li>
                                    <li>Puoi inserire post nella propria bacheca personale oppure lasciare messaggi in klingon ma anche in italiano, nella bacheca dei tuoi amiNerd</li>
                                    <li>Puoi gestire tu il tuo gruppo di amici; puoi chiedere l'amicizia a utenti conosciuti attraverso i gruppi ma anche non confermare le richieste da parte degli sconosciuti</li>
                                </ul>
                            </nav> 
                        </div>
                    </div> 
                </div>

                <div id="ComeIscriversi">
                    <h3>Come Iscriversi?</h3>
                    <div class="paragrafo">
                        <p>Ti basterà  inserire i tuoi dati al momento della iscrizione;</p>
                        <div class="lista">
                            <nav>
                                <ul>
                                    <li>Nome</li>
                                    <li>Cognome</li>
                                    <li>Url di una immagine del profilo</li>
                                    <li>Frase di presentazione</li>
                                    <li>Data di nascita</li>
                                    <li>Password</li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
