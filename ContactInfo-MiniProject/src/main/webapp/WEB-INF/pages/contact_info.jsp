<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<center>
<img src="images/airtel.png" width="80" height="60"/>
<h1 style="color:blue;text-align:center"><marquee>WELCOME TO AIRTEL</marquee></h1>
	<h2>Contact Form</h2>
	<h4 style="color:green;text-align:center">${msg}</h4>
	<form:form modelAttribute="contact" method="POST" action="save?contactId=${contact.contactId}">
		<table border="1">
			<tr>
				<td>Enter Person Name ::</td>
				<td><form:input path="contactName" /></td>
			</tr>
			<tr>
				<td>Enter Person Email ::</td>
				<td><form:input path="contactEmail" /></td>
			</tr>
			<tr>
				<td>Enter Mobile Number ::</td>
				<td><form:input path="phNo" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="register"></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</table>
	</form:form>

<br><br>
<a href="allContacts">all contacts</a>
</center>


