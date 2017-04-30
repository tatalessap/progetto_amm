<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>loginNerdBook</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Marta Pibiri">
        <meta name="keywords" content="login loginnerd loginnuovo registrazione">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">

    </head>
    <body>
<!--        <header>
            <h1>Login-NerdBook</h1>
                <div class="collegamentiesterni">
                    <nav>
                        <ul>
                            <li><a href="bacheca.html">Bacheca Personale</a></li>
                            <li><a href="descrizione.html">Login</a></li>
                            <li><a href="profilo.html">Profilo Personale</a></li>
                        </ul>
                    </nav>
                </div>
        </header>-->
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>
        <div id="DescrizioneLogin" class="iscrizioneLogin">
            
                <h3 id="titoloLogin">NerdBook:</h3>
                
                <div class="InserisciDati">
                    
                    <form action="Login" method ="post">
                        <label for="username">Username:</label>
                        <input type="text" name="username" id="username"/>
                        <label for="password">Password:</label>
                        <input type="password" name="password" id="password"  />
                        
                        <button type="submit">Conferma</button>
                    </form>
                </div>
        </div>
    </body>
</html>
