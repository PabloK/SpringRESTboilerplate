<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
	<title>Login</title>
</head>
<body>

	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<div style="position: absolute; left: 50%; top: 50%; width: 300px; height: 300px; margin-left: -160px; margin-top: -160px; background-color: #F3F3F3; border: 1px solid #CCC; padding: 20px; border-radius: 5px; box-shadow: 0 1px 4px rgba(0, 0, 0, 0.165);">
		<h3>Login</h3>
		<form name='f' action="<c:url value='/j_spring_security_check' />" method="POST">
			<p>Username:<br><input type="text" name="j_username"></p>
			<p>Password:<br><input type="password" name="j_password"></p>
			<input type="submit" name="submit" value="login">
		</form>
	
	</div>
</body>
</html>