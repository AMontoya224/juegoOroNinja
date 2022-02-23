<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			Ninja Gold Game
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style2.css">
	</head>
	<body>
		<h1>
			Your Gold: <c:out value="${gold}"/>
		</h1>
		<main>
			<form action="/farm" method="POST">
				<div>
					<label for="farm">
						Farm
					</label>
					<label for="farm">
						(earns 10-20 gold)
					</label>
					<button type="submit">
						Find Gold!
					</button>
				</div>
			</form>
			<form action="/cave" method="POST">
				<div>
					<label for="cave">
						Cave
					</label>
					<label for="cave">
						(earns 5-10 gold)
					</label>
					<button type="submit">
						Find Gold!
					</button>
				</div>
			</form>
			<form action="/house" method="POST">
				<div>
					<label for="house">
						House
					</label>
					<label for="house">
						(earns 2-5 gold)
					</label>
					<button type="submit">
						Find Gold!
					</button>
				</div>
			</form>
			<form action="/casino" method="POST">
				<div>
					<label for="casino">
						Casino!
					</label>
					<label for="casino">
						(earns/takes 0-50 gold)
					</label>
					<button type="submit">
						Find Gold!
					</button>
				</div>
			</form>
			<form action="/spa" method="POST">
				<div>
					<label for="spa">
						Go Spa!
					</label>
					<label for="spa">
						(takes 10-45 gold)
					</label>
					<button type="submit">
						Find Gold!
					</button>
				</div>
			</form>
		</main>
		<footer>
			<h1>
				Activities:
			</h1>
			<div>
				<c:forEach var="activities" items="${activitiesList}">
					<c:if test="${activities.length() < 90}">
						<p>
		                	<c:out value="${activities}"/>
		                </p>
	                </c:if>
		            <c:if test="${activities.length() > 90}">
		                <p class="red">
		                	<c:out value="${activities}"/>
		                </p>
	                </c:if>
				</c:forEach>
	        </div>
	        <form action="/restart" method="GET">
				<button type="submit" class="link">
					Restart
				</button>
			</form>
		</footer>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>