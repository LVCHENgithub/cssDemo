<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2018/2/23
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {

        $("li>a").click(function () {
            var no = $(this).attr("no");
            var url = location.href.split("?")[0] + "?pageNum=" + no + "&pageSize=3";
            location.href = url;
        })
    })
</script>
<div class="row">
    <nav aria-label="Page navigation">
        <div class="col-md-2 col-md-offset-2">
            <h5>
                总共:${pageInfo.total}条 , 一共:${pageInfo.pages}页
            </h5>
        </div>
        <div class="col-md-6 col-md-offset-2">
            <ul class="pagination">
                <c:if test="${pageInfo.isFirstPage}">
                    <li class="disabled"><span>首页</span></li>
                </c:if>
                <c:if test="${pageInfo.isFirstPage==false}">
                    <li><a href="#" no="1">首页</a></li>
                </c:if>

                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="#" aria-label="Previous" no="${pageInfo.prePage}">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageInfo.hasPreviousPage==false}">
                    <li class="disabled">
                        <span aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </span>
                    </li>
                </c:if>

                <c:forEach items="${pageInfo.navigatepageNums}" var="no">
                    <li <c:if test="${no==pageInfo.pageNum}">class="active"</c:if>><a href="#" no="${no}">${no}</a></li>
                </c:forEach>

                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="#" aria-label="Next" no="${pageInfo.nextPage}">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageInfo.hasNextPage==false}">
                    <li class="disabled">
                        <span aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </span>
                    </li>
                </c:if>



                <c:if test="${pageInfo.isLastPage}">
                    <li class="disabled"><span>末页</span></li>
                </c:if>
                <c:if test="${pageInfo.isLastPage==false}">
                    <li><a href="#" no="${pageInfo.pages}">末页</a></li>
                </c:if>

            </ul>
        </div>

    </nav>
</div>
