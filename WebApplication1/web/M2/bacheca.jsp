<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <header>
            <h1>Bacheca-NerdBook</h1>
            <div class="collegamentiesterni">
                    <nav>
                        <ul>
                            <li><a href="login.html">Login</a></li>
                            <li><a href="descrizione.html">Descrizione</a></li>
                        </ul>
                    </nav>
            </div>
            <div class="profiloattivo">
                <h3>Tenente Colombo</h3>
                <h3> <a href=#out> Logout </a> </h3>
            </div>
        </header>
        <div class="latosx">
            <input type="text" name="cerca" id="ricerca" value="Cerca.."/>
            <div id="personeLista">
                <p> Persone </p>
                    <nav>
                        <ul>
                            <li>
                                <a href=#GiulioCesare> Giulio Cesare </a>
                            </li>
                            <li>
                                <a href=#MarcoClaudioMarcello>Marco Claudio Marcello (nipote di Augusto)</a>
                            </li>
                            <li>
                                <a href=#Romolo> Romolo </a>
                            </li>
                        </ul>
                    </nav>
            </div>
            <div id="gruppi">
                <p> Gruppi </p>
                <nav>
                        <ul>
                            <li>
                                <a href=#chistava> Chi stava guardando la melevisione l'undici settembre </a>
                            </li>
                            <li>
                                <a href=#natale>X chi vuole partire a Milano per Natale</a>
                            </li>
                            <li>
                                <a href=#sette> SettePugnalate: il locale</a>
                            </li>
                        </ul>
                    </nav>
            </div>
        </div>
        <div class="bacheca">
            <!--Esempi-->
            <div id="posts">
                <!--primo post senza allegati-->
                 <div class="post">
                     <div id="profiloMark_1" class="profilo">
                        <img title="profiloMark" alt="FotoDiMark"
                             src="img/Mark.jpg" width="300" height="300">
                        <h2><a href="#indirizzo_Mark">Mark Zuckerberg </a></h2>  
                    </div>
                    <div class="post_testo">
                            <p> Fiamma! Oggi prima lezione di PR1. Solo bomba! Mi piace troppo! int i, int i=0, printf("Gia sesi acconciu"); </p>
                    </div>
                </div>
                <!--secondo post con allegata una immagine-->
                <div class="post">
                    <div id="profiloHackerino" class="profilo">
                        <img title="profiloHackerino" alt="FotoDiHackerino"
                             src="img/picHacherino.jpg" width="480" height="360">
                        <h2><a href="#indirizzo_Hackerino">Hack Rino </a></h2>
                    </div>
                    <div class="post_testo">
                            <img title="cistannotracciando" alt="FotoDiHackStaccah"
                             src="img/imhacherino.jpg" width="480" height="360">
                            <p>Ci stanno tracciando, staccaaaaaaaa</p>
                    </div>
                </div>
                <!--terzo post con allegato un link-->
                <div class="post">
                    <div id="profiloJonSudano" class="profilo">
                        <img title="profiloJonSudano" alt="FotoDiJonsudano"
                             src="img/jonsudano.jpg" width="630" height="400">
                        <h2><a href="#indirizzo_JonSudano">Jon Sudano </a></h2>
                    </div>
                    <div class="post_testo">
                        <p> Follow me and see a <a href=" https://www.youtube.com/watch?v=gTwxtYin1p0 " target="_blank"> new video </a> on Youtube </p>
                    </div>
                </div>           
            </div>     
        </div>
    </body>
</html>
