<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));


    Member member = new Member(username, age);

    memberRepository.save(member);

%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/jsp/members/save.jsp" method="post">
    username : <input type = "text" name = "username"/>
    age :      <input type = "text" name = "age" />
    <button type = "submit">전송</button>
</form>
</body>
</html>