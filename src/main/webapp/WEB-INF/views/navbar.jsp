<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<body>
<spring:url value="/students" var="studentUrl" />
<spring:url value="/classes" var="classUrl" />
<nav class="flex items-center justify-between flex-wrap bg-gray-400 p-6">
    <div class="flex items-center flex-shrink-0 text-white mr-6">
        <span class="font-semibold text-xl tracking-tight">Spring MVC</span>
    </div>
    <div class="w-full block flex-grow lg:flex lg:items-center lg:w-auto">
        <div class="text-sm lg:flex-grow">
            <a href="${studentUrl}" class="block mt-4 lg:inline-block lg:mt-0 text-white hover:text-black mr-4">
                Students
            </a>
            <a href="${classUrl}" class="block mt-4 lg:inline-block lg:mt-0 text-white hover:text-black mr-4">
                Classes
            </a>
        </div>
    </div>
</nav>
</body>
