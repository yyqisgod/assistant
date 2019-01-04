var undefined;
var bharosaAuthenticator = "Bharosa_Register_Pad";

var ns4=document.layers
var ie4=document.all
var ns6=document.getElementById&&!document.all
var loginIdRegExpr = "[\\w\\.\\-\\@]";

// If location.replace not supported, try assign
if (location.replace == null)   location.replace = location.assign;

function isDigit(num) {
	for (var i=0, valid="1234567890"; i<num.length; i++) {
		if (valid.indexOf(num.charAt(i)) == -1) {
			return false;
  		}
	}
	return true;
}

function trimstring(str){
	if (str) {
	if (str.replace) {
		var val = str.replace(/(^\s*)|(\s*$)/g,"");
		return val;
	} else {
		return stringtrim(str)
	}
	}
	return str;
}

function stringtrim(str){
var newstr = "";
str = str.toLowerCase();
for(var i = 0; i < str.length; i++){
	var ch = str.charAt(i);
	if(ch == ' ') {
		continue;
	}
	newstr = newstr + ch;
}
return newstr;
}

function validatePass(str){
  str = trimstring(str);
  if (str.length < 3){
	  return false;
  }
  return true;
}
//methods and variables specifically for pinpad.

function replaceHtmlChars(str) {
str = trimstring(str);
if (str == '') {
return "";
}
if (str.replace) {
var val = str.replace(/(\>)*(\<)*/g,"");
str = val;
}
return str;
}

function replaceHtmlEscapeChars(str) {
	var str = str.replace(/(\')/g,"&#39;");
	str = str.replace(/(\<)/g,"&lt;");
	str = str.replace(/(\>)/g,"&gt;");
	str = str.replace(/(\")/g,"&quot;");
	str = str.replace(/(\,)/g,"&#44;");
	str = str.replace(/(\\)/g,"&#92;");
	return str;
}

function isValidLoginId(str,fieldName) {
	var regExpr = loginIdRegExpr;
	
	var result = str.match(regExpr);
	
	if (! result || result == null || result.length != str.length) {
	alert(app_messages.validateInvalidChars.insertValues(fieldName));
		return false;
	}
	return true;
}


//methods and variables specifically for answer page.

var maxDisplayChars = "****";
var maxPinLength = 25;
var minPinLength = 3;
var imgDir = 'images/';
var focusIndex = '';


function hide_keypad(keypad) {
keypad.canHide = true;
keypad.hide();
hideImgLinks();
}

function hideImgLinks() {
var sfield = '';
  for (var i=0 ; i < page_pads.length; i++) {
	sfield = page_pads[bharosaAuthenticator+i].name + 'Icon';
	if (document.getElementById(sfield)){
		document.getElementById(sfield).innerHTML = '&nbsp;';
	}
  }
}

function enableSubmit(show) {

var text = '';
var enable = true;
for (var i=0 ; i < page_pads.length; i++) {
text = page_pads[bharosaAuthenticator+i].dataField.value;
if (text == '' || text == ':') {
enable = false;
break;
}
}

if (page_pads.length > 0) { submitForm(); }
}

function onClickEnter(keypad) {
	var show = syncData(keypad);

	if (show){
		hide_keypad(keypad);
		enableSubmit(show);
	}
}

function onClickEnterTP(index) {
	focusIndex = index;
	if (validateFields()) {
		page_pads[bharosaAuthenticator+index].dataField.form.submit();
	}
}

function syncData(keypad){

var elem = keypad.dataField;
	if (elem) {
		var value = elem.value;
		if (value != '' && value != ':') {
			var displayChars = keypad.dataDiv.innerHTML;
			if (displayChars.length < minPinLength) {
				alert(app_messages.validateMinMaxLength.insertValues([minPinLenght, maxPinLength]));
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
}

function validateAnswers() {
var text = '';
var num = '';
var index = -1;
for (var i=0 ; i < page_pads.length; i++) {
text = page_pads[bharosaAuthenticator+i].dataField.value;
if (text == '' || text == ':') {
if (index == -1) {
index = i;
}
num = num + ", " + (i+1);
}
}
if (num.indexOf(',') == 0) {
num = num.substring(1,num.length);
}

if (num != '') {
alert(app_messages.validateEmptyAnswers + " - " + num);
showPadWithFocus(index);
return false;
}
return true;
}

function validateSecurityQA() {
var flag = validateQuestions();
if (flag) {
flag = validateAnswers();
}
return flag;
}

function validateQuestions() {
var num = page_pads.length;
for (var i = 0; i < num; i++) {
var elem = document.getElementById("question"+i);
var index = elem.selectedIndex;
var value = '';
if (index != -1) {
  value = elem.options[index].value;
}
value = trimstring(value);
if (value == '') {
alert(app_messages.validateSelectQuestions);
document.getElementById("question"+i).focus();
return false;
}
}

//check if the user has selected same question again.
for (var j = 0; j < num; j++) {
  var quest = document.getElementById("question"+j);
  var qVal = quest[quest.selectedIndex].value;
for (var k = j+1; k < num; k++) {
  var checkQuest = document.getElementById("question"+k);
  var checkQVal = checkQuest[checkQuest.selectedIndex].value;
if (checkQVal == qVal) {
alert(app_messages.validateDuplicateQuestion);
document.getElementById("question"+k).focus();
return false;
}
}
}
return true;
}

function submitForm() {
if (validateQuestions()) {
page_pads[0].dataField.form.submit();
}
}

var whatsThisName = "";
function whatsThis(name){
  if (name != undefined && name != "") {
    helpWindow(name);
  } else {
    helpWindow("whatsthis");
  }
}

function helpWindow(helpName) {
var helpWinWidth = 840;
var helpWinHeight = 710;

var helpWinFeatures = 'directories=no,location=no,menubar=no,status=no,titlebar=no,toolbar=no,scrollbars=yes,resizable=yes,top= 5,left= 5, width='+helpWinWidth + ',height=' + helpWinHeight ;

var url = helpName + ".jsp";

var win = window.open(url,'bharosaInfoWindow',helpWinFeatures);

try {
win.focus();
} catch(e) {}
}

function infoWindow(infoName) {
var infoWinWidth = 440;
var infoWinHeight = 210;

var infoWinFeatures = 'directories=no,location=no,menubar=no,status=no,titlebar=no,toolbar=no,scrollbars=yes,resizable=yes,top= 100,left= 150, width='+infoWinWidth + ',height=' + infoWinHeight ;

var url =  "message.do?msg=" + infoName;

var win = window.open(url,'bharosaHelpWindow',infoWinFeatures);

try {
win.focus();
} catch(e) {}
}

function showPad(index) {
  var pad = page_pads[bharosaAuthenticator+index];
  if (pad != undefined){
  	pad.show();
  }
  for (i=0;i<page_pads.length;i++){
    var inputContent = document.getElementById("registerQuestionsInput"+i);
    var arrowContent = document.getElementById("registerQuestionsArrow"+i);

    if (inputContent != undefined){
	  inputContent.className = (i==index?"registerQuestionsInputSelected":"registerQuestionsInput");
	}
    if (arrowContent != undefined){
	  arrowContent.className = (i==index?"registerQuestionsArrowSelected":"registerQuestionsArrow");
	}
  }
}


function showPadWithFocus(index) {
  var pad = page_pads[bharosaAuthenticator+index];
  if (pad != undefined){
	  pad.show();
	  pad.setFocus();
  }
}

function validateSecurityQAforTP() {
var num= page_pads.length;
if (num > 0) {
var text = '';
//validate the focused textfield
if (!validateAnswerTP(focusIndex)) {
showPadWithFocus(focusIndex);
return false;
}

//check if any other answer fields are empty
for (var i=0 ; i < page_pads.length; i++) {
var tIndex = bharosaAuthenticator+i;
var elem = page_pads[tIndex].dataField;
text = trimstring(elem.value);
//elem.value = text;
if (text == '') {
showPad(i);
return false;
}
}
} //end of num if condition

var flag = validateQuestionsTP();
if (flag) {
flag = validateAnswersTP();
}
return flag;
}

function validateAnswerTP(index) {
var elem = page_pads[bharosaAuthenticator+index].dataField;
if (elem) {
text = trimstring(elem.value);
//elem.value = text;
if (text == '') {
alert(app_messages.validateEmptyAnswer);
return false;
}

if (text.length < minPinLength || text.length > maxPinLength) {
alert(app_messages.validateMinMaxLength.insertValues([minPinLength, maxPinLength]));
return false;
}
}
return true;
}

function validateQuestionsTP() {
var num = page_pads.length;
for (var i = 0; i < num; i++) {
var qIndex = i;
var elem = document.getElementById("question"+qIndex);
var index = elem.selectedIndex;
var value = '';
if (index != -1) {
  value = elem.options[index].value;
}
value = trimstring(value);
if (value == '') {
alert(app_messages.validateSelectQuestions);
document.getElementById("question"+qIndex).focus();
return false;
}
}

  //check if the user has selected same question again.
  for (var j = 0; j < num; j++) {
    var quest = document.getElementById("question"+j);
    var qVal = quest[quest.selectedIndex].value;
  for (var k = j+1; k < num; k++) {
    var checkQuest = document.getElementById("question"+k);
    var checkQVal = checkQuest[checkQuest.selectedIndex].value;
  if (checkQVal == qVal) {
  alert(app_message.validateDuplicateQuesetion);
  document.getElementById("question"+k).focus();
  return false;
}
}
}
return true;
}

function validateAnswersTP() {
var text = '';
var num = '';
var index = -1;

for (var i=0 ; i < page_pads.length; i++) {
var tIndex = bharosaAuthenticator+i;
var elem = page_pads[tIndex].dataField;
text = trimstring(elem.value);
//elem.value = text;
if (text == '') {
if (index == -1) {
index = i;
}
num = num + ", " + (tIndex);
}
}
if (num.indexOf(',') == 0) {
num = num.substring(1,num.length);
}

if (num != '') {
alert(app_messages.validateEmptyAnswers + " - " + num);
showPad(index);
return false;
}

for (var i=0 ; i < page_pads.length; i++) {
  var tIndex = bharosaAuthenticator+i;
  var elem = page_pads[tIndex].dataField;
  text = elem.value;

  if (text.length < minPinLength) {
       alert(app_messages.validateMinMaxLength.insertValues([minPinLength, maxPinLength]));
       showPadWithFocus(i);
       return false;
  }
}
return true;
}

String.prototype.insertValues = function(values){
	var retVal = this;
    if(isArray(values)) {
		for (var i=0;i<values.length;i++){
			retVal = retVal.replace(new RegExp("\\{" + i + "\\}", "gi") , values[i]);
		}	
	}else{
		// values is not an array
		retVal = retVal.replace(new RegExp("\\{0\\}", "gi") , values);
	}
	return retVal;
}

function isArray(obj) {
   if (obj.constructor.toString().indexOf("Array") == -1) {
      return false;
   }else{
      return true;
   }
}
