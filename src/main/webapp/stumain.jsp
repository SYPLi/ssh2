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
    <title>stu</title>
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
                url:"${pageContext.request.contextPath}/StudentAction_initialize",
                dataType: "json",
                success:function (data) {
                    var teacherlist;
                    var stu_teaList;
                    $.each(data,function (key,value) {
                        if(key=="teacherlist"){
                            teacherlist=value;
                        }
                        else if(key=="stu_teaList"){
                            stu_teaList=value;
                        }
                    });
                    $("#table1").empty();
                    var str="<tr><th>姓名</th><th>课程</th><th>状态</th></tr>";
                    for(var i=0;i<teacherlist.length;i++){
                        str=str+"<tr><td>"+teacherlist[i].name+"</td><td>"+teacherlist[i].lesson+"</td>";
                        var flag=true;
                        for(var j=0;j<stu_teaList.length;j++){
                            if(teacherlist[i].id==stu_teaList[j].tea_id){
                                flag=false;
                                var status=stu_teaList[j].status;
                                if(status==0){
                                    str=str+"<td>申请中。。。</td></tr>";
                                }
                                else if(status==1){
                                    str=str+"<td>已通过。。。</td></tr>";
                                }
                                else if(status==2){
                                    str=str+"<td>被拒绝。。。</td></tr>";
                                }
                            }
                        }
                        if(flag){
                            str=str+"<td id='"+teacherlist[i].id+"'><button onclick='apply("+teacherlist[i].id+")'>申请</button></td></tr>";
                        }

                    }
                    $("#table1").append(str);
                }
            });
        })
        function apply(id) {
            $.ajax({
                url:"${pageContext.request.contextPath}/StudentAction_apply",
                data:{
                    tea_id:id
                },
                type:"post",
                success:function () {
                    $("#"+id).html("申请中。。。");
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
