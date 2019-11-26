//参数1:分页对象
//参数2:访问的地址
//参数3 以后 都以key=value的字符串传入
//该方法用来拼接字符串的分页 多个li 返回一个字符串
//调用案例 如下
//var pageStr= addPage(resultInfo.data,"http://localhost:8080/travel/favoriterank.html" ,"key=value","key=value" ,"key=value");
function addPage(pageBean , myUrl){

    //拼接分页
    //需要的参数格式 key=value
    var paramsTemp ="";
    for(var i = 2 ; i <arguments.length ; i++){
        if(i==2){
            paramsTemp+="&"
        }
        //拼接参数
        paramsTemp+=arguments[i];
        //除了最后一个参数不拼接& 其他的都拼接  &key=value&key=value&key=value
        //http://localhost:8080/项目名称/favoriterank.html?pageNumber=1&key=value&key=value&key=value
        if(i!=arguments.length-1){
            paramsTemp+="&";
        }
    }


    //分页
    var pageNumberInt = parseInt(pageBean.pageNumber);
    //计算前一页
    var backPage = pageNumberInt-1;
    //计算后一页
    var afterPage = pageNumberInt+1;
    //拼接首页
    var   pageStr =" <li><a href=\""+myUrl+"?pageNumber=1"+paramsTemp+"\">首页</a></li>";
    //拼接上页
    pageStr +=" <li><a href=\""+myUrl+"?pageNumber="+backPage+""+paramsTemp+"\">上页</a></li>";

    //拼接中间页码
    for(var i =pageBean.start ; i <=pageBean.end ; i ++ ){
        if(i == pageNumberInt){
            //pageStr +=" <li class='curPage'><a href=\""+myUrl+"?pageNumber="+i+""+paramsTemp+"\">"+i+"</a></li>";
            pageStr +=" <li class='curPage'><a href='"+myUrl+"?pageNumber="+i+""+paramsTemp+"'>"+i+"</a></li>";
            //地址?pageNumber=1&key=value&key=value&key=value

        }else{
           // pageStr +=" <li><a href=\""+myUrl+"?pageNumber="+i+"\""+paramsTemp+">"+i+"</a></li>";
            pageStr +=" <li><a href='"+myUrl+"?pageNumber="+i+""+paramsTemp+"'>"+i+"</a></li>";
        }
    }
    //拼接下页
    //pageStr +=" <li><a href=\""+myUrl+"?"+paramsTemp+"&pageNumber="+afterPage+"\">下页</a></li>";
    pageStr +=" <li><a href='"+myUrl+"?pageNumber="+afterPage+""+paramsTemp+"'>下页</a></li>";
    //拼接尾页
    pageStr +=" <li><a href='"+myUrl+"?pageNumber="+pageBean.totalPage+""+paramsTemp+"'>尾页</a></li>";
    //pageStr +=" <li><a href=\""+myUrl+"?"+paramsTemp+"&pageNumber="+pageBean.totalPage+"\">尾页</a></li>";
    return pageStr ;
}