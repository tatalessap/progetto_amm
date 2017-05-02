<%-- 
    Document   : newPost
    Created on : 2-mag-2017, 11.17.49
    Author     : marta_nga0hmy
--%>
<%@page import="Modelli.UtentiRegistratiFactory"%>
<%@page import="Modelli.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:forEach var="post" items="${posts}">
    <div class="newPost">

        <div class="profilo">
            <img class="immagineProfilo" title="profilo" alt="immagineProfilo" src="${post.immagineProfilo}">
            <div class="nomeProfilo"><a href="#indirizzo">${post.nomeUtente}</a></div>
        </div>
        <c:if test="${not empty post.content}"><div class="testopost"><p>${post.content}</p></div></c:if>
        <c:if test="${not empty post.postType}"><div class="testopost"><p>${post.postType}</p></div></c:if>
        <c:if test="${not empty post.image}"><div class="img_post"> <img alt="immaginec" src="${post.image}"> </div></c:if>
    </div></c:if>
</div>
</c:forEach>
