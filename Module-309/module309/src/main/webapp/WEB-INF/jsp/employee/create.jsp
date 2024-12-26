<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <h1 class ="m-9 text-center"> Create Customer</h1>
        </div>
    </div>
</section>
<section class ="bg-light2 pt-5 pb-5">
    <div class="container">
        <form action = "/employee/createEmployee">
            <input type = "hidden" name = "id" value = "${form.id}"/>


            <div class="mt-3 row justify-content-center">
                <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="firstName" name="firstName" value="${form.firstName}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('firstName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${form.lastName}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('lastName')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('lastName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>


            <div class="mt-3 row justify-content-center">
                <label for="extension" class="col-sm-2 col-form-label">extension</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="extension" name="extension" value="${form.extension}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('extension')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('extension')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <label for="email" class="col-sm-2 col-form-label">email</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="email" name="email" value="${form.email}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('email')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('email')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <label for="reportsTo" class="col-sm-2 col-form-label">reports To</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="reportsTo" name="reportsTo" value="${form.reportsTo}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('reportsTo')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('reportsTo')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <label for="jobTitle" class="col-sm-2 col-form-label">job Title</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="jobTitle" name="jobTitle" value="${form.jobTitle}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('jobTitle')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('jobTitle')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <div class="col-sm-12 col-lg-8">

                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </form>


    </div>

</section>




<jsp:include page="../include/footer.jsp"/>