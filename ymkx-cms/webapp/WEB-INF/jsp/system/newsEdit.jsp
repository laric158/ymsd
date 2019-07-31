<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>源码快讯 管理中心  - 添加新商品 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="./styles/general.css" rel="stylesheet" type="text/css" />
<link href="./styles/main.css" rel="stylesheet" type="text/css" />

<style type="text/css">

.label{
    width: 100px !important;
    display: block;
}
</style>
</head>

<body>
<h1>
    <span class="action-span"><a href="">新闻列表</a>
    </span>
    <span class="action-span1"><a href="">源码快讯 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 添加 </span>
    <div style="clear:both"></div>
</h1>


<div class="tab-div">
	<input id="type_id" type="text" value="${news.type_id }">
	<input id="isRecommend" type="text" value="${news.isRecommend }">
    <div id="tabbar-div">
        <p>
            <span class="tab-front" id="general-tab">通用信息</span>
        </p>
    </div>
    <div id="tabbody-div">
        <form action="editNews" method="post">
            <table width="90%" id="general-table" align="center">
                <tr>
                    <td class="label">新闻标题：</td>
                    <td><input type="text" name="_title" value="${news.title }" size="30" />
                    <span class="require-field">*</span></td>
                </tr>
                <tr>
                    <td class="label">新闻分类：</td>
                    <td>
                        <select name="_type_id" id="_type_id">
				            <c:forEach items="${newsTypeList }" var="type">
				            	<option value="${type.id }">${type.name }</option>
				            </c:forEach>
				            
				        </select>
                        <span class="require-field">*</span>
                    </td>
                </tr>
                <tr>
                    <td class="label">是否推荐：</td>
                    <td>
                        <input type="radio" name="_isRecommend" value="true" checked="checked"/> 是
                        <input type="radio" name="_isRecommend" value="false"/> 否
                    </td>
                </tr>
                <tr>
                    <td class="label">新闻内容：</td>
                    <td>
                        <script id="container" name="_context" type="text/plain"></script>
                    </td>
                </tr>
            </table>
            <div class="button-div">
                <input type="submit" value=" 确定 " class="button"/>
                <input type="reset" value=" 重置 " class="button" />
            </div>
        </form>
    </div>
</div>

<script type="text/javascript"
		src="plugin/ueditor/ueditor.config.js"></script>
	<!-- 2，引入编辑器源码文件 -->
	<script type="text/javascript"
		src="plugin/ueditor/ueditor.all.js"></script>
	<!-- 3，实例化编辑器 (注意，这里拿的是上面显示HTML内容的script的id) -->
	<script type="text/javascript">
		var editor = UE.getEditor('container', {
			initialFrameWidth : 500, //初始代编辑器的宽度 
			initialFrameHeight : 200, //初始代编辑器的高度 
			initialContent : '${news.context}' //完成回显 
		});
	</script>

<script type="text/javascript">

	window.onload=function(){
		//1.回显新闻分类
		var type_id = document.getElementById("type_id").value;
		var _type_id = document.getElementById("_type_id");
		for(var i = 0;i<_type_id.length;i++){
			if(_type_id[i].value==type_id){
				_type_id.value = type_id;
				break;
			}
		}
		
		//2.回显是否推荐
		var isRecommend = document.getElementById("isRecommend").value;
		var _isRecommend = document.getElementsByName("_isRecommend");
		
		for(var i= 0;i<_isRecommend.length;i++){
			if(_isRecommend[i].value==isRecommend){
				_isRecommend[i].checked = "checked";
			}else{
				_isRecommend[0].checked = "checked";
			}
		}
		
	}
</script>
<div id="footer">
共执行 9 个查询，用时 0.025161 秒，Gzip 已禁用，内存占用 3.258 MB<br />
版权所有 &copy; 2005-2012 上海商派网络科技有限公司，并保留所有权利。</div>
</body>
</html>