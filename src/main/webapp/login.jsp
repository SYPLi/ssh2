<%--
  Created by IntelliJ IDEA.
  User: 李广军
  Date: 2019/1/16
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        div {
            width:250px;
            margin: 200px auto;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/login">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="account"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="radio" name="status" value="1" checked="checked">教师
                    <input type="radio" name="status" value="0">学生
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="register.jsp">去注册</a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
