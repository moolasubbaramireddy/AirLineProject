<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Display Flights</title>
</head>
<body>
    <h2>Flight search Results</h2>
    <h2>List Of Flights</h2>

    <table border="1">
        <thead>
        <tr>
            <th>Airlines</th>
            <th>Departure City</th>
            <th>Arrival City</th>
            <th>Departure Time</th>
            <th>Select Flight</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${findFlights}" var="flight">
            <tr>
                <td>${flight.operatingAirlines}</td>
                <td>${flight.departureCity}</td>
                <td>${flight.arrivalCity}</td>
                <td>${flight.estimatedDepartureTime}</td>
                <td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
