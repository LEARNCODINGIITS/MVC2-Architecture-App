<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>PRODUCT FORM</h2>
	<hr/>
	 <form action="api" method="post">
	 <label>PID:</label>
	 <input type="text" name="pid"/><br/>
	 <label>PNAME:</label>
	 <input type="text" name="pname"/><br/>
	 <label>PRICE:</label>
	 <input type="text" name="price"/><br/><br/>
	 <input type="submit" value="STORE"/>
	 
	 </form>
	
	<hr/>
</body>
</html>