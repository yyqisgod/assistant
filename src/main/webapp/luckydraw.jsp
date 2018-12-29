<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="bg4" charset="UTF-8" >
<head>

    <!--There is a special meta tag you can append into the document header which resets this in most Android and iPhone devices.-->

    <!--[if IE]> <link rel="stylesheet" type="text/css" href="css/ie.css" /><![endif]-->
    <title>sc.chinaz.com</title>

    <meta http-equiv="Content-Type" content="text/html; charset="UTF-8" /></head>
<body><meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<section id="container" class="blue">

    <!-- TOOLS PANEL-->
    <a href="#" id='show-hide'>+</a>
    <div id="tools" style="display:none;">
        <div id="skins-select">
            <a href="#" class="blue skins" id="blue-skin">蓝</a>
            <a href="#" class="red skins" id="red-skin">红</a>
            <a href="#" class="purple skins" id="purple-skin">紫</a>
            <a href="#" class="green skins" id="green-skin">绿</a>
        </div>
        <div id="pattern-select">
            <a href="#" class="pattern" id="pat1"><span id="day"></span><img src="img/bg.png" /></a>
            <a href="#" class="pattern" id="pat2"><span id="hour"></span><img src="img/bg1.png" /></a>
            <a href="#" class="pattern" id="pat3"><span id="minute"></span><img src="img/bg2.png" /></a>
            <a href="#" class="pattern" id="pat4"><span id="second"></span><img src="img/bg3.png" /></a>
        </div>
    </div>
    <!-- / TOOLS PANEL -->

    <br />
    <!-- WELCOME TEXT -->
    <p>抽奖环节倒计时<br /><span>Please look forward to.</span></p>
    <!-- WELCOME TEXT -->

    <br />

    <!-- COUNTDOWN // html code generated in main.js -->
    <div id="count"></div>
    <!-- /COUNTDOWN  -->




</section>

<!--JS FILES LOAD-->
<script src="script/jquery.min.js" type="text/javascript"></script>
<script src="script/jcountdown.min.js" type="text/javascript"></script>
<script src="script/main.js" type="text/javascript"></script>

<SCRIPT language=javascript>
    var seconds=61;
    //document.write("");
    function show_student163_time(){
        window.setTimeout("show_student163_time()", 1000);
        BirthDay=new Date("12-29-2018");//改成你的计时日期
        today=new Date();
        timeold=(BirthDay.getTime()-today.getTime());
        sectimeold=timeold/1000
        secondsold=Math.floor(sectimeold);
        msPerDay=24*60*60*1000
        e_daysold=timeold/msPerDay
        daysold=Math.floor(e_daysold);
        e_hrsold=(e_daysold-daysold)*24;
        hrsold=Math.floor(e_hrsold);
        e_minsold=(e_hrsold-hrsold)*60;
        minsold=Math.floor((e_hrsold-hrsold)*60);
        seconds--;
        //document.getElementById("days-count").innerHTML=daysold + "<span class=\"days-label\">天</span>";
        //document.getElementById("hours-count").innerHTML=hrsold  + "<span class=\"days-label\">时</span>";
        //document.getElementById("min-count").innerHTML=minsold + "<span class=\"days-label\">分</span>";
        document.getElementById("sec-count").innerHTML=seconds + "<span class=\"days-label\">秒</span>";
    }
    show_student163_time();
</SCRIPT>
</body>
</html>