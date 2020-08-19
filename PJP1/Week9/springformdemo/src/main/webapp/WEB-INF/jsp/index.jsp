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
<h2 class="hello-title">Student Data!</h2>
<br>
<br>
<table border="1">
    <thead>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>City</td>
    </tr>
    </thead>
    <tbody>
    <%
        Map<String, Student> studentData= (Map<String, Student>) request.getAttribute("studentMap");
        for (Map.Entry<String, Student> entry: studentData.entrySet()) {
            out.println("<tr><td>"+entry.getValue().getId()+"</td><td>"+entry.getValue().getName()+"</td><td>"+entry.getValue().getCity()+"</td></tr>");
        }
    %>
    </tbody>
</table>
<br>
<br>
<h3>Search by id</h3>

<form method="post" action="/search-student">
    <label>
        ID
        <input type="text" name="id" pattern="[0-9]{3,}"/>
    </label>
    <input type="submit" value="Find">
</form>
</body>
</html>