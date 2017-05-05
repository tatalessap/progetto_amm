<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
    <!--       barra superiore a cui poter accedere ai contenuti pricipali del sito-->
    <h1>Bacheca-NerdBook</h1>
    <div class="collegamentiesterni">
        <nav>
            <ul>
                <li><a href="login.html">Login</a></li>
                <li><a href="descrizione.jsp">Descrizione</a></li>
                <li><a href="Bacheca">Bacheca</a> </li>
                <li><a href="Profilo">Profilo</a></li>
            </ul>
        </nav>
    </div>
    <!--            visualizzazione dell'utente autenticato, con nome e cognome-->
    <div class="profiloattivo">
        <h3>${utente.nomeUtente} ${utente.cognomeUtente}</h3>
        <h3><a href=Login?logout=true>Logout</a></h3>
    </div>
</header>
