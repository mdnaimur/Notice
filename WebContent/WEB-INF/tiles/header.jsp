 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
 
 <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
   
        <a class="nav-link" href="   <c:url value='/'/>">Home <span class="sr-only">(current)</span></a>
      </li>
     
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <sec:authorize access="!isAuthenticated()">
		<li class="nav-item">
			<a class="nav-link" href="<c:url value='/login'/>"> Log In</a>
		</li>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<li class="nav-item">
			<a class="nav-link" href="<c:url value='/j_spring_security_logout'/>">Log out</a>
		</li>
	</sec:authorize>
     
    </ul>&nbsp;
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>