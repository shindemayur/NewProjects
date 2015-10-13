<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>



"src/main/webapp/WEB-INF/jsp/reg.jsp"

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="js/employee.js"></script>
    <style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table   width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
  <tr valign="top" align="center">
    <td align="center">
    <form:form method="post" action="saveContact.htm"  commandName="employee">
    
    <form:errors path="*" cssClass="errorblock" element="div" />
    
    <table>
					<tr>
						<td> Name :</td>
						<td><form:input path="name" /></td>
						<td><form:errors path="name"></form:errors>
					</tr>
					<tr>
						<td>Address :</td>
						<td><form:input path="address" /></td>
						<td><form:errors path="address"></form:errors>
					</tr>
					<tr>
						<td>Age :</td>
						<td><form:input path="age"/></td>
						<td><form:errors path="age"></form:errors>
					</tr>
					<tr>
						<td>Salary :</td>
						<td><form:input path="salary"/></td>
						<td><form:errors path="salary"></form:errors>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" /></td>
						
					</tr>
					
						<tr>
						<input value="Back" onclick="javascript:go('index.htm');" type="button"/> 
					</tr>
				</table>
			</form:form>
			
		</td>
		</tr>
		</table>
 
</body>
</html>