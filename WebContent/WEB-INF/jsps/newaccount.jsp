<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<title>Create New Account</title>
</head>
<body>

	<div class="container" class="col-md-6 offset-md-3">
		<sf:form class="form-horizontal" method="post"
			action="${pageContext.request.contextPath }/createaccount"
			modelAttribute="user"  onsubmit="return checkForm(this);">
			<fieldset>

				<!-- Form Name -->
				<legend>Create User</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">username</label>
					<div class="col-md-6">
						<sf:input id="username" path="username" name="username"
							type="text" placeholder="enter username"
							class="form-control input-md" />
						<sf:errors path="username" cssClass="alert-danger" />
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Email</label>
					<div class="col-md-6">
						<sf:input id="email" path="email" name="email" type="text"
							placeholder="enter your email address"
							class="form-control input-md" />
						<span class="help-block">ex:mnrd@gmail.com</span><br/>
						<sf:errors path="email" cssClass="alert-danger" />
					</div>
				</div>
				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">Password</label>
					<div class="col-md-6">
						<sf:input id="password" path="password" name="password"
							type="password" /><br/>
							<sf:errors path="password" cssClass="alert-danger" />

					</div>
				</div>
				<!-- Confirm Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Confirm
						Password</label>
					<div class="col-md-6">
						<input id="confirmpassword" name="confirmpassword" type="password" />

					</div>
				</div>


				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="sumbit"></label>
					<div class="col-md-4">
						<button id="sumbit" name="sumbit" class="btn btn-primary">Create
							User</button>
					</div>
				</div>

			</fieldset>
		</sf:form>
	</div>
	
	<script type="text/javascript">

	var password = document.getElementById("password")
	  , confirm_password = document.getElementById("confirmpassword");

	function validatePassword(){
	  if(password.value != confirm_password.value) {
	    confirm_password.setCustomValidity("<fmt:message key='Unmatchpassword.user.password'/>");
	  } else {
	    confirm_password.setCustomValidity('');
	  }
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;

</script>
</body>
</html>