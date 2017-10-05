<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update book</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Bookshelf</h2>

    </div>
</div>

<div id="container">
    <h3>Update book</h3>

    <form:form action="updateBook" modelAttribute="book" method="post">
        <form:hidden path="id"/>
        <form:hidden path="author"/>
        <table>
            <tbody>
            <tr>
                <td><label>Title:</label></td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td><label>Description:</label></td>
                <td style="height: 40px"><form:input path="description"/></td>
            </tr>
            <tr>
                <td><label>Isbn:</label></td>
                <td><form:input path="isbn"/></td>
            </tr>
            <tr>
                <td><label>Print year:</label></td>
                <td><form:input path="printYear"/></td>
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