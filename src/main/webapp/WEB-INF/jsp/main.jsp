<%-- 
    Document   : main
    Created on : 7 Ιουλ 2019, 12:57:06 πμ
    Author     : Dimitris-pc
--%>
<%@page import="org.springframework.ui.ModelMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lobster">
        <link rel="stylesheet" href="css/main.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Song Web App</title>
    </head>
    <body>
        <table class="w3-table w3-centered w3-hoverable ">
            <thead>
                <tr class="w3-black lobster w3-large">
                    <th>Title</th>
                    <th>Artist</th>
                    <th>Album</th>
                    <th>Release Year</th>
                    <th>Lyrics</th>
                    <th>Download</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="song" items="${list}">
                    <tr class="w3-padding">
                        <td>
                            <c:out value="${song.title}"/>
                        </td>
                        <td>
                            <c:out value="${song.artist}" />
                        </td>
                        <td>
                            <c:out value="${song.album}" />
                        </td>
                        <td>
                            <c:out value="${song.releaseYear}" />
                        </td>
                        <td>
                            <button class="w3-button w3-padding-small w3-blue w3-hover-light-blue lrbtn" id="${song.id}">Lyrics</button>

                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/download/${song.id}" class="w3-hover-light-blue" download="${song.mp3filename}" >
                                <img class="min" src="img/download.svg" alt="download">
                            </a>
                        </td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>

        <c:forEach var="song" items="${list}">
            <div class="w3-modal lyrics ${song.id} " >
                <div class="w3-modal-content w3-animate-zoom w3-round-large">
                    <div class="w3-container">
                        <div class="w3-display-topright">
                            <span class="w3-button w3-display-topright w3-round-large w3-hover-red">&times;</span>
                        </div>
                        <div>
                            <h3 class="lobster">
                                <c:out value="${song.title}' s Lyrics"/>
                            </h3>
                            <p>
                                <c:out value="${song.lyrics}"/>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        
        <script src="scripts/main.js"></script>
    </body>
</html>
