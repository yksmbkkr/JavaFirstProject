<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Map" %>
<%@ page import="tech.yash.springformdemo.pojo.Student" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My App</title>
</head>
<body>
<h2 class="hello-title">Student Search Result!</h2>
<br>
<br>
<%
    Boolean found = (Boolean) request.getAttribute("found");
    if(!found){
        out.println("<h3 style=\"color: red\">No Student Found for ID: "+(String) request.getAttribute("sid")+"</h3>");
    }else {
        out.println("<h3 style=\"color: green\"> Student Found for ID: "+(String) request.getAttribute("sid")+"</h3>");
        Student temp = (Student) request.getAttribute("resStudent");
        out.println("<p>"+temp.toString()+"</p>");
    }
%>
<br><br>
<button type="button" onclick="window.location='/'">Go to Home</button>

</body>
</html>