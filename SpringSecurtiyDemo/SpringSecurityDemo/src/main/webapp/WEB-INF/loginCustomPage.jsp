<html>
<head>
<title>
Customized Login Page
</title>
</head>
My Login Page
<body>
<form  method="post">       
    <p>
        <label for="username">Username</label>
        <input type="text" id="username" name="username"/>  
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>  
    </p>
    <input type="hidden"                        
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
    <button type="submit" class="btn">Log in</button>
</form>
</body>

</html>