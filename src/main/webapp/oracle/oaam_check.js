

function stripHTML()
{
        var orgURL=location.href;
        var tempURL=orgURL;
        orgURL.replace(/[\"\'][\s]*javascript:(.*)[\"\']/g, "\"\"");
    orgURL = orgURL.replace(/%22%3E%3Cscript(.*)/g, "");
        orgURL = orgURL.replace(/script(.*)/g, "");
        orgURL = orgURL.replace(/eval\((.*)\)/g, "");
        if(tempURL.length!= orgURL.length)
      location.href=orgURL;

}

// check if username or password is null or has illegal characters
function validateFieldsLoginPage(processing_text) 
{	
    var elemUsername = document.getElementById("userid");
    var userid = elemUsername.value;
    userid = trimstring(userid);
    elemUsername.value = userid;
    var elemPassword = document.getElementById("pass");
    var pass = elemPassword.value;
    pass = trimstring(pass);
    elemPassword.value = pass;
    
	if (userid == '' || pass == '') 
	{		
		document.getElementById('required').className = "error-show";
		
		try
        {
            document.getElementById('errormsg').className = "error-hide";
        }
        catch (err)
        {
        }
		
        setFocusLoginPage();
        return false;
    }
	
    if (!isValidLoginId(userid,"Username")) 
	{		
        elemPassword.focus();
		elemUsername.focus();
        return false;
    }

	var isButtonDisabled = document.getElementById('signin_button').disabled;
	
	if (isButtonDisabled)
	{
		return false;
	}
	else
	{
		document.getElementById('signin_button').disabled = true;
		document.getElementById('signin_button').value = processing_text;
		return true;
	}
}

// set the focus on password field if username exists
function setFocusLoginPage()
{  
    var elemUsername = document.getElementById("userid");
    var userid = elemUsername.value;
    userid = trimstring(userid);
	var elemPassword = document.getElementById("pass");
    var pass = elemPassword.value;
    pass = trimstring(pass);
          
    if(userid != null && userid != "")
    {
      elemUsername.focus();
	  elemPassword.focus();
    }
    else
    {
      elemUsername.focus();
    }
}

//-->

