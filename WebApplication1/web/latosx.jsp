<%-- 
    Document   : latosx
    Created on : 30-apr-2017, 18.40.19
    Author     : marta_nga0hmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="latosx">
    
    <input type="text" name="cerca" id="ricerca" value="Cerca.."/>
    <div id="personeLista">
        <p> Utenti: </p>
        <nav>
            <ul>
<!--                <c:forEach var="Listautenti" items="${Listautenti}">
                    <li> <div id="${Listautenti}" class="profilo">
                            <h2><a href="bacheca.html?postvisualizati=true&idOtherUser=${Listautenti.idUtente}">${Listautenti.nome} ${Listautenti.cognome} </a>
                            </h2>
                        </div> </li>
                </c:forEach>-->
                         
<!--                         <c:forEach var="nomiutenti" items="${DButenti}">
               <li><div class="botdiv"><a href="bacheca.html?postvisualizati=true&idOtherUser=${nomiutenti.idUtente}">
                    ${nomiutenti.nome} ${nomiutenti.cognome}</a></div></li>-->
                <!--</c:forEach>-->
<!--                <li>
                    <a href=#GiulioCesare> Giulio Cesare </a>
                </li>
                <li>
                    <a href=#MarcoClaudioMarcello>Marco Claudio Marcello (nipote di Augusto)</a>
                </li>
                <li>
                    <a href=#Romolo> Romolo </a>
                </li>-->
            </ul>
        </nav>
    </div>

    <div id="gruppi">
        <p> Gruppi </p>
        <nav>
            <ul>
                <c:forEach var="gruppi" items="${listaGruppi}">                
                    <li><div class="botdiv"><a href="bacheca.html?postgruppivisualizati=true&idGruppoSideBar=${gruppi.id}">
                                ${gruppi.nameGroup}</a></div></li>                
                </c:forEach>
                </li>
            </ul>
        </nav>
    </div>
</div>
