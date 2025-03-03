<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Welcome to Telusko

	<form action="addAlien" method="post">
	    Alien id : <input type="text" name="aid"><br>
	    Alien name : <input type="text" name="aname"><br>
        <input type="submit">
    </form>
    <hr>
    <form action="getAlien">
        Enter id : <input text="text" name="aid"><br>
        <input type="submit">
    </form>
    <hr>
    <form action="getAlienByName">
        Enter name : <input text="text" name="aname"><br>
        <input type="submit">
    </form>
</body>
</html>