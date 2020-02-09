<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container" class="col-md-6 offset-md-3">
	<sf:form class="form-horizontal" method="post"
		action="${pageContext.request.contextPath }/createaccount"
		modelAttribute="user" onsubmit="return checkForm(this);">
		<fieldset>

			<!-- Form Name -->
			<legend>Create User</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-2" for="username">username</label>
				
					<sf:input id="username" path="username" name="username" type="text"
						placeholder="enter username" class="" />
					<sf:errors path="username" cssClass="alert-danger" />
			
			</div>


			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-2" for="name">Full Name:</label>
				
					<sf:input id="name" path="name" name="name" type="text"
						placeholder="enter full name" class="input-md" />
					<sf:errors path="name" cssClass="alert-danger" />
				
			</div>


			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-2 control-label" for="email">Email</label>

				<sf:input id="email" path="email" name="email" type="text"
					placeholder="enter your email address" class="" />

				<sf:errors path="email" cssClass="alert-danger" />

			</div>
			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-2 control-label" for="password">Password</label>

				<sf:input id="password" path="password" name="password"
					type="password" />
				<br />
				<sf:errors path="password" cssClass="alert-danger" />


			</div>
			<!-- Confirm Password input-->
			<div class="form-group">
				<label class="col-md-2 control-label" for="email">Confirm
					Password</label> <input id="confirmpassword" name="confirmpassword"
					type="password" />


			</div>


			<!-- Button -->
			<div class="form-group">
				<label class="col-md-6 control-label" for="sumbit"></label>
				<div class="col-md-6 mx-auto">
					<button id="sumbit" name="sumbit" class="btn btn-primary">Create
						User</button>
				</div>
			</div>

		</fieldset>
	</sf:form>
</div>

<script type="text/javascript">
	var password = document.getElementById("password"), confirm_password = document
			.getElementById("confirmpassword");

	function validatePassword() {
		if (password.value != confirm_password.value) {
			confirm_password
					.setCustomValidity("<fmt:message key='Unmatchpassword.user.password'/>");
		} else {
			confirm_password.setCustomValidity('');
		}
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
</script>
