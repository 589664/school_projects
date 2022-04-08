<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="norsk">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
    <title>Document</title>
</head>
<body>
  <form method="post" class="pure-form pure-form-aligned">

    <select name="adresse" id="add">
      <c:forEach items="${kontor}" var="k">
        <option name=${k.adresse}>${k.adresse}</option>
      </c:forEach>
    </select>

    <input id="dato" type="text" name="datetimes"/>

    <br>
    <label for="kategori">Velg kategori:</label>

    <select name="kategori" id="cars">
      <option value="B">B</option>
      <option value="C">C</option>
      <option value="D">D</option>
    </select>
    <br>
    <button type="submit" class="pure-button pure-button-primary">Sjekk tilgjengelighet!</button>
  </form>
    
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    
    <script>
    $(function() {
      $('input[name="datetimes"]').daterangepicker({
        timePicker: true,
        timePicker24Hour: true,
        startDate: moment().startOf('hour'),
        endDate: moment().startOf('hour').add(32, 'hour'),
        locale: {
          format: 'YYYY-MM-DD HH:MM'
        }
      });
    });
    </script>
</body>
</html>