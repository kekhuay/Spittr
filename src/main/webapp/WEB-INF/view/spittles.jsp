<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spittles</title>
</head>
<body>
  <h1>Recent Spittles</h1>
  <ul>
    <c:forEach items="${spittleList}" var="spittle">
      <li id="spittle_<c:out value="spittle.id" />">
        <div class="spittleMessage">
          <c:out value="${spittle.message}" />
        </div>
        <div>
          <span class="spittleTime"><c:out value="spittle.time" /></span>
          <span class="spittleLocation">(<c:out
              value="spittle.latitude" />, <c:out
              value="spittle.logitude" />)
          </span>
        </div>
      </li>
    </c:forEach>
  </ul>
</body>
</html>