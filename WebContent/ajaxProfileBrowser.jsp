<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Browser</title>
<!--
<script>

function createXMLHttpRequest(){
      if( typeof XMLHttpRequest == "undefined" )
          XMLHttpRequest = function() {
          return new XMLHttpRequest();
    }
}

var AJAX = createXMLHttpRequest();

function handler() {
      if(AJAX.readyState == 4 && AJAX.status == 200) {
          var json = eval('(' + AJAX.responseText +')');
          alert('Success. Result: name => ' + json.name + ',' + 'balance => ' + json.balance);
      }else if (AJAX.readyState == 4 && AJAX.status != 200) {
        alert('Something went wrong...');
      }
    }
function show(){
      AJAX.onreadystatechange = handler;
      AJAX.open("GET", "service.jsp");
      AJAX.send("");
    };




        function loadXMLDoc() {
                var xmlhttp;
                if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                        xmlhttp = new XMLHttpRequest();
                } else {// code for IE6, IE5
                        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function() {
                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                                document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
                        }
                }
                xmlhttp.open("GET", "ajax_info.txt", true);
                xmlhttp.send();
        }
</script>
 -->

<script>
	function doAjaxCall() {
		req = new XMLHttpRequest();
		if (req != null) {
			  try {
			//req.send("AjaxRetriveProfile.action", "username=sriram", "POST");
			req.open("POST", "AjaxRetriveProfile.action?username=sriram", true);
			req.onreadystatechange = setAjaxOutput;
			req.send();
			  } catch (e) {
				    alert("Can't connect to server:\n" + e.toString());
			       }
		}
	}

	function setAjaxOutput() {
		var jsonObject = null;
		if (req.readyState == 4 && req.status == 200) {
			jsonObject = eval("(" + req.responseText + ")");
			//console = document.getElementById('console');
			console.log(jsonObject);
			//document.getElementById("textarea1").innerHTML = jsonObject;
			document.getElementById("myDiv").innerHTML = jsonObject;
			//toFinalConsole(jsonObject);
		}
	}


</script>
</head>
<body>
    <!-- <a href="#" onclick="javascript:show();"> Click here to get JSON data from the server side</a> -->

    <s:form action="AjaxRetriveProfile">
        <s:textfield name="username" label="User name" onblur="doAjaxCall()" />
        <!--<s:textarea id="textarea1" label="Response" value="" style="width:'192px'; height:'90px';" readonly="true"></s:textarea>-->
        <s:submit value="submit" align="left" />
    </s:form>
        <br/><br/>
        Response :
        <div id="myDiv" style="color: red;font-weight: bold"></div>

</body>
</html>

