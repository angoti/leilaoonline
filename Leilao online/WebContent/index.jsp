<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Theme Made By www.w3schools.com -->
<title>Leilão online</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
body {
	font: 400 15px Lato, sans-serif;
	line-height: 1.8;
	color: #818181;
}

h2 {
	font-size: 24px;
	text-transform: uppercase;
	color: #303030;
	font-weight: 600;
	margin-bottom: 30px;
}

h4 {
	font-size: 19px;
	line-height: 1.375em;
	color: #303030;
	font-weight: 400;
	margin-bottom: 30px;
}

.jumbotron {
	background-color: #f4511e;
	color: #fff;
	padding: 100px 25px;
	font-family: Montserrat, sans-serif;
}

.container-fluid {
	padding: 60px 50px;
}

.bg-grey {
	background-color: #f6f6f6;
}

.logo-small {
	color: #f4511e;
	font-size: 50px;
}

.logo {
	color: #f4511e;
	font-size: 200px;
}

.thumbnail {
	padding: 0 0 15px 0;
	border: none;
	border-radius: 0;
}

.thumbnail img {
	width: 100%;
	height: 100%;
	margin-bottom: 10px;
}

.carousel-control.right, .carousel-control.left {
	background-image: none;
	color: #f4511e;
}

.carousel-indicators li {
	border-color: #f4511e;
}

.carousel-indicators li.active {
	background-color: #f4511e;
}

.item h4 {
	font-size: 19px;
	line-height: 1.375em;
	font-weight: 400;
	font-style: italic;
	margin: 70px 0;
}

.item span {
	font-style: normal;
}

.panel {
	border: 1px solid #f4511e;
	border-radius: 0 !important;
	transition: box-shadow 0.5s;
}

.panel:hover {
	box-shadow: 5px 0px 40px rgba(0, 0, 0, .2);
}

.panel-footer .btn:hover {
	border: 1px solid #f4511e;
	background-color: #fff !important;
	color: #f4511e;
}

.panel-heading {
	color: #fff !important;
	background-color: #f4511e !important;
	padding: 25px;
	border-bottom: 1px solid transparent;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
	border-bottom-left-radius: 0px;
	border-bottom-right-radius: 0px;
}

.panel-footer {
	background-color: white !important;
}

.panel-footer h3 {
	font-size: 32px;
}

.panel-footer h4 {
	color: #aaa;
	font-size: 14px;
}

.panel-footer .btn {
	margin: 15px 0;
	background-color: #f4511e;
	color: #fff;
}

.navbar {
	margin-bottom: 0;
	background-color: #f4511e;
	z-index: 9999;
	border: 0;
	font-size: 12px !important;
	line-height: 1.42857143 !important;
	letter-spacing: 4px;
	border-radius: 0;
	font-family: Montserrat, sans-serif;
}

.navbar li a, .navbar .navbar-brand {
	color: #fff !important;
}

.navbar-nav li a:hover, .navbar-nav li.active a {
	color: #f4511e !important;
	background-color: #fff !important;
}

.navbar-default .navbar-toggle {
	border-color: transparent;
	color: #fff !important;
}

footer .glyphicon {
	font-size: 20px;
	margin-bottom: 20px;
	color: #f4511e;
}

.slideanim {
	visibility: hidden;
}

.slide {
	animation-name: slide;
	-webkit-animation-name: slide;
	animation-duration: 1s;
	-webkit-animation-duration: 1s;
	visibility: visible;
}

@media screen and (max-width: 768px) {
	.col-sm-4 {
		text-align: center;
		margin: 25px 0;
	}
	.btn-lg {
		width: 100%;
		margin-bottom: 35px;
	}
}

@media screen and (max-width: 480px) {
	.logo {
		font-size: 150px;
	}
}
</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="http://localhost:8080/Leilao_online/">Leilão online</a>
			</div>

			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#cadastro">Cadastrar produto</a></li>
					<li><a href="#abrir">Abrir leilão</a></li>
					<li><a href="#encerrar">Encerrar leilão</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<c:if test="${!empty msg}">
		<div class="alert alert-info">
			<br>
			<h3>${msg}</h3>
		</div>
	</c:if>


	<!-- Container Cadastrar produto --------------------------------------------------------------------------------------------->
	<div id="cadastro" class="container-fluid">
		<div class="jumbotron text-center">
			<h1>Cadastro de item de leilão</h1>
		</div>

		<form action="http://localhost:8080/Leilao_online/Controle">
			<input type="hidden" name="acao" value="cadastrar">
			<div class="form-group">
				<label for="nome">Nome do item:</label> <input type="text" class="form-control" id="nome" placeholder="Digite o nome do item a ser leiloado" name="nome">
			</div>
			<div class="form-group">
				<label for="valorMinimo">Valor mínimo</label> <input type="number" class="form-control" id="valorMinimo" placeholder="Digite o valor mínimo do lance deste item" name="valorMinimo">
			</div>
			<button type="submit" class="btn btn-default">Cadastrar</button>
		</form>
	</div>


	<!-- Container abrir leilão ------------------------------------------------------------------------------------------------------->
	<div id="abrir" class="container-fluid">
		<div class="jumbotron text-center">
			<h1>Abertura de leilão</h1>
		</div>

		<form action="http://localhost:8080/Leilao_online/Controle">
			<input type="hidden" name="acao" value="abrir_leilao">
			<div class="form-group">
				<label for="sel1">Selecione um item:</label> <select class="form-control" id="sel1" name="abrir_leilao">
					<c:forEach var="item" items="${lista}">
						<c:if test="${!item.status}">
							<option value="${item.id}">${item.nome}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-default">Abrir leilão</button>
		</form>

	</div>

	<!-- Container encerrar leilão ------------------------------------------------------------------------------------------->
	<div id="encerrar" class="container-fluid">
		<div class="jumbotron text-center">
			<h1>Encerra um leilão</h1>
		</div>

		<form action="http://localhost:8080/Leilao_online/Controle">
			<input type="hidden" name="acao" value="encerrar_leilao">
			<div class="form-group">
				<label for="sel1">Selecione um item:</label> 
				<select class="form-control" id="sel1" name="encerrar_leilao">
					<c:forEach var="item" items="${lista}">
						<c:if test="${item.status}">
							<option value="${item.id}">${item.nome}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-default">Encerrar leilão</button>
		</form>

	</div>


	<footer class="container-fluid text-center">
		<a href="#myPage" title="To Top"> <span class="glyphicon glyphicon-chevron-up"></span>
		</a>
		<p>
			Bootstrap Theme Made By <a href="https://www.w3schools.com" title="Visit w3schools">www.w3schools.com</a>
		</p>
	</footer>

	<script>
		$(document).ready(
				function() {
					// Add smooth scrolling to all links in navbar + footer link
					$(".navbar a, footer a[href='#myPage']").on('click',
							function(event) {
								// Make sure this.hash has a value before overriding default behavior
								if (this.hash !== "") {
									// Prevent default anchor click behavior
									event.preventDefault();

									// Store hash
									var hash = this.hash;

									// Using jQuery's animate() method to add smooth page scroll
									// The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
									$('html, body').animate({
										scrollTop : $(hash).offset().top
									}, 900, function() {

										// Add hash (#) to URL when done scrolling (default click behavior)
										window.location.hash = hash;
									});
								} // End if
							});

					$(window).scroll(function() {
						$(".slideanim").each(function() {
							var pos = $(this).offset().top;

							var winTop = $(window).scrollTop();
							if (pos < winTop + 600) {
								$(this).addClass("slide");
							}
						});
					});
				})
	</script>
</body>
</html>