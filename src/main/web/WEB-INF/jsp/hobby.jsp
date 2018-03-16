<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2018/3/3
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("#hobbyDataGrid").datagrid({
                url:"${pageContext.request.contextPath}/hobby/queryAll",
                method:"get",
                pagination:true,

                toolbar:[
                    {
                        text:'添加爱好',
                        iconCls:'icon-add',
                        handler:function () {
                            addHobbyButton();
                        }
                    },
                    {
                        text:'批量删除',
                        iconCls:'icon-remove',
                        handler:function () {
                            var checkHobby = $("#hobbyDataGrid").datagrid('getChecked');
                            var ids = "";
                            if(checkHobby==null||checkHobby.length<=0){
                                alert("请选择要删除的选项");
                                return;
                            }
                            if(confirm("确认删除这些爱好吗?")){
                                $.each(checkHobby,function (index, item) {
                                    ids = ids+item.id+",";
                                })
                                $.post("${pageContext.request.contextPath}/hobby/deleteHobbyByIds",{"ids":ids},function (data) {
                                    alert(data.msg);
                                    $("#hobbyDataGrid").datagrid("reload");
                                })
                            }

                        }
                    }
                ],
                columns:[[

                    {
                        field:'ck',
                        checkbox:true,
                    },

                    {field:"hobbyName",title:"爱好名称"},
                    {field:"createTime",title:"创建时间",formatter:function (value,row,index) {
                        var date = new Date(value);
                        var y = date.getFullYear();
                        var m = date.getMonth()+1;
                        var d = date.getDate();
                        return y+"-"+m+"-"+d;
                    }},
                    {field:"id",title:"操作列",formatter:function (value,row,index) {
                        var queryButton = "<button onclick='detailHobbyButton("+value+")'>详情</button>";
                        var updateButton = "<button onclick='updateHobbyButton("+value+")'>修改</button>";
                        var deleteButton = "<button onclick='deleteHobbyButton("+value+")'>删除</button>";
                        return queryButton+updateButton+deleteButton;
                    }}
                ]]
            });
            $("#addHobbyButton").click(function () {
                $.post("${pageContext.request.contextPath}/hobby/addHobby",$("#addHobbyForm").serialize(),function (data) {
                    alert(data.msg);
                    $("#addHobbyForm").form("clear");
                    $("#addHobbyWindow").window("close");
                    $("#hobbyDataGrid").datagrid("reload");
                })
            })
            $("#updateHobbyButton").click(function () {
                $.post("${pageContext.request.contextPath}/hobby/updateHobbyById",$("#updateHobbyForm").serialize(),function (data) {
                    alert(data.msg);
                    $("#updateHobbyWindow").window("close");
                    $("#hobbyDataGrid").datagrid("reload");
                })
            })
            function addHobbyButton() {
                $("#addHobbyWindow").window("open");
            }
        })
        function deleteHobbyButton(id) {
            if (confirm("确认删除该班级吗?")){
                $.post("${pageContext.request.contextPath}/hobby/deleteHobby",{"id":id},function (data) {
                    alert(data.msg);
                    $("#hobbyDataGrid").datagrid("reload");
                })
            }
        }
        function detailHobbyButton(id) {
            $.post("${pageContext.request.contextPath}/hobby/detailHobbyById",{"id":id},function (data) {
                var date=new Date(data.createTime);
                var Y=date.getFullYear();
                var M=date.getMonth()+1;
                var D=date.getDate();
                var H=date.getHours();
                var m=date.getMinutes();
                var s=date.getSeconds();
                data.createTime =Y+"-"+M+"-"+D+" "+H+":"+m+":"+s;
                console.log(data);
                $("#detailHobbyForm").form('load', data);
            })
            $("#detailHobbyWindow").window("open");
        }
        function updateHobbyButton(id) {
            $.post("${pageContext.request.contextPath}/hobby/detailHobbyById",{"id":id},function (data) {
                $("#updateHobbyForm").form('load', data);
            })
            $("#updateHobbyWindow").window("open");
        }
    </script>
</head>
<body>
<table id="hobbyDataGrid"></table>

<div id="addHobbyWindow" class="easyui-window" title="添加爱好" style="top: 20%;left: 20%;width: 500px;height: 200px;padding: 20px 80px" closed="true">
    <form action="" id="addHobbyForm" method="post">
        <div>
            <label >爱好名称:</label>
            <input type="text" name="hobbyName" class="easyui-textbox">

        </div>
    </form>
    <button type="button" class="easyui-linkButton" id="addHobbyButton">保存</button>
</div>

<%--查询爱好window--%>
<div id="detailHobbyWindow" class="easyui-window" title="爱好查询" style="width: 500px;height: 300px;padding: 60px 120px" closed="true">
    <form id="detailHobbyForm">
        <div>
            <label>爱好名称:</label>
            <input class="easyui-textbox" name="hobbyName" id="queryHobbyName" readonly>
        </div>
        <div>
            <label>创建时间:</label>
            <input class="easyui-textbox" name="createTime" id="createTime" readonly>
        </div>
    </form>
</div>

<%--修改爱好window--%>
<div id="updateHobbyWindow" class="easyui-window" title="修改爱好" style="width: 500px;height: 300px;padding: 60px 120px" closed="true">
    <form id="updateHobbyForm">
        <div>
            <label>爱好名称:</label>
            <input class="easyui-textbox" name="hobbyName" id="updateHobbyName">
            <input type="hidden" name="id">
        </div>
    </form>
    <button id="updateHobbyButton" class="easyui-linkbutton">保存</button>
</div>



</body>
</html>
