<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>线路列表</title>
    <link rel="stylesheet" href="css/search.css">
</head>
<body>
<!--引入头部-->

<jsp:include page="header.jsp"></jsp:include>
<div class="page_one">
    <div class="contant">
        <div class="crumbs">
            <img src="images/search.png" alt="">
            <p>黑马旅行><span>搜索结果</span></p>
        </div>
        <div class="xinxi clearfix">
            <%--线路列表 start--%>
            <div class="left">
                <div class="header">
                    <span>商品信息</span>
                    <span class="jg">价格</span>
                </div>
                <ul>
                    <c:forEach items="${pb.list}" var="route">

                        <li>
                            <div class="img"><img src="${route.rimage}" width="300px" alt=""></div>
                            <div class="text1">
                                <p>${route.rname}</p>
                                <br/>
                                <p>${route.routeIntroduce}</p>
                            </div>
                            <div class="price">
                                <p class="price_num">
                                    <span>&yen;</span>
                                    <span>${route.price}</span>
                                    <span>起</span>
                                </p>
                                <p><a href="route_detail.jsp">查看详情</a></p>
                            </div>
                        </li>
                    </c:forEach>


                </ul>
                <div class="page_num_inf">
                    <i></i> 共
                    <span>${pb.totalPage}</span>页<span>${pb.totalCount}</span>条
                </div>
                <div class="pageNum">
                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/route?action=findRoutByPage&cid=${cid}&currentPage=1&pageSize=10">首页</a>
                        </li>
                        <c:if test="${pb.currentPage>1}">

                            <li class="threeword"><a
                                    href="${pageContext.request.contextPath}/route?action=findRoutByPage&cid=${cid}&currentPage=${pb.currentPage-1}&pageSize=10">上一页</a>
                            </li>
                        </c:if>

                        <c:forEach begin="${pb.begin}" end="${pb.end}" var="page">
                            <c:if test="${pb.currentPage == page}">
                                <%--判断是否是当前页--%>
                                <li class="curPage">
                                    <a href="${pageContext.request.contextPath}/route?action=findRoutByPage&cid=${cid}&currentPage=${page}&pageSize=10">${page}</a>
                                </li>
                            </c:if>
                            <c:if test="${pb.currentPage != page}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/route?action=findRoutByPage&cid=${cid}&currentPage=${page}&pageSize=10">${page}</a>
                                </li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pb.currentPage<pb.totalPage}">

                            <li class="threeword"><a
                                    href="${pageContext.request.contextPath}/route?action=findRoutByPage&cid=${cid}&currentPage=${pb.currentPage+1}&pageSize=10">下一页</a>
                            </li>
                        </c:if>
                        <li class="threeword"><a
                                href="${pageContext.request.contextPath}/route?action=findRoutByPage&cid=${cid}&currentPage=${pb.totalPage}&pageSize=10">末页</a>
                        </li>
                    </ul>
                </div>
            </div>
            <%--线路列表--%>
            <%--热门推荐 start--%>
            <div class="right">
                <div class="top">
                    <div class="hot">HOT</div>
                    <span>热门推荐</span>
                </div>
                <ul>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
            <%--热门推荐 end--%>
        </div>
    </div>
</div>

<!--引入头部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
