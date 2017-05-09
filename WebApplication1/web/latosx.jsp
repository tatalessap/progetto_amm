<%-- 
    Document   : latosx
    Created on : 30-apr-2017, 18.40.19
    Author     : marta_nga0hmy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="latosx">
   
    
     <div id="personeLista">
        <p> Altri utenti: </p>
        <nav>
            <ul>
                <c:forEach var="listaUt" items="${listaUtenti}">                
                    <li>
                        <a href="bacheca.html?bachecadiversa=${listaUt.personalID}" > ${listaUt.nomeUtente} </a> 
                       
                    </li>                
                </c:forEach>
            </ul>
        </nav>
    </div>

    <div id="gruppi">
        <p> Gruppi: </p>
        <nav>
            <ul>
                <c:forEach var="lista" items="${listaGruppi}">                
                    <li>
                            <p>${lista.nameGroup}</p>
                       
                    </li>                
                </c:forEach>
            </ul>
        </nav>
    </div>
</div>
