<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.itts.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
width:100%;
}
</style>
</head>
<body>
        <%
        	List<Product> list=(List<Product>)request.getAttribute("lists");
             
        %>

		<table border="1">
			<thead>
					<tr>
							<th>PID</th>
							<th>PNAME</th>
							<th>PRICE</th>
							
					</tr>
			</thead>
			<tbody>
			     <% for(Product product:list){ %>
					<tr>
								<td><%=product.getPid()%></td>
								<td><%=product.getPname()%></td>
								<td><%=product.getPrice()%></td>
								
					</tr>
			</tbody>
			<%} %>
		</table>

</body>
</html>