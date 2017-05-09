<%-- 
    Document   : newpost
    Created on : 4-mag-2017, 12.02.50
    Author     : marta_nga0hmy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>nuovopost</title>
    </head>
    <body>
        <div class="blocco">
            
            <h2>Inserisci un nuovo post..</h2>
            
            <div class="inserimentopost">
                
                <form action="nuovopost" method="post">
                    
                    <div class="blocco1">
                        <label for="content">Inserisci il testo:</label>

                        <div class="blocco2">
                            <input type="textarea" name="content" 
                                   id="content"
                                   <c:if test="${not empty content}"> value="${content}"</c:if>
                                   <c:if test="${not empty post.content}"> value=" ${post.content}"</c:if>>     
                            </div>
                            
                        </div>
                            
                        <div class="blocco1">
                            <label for="image">Inserisci l'immagine:</label>

                            <div class="blocco2">
                                <input type="text" name="image" 
                                       id="image"
                                <c:if test="${not empty image}"> value="${image}"</c:if>
                                <c:if test="${not empty post.image}"> value="${post.image}"</c:if>>
                        </div>
                    </div>

                </form>
            </div>

        </div>


    </body>
</html>
