<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <title>Example project: BAND OAuth 2.0 Login </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<p>
    Login with Band <a href="${authorizeUrl}">Click</a>
</p>

<c:if test="${not empty accessToken}">
    <p>
       access_token: <input type="text" name="accessToken" size="150" value="${accessToken}" readonly="readonly">
    </p>

    <c:if test="${not empty profile}">
        <h2>Profile: </h2>
        <table>
            <thead>
                <colgroup/>
                <colgroup width="100px"/>
            </thead>
            <tbody>
            <tr>
                <th>name</th><td>${profile.name}</td>
            </tr>
            <tr>
                <th>profile</th><td><img src="${profile.profileImageUrl}?type=s150" width="150" height="150"></td>
            </tr>
            <tr>
                <th>user_key</th><td>${profile.userKey}</td>
            </tr>
            </tbody>
        </table>
    </c:if>
</c:if>

</body>
</html>
