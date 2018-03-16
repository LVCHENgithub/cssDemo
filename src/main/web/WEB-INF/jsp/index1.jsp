<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2018/3/3
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/jquery-easyui-1.5.1/themes/default/easyui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/jquery-easyui-1.5.1/themes/icon.css">
<script type="text/javascript"
        src="${pageContext.request.contextPath}/statics/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/statics/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/statics/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    $(function () {
        $("button[name=button]").click(function () {
            $("#button").window("open");
        })
    })
</script>

<%--<link--%>
        <%--rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/default/easyui.css">--%>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/icon.css"> </link>--%>
<%--<script type="text/javascript"--%>
        <%--src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>--%>
<%--<script type="text/javascript"--%>
        <%--src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>--%>
<%--<script type="text/javascript"--%>
        <%--src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js">--%>
<%--</script>--%>


<head>
    <title>Title</title>
</head>
<body>

<div class="easyui-window" title="登录窗口" style="top: 20%;left: 20%;width: 500px;height: 300px" id="button"  >
    <form action="${pageContext.request.contextPath}/main" method="post" style="padding: 3% 10% 5% 20%">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" class="easyui-textbox" name="userName"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input class="easyui-passwordbox" name="password"></td>
            </tr>
            <tr>
                <td><input type="reset" value="重置"></td>
                <td><input type="submit" value="登录" class="easyui-linkbutton" style="width: 35px;height: 35px" ></td>
            </tr>
        </table>



    </form>
</div>

<%--<div class="easyui-window" title="简单窗口"--%>
     <%--style="top:20%; left:20%;width:500px;height: 200px;">--%>
    <%--内容--%>
<%--</div>--%>
</body>
</html>
