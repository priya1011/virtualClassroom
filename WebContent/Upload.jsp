<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload</title>
</head>

<script type="text/javascript">
    if (document.addEventListener) { // IE >= 9; other browsers
        document.addEventListener('contextmenu', function(e) {
        	e.preventDefault();
        	<menu type="context" id="mymenu">
        	  <menuitem label="Refresh" onclick="window.location.reload();" icon="ico_reload.png"></menuitem>
        	  
        	  <menuitem label="Email This Page" onclick="window.location='mailto:?body='+window.location.href;"></menuitem>
        	</menu>

            
        }, false);
    } else { // IE < 9
        document.attachEvent('oncontextmenu', function() {
            alert("You've tried to open context menu");
            window.event.returnValue = false;
        });
    }
    
    function onSubmit() {
    	alert("successfully uploaded");
    	}
</script>

<body>

<form method="post" action="/Faculty/Upload" >

Description : 
<input type="text" name="description" placeholder="Enter the Description" required /> <br>

URL : 
<input type="text" name="url" placeholder="Enter the link of study material" /> <br>

<input type="submit" value="Upload" onClick="onSubmit()" />

</form>





</body>
</html>