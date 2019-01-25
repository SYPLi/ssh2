<%--
  Created by IntelliJ IDEA.
  User: 李广军
  Date: 2019/1/24
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.js"></script>
    <script type="text/javascript">
        $(function () {
            query();
        })
        function query() {
            $.ajax({
                url:"${pageContext.request.contextPath}/Test_query",
                dataType:"json",
                success:function (data) {
                    $("#tx").val(data.name);
                }
            });
        }
        function xg() {
            $.ajax({
                url:"${pageContext.request.contextPath}/Test_update",
                dataType:"json",
                data:{
                    name:$("#tx").val()
                },
                success:function (data) {
                    alert(data);
                    query();
                }
            });
        }
    </script>
</head>
<body>
    <input type="text" id="tx">
    <button onclick="xg()">确定</button>
</body>
</html>
