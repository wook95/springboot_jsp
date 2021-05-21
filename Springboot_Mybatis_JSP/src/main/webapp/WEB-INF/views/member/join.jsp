<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>



<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

    <title>Hello, JSP!</title>
    
    <style type="text/css">
  
    .c1{
    color : red;
    }
    </style>
  </head>
  <body>
    

	<div id="container">
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
      <a class="navbar-brand" href="#">Hidden brand</a>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/member/join">Join</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>



    <div class="p-5 mt-4 bg-light rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">연습 페이지</h1>
        <p class="col-md-8 fs-4">Using a series of utilities, you can create this jumbotron, just like the one in previous versions of Bootstrap. Check out the examples below for how you can remix and restyle it to your liking.</p>
        <button class="btn btn-primary btn-lg" type="button">Example button</button>
      </div>
	
	</div>




<form:form action="./join" modelAttribute="memberVO" method="post">



<div class="input-group mb-3"  style=" width: 300px;">
  <form:input path="id" class="form-control" placeholder="id" aria-label="Recipient's username" aria-describedby="button-addon2" ></form:input>
</div>


<div class="input-group mb-3" style=" width: 300px;">
  <form:password path="pw"  class="form-control" placeholder="password" aria-label="Recipient's username" aria-describedby="button-addon2"></form:password>
</div>

<!-- <div class="input-group mb-3" style=" width: 300px;">
  <input name="pw1" type="text" class="form-control" placeholder="password" aria-label="Recipient's username" aria-describedby="button-addon2">
</div> -->

<div class="input-group mb-3"  style=" width: 300px;">
  <form:input path="name" class="form-control" placeholder="name" aria-label="Recipient's username" aria-describedby="button-addon2" ></form:input>
	<br><form:errors path="name"></form:errors>
</div>

<div class="input-group mb-3"  style=" width: 300px;">
  <form:input path="email" class="form-control" placeholder="email" aria-label="Recipient's username" aria-describedby="button-addon2" ></form:input>
	<br><form:errors class="c1" path="email"></form:errors>
</div>

<div class="input-group mb-3"  style=" width: 300px;">
  <form:input path="phone" type="text" class="form-control" placeholder="phone" aria-label="Recipient's username" aria-describedby="button-addon2" ></form:input>
</div>
<!-- 
<div>
<input type="file" name="avatar" id="avatar">
</div> -->

<input type="submit" id="btn" value="JOIN" class="button">
</form:form>










<footer class="footer mt-auto py-3 bg-dark">
  <div class="container">
    <span class="text-muted">Place sticky footer content here.</span>
  </div>
</footer>


</div>



    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
	
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js" integrity="sha384-lpyLfhYuitXl2zRZ5Bn2fqnhNAKOAaM/0Kr9laMspuaMiZfGmfwRNFh8HlMy49eQ" crossorigin="anonymous"></script>
    -->
  </body>
</html>