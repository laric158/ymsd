<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>源码快讯 管理中心 - 新闻列表 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="./styles/general.css" rel="stylesheet" type="text/css" />
<link href="./styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
    <span class="action-span"><a href="addNews">添加新闻</a></span>
    <span class="action-span1"><a href="__GROUP__">源码快讯 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 新闻列表 </span>
    <div style="clear:both"></div>
</h1>
<div class="form-div">
    <form action="newsList" name="searchForm" method="post">
        <img src="img/icon_search.gif" width="26" height="22" border="0" alt="search" />
        <!-- 分类 -->
        <select name="type">
            <option value="0">新闻分类</option>
            <c:forEach items="${newsTypeList }" var="type">
            	<option value="${type.id }">${type.name }</option>
            </c:forEach>
            
        </select>
        <!-- 推荐 -->	
        <select name="isRecommend">
            <option value="">是否推荐</option>
            <option value="">--全部--</option>
            <option value="1">是</option>
            <option value="0">否</option>
        </select>
        <!-- 关键字 -->
        关键字 <input type="text" name="keyword" size="15" />
        <input type="submit" value=" 搜索 " class="button" />
    </form>
</div>

<!-- 商品列表 -->
<form method="post" action="" name="listForm" onsubmit="">
    <div class="list-div" id="listDiv">
        <table cellpadding="3" cellspacing="1">
            <tr>
                <th>编号</th>
                <th>新闻标题</th>
                <th>新闻类型</th>
                <th>是否推荐</th>
                <th>录入日期</th>
                <th>录入人</th>
                <th>操作</th>
            </tr>
            
            
            <c:forEach items="${page.list }" var="news">
            
            	<tr>
	                <td align="center">${news.id }</td>
	                <td align="center" class="first-cell">${news.title }</td>
	                <td align="center">${news.newsType.name }</td>
	                <td align="center">
	                   <c:if test="${news.isRecommend==true }">
	                		<img src="img/yes.gif" />
	                	</c:if>
	                	<c:if test="${news.isRecommend==false}">
	                		<img src="img/no.gif" />
	                	</c:if>
	                	
	                </td>
	                <td align="center">${news.inputDate }</td>
	                <td align="center">${news.user.name }</td>
	                
	                <td align="center">
		                <a href="" target="_blank" title="查看"><img src="img/icon_view.gif" width="16" height="16" border="0" /></a>
		                <a href="addNews?id=${news.id }" title="编辑"><img src="img/icon_edit.gif" width="16" height="16" border="0" /></a>
		                <a href="deleteNews?id=${news.id }" title="回收站"><img src="img/icon_trash.gif" width="16" height="16" border="0" /></a>
	                </td>
           		</tr>
            </c:forEach>
        </table>

    <!-- 分页开始 -->
        <table id="page-table" cellspacing="0">
            <tr>
                <td width="80%">&nbsp;</td>
                <td align="center" nowrap="true">
                    	 <a href="newsList?pageNo=${page.pageNo-1 }&type=${param.type}&isRecommend=${param.isRecommend}&keyword=${param.keyword}">上一页</a>
                    	 总共${page.pageCount}条，共${page.totalPage }页,当前第${page.pageNo }页
                    	<a href="newsList?pageNo=${page.pageNo+1 }&type=${param.type}&isRecommend=${param.isRecommend}&keyword=${param.keyword}">下一页</a> 
                    	
                </td>
            </tr>
        </table>
    <!-- 分页结束 -->
    </div>
</form>

<div id="footer">
共执行 7 个查询，用时 0.028849 秒，Gzip 已禁用，内存占用 3.219 MB<br />
版权所有 &copy; 2005-2012 上海商派网络科技有限公司，并保留所有权利。</div>
</body>
</html>