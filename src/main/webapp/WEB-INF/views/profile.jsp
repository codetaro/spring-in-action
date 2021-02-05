<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<h1>Your Profile</h1>
<c:out value="#{spitter.username}"/><br/>
<c:out value="#{spitter.firstName}"/> <c:out value="#{spitter.lastName}"/><br/>
<c:out value="#{spitter.email}"/>
