<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Class</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="navbar.jsp" />
    <spring:url value="${url}" var="actionUrl" />
    <div class="max-w-full max-w-xs mt-10 mx-80">
        <form:form action="${actionUrl}" class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4" method="POST" commandName="classInstance">
            <form:hidden path="id" />
            <div class="mb-4">
                <form:label path="code" class="block text-gray-700 text-sm font-bold mb-2">
                    Code
                </form:label>
                <form:input path="code" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" placeholder="Code" />
            </div>
            <div class="mb-6">
                <form:label path="title" class="block text-gray-700 text-sm font-bold mb-2">
                    Title
                </form:label>
                <form:input path="title" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" placeholder="Title" />
            </div>
            <div class="mb-6">
                <form:label path="description" class="block text-gray-700 text-sm font-bold mb-2">
                    Description
                </form:label>
                <form:input path="description" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" placeholder="Description" />
            </div>
            <div class="flex items-center justify-center">
                <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="submit">
                    Save class
                </button>
            </div>
        </form:form>
    </div>
</body>
</html>
