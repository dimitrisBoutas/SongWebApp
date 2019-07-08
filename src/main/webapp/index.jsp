<%-- 
    Document   : index
    Created on : 6 Ιουλ 2019, 11:31:57 μμ
    Author     : Dimitris-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lobster">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Orbitron&display=swap" >
        <link rel="stylesheet" href="css/index.css">


        <title>Song Web Appplication</title>
    </head>

    <body class="w3-row">

        <div class="w3-container">

            <div class="w3-display-middle">
                <button onclick="openUploadForm()" class="w3-button  w3-hover-light-green w3-green w3-round-large w3-xxxlarge  lobster">Upload Song</button>
            </div>

            <div id="id01" class="w3-modal">

                <div class="w3-modal-content w3-animate-zoom w3-light-green w3-round-large ">

                    <div class="w3-container">

                        <span onclick="closeUploadForm()"  class="w3-button w3-display-topright w3-round-large w3-hover-red">&times;</span>

                        <form class="w3-padding w3-margin" action="${pageContext.request.contextPath}/upload" method="POST" enctype="multipart/form-data">
                            <input type="file" name="songfile" class="w3-input w3-border w3-padding  w3-white w3-round-large ">
                            <button type="submit" value="Upload" class="w3-button w3-green  w3-block w3-round-large" > 
                                <span>
                                    <img class="min" src="img/upload.svg" alt="Upload"/>
                                </span>
                            </button>
                        </form>

                    </div>

                </div>

            </div>

        </div>
        <div class="w3-display-bottomright">
            <a href="${pageContext.request.contextPath}/allsongs" class=" lobster w3-button w3-margin w3-round-large w3-green w3-hover-light-green">Songs in DB</a>
        </div>
        <script src="scripts/index.js"></script>
    </body>

</html>