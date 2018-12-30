<%-- 
    Document   : index
    Created on : 27 Dec, 2018, 10:23:00 PM
    Author     : pranav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            
        <input type="text" id="path">
        <input type="button" onclick="getflist(document.getElementById('path').value);" value='Get File List'>
        <p id='result'></p>
        </form>
    </body>
    <script>
        function getflist(path)
        {
            var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("result").innerHTML = this.responseText;
            }
        };
        xmlhttp.open("GET", "baseHREF?path=" + path, true);
        xmlhttp.send();
        }
        </script>
</html>
