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
    <spring:url value="/" var="baseURL" />
    <div class="max-w-full max-w-xs mt-10 mx-80">
        <div class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
            <div class="mb-4">
                <label class="block text-gray-700 text-sm font-bold mb-2">
                    First name
                    <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" value="${student.firstName()}" disabled="disabled" />
                </label>
            </div>
            <div class="mb-6">
                <label class="block text-gray-700 text-sm font-bold mb-2">
                    Last name
                    <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" value="${student.lastName()}" disabled="disabled" />
                </label>
            </div>
        </div>

        <div class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
            <div class="flex flex-wrap -mx-3 mb-6">

                <div class="w-3/12 px-5 py-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="class-code">
                        Code
                    </label>
                    <div class="relative">
                        <select class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="class-code" onchange="onCodeChanged()">
                            <option></option>
                            <c:forEach var="availableClass" items="${availableClasses}" varStatus="loop">
                                <option>${availableClass.code()}</option>
                            </c:forEach>
                        </select>
                        <div class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
                            <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"/></svg>
                        </div>
                    </div>
                </div>

                <div class="w-3/12 px-5 py-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="class-title">
                        Title
                    </label>
                    <input class="appearance-none block w-full bg-gray-200 text-gray-700 border rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" id="class-title" value="" disabled="disabled">
                </div>

                <div class="w-4/12 px-5 py-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="class-description">
                        Description
                    </label>
                    <input class="appearance-none block w-full bg-gray-200 text-gray-700 border rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" id="class-description" value="" disabled="disabled" />
                </div>

                <div class="w-1/12 px-5 py-3 justify-center">
                    <a id="add-class-hyperlink" href="">
                        <button type="button" class="text-sm bg-green-500 hover:bg-green-700 text-white py-1 px-2 rounded focus:outline-none focus:shadow-outline disabled:opacity-50" id="add-class-button" disabled>Add</button>
                    </a>
                </div>

            </div>
        </div>

        <div class="container mx-auto px-4 sm:px-8">
            <div class="py-8">
                <div>
                    <h2 class="text-2xl font-semibold leading-tight">Classes</h2>
                </div>
                <div class="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto">
                    <div class="inline-block min-w-full shadow rounded-lg overflow-hidden">
                        <table class="min-w-full leading-normal table-fixed">
                            <thead>
                            <tr>
                                <th class="w-1/12 px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider">
                                    No.
                                </th>
                                <th class="w-3/12 px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider">
                                    Code
                                </th>
                                <th class="w-3/12 px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider">
                                    Title
                                </th>
                                <th class="w-4/12 px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider">
                                    Description
                                </th>
                                <th class="w-1/12 px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider">
                                    Options
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="studentsClass" items="${studentsClasses}" varStatus="loop">
                                <tr>
                                    <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                        <p class="text-gray-900 whitespace-no-wrap text-center">${loop.index + 1}</p>
                                    </td>
                                    <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                        <p class="text-gray-900 whitespace-no-wrap text-center">${studentsClass.code()}</p>
                                    </td>
                                    <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                        <p class="text-gray-900 whitespace-no-wrap text-center">${studentsClass.title()}</p>
                                    </td>
                                    <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                        <p class="text-gray-900 whitespace-no-wrap text-center">${studentsClass.description()}</p>
                                    </td>
                                    <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                        <div class="flex justify-center">
                                            <a href="${baseURL}/students/${student.id()}/remove/class/${studentsClass.id()}">
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
    </div>
</body>

<script>

    function onCodeChanged() {
        const code = document.getElementById("class-code").value;
        if (code !== '') {
            let classesArray = [];

            <c:forEach var="classInstance" items="${availableClasses}">
                classesArray.push({
                    id: "${classInstance.id()}",
                    code: "${classInstance.code()}",
                    title: "${classInstance.title()}",
                    description: "${classInstance.description()}"
                });
            </c:forEach>

            const selectedClass = classesArray.filter(c => c.code === code)[0];
            document.getElementById('class-title').value = selectedClass.title;
            document.getElementById('class-description').value = selectedClass.description;
            document.getElementById('add-class-button').disabled = false;
            document.getElementById('add-class-hyperlink').href = '${baseURL}/students/${student.id()}/add/class/' + selectedClass.id;
        } else {
            document.getElementById('class-title').value = '';
            document.getElementById('class-description').value = '';
            document.getElementById('add-class-button').disabled = true;
            document.getElementById('add-class-hyperlink').href = '';
        }
    }

</script>
</html>
