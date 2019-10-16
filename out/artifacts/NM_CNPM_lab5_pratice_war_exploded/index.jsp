
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <%-- Custom CSS --%>
    <link rel="stylesheet" href="css/main.css">
    <title>Online Book Store</title>
</head>
<body>
    <div class="wrapper fadeInDown">
        <div id="formContent">

<%--            <div class="fadeIn first">--%>
<%--                <img src="https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png" width="100" id="icon" alt="User Icon" />--%>
<%--            </div>--%>

            <form action="login" method="post">
                <input type="text" id="login" class="fadeIn second" name="username" placeholder="Username">
                <input type="password" id="password" class="fadeIn third" name="password" placeholder="Password">
                <input type="submit" class="fadeIn fourth" value="Log In">
            </form>

<%--            <div id="formFooter">--%>
<%--                <a class="underlineHover" href="register.jsp">Not a member? Sign up</a>--%>
<%--            </div>--%>

        </div>
    </div>

</body>
</html>
