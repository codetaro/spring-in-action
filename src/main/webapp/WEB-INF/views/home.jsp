<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<h1><s:message code="spittr.welcome" text="Welcome"/></h1>

<s:url value="/spitter/register" var="registerUrl"/>

<a href="<s:url value="/spittles" />">Spittles</a>
<a href="${registerUrl}">Register</a>