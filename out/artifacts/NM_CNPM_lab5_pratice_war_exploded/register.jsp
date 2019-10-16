
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

        <!-- Icon -->
        <div class="fadeIn first">
            <img src="https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png" width="100" id="icon" alt="User Icon" />
        </div>

        <!-- Sign up Form -->
        <form action="register" method="post">
            <input type="text" id="username" class="fadeIn second" name="username" placeholder="Username">
            <input type="text" id="first-name" class="fadeIn second" name="first-name" placeholder="First Name">
            <input type="text" id="last-name" class="fadeIn second" name="last-name" placeholder="Last Name">
            <input type="text" id="email" class="fadeIn second" name="email" placeholder="Email">
            <input type="password" id="password" class="fadeIn second" name="password" placeholder="Password">
            <input type="password" id="password-confirm" class="fadeIn second" name="password-confirm" placeholder="Confirm your password">
            <input type="text" id="address" class="fadeIn second" name="address" placeholder="Address">
            <input type="text" id="phone-number" class="fadeIn second" name="phone-number" placeholder="Phone number">
            <input type="submit" class="fadeIn third" value="Register">
        </form>

        <div id="formFooter">
            <a class="underlineHover" href="index.jsp">Already a member? Sign up</a>
        </div>

    </div>
</div>

</body>
</html>
