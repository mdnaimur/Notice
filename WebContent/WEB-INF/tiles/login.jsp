<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(documnet).ready(function() {
		$(j_username).focus();
	});
</script>
<div class="container" class="col-md-6 offset-md-3">
	<h3>Login with Username and Password</h3>
	<form class="form-horizontal"
		action='${pageContext.request.contextPath }/j_spring_security_check'
		method='POST'>
		<fieldset>

			<!-- Form Name -->
			<legend></legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-1 control-label" for="j_username">User</label>

				<input id="j_username" name="j_username" type="text" placeholder=""
					class="input-md">


			</div>

			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-1 control-label" for="j_password">Password
				</label> <input id="j_password" name="j_password" type="password"
					placeholder="" class=" input-md ">


			</div>

			<!-- Remember me input-->
			<div class="form-group">
				<label class="" for="j_password">Remember me </label> <input
					id="_spring_security_remember_me"
					name="_spring_security_remember_me" type="checkbox">


			</div>
			<div class="alert-danger ">
				<p>
					<c:if test="${param.error!=null }">Incorrect Username or password</c:if>

				</p>
			</div>
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="submit"></label>
				<div class="col-md-4 mx-auto">
					<button id="submit" name="submit" class="btn btn-primary">Sumbit</button>
				</div>
			</div>

		</fieldset>
	</form>
	<p>
		<a href="<c:url value= '/newaccount' />">Create New Account</a>
	</p>
</div>

