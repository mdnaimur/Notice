<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container" class="col-md-6 offset-md-3">
	<sf:form class="form-horizontal" method="post"
		action="${pageContext.request.contextPath }/docreate"
		modelAttribute="notice">
		<fieldset>

			<!-- Form Name -->
			<legend>Create Notice</legend>


			<sf:input path="id" name="id" type="hidden" />

			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-2 control-label" for="text">Notice</label>
				<div class="col-md-6" style="margin: auto;margin-left=30px;">
					<sf:textarea class="form-control" path="text" id="text" name="text" />
					<sf:errors path="text" cssClass="alert-danger" />
				</div>
			</div>


			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="sumbit"></label>
				<div class="col-md-4" style="margin: auto;margin-left=30px;">
					<button id="sumbit" name="sumbit" class="btn btn-primary">Save
						Notice</button>
				</div>
			</div>
			
			<c:if test="${notice.id!=0}">
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="sumbit"></label>
				<div class="col-md-4" style="margin: auto;margin-left=30px;">
					<button id="delete" name="delete" class="btn btn-primary">
						Delete</button>
				</div>
			</div> 
			</c:if>

		</fieldset>
	</sf:form>
</div>
