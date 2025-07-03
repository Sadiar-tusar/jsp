<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Student" %>
<%@page import="dao.StudentDao" %>
<%@page import="java.util.*" %>

<%@include file="header.jsp" %>

<%
    
List<Student> list=StudentDao.getAllStudent();
request.setAttribute("list",list);

%>

<div class="container"> 

    <h1 class="text-primary text-center">All Student</h1> 
    <<table class="table table-striped">

        <thead> 
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Salary</th>
                <th>Action</th>
            </tr>

        </thead>

        <tbody>
            <c:forEach items="${list}" var="e">
                <tr>
                    <td>${e.getId()}</td>
                    <td>${e.getName()}</td>
                    <td>${e.getEmail()}</td>
                    <td>${e.getSalary()}</td>
                    <td>
                        <a href="studentServelet?action=edit&id=${e.id}" class="btn btn-primary">Edit </a>
                        <a href="studentServelet?action=delete&id=${e.id}" class="btn btn-warning" onclick="return confirm('Are you sure you want delete this employee')">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </tbody>

    </table>
</div>

<%@include file="footer.jsp" %>