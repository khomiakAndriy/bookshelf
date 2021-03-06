<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save book</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-book-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header" style="width: 850px">
        <h2>Bookshelf</h2>

    </div>
</div>

<div id="container">
    <h3>Save book</h3>

    <form:form action="saveBook" modelAttribute="book" method="post">
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>Title:</label></td>
                <td><form:input path="title" cssStyle="width: 700px"/></td>
            </tr>
            <tr>
                <td><label>Description:</label></td>
                <td><form:textarea path="description" rows="3" cols="97"/></td>
            </tr>
            <tr>
                <td><label>Author:</label></td>
                <td><form:input path="author" cssStyle="width: 700px"/></td>
            </tr>
            <tr>
                <td><label>Isbn:</label></td>
                <td><form:input path="isbn" cssStyle="width: 700px"/></td>
            </tr>
            <tr>
                <td><label>Print year:</label></td>
                <td><form:input path="printYear" cssStyle="width: 700px"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" , class="save"/></td>
            </tr>


            </tbody>
        </table>
    </form:form>
    <div style="clear: both"></div>

    <p>
        <a href="${pageContext.request.contextPath}/book/list/1">Back to List</a>
    </p>


</div>

</body>
</html>