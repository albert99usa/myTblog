<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inc/header.jsp"></jsp:include>
<div class='container main'>
    <jsp:include page="../inc/sidebar.jsp"></jsp:include>
    <div class='col-md-9'>
        <ul class='breadcrumb'>
            <li><a href='${contextPath}/'>主頁</a><span class='divider'></span></li>
            <li class='active'>文章管理</li>
        </ul>
        <div class='panel'>
            <div class='inner'>
                <div class="topic_content">
                    <div class="markdown-text">
                        <h3>文章列表 <a href="${contextPath}/topic/create">【新增】</a> </h3>
                        <jsp:include page="../inc/msgbox.jsp"></jsp:include>
                        <c:if test="${not empty pager and not empty pager.content}">
                            <table class="table">
                                <tr>
                                    <th>文章標題</th>
                                    <th>欄目</th>
                                    <th>創建日期</th>
                                    <th>更新日期</th>
                                    <th>操作</th>
                                </tr>
                                <c:forEach items="${pager.content}" var="topic">
                                    <tr>
                                        <td>${topic.title}</td>
                                        <td>${topic.catName},${topic.catDir}</td>
                                        <td>${topic.createAtFormatted}</td>
                                        <td>${topic.updateAtFormatted}</td>
                                        <td>
                                            <a href="${contextPath}/article/${topic.topicId}" target="_blank">查看</a>
                                            <a href="${contextPath}/topic/edit/${topic.topicId}">修改</a>
                                            <a href="${contextPath}/topic/del/${topic.topicId}">刪除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <!--分頁開始-->
                            <jsp:include page="../inc/pagination.jsp">
                                <jsp:param name="pager" value="${pager}"/>
                                <jsp:param name="baseURL" value="${contextPath}/topic/list"/>
                                <jsp:param name="otherParams" value=""/>
                            </jsp:include>
                            <!--分頁結束-->
                        </c:if>
                        <c:if test="${empty pager.content}">
                            <p class="text-center">還沒有創建文章</p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../inc/footer.jsp"></jsp:include>

