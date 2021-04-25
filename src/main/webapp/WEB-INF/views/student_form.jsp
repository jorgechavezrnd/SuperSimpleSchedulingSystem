<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="navbar.jsp" />
    <spring:url value="${url}" var="actionUrl" />
    <div class="max-w-full max-w-xs mt-10 mx-80">
        <form:form action="${actionUrl}" class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4" method="POST" commandName="student">
            <form:hidden path="id" />
            <form:hidden path="classesIds" />
            <div class="mb-4">
                <form:label path="firstName" class="block text-gray-700 text-sm font-bold mb-2">
                    First name
                </form:label>
                <form:input path="firstName" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" placeholder="First name" />
            </div>
            <div class="mb-6">
                <form:label path="lastName" class="block text-gray-700 text-sm font-bold mb-2">
                    Last name
                </form:label>
                <form:input path="lastName" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" placeholder="Last name" />
            </div>
            <div class="flex items-center justify-center">
                <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="submit">
                    Save student
                </button>
            </div>
        </form:form>
    </div>
</body>
</html>
