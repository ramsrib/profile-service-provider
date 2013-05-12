
function fetchUser() {

	console = document.getElementById('console');
	var selectBox = document.getElementById('AjaxRetriveProfile_username');
	var selectedIndex = selectBox.selectedIndex;
	var selectedValue = selectBox.options[selectedIndex].value;
	sendRequest("AjaxRetriveProfile.action", "username=" + selectedValue, "POST");

}

function doAjaxCall() {
	req = new XMLHttpRequest();
	if (req != null) {
        req.send("AjaxRetriveProfile.action", "username=sriram", "POST");

	req.onreadystatechange = setAjaxOutput;
	}
}


function setAjaxOutput() {
	var ready = req.readyState;
	var jsonObject = null;
	if(ready == READY_STATE_COMPLETE) {
		jsonObject = eval("(" + req.responseText + ")");
		console.log(jsonObject);
		toFinalConsole(jsonObject);
	}


}

