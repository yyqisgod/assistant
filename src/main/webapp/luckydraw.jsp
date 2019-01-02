<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="bg4" charset="UTF-8">
<head>

    <!--There is a special meta tag you can append into the document header which resets this in most Android and iPhone devices.-->

    <!--[if IE]>
    <link rel="stylesheet" type="text/css" href="css/ie.css"/><![endif]-->

    <meta http-equiv="Content-Type" content="text/html; charset="utf-8" />
</head>
<script src="./js/layui.js" charset="utf-8"></script>
<script src="script/jquery.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="./css/layui.css"  media="all">
<body>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<section id="container" class="blue">

    <!-- TOOLS PANEL-->
    <a href="#" id='show-hide'>+</a>
    <div id="tools" style="display:none;">
        <div id="skins-select">
            <a href="#" class="purple skins" id="purple-skin">紫</a>
            <a href="#" class="blue skins" id="blue-skin">蓝</a>
            <a href="#" class="red skins" id="red-skin">红</a>
            <a href="#" class="green skins" id="green-skin">绿</a>
        </div>
        <div id="pattern-select">
            <a href="#" class="pattern" id="pat1"><span id="day"></span><img src="img/bg.png"/></a>
            <a href="#" class="pattern" id="pat2"><span id="hour"></span><img src="img/bg1.png"/></a>
            <a href="#" class="pattern" id="pat3"><span id="minute"></span><img src="img/bg2.png"/></a>
            <a href="#" class="pattern" id="pat4"><span id="second"></span><img src="img/bg3.png"/></a>
        </div>
    </div>
    <!-- / TOOLS PANEL -->

    <br/>
    <!-- WELCOME TEXT -->
    <p>抽奖环节倒计时<br/></p>
    <br/>
    <p id="mynameP">请大家发送 <br/></p><br/>
    <!-- COUNTDOWN // html code generated in main.js -->
    <div id="count"></div>
    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
   <%-- &lt;%&ndash;默认消失 秒数==0的时候出来-%>--%>
    <p id="MyList" style="display: none">中奖名单是:</p>
    <%--进度条--%>
<div id="Mydiv" style="display: none">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>计算抽奖中奖名单中...</legend>
    </fieldset>

    <div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="demo">
        <div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
    </div>

    <div class="site-demo-button" style="margin-top: 20px; margin-bottom: 0;display: none">
        <button  class="layui-btn site-demo-active" data-type="setPercent">设置50%</button>
        <button id="MyButton" class="layui-btn site-demo-active" data-type="loading">模拟loading</button>
    </div>
</div>
</section>
<script>
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        //触发事件
        var active = {
            //让进度条突然走到50% 没啥用
            setPercent: function(){
                //设置50%进度
                element.progress('demo', '50%')
            }
            //动态加载进度条
            ,loading: function(othis){
                var DISABLED = 'layui-btn-disabled';
                if(othis.hasClass(DISABLED)) return;
                var n= 0;
                //模拟loading
                    timer = setInterval(function(){
                    n = n + Math.random()*40|0;
                    if(n>100){
                        n = 100;
                        layer.closeAll();
                        clearInterval(timer);
                        othis.removeClass(DISABLED);
                    }
                    element.progress('demo', n+'%');
                }, 300+Math.random()*1000);

                othis.addClass(DISABLED);
            }
        };

        $('.site-demo-active').on('click', function(){
            var othis = $(this), type = $(this).data('type');
            active[type] ? active[type].call(this, othis) : '';
        });
    });
</script>


<script src="script/jcountdown.min.js" type="text/javascript"></script>
<script src="script/main.js" type="text/javascript"></script>

</body>

<script type="text/javascript">
    var seconds = null;
    $(function () {
       $.get("/wwsw/msg",function (result) {
           seconds=result.time;
           $("#mynameP").append("\""+result.name+"\" <br />至订阅号参与抽奖");
       })
    });
    window.onload=function () {
        $.get("/wwsw/getCode",function (obj) {
            $("#MyList").append(obj.id+" ");
        })
    };
    //document.write("");
    function show_student163_time() {
        window.setTimeout("show_student163_time()", 1000);
        BirthDay = new Date("12-29-2018");//改成你的计时日期
        today = new Date();
        timeold = (BirthDay.getTime() - today.getTime());
        sectimeold = timeold / 1000;
        secondsold = Math.floor(sectimeold);
        msPerDay = 24 * 60 * 60 * 1000;
        e_daysold = timeold / msPerDay;
        daysold = Math.floor(e_daysold);
        e_hrsold = (e_daysold - daysold) * 24;
        hrsold = Math.floor(e_hrsold);
        e_minsold = (e_hrsold - hrsold) * 60;
        minsold = Math.floor((e_hrsold - hrsold) * 60);
        seconds--;
        //document.getElementById("days-count").innerHTML=daysold + "<span class=\"days-label\">天</span>";
        //document.getElementById("hours-count").innerHTML=hrsold  + "<span class=\"days-label\">时</span>";
        //document.getElementById("min-count").innerHTML=minsold + "<span class=\"days-label\">分</span>";
        document.getElementById("sec-count").innerHTML=seconds + "<span class=\"days-label\">秒</span>";
        //倒计数结束后---展示中奖信息
       if (seconds == 0) {
           //让倒计数消失
           $("#sec-count").attr("style","display: none");
            //结束后让P标签出来
           $("#Mydiv").attr("style","display: block");
           //当秒数==0的时候 点击一下进度条模拟一波
            $("#MyButton").click();
            //延迟大概10s后 让进度条消失，并且展示中奖List
           setTimeout(function () {
               $("#Mydiv").attr("style","display: none");
               $("#MyList").attr("style","display: block");
           },10000);

        }
    }

    show_student163_time();
</script>
</html>