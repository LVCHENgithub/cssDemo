<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2018/3/5
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
    <script type="text/javascript">
        $("#md").datagrid({
            url: '${pageContext.request.contextPath}/statics/jquery-easyui-1.5.1/demo/datagrid/products.json',
            method: 'post',
            columns: [[
                {field: 'productid', title: '商品id'},
                {field:'productname',title:'商品名称'}
            ]]
        });
    </script>
</head>
<body>
<table id="md"></table>

123
</body>
</html>
