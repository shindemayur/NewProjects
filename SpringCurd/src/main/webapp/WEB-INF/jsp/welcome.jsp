<%@include file="../jsp/taglib_includes.jsp" %>
<html>
<body style="color:maroon; ">
	<center>
		<br><br><br><br><br>
		<table border="1">
			<tr>
				<td class="heading">User Id</td>
				<td class="heading">Name</td>
				<td class="heading">Addres Name</td>
				<td class="heading">Age</td>
				<td class="heading">Salary</td>
				<td class="heading">Edit</td>
				<td class="heading">Delete</td>
			</tr>
			<c:forEach var="list" items="${Elist}">
				<tr>
				
					<td>${list.id}</td>
					<td>${list.name}</td>
					<td>${list.address}</td>
					<td>${list.age}</td>
					<td>${list.salary}</td>
					<td><a href="edit.htm?id=${list.id}">Edit</a></td>
					<td><a href="delete.htm?id=${list.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="getlist.htm">next page</a>
	</center>
	<h1>hello ${check}</h1>
	<h2 style="color:blue; "><center><center></h2>
</body>
</html>




