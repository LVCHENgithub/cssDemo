<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2018/2/5
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <%@include file="basic.jsp" %>

    <script type="text/javascript">
        $(function () {
            $("button[name=queryGradeButton]").click(function () {
                var queryGrade = $(this).attr("no");
                $.post("${pageContext.request.contextPath}/grade/detailGrade",{"id":queryGrade},function (data) {
                    var date =new Date(data.createDate);
                    var y = date.getFullYear();
                    var m = date.getMonth();
                    var d = date.getDate();
                    $("#gradeid").html(data.id);
                    $("#gradename").html(data.gradeName);
                    $("#createDate").html(y+"-"+m+"-"+d);
                    $("#details").html(data.details);

                },"json")
                $("#detailgrade").modal("show");

            })

            $("button[name=deleteGradeButton]").click(function () {
                var gradeId=$(this).attr("no");
                var url="${pageContext.request.contextPath}/grade/deleteGradeById";
                $.get(url,{"gradeId":gradeId},function (data) {
                    alert(data.msg);
                    //刷新当前页
                    location.href = location.href;
                });
            })

            $("#updateGradeButton").click(function () {
                //取选择项的班级id
                var gradeIds="";
                $.each($("input:checkbox"),function () {
                    if(this.checked){
                        gradeIds=gradeIds+$(this).val()+",";
                    }
                })
                if(gradeIds==""){
                    alert("请选择要删除的班级");
                }else{
                    var url="${pageContext.request.contextPath}/grade/deleteGradeByIdArray";
                    $.post(url,{"ids":gradeIds},function (result) {
                        alert(result.msg);
                        location.href=location.href;
                    })
                }
            })


            $("#addGradeButton").click(function () {
                $("#addGradeModal").modal("show");
            })
            $("#addGradeSaveButton").click(function () {

                var grade = $("#addGradeForm").serialize();
                $.post("${pageContext.request.contextPath}/grade/addGrade",grade,function (data) {

                    alert(data.msg);
                    $("#addgrademodal").modal("hide");
                    location.href = location.href;
                })
            })

            $("button[name=updateGradeButton]").click(function () {
                var queryGrade = $(this).attr("no");
                $.post("${pageContext.request.contextPath}/grade/detailGrade",{"id":queryGrade},function (data) {
                    var date =new Date(data.createDate);
                    var y = date.getFullYear();
                    var m = date.getMonth();
                    var d = date.getDate();
                    $("#id").val(data.id);
                    $("#updategradeName").val(data.gradeName);
                    $("#updategradeData").val(y+"-"+m+"-"+d);
                    $("#details").val(data.details);
                    $("#updateGradeModal").modal("show");
                },"json")

            })
            $("#updateGradeSaveButton").click(function () {
                var grade = $("#updateGradeForm").serialize();
                $.post("${pageContext.request.contextPath}/grade/updateGrade",grade,function (data) {
                    alert(data.msg);
                    $("#updateGradeModal").modal("hide");
                    location.href = location.href;
                })
            })



        })
    </script>
</head>
<body>
<div class="container">
    <%@include file="top.jsp" %>
    <div class="row">
        <%@include file="left.jsp" %>
        <div class="col-md-10">
            <h2>班级管理</h2>
        </div>
        <div class="row">
            <div class="col-md-1 col-md-offset-6">
                <button type="button" class="btn btn-info" id="addGradeButton" >添加班级</button>

            </div>
            <div class="col-md-1 "><button type="button" class="btn btn-danger" id="updateGradeButton" >批量删除</button></div>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <table class="table table-striped" style="width:100%">
                    <tr>
                        <td></td>
                        <td>班级编号</td>
                        <td>班级名称</td>
                        <td>创建时间</td>
                        <td>班级描述</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="grade">
                        <tr>
                            <td><input type="checkbox"name="gradeIds" value="${grade.id}"/></td>
                            <td>${grade.id}</td>
                            <td>${grade.gradeName}</td>

                            <td><fmt:formatDate value="${grade.createDate}" pattern="YYYY-MM-DD"/></td>
                            <td>${grade.details}</td>
                            <td>
                                <button type="button" class="btn btn-info" name="queryGradeButton" no="${grade.id}">详情</button>
                                <button type="button" class="btn btn-info" name="updateGradeButton" no="${grade.id}">修改</button>
                                <button type="button" class="btn btn-danger" name="deleteGradeButton" no="${grade.id}">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <%@include file="page.jsp"%>
</div>

<div id="detailgrade" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">班级详情</h4>
            </div>
            <div class="modal-body">
                <table >
                    <tr>
                        <td>班级编号:</td>
                        <td><div id="gradeid"></div></td>
                    </tr>
                    <tr>
                        <td>班级名称:</td>
                        <td><div id="gradename"></div></td>
                    </tr>
                    <tr>
                        <td>创建时间:</td>
                        <td><div id="createDate"></div></td>
                    </tr>
                    <tr>
                        <td>班级描述:</td>
                        <td><div id="details"></div></td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!--添加班级模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="addGradeModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加班级</h4>
            </div>
            <div class="modal-body">
                <form id="addGradeForm">
                    <div class="form-group">
                        <label >班级名称：</label>
                        <input type="text" class="form-control"  placeholder="班级名称" name="gradeName">
                    </div>
                    <div class="form-group">
                        <label >班级描述：</label>
                        <textarea class="form-control" rows="3" name="details" placeholder="班级描述"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="addGradeSaveButton">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!--修改班级模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="updateGradeModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加班级</h4>
            </div>
            <div class="modal-body">
                <form id="updateGradeForm">
                    <div class="form-group">
                        <label >班级名称：</label>
                        <input type="text" class="form-control" id="updategradeName" readonly >
                        <input type="hidden" id="id" name="id">
                    </div>
                    <div>
                        <label>创建时间:</label>
                        <input  type="text" class="form-control" id="updategradeData" readonly>
                    </div>
                    <div class="form-group">
                        <label >班级描述：</label>
                        <textarea class="form-control" rows="3" id="updateDetails" name="details" placeholder="班级描述"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="updateGradeSaveButton">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




</body>
</html>
