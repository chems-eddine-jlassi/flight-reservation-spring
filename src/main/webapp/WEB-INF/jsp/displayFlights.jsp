<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight-display</title>
</head>
<body>
	<h2>Flights:</h2>
	<table>
		<tr>
			<th>Airlines</th>

			<th>Departure City</th>

			<th>Departure Time</th>

		</tr>
	</table>
	<table>
		<c:forEach items="${flightlist}" var="flight">
			<tr>

				<td>${flight.operatingAirlines}</td>

				<td>${flight.departureCity}</td>

				<td>${flight.estimatedDepartureTime}</td>


				<td><a href="showCompleteReservation?flightid=${flight.id}">Select</a></td>
			</tr>


		</c:forEach>
	</table>


</body>
</html>