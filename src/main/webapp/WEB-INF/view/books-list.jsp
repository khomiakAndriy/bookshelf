<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books list</title>

    <!-- reference our style sheet -->
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>
<div id="wrapper">
    <div id="header" style="width: 95%">
        <h2>Bookshelf</h2>
    </div>
</div>
<div id="container">
    <div id="content">

        <%--Add button and search panel--%>
        <table>
            <tr><input type="button" value="Add book"
                       onclick="window.location.href= '/book/showFormForAdd'; return false;"
                       class="add-button"
            />
            </tr>
            <tr>    </tr>
            <tr>
                <form action="/book/search" method="get">
                    <input type="text" name="searchText" placeholder="Search here..." required>
                    <button type="submit">Search</button>
                </form>
            </tr>
        </table>


        <%--Booklist--%>
        <table>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th style="width: 120px">Author</th>
                <th >Isbn</th>
                <th>Print Year</th>
                <th>Status</th>
                <th style="width: 100px">Action</th>
            </tr>

            <c:forEach var="book" items="${books}">
                <c:url var="deleteLink" value="/book/delete">
                    <c:param name="bookId" value="${book.id}"/>
                </c:url>

                <c:url var="updateLink" value="/book/showFormForUpdate">
                    <c:param name="bookId" value="${book.id}"/>
                </c:url>

                <c:url var="changeStatusLink" value="/book/changeStatus">
                    <c:param name="bookId" value="${book.id}"/>
                </c:url>
                <tr>
                    <td> ${book.title}</td>
                    <td> ${book.description}</td>
                    <td> ${book.author}</td>
                    <td> ${book.isbn}</td>
                    <td> ${book.printYear}</td>

                    <td>
                        <a href="${changeStatusLink}"
                           onclick="if (!(confirm('Have you read this book??'))) return false">${book.readAlready}</a>
                    </td>
                    <td>
                        <a href="${updateLink}">Update</a> | <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure want to delete this book?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<a href="/book/list/1">1</a>
<a href="/book/list/2">2</a>
<a href="/book/list/3">3</a>
<a href="/book/list/4">4</a>

</body>
</html>