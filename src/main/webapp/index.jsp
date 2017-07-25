<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户上传图片页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<center>
    <form action="/upload" method="post"
          enctype="multipart/form-data">

        <input type="text" name="contentJson"/><br/>

        <input type="file" name="file"/><br/>
        <input type="file"
               name="file"/><br/> <input type="file" name="file"/><br/> <input
            type="submit" value="上 传"/>
    </form>
    <h5>上传结果：</h5>

</center>
</body>
</html>