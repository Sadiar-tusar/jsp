<%@page import="model.Emp" %>
<%@include file="header.jsp" %>

<% 

Emp e = (Emp) request.getAttribute("emp");

%>

<div class="container my-3">
    <div class="bg-success text-center">
        <h1 class="jumborton">Edit Employee</h1>
    </div>
    <!--    start form-->
    <form action="empServelet"  method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= e.getId()%>">
        <div class="row">
            <div class="col-md-6">
                <label class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="<%= e.getName()%>" placeholder="Full Name" required>
            </div>
    
        </div>
        <div class="row">
            <div class="col-md-6">
                <label class="form-label">Designation</label>
                <input type="text" class="form-control" id="designation" name="designation" value="<%= e.getDesignation()%>" placeholder="Full Name" required>
            </div>
    
        </div>
        <!-- start 2nd row-->
        <div class="row mt-3">
            <div class="col-md-6">
                <label  class="form-label">Salary</label>
                <input type="text" class="form-control" id="salary" name="salary" value="<%= e.getSalary()%>" required>
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
