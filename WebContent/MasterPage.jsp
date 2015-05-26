<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html 	xmlns="http://www.w3.org/1999/xhtml"
		xmlns:h="http://java.sun.com/jsf/html"
		xmlns:ui="http://java.sun.com/jsf/facelets">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cook Me</title>
	</head>
	
	<header>
		<div id=title>
			<p><ui:insert name="sectionTitle">Default Section Title</ui:insert></p>
		</div>
		<div id="register">
			<button value="+"></button><p>Become membre</p>
			<h:form>
				<p>Username </p>
				<h:inputText id="username" value=""></h:inputText>
				<p>Password </p>
				<h:inputSecret id="password" value=""></h:inputSecret>
				<h:message for="password"></h:message>
				<h:commandButton action="" value="Login"></h:commandButton>
			</h:form>		
		</div>
	</header>
	
	<body>
		<ui:insert name="body">Default Section Content</ui:insert>
	</body>
	
	<footer>
		<p>Copyright 2015 guiBra / tristandefournas / benobab [on Github] <img src="logo.png"/></p>		
	</footer>
</html>