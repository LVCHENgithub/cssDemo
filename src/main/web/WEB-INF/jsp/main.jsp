<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2018/3/3
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
    <script type="text/javascript" >
        $(function () {
            $("li>a").click(function () {
                var url=$(this).attr("src");
                var title=$(this).text();
                if($("#tt").tabs("exists",title)){
                    $("#tt").tabs("select",title);
                }else{
                    var content= "<iframe scrolling='auto'frameborder='0'style='width: 100%;height: 100%'src='"+url+"'> </iframe>";
                    $("#tt").tabs("add",{
                        title:title,
                        content:content,
                        closable:true
                    });
                }
            });
        });
    </script>
</head>
<body>
<div class="easyui-layout" style="width:100%;height: 100%">
    <div region="north" style="height:25%;padding: 10px">
        <div align="center">
            <h1>学生管理系统</h1>
        </div>
        <div align="right">
            <h3>欢迎您:${tUser.nickName}</h3>
        </div>

    </div>
    <div region="south">
        <div align="center" style="padding:15px">
            <h4>版权XXX</h4>
        </div>
    </div>
    <div region="west" title="菜单栏" style="width:20%">
        <li><a href="#" src="${pageContext.request.contextPath}/mode/toMode" class="easyui-linkbutton" data-options="iconCls:'icon-search'">mode</a></li>
        <li><a  href="#" src="${pageContext.request.contextPath}/hobby/toHobby" class="easyui-linkbutton" data-options="iconCls:'icon-search'">爱好管理</a></li>
        <li><a href="#"  src="${pageContext.request.contextPath}/score/toScore" class="easyui-linkbutton" data-options="iconCls:'icon-search'">成绩管理</a></li>
    </div>
    <div region="center">
        <div id="tt" class="easyui-tabs" style="width: 100%;height: 100%">
            <div title="首页">
                欢迎使用学生管理系统
            </div>

        </div>

    </div>





</div>
</body>
</html>
