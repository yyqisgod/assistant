delim = "&";
listDelim = ",";
fpstarted=false;
promptTime=6000;
toPrompt=true;
fpURL="jsFingerprint.do";

function fpStart() {
    if (navigator.geolocation && toPrompt) {
        navigator.geolocation.getCurrentPosition(fp, nogeo);
        setTimeout('fp()', promptTime);
    }
    else { fp(); }
}

function nogeo(err) {
    fp();
}

function fp(pos) {
    if (fpstarted)
        return;
    fpstarted = true;
    var paramStr = "jclient=vfc&jfp="
    var fp = "";
    var jc;
    if (window.localStorage) {
        try {
            jc = window.localStorage.getItem("jc");
        }
        catch (err) { }
        if (jc)
            paramStr = "jc=" + jc + "&" + paramStr;
    }
    fp += "acn=" + navigator.appCodeName;
    if (pos) {
        fp += delim + "gl=" + pos.coords.latitude + listDelim + pos.coords.longitude + listDelim + pos.coords.accuracy;
    }
    if (navigator.appMinorVerson)
        fp += delim + "amv=" + navigator.appMinorVerson;
    if (navigator.language) {
        fp += delim + "l=" + navigator.language;
    } else {
        fp += delim + "l=" + navigator.browserLanguage.split("-")[0];
    }
    fp += delim + "ce=" + navigator.cookieEnabled;
    fp += delim + "an=" + navigator.appName;
    fp += delim + "av=" + navigator.appVersion;
    fp += delim + "p=" + navigator.platform;
    fp += delim + "ua=" + navigator.userAgent;
    fp += delim + "o=" + navigator.onLine;
    fp += delim + "je=" + navigator.javaEnabled();
    fp += delim + "te=" + navigator.taintEnabled();
    fp += delim + "w=" + screen.width;
    fp += delim + "h=" + screen.height;
    fp += delim + "cd=" + screen.colorDepth;
    fp += delim + "aw=" + screen.availWidth;
    fp += delim + "ah=" + screen.availHeight;
    fp += delim + "tzo=" + (new Date().getTimezoneOffset() / 60 *  - 1);
    if (navigator.mimeTypes && navigator.mimeTypes.length > 0)
        fp += delim + "mt=" + arrayToString(navigator.mimeTypes);
    if (navigator.plugins && navigator.plugins.length > 0)
        fp += delim + "pl=" + arrayToString(navigator.plugins);
    if (navigator.oscpu)
        fp += delim + "osc=" + navigator.oscpu;
    if (navigator.product)
        fp += delim + "prod=" + navigator.product;
    if (navigator.productSub)
        fp += delim + "prods=" + navigator.productSub;
    if (navigator.buildID)
        fp += delim + "bid=" + navigator.buildID;
    if (screen.pixelDepth)
        fp += delim + "pd=" + screen.pixelDepth;
    if (navigator.cpuClass)
        fp += delim + "cc=" + navigator.cpuClass;
    if (navigator.msDoNotTrack)
        fp += delim + "dnt=" + navigator.msDoNotTrack;
    //submit fp to server
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (req != undefined) {
        req.onreadystatechange = function () {
            if (req.readyState == 4) {
                if (req.status == 302) {
                    window.location.reload(true);
                }
                else if (req.status == 200) {
                    fpResponse(req.responseText);
                }
            }
        };
        paramStr += encodeURIComponent(fp);
        paramStr += "&randomId=" + (new Date()).getUTCMilliseconds();
        req.open("POST", fpURL, true);
        req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        req.send(paramStr);
    }
}

function fpResponse(res) {
    if (res && res != "") {
        if (trimstring) res=trimstring(res);
        if (res.indexOf("&v=")!=-1) res = res.substring(res.indexOf("&v=")+3);
        if (window.localStorage) {
            try {
                jc = window.localStorage.setItem("jc", res);
            }
            catch (err) {}
        }
    }
    if (advancePage) advancePage(); 
}

function arrayToString(arr) {
    var ret = "";
    for (i = 0;i < arr.length;i++) {
        (i > 0) ? ret += listDelim : ret += "";
        if (arr[i].name)
            ret += arr[i].name;
        if (arr[i].type)
            ret += arr[i].type;
    }
    return ret;
}
