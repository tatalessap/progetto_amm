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
        <meta name="author" content="Marta Pibiri">

        <title>nuovopost</title>
    </head>
    <body>
        <div class="blocco">
            <c:choose>
                <c:when test="${empty newpost}">
                    <div class="inserimentopost">
                        <form action="NuovoPost" method="post">
                            <div class="postType">
                                <div class="blocco2">
                                    <label for="textType">Post di Testo</label>
                                    
                                        <input type="radio" name="postType" value="textType" id="textType" checked="checked">
                                    
                                    
                                </div>
                                <div class="blocco2">
                                    <label for="imgType">Post con Foto</label>
                                    
                                        <input type="radio" name="postType" value="imgType" id="imgType">
                                    
                                </div>
                            </div>
                            <div class="postContent">
                                <div>
                                    <label for="textPost">Contenuto</label>
                                    <textarea name="content" id="content"></textarea>
                                </div>
                            </div>
                            <button type="submit" name="thereIsPost" value="needConfirm">Conferma</button>
                        </form>     
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="formNewPost">
                        <form action="NuovoPost" method="post">
                            <h3>${nome} ${cognome}</h3> 
                            <c:if test="${postType == 'textType'}">
                                <p>${content}</p>
                            </c:if>
                                
                            <c:if test="${postType == 'imgType'}">
                                <img src="${content}" alt="downloadedImage">
                            </c:if>
                            <input type="text" hidden name="content" value="${content}">
                            <input type="text" hidden name="postType" value="${postType}">

                            <button type="submit" name="thereIsPost" value="Confirmed">Conferma primo</button>
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

    </body>
</html>
