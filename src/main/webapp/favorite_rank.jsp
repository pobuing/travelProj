<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>收藏排行榜</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="css/ranking-list.css">
</head>
<body>
<!--引入头部-->
<jsp:include page="header.jsp"></jsp:include>
<div class="contant">
    <div class="shaixuan">
        <span>线路名称</span>
        <input type="text">
        <span>金额</span>
        <input type="text">~<input type="text">
        <button>搜索</button>
    </div>
    <div class="list clearfix">
        <ul>
           <c:forEach var="route" items="${pb.data}" varStatus="status">
               <li>
                   <span class="num one">${status.index}</span>
                   <a href="route_detail.html"><img src="${route.rimage}" alt=""></a>
                   <h4><a href="route_detail.html">${route.rname}</a></h4>
                   <p>
                       <b class="price">&yen;<span>${route.price}</span>起</b>
                       <span class="shouchang">已收藏${route.count}次</span>
                   </p>
               </li>
           </c:forEach>

        </ul>
    </div>
    <div class="pageNum">
        <ul>
            <li><a href="">首页</a></li>
            <li class="threeword"><a href="#">上一页</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">6</a></li>
            <li><a href="#">7</a></li>
            <li><a href="#">8</a></li>
            <li><a href="#">9</a></li>
            <li><a href="#">10</a></li>
            <li class="threeword"><a href="javascript:;">下一页</a></li>
            <li class="threeword"><a href="javascript:;">末页</a></li>
        </ul>
    </div>
</div>

<!--导入底部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
