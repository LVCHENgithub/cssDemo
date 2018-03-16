<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2018/2/5
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="col-md-2">
        <ul class="nav nav-pills nav-stacked">
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/grade/toGrade?pageNum=1&pageSize=3">
                    班级管理
                </a></li>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/student/toStudent?pageNum=1&pageSize=3">
                    学生管理
                </a></li>
            <li role="presentation">
                <a href=""></a>
            </li>
            <li role="presentation">
                <a href=""></a>
            </li>
        </ul>
    </div>
