<%@page import="model.Student" %>
<%@include file="header.jsp" %>

<% 

Student s = (Student) request.getAttribute("student");

%>

<div class="container my-3">
    <div class="bg-success text-center">
        <h1 class="jumborton">Edit Student</h1>
    </div>
    <!--    start form-->
    <form action="studentServelet"  method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= s.getId()%>">
        <div class="row">
            <div class="col-md-6">
                <label class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="<%= s.getName()%>" placeholder="Full Name" required>
            </div>
    
        </div>
        <div class="row">
            <div class="col-md-6">
                <label class="form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email" value="<%= s.getEmail()%>" placeholder="Full Email" required>
            </div>
    
        </div>
        <!-- start 2nd row-->
        <div class="row mt-3">
            <div class="col-md-6">
                <label  class="form-label">Salary</label>
                <input type="text" class="form-control" id="salary" name="salary" value="<%= s.getSalary()%>" required>
            </div>

        </div>

        <div class="row mt-3 text-center">
            <div class="col-md-6">
                <button type="submit" class="btn btn-success text-center" >Update</button>

            </div>

            <div class="col-md-6">
                <a href="allemployee.jsp" class="btn btn-danger text-center" >Reset</a>

            </div>
        </div>
    </form>

    <!--end form    -->
</div>


<%@include file="footer.jsp" %>
