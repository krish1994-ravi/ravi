<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<a href="showForm"><img src="images/contact.jpg" width="60"
		height="50"></img></a>
	<h1 style="color: green; text-align: center">All Contacts
		Information</h1>
		<h4 style="color:green;text-align:center">${msg}</h4>
	<c:choose>
		<c:when test="${!empty activeContacts}">
			<table border="1">
				<tr>
					<th>Contact Id</th>
					<th>Person Name</th>
					<th>Person Email</th>
					<th>Mobile Number</th>
					<th>Action</th>
				</tr>
				<c:forEach var="contact" items="${activeContacts}">
					<tr>
						<td>${contact.contactId}</td>
						<td>${contact.contactName}</td>
						<td>${contact.contactEmail}</td>
						<td>${contact.phNo}</td>
						<td><a href="edit?id=${contact.contactId}">edit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete?id=${contact.contactId}" onclick="return confirmDelete()">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
	</c:choose>
</center>
<script type="text/javascript">
function confirmDelete(){
	return confirm("are you delete record");
}

</script>