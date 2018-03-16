<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2018/2/5
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <%@include file="basic.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("#deleteStudentButton").click(function () {
                var id = "";
                $.each($("input:checkbox"),function () {
                    if (this.checked) {
                        id = $(this).val() + ",";
                    }
                })

                if (id==""){
                    alert("请选择要删除的学生");
                }else{
                    if (confirm("确认删除这些学生吗?")){
                        $.get("${pageContext.request.contextPath}/student/deleteStudent",{"id":id},function (data) {
                            alert(data.msg);
                            location.href=location.href;
                        })
                    }
                }
            })
            
            $("#addStudentButton").click(function () {
                addGradeSelect($("#addStudentGradeSelect"), null);
                    $("#addStudentModal").modal("show");
            })

            $("#updateStudentSaveButton").click(function () {
                var student = $("#updateStudentForm").serialize();
                alert(student);
                $.post("${pageContext.request.contextPath}/student/updateStudent",student,function (data) {
                    alert(data.msg);
                    location.href=location.href;
                })
            })

            $("button[name=updateStudentButton]").click(function () {
                $.get("${pageContext.request.contextPath}/student/queryAllStudentById",{"id":$(this).attr("no")},function (data) {
                    if(data.gender=="男"){
                        $("#updateStudentGenderNan").attr("checked","checked");
                    }else{
                        $("#updateStudentGenderNv").attr("checked", "checked");
                    }
                    $("#updateStudentName").val(data.studentName);
                    $("#updateStudentNum").val(data.studentNum);
                    $("#updateStudentAge").val(data.age);
                    $("#updateStudentGender").val(data.gender);
                    $("#updateStudentId").val(data.id)
                    var gradeid = data.grade.id;
                    addGradeSelect($("#updateStudentGradeSelect"),gradeid );
                    $("#updateStudentModal").modal("show");
                })

            })

            <%--$("#updateStudentSaveButton").click(function () {--%>
                <%--var student  = $("#updateStudentForm").serialize();--%>

                <%--$.post("${pageContext.request.contextPath}/student/updateStudent",student,function (data) {--%>
                    <%--alert(data.msg);--%>
                    <%--location.href = location.href;--%>
                <%--})--%>
            <%--})--%>


        })
        
        function addGradeSelect(ele,gradeid) {
            ele.empty();
            $.get("${facesContext.request.contextPath}/grade/queryAllGrade",function (data) {
                for (var i =0;i<data.length;i++){
                    var option = "<option value='"+data[i].id+"' >"+data[i].gradeName+"</option>"
                    ele.append(option);
                }
                if (gradeid!=null) {
                    ele.val(gradeid);
                }
            })
        }
        
        
        
    </script>




</head>
<body>

<div class="container">
    <%@include file="top.jsp"%>
    <div class="row">
        <%@include file="left.jsp"%>
        <div class="col-md-10">
            <h2>学生管理</h2>
        </div>
        <div class="row">
            <div class="col-md-1 col-md-offset-6">
                <button type="button" class="btn btn-info" id="addStudentButton" >添加班级</button>

            </div>
            <div class="col-md-1 "><button type="button" class="btn btn-danger" id="deleteStudentButton" >批量删除</button></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <table class="table table-striped" style="width:100%" >
                <tr>
                    <td></td>
                    <td>学生编号</td>
                    <td>学生班级</td>
                    <td>学生名称</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>学号</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${pageInfo.list}" var="student">
                    <tr>
                        <td><input type="checkbox" name="" id="" value="${student.id}"></td>
                        <td>${student.id}</td>
                        <td>${student.grade.gradeName}</td>
                        <td>${student.studentName}</td>
                        <td>${student.gender}</td>
                        <td>${student.age}</td>
                        <td>${student.studentNum}</td>
                        <td>
                            <button type="button" class="btn btn-info" name="queryStudentButton" no="${student.id}">详情</button>
                            <button type="button" class="btn btn-info" name="updateStudentButton" no="${student.id}">修改</button>
                            <button type="button" class="btn btn-danger" name="deleteStudentButton" no="${student.id}">删除</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <%@include file="page.jsp"%>
    </div>
</div>

<!--添加学生模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="addStudentModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加学生</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="addStudentForm">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">学生姓名：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="studentName" placeholder="学生姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-3 control-label">年龄：</label>
                        <div class="col-sm-8">
                            <input type="number" min="1" class="form-control" name="age" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-3 control-label">性别：</label>
                        <div class="col-sm-8">
                            <select class="form-control" name="gender" >
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-3 control-label">班级：</label>
                        <div class="col-sm-8">
                            <select class="form-control" name="grade.id" id="addStudentGradeSelect">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-3 control-label">学生编号：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="studentNum" placeholder="学生编号">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="addStudentSaveButton">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!--修改学生模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="updateStudentModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改学生</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="updateStudentForm">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">学生姓名：</label>
                        <div class="col-sm-8">
                            <input type="hidden" name="id" id="updateStudentId">
                            <input type="text" class="form-control" name="studentName" placeholder="学生姓名" id="updateStudentName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-3 control-label">年龄：</label>
                        <div class="col-sm-8">
                            <input type="number" min="1" class="form-control" name="age"  id="updateStudentAge">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-3 control-label">性别：</label>
                        <div class="col-sm-8">
                            <%--<select class="form-control" name="gender" id="updateStudentGender" >--%>
                                <%--<option value="男">男</option>--%>
                                <%--<option value="女">女</option>--%>
                            <%--</select>--%>
                                <label class="radio-inline">
                                    <input type="radio" name="gender"  value="男" id="updateStudentGenderNan" > 男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="gender"  value="女" id="updateStudentGenderNv"> 女
                                </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-3 control-label">班级：</label>
                        <div class="col-sm-8">
                            <select class="form-control" name="grade.id" id="updateStudentGradeSelect">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-3 control-label">学生编号：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="studentNum" placeholder="学生编号" id="updateStudentNum">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="updateStudentSaveButton">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->













</body>
</html>
