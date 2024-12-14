<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<h1 class="text-center">Employee Search</h1>
<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <form action="/employee/search" class="mb-0">
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="mb-3">
                        <label for="firstNameId" class="form-label">First Name</label>
                        <input type="text" class="form-control" id="firstNameId" name="firstName" value="${search}">
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </div>
        </form>
    </div>
</section>

<c:if test="${not empty search}">
    <section class="bg-light2 pt-5 pb-5">
        <div class="container">
            <h2 class="text-center">Employee Found (${employeesKey.size()})</h2>

            <table class="table mt-5 table-info table-bordered border-danger table-striped table-hover">
                <tr>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>id</th>
                    <th>Job Title</th>
                    <th>Extension</th>
                    <th>Email</th>
                    <th>Edit</th>
                </tr>
                <c:forEach var="employee" items="${employeesKey}">
                    <tr>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.id}</td>
                        <td>${employee.jobTitle}</td>
                        <td>${employee.extension}</td>
                        <td>${employee.email}</td>
                        <td><a href="/employee/edit/${employee.id}">Edit</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </section>
</c:if>

<jsp:include page="../include/footer.jsp"/>