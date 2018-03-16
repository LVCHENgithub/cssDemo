<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2018/3/5
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
    <script type="text/javascript">
        $(function () {
           $("#scDataGrid").datagrid({
               url:'${pageContext.request.contextPath}/score/queryScoreAll',
               method:'get',
               rownumbers:true,
               striped:true,
               pagination:true,
               checkOnSelect:false,
               toolbar:[
                   {
                       text:'添加',
                       iconCls:'icon-add',
                       handler:function () {
                           alert("添加");
                       }
                   },
                   {
                       text:'删除',
                       iconCls:'icon-remove',
                       handler:function () {
                           alert("删除");
                       }
                   }
               ],
               columns:[[
                   {
                       field:'ck',
                       checkbox:true,
                   },
                   {
                       field:'grade',
                        title:'班级名称',

                       formatter:function (value, row, index) {
                           return row.student.grade.gradeName;
                       }
                   },
                   {
                       field:'student',
                       title:'学生姓名',

                       formatter:function (value, row, index) {
                           return row.student.studentName;
                       }
                   },
                   {
                       field:'course',
                       title:'课程',

                       formatter:function (value, row, index) {
                           return row.course.courseName;
                       }
                   },
                   {
                       field:'score',
                       title:'成绩',


                   },
                   {
                       field:'id',
                       title:'操作',

                       formatter:function (value, row, index) {
                           var detailScoreButton= "<button onclick='detailScoreButton("+value+")'>详情</button>";
                           var updateScoreButton= "<button onclick='updateScoreButton("+value+")'>修改</button>";
                           var deleteScoreButton= "<button onclick='deleteScoreButton("+value+")'>删除</button>";
                           return detailScoreButton+" "+updateScoreButton+" "+deleteScoreButton;
                       }
                   }
               ]]
           })

            $.get("${pageContext.request.contextPath}/grade/queryAllGrade",function (data) {
                var grade1 = $.parseJSON('{"id":-1,"gradeName":"--请选择--"}');
                data.push(grade1);
                $("#gradeCombobox").combobox({
                    valueField:'id',
                    textField:'gradeName',
                    editable:false,
                    data:data,
                    onLoadSuccess:function () {
                        $(this).combobox('select', -1);
                    },
                    onSelect:function (grade) {
                        var gradeid = grade.id;
                        $.get("${pageContext.request.contextPath}/student/queryAllStudentByGradeId",{"gradeId":gradeid},function (data) {
                            var student1 = $.parseJSON('{"id":-1,"studentName":"--请选择--"}');
                            data.push(student1);
                            $("#studentCombox").combobox({
                                valueField:'id',
                                textField:'studentName',
                                editable:false,
                                data:data,
                                onLoadSuccess:function () {
                                    $(this).combobox('select', -1);
                                }

                            })
                        })
                    }
                })
            })
            $("#queryScoreButton").click(function () {
                var gradeId = $("#gradeCombobox").combobox('getValue');
                var studentId = $("#studentCombox").combobox('getValue');

//                alert(gradeId);
//                alert(studentId);
                $("#scDataGrid").datagrid('load',{
                    "gradeId":gradeId,
                    "studentId":studentId,

                });
            })


        })
        function detailScoreButton(id) {
            alert("详情" + id);
        }
        function updateScoreButton(id) {
            alert("修改" + id);
        }
        function deleteScoreButton(id) {
            alert("删除" + id);
        }
    </script>
</head>
<body>

<!--条件查询-->
<div>
    <form id="queryScoreForm">
        班级：<input id="gradeCombobox" name="gradName">
        学生：<input id="studentCombox" name="studentName">
        <a id="queryScoreButton" href="#" class="easyui-linkbutton" iconCls="icon-search">
            查询
        </a>
    </form>
</div>

<table id="scDataGrid" class="easyui-datagrid"></table>
</body>
<!--添加成绩-->
<div id="addScoreWindow" class="easyui-window" title="添加成绩" style="width: 500px;height: 300px;top: 20%;left: 20%;padding: 20px 100px;" closed="true">
    <form id="addScoreform">
        <div>
            班级: <input id="addScoreGradeNameCombobox" name="student.grade.id">
        </div>
        <div>
            学生: <input id="addScoreStudentNameCombobox" name="student.id"/>
        </div>
        <div>
            课程:<input id="addScoreCourseCombobox" name="course"/>
        </div>
        <div>
            成绩: <input id="addScore" name="score" class="easyui-numberbox"/>
        </div>
    </form>
        <button id="addScoreButton"  >保存</button>

</div>
</html>
