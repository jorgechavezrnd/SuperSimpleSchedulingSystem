<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Students</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="navbar.jsp" />
    <div class="container mx-auto px-4 sm:px-8">
        <div class="py-8">
            <a href="students/create">
                <button class="bg-green-500 hover:bg-green-700 text-white font-bold mb-8 py-2 px-4 rounded focus:outline-none focus:shadow-outline">
                    Create student
                </button>
            </a>
            <div>
                <h2 class="text-2xl font-semibold leading-tight">Students</h2>
            </div>
            <div class="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto">
                <div class="inline-block min-w-full shadow rounded-lg overflow-hidden">
                    <table class="min-w-full leading-normal table-fixed">
                        <thead>
                        <tr>
                            <th class="w-1/6 px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider">
                                No.
                            </th>
                            <th class="w-2/6 px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider">
                                First name
                            </th>
                            <th class="w-2/6 px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider">
                                Last name
                            </th>
                            <th class="w-1/6 px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider">
                                Options
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="student" items="${students}" varStatus="loop">
                            <tr>
                                <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <p class="text-gray-900 whitespace-no-wrap text-center">${loop.index + 1}</p>
                                </td>
                                <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <p class="text-gray-900 whitespace-no-wrap text-center">${student.firstName()}</p>
                                </td>
                                <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <p class="text-gray-900 whitespace-no-wrap text-center">${student.lastName()}</p>
                                </td>
                                <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <div class="flex justify-center">
                                        <button type="button" class="mr-2 text-sm bg-green-500 hover:bg-green-700 text-white py-1 px-2 rounded focus:outline-none focus:shadow-outline">View</button>
                                        <a href="students/edit/${student.id()}">
                                            <button type="button" class="mr-2 text-sm bg-blue-500 hover:bg-blue-700 text-white py-1 px-2 rounded focus:outline-none focus:shadow-outline">Edit</button>
                                        </a>
                                        <a href="students/delete/${student.id()}">
                                            <button type="button" class="text-sm bg-red-500 hover:bg-red-700 text-white py-1 px-2 rounded focus:outline-none focus:shadow-outline">Delete</button>
                                        </a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
