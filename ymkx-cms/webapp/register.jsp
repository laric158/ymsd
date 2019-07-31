<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>源码快讯 管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="styles/general.css" rel="stylesheet" type="text/css" />
<link href="styles/main.css" rel="stylesheet" type="text/css" />

<style type="text/css">

#errMsg{
color:red;
font-weight: bold;
}
</style>
</head>
<body style="background: #278296;color:white">
<form method="post" action="register" onsubmit="return validate()">
    <table cellspacing="0" cellpadding="0" style="margin-top:100px" align="center">
        <tr>
            <td>
                <img src="img/login.png" width="178" height="256" border="0" alt="ECSHOP" />
            </td>
            <td style="padding-left: 50px">
                <table>
                    <tr>
                        <td>注册姓名：</td>
                        <td>
                            <input type="text" name="username" id="username"/>
                        </td>
                    </tr>
                    <tr>
                        <td>注册密码：</td>
                        <td>
                            <input type="password" name="password" id="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                        <span id = "errMsg">${errMsg }</span>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="submit" value="注册账号"  />
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
  <input type="hidden" name="act" value="signin" />
</form>

<script type="text/javascript">

	function validate(){
		//1.获取输入的账号
		var username = document.getElementById("username").value.trim();
		//2.获取输入的密码
		var password = document.getElementById("password").value.trim();
		
		//3.获取提示信息元素
		var errMsg = document.getElementById("errMsg");
		if(username.length<1||password.length<1){
			errMsg.innerHTML = "账号或密码为空!!!";
			return false;
		}
		return true;
	}
	
	
</script>
</body>


</html>