<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
		xmlns:h="http://java.sun.com/jsf/html"
		xmlns:ui="http://java.sun.com/jsf/facelets">
	<h:head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="css/style.css" /> 
		<title>Cook Me</title>
	</h:head>
	
	<h:body>
		<div id="header">
			<ui:insert name="sectionTitle" id="title">Default Section Title</ui:insert>
			<div id="register">
				<div id="bouton">				
					<button>+</button>
					<p>Become membre</p>
				</div>
				<h:form id="form">
					<p>Username </p>
					<h:inputText id="username" value=""></h:inputText>
					<p>Password </p>
					<h:inputSecret id="password" value=""></h:inputSecret>
					<h:message for="password"></h:message>
					<h:commandButton action="" value="Login"></h:commandButton>
				</h:form>		
			</div>
		</div>
		
		<div id="body">
			<ui:insert name="body">Default Section Content</ui:insert>
		</div>
		
		<div id="footer">
			<p>Copyright 2015 guiBra / tristandefournas / benobab [on Github] <img id="logo" src="logo.png"/></p>		
		</div>
	</h:body>
</html>