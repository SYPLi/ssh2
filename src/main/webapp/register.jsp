<%--
  Created by IntelliJ IDEA.
  User: 李广军
  Date: 2019/1/16
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        div {
            width: 400px;
            margin: 100px auto;
            border: 1px solid black;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.js"></script>
    <script type="text/javascript">
        function register() {
            $.ajax({
                url:"${pageContext.request.contextPath}/register",
                dataType: "json",
                data:$("#form1").serialize(),
                success:function (data) {
                    alert(data);
                }
            });
        }
        function checkedTeacher() {
            $("#table1").empty();
            var str="<tr><td>姓名：</td><td><input type='text' name='teacher.name'></td><td></td></tr><tr><td>账号：</td><td><input type='text' name='teacher.account'></td><td></td></tr><tr><td>密码：</td><td><input type='password' name='teacher.password'></td><td></td></tr><tr><td>课程：</td><td><input type='text' name='teacher.lesson'></td><td></td></tr><tr><td></td><td><input type='button' value='注册' onclick='register()'>&nbsp;&nbsp;&nbsp;&nbsp;<a href='${pageContext.request.contextPath}/login.jsp'>去登录</a></td><td></td></tr>";
            $("#table1").append(str);
        }
        function chechedStudent() {
            $("#table1").empty();
            var str="<tr><td>姓名：</td><td><input type='text' name='student.name'></td><td></td></tr><tr><td>账号：</td><td><input type='text' name='student.account'></td><td></td></tr><tr><td>密码：</td><td><input type='password' name='student.password'></td><td></td></tr><tr><td></td><td><input type='button' value='注册' onclick='register()'>&nbsp;&nbsp;&nbsp;&nbsp;<a href='${pageContext.request.contextPath}/login.jsp'>去登录</a></td><td></td></tr>";
            $("#table1").append(str);
        }
    </script>
</head>
<body>
<div>
    <form id="form1" method="post">
        请选择<input type="radio" name="status" value="1" onclick="checkedTeacher()">教师
        <input type="radio" name="status" value="0" onclick="chechedStudent()">学生<br>
        <table id="table1">

        </table>
    </form>
</div>
</body>
</html>
