<%--
  Created by IntelliJ IDEA.
  User: 李广军
  Date: 2019/1/22
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tea</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        div {
            width: 800px;
            margin: 100px auto;
            border: 1px solid black;
        }
        table{
            width: 100%;
            text-align: center;
        }
        tr{
            width: 100%;
        }
        td{
            width: 33%;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url:"${pageContext.request.contextPath}/TeacherAction_initialize",
                dataType:"json",
                success:function (data) {
                    var studentList;
                    var stu_teaList;
                    $.each(data,function (key,value) {
                        if(key=="studentList"){
                            studentList=value;
                        }
                        else if(key=="stu_teaList"){
                            stu_teaList=value;
                        }
                    });
                    $("#table1").empty();
                    var str="<tr><th>姓名</th><th>状态</th><th>操作</th></tr>";
                    for(var i=0;i<stu_teaList.length;i++){
                        for (var j=0;j<studentList.length;j++){
                            if(studentList[j].id==stu_teaList[i].stu_id){
                                str=str+"<tr id='"+(stu_teaList[i].id+"tr")+"'><td>"+studentList[j].name+"</td>";
                            }
                        }
                        var status=stu_teaList[i].status;
                        if(status==0){
                            str=str+"<td id='"+stu_teaList[i].id+"'>申请中。。。</td><td><input type='radio' name='"+stu_teaList[i].id+"' onclick='accepts("+stu_teaList[i].id+")'>接受<input type='radio' name='"+stu_teaList[i].id+"' onclick='refuse("+stu_teaList[i].id+")'>拒绝<button onclick='cancel("+stu_teaList[i].id+")'>取消</button></td>";
                        }
                        else if(status==1){
                            str=str+"<td id='"+stu_teaList[i].id+"'>已通过。。。</td><td><input type='radio' name='"+stu_teaList[i].id+"' checked='checked' onclick='accepts("+stu_teaList[i].id+")'>接受<input type='radio' name='"+stu_teaList[i].id+"' onclick='refuse("+stu_teaList[i].id+")'>拒绝<button onclick='cancel("+stu_teaList[i].id+")'>取消</button></td>";
                        }
                        else if(status==2){
                            str=str+"<td id='"+stu_teaList[i].id+"'>已拒绝。。。</td><td><input type='radio' name='"+stu_teaList[i].id+"' onclick='accepts("+stu_teaList[i].id+")'>接受<input type='radio' name='"+stu_teaList[i].id+"' checked='checked' onclick='refuse("+stu_teaList[i].id+")'>拒绝<button onclick='cancel("+stu_teaList[i].id+")'>取消</button></td>";
                        }
                    }
                    $("#table1").append(str);
                }
            })
        })

        function accepts(id) {
            alert(11);
            $.ajax({
                url:"${pageContext.request.contextPath}/TeacherAction_accept",
                data:{
                    id:id
                },
                type:"post",
                success:function () {
                    $("#"+id).html("已通过。。。");
                }
            });
        }
        function refuse(id) {
            $.ajax({
                url:"${pageContext.request.contextPath}/TeacherAction_refuse",
                data:{
                    id:id
                },
                type:"post",
                success:function () {
                    $("#"+id).html("已拒绝。。。");
                }
            });
        }
        function cancel(id) {
            $.ajax({
                url:"${pageContext.request.contextPath}/TeacherAction_cancel",
                data:{
                    id:id
                },
                type:"post",
                success:function () {
                    $("#"+id+"tr").remove();
                }
            });
        }
    </script>
</head>
<body>
<div>
    <table id="table1">

    </table>
</div>
</body>
</html>
