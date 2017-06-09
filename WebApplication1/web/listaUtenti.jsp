<%-- 
    Document   : listaUtenti
    Created on : 5-giu-2017, 13.37.14
    Author     : marta_nga0hmy
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="utente" items="${listaUtenti}">
        <json:object>
            <json:property name="nomeUtente" value="${utente.nomeUtente}"/>
            <json:property name="cognomeUtente" value="${utente.cognomeUtente}"/>
            <json:property name="personalID" value="${utente.personalID}"/>
            <json:property name="url" value="${utente.url}"/>
            <json:property name="biografia" value="${utente.biografia}"/>
            <json:property name="dataNascita" value="${utente.dataNascita}"/>
            <json:property name="password" value="${utente.password}"/>
        </json:object>
    </c:forEach>
</json:array>
