<%--
  Created by IntelliJ IDEA.
  User: bici
  Date: 2018/12/10
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Title</title>
    <style type="text/css">
        *{
            padding:0;
            margin:0;
        }
        a{
            text-decoration: none;
        }

        .form-control{
            display: inline-block;
            width: auto;
            padding: 6px 12px;
            font-size: 14px;
            line-height: 1.42857143;
            color: #555;
            background-color: #fff;
            background-image: none;
            border: 1px solid #ccc;
            border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
            -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
        }

        .btn{
            display: inline-block;
            padding: 6px 12px;
            margin-bottom: 0;
            font-size: 14px;
            font-weight: 400;
            line-height: 1.42857143;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            -ms-touch-action: manipulation;
            touch-action: manipulation;
            cursor: pointer;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            background-image: none;
            border: 1px solid transparent;
            border-radius: 4px;
        }

        .btn-primary {
            color: #fff;
            background-color: #337ab7;
            border-color: #2e6da4;
        }

        /*组件主样式*/
        .overflow-text{
            display: block;
            white-space:nowrap;
            overflow:hidden;
            text-overflow:ellipsis;
            opacity:0;
            clear: both;
            padding:3px 10px;
            border-radius: 10px;
            box-sizing: border-box;
            max-width: 100%;
            color:#fff;
            animation:colorchange 3s infinite alternate;
            -webkit-animation:colorchange 3s infinite alternate; /*Safari and Chrome*/
        }
        @keyframes colorchange{
            0%{
                color:red;
            }
            50%{
                color:green;
            }
            100%{
                color:#6993f9;
            }
        }
        /*组件主样式*/

    </style>
    <link rel="stylesheet" type="text/css" href="photos/dist/partialviewslider.min.css">
</head>
<body>
    <ul id="partial-view" style="height: 100%;">
        <li>
            <img src="imgs/1.jpg" />
        </li>
        <li>
            <img src="imgs/2.jpg" />
        </li>
        <li>
            <img src="imgs/3.jpg" />
        </li>
        <li>
            <img src="imgs/4.jpg" />
        </li>
    </ul>

    <div id="danmu"></div>
    <div id="input" style="position:absolute; left: 40%; top: 95% ;z-index:9999">
        <button id="stop" class="btn btn-primary">停止</button>
        <button id="open" class="btn btn-primary">显示</button>
        <input type="text" class="form-control" name="" id="barrage_content" placeholder="添加弹幕内容">
        <button class="btn btn-primary" id="submit_barraget" style="margin-left: 1px">发送</button>
    </div>
</body>
<script src="jquery.min.js"></script>
<script src="jquery.danmu.js-master/dist/jquery.danmu.min.js"></script>
<script src="jiaoben5835/js/index.js"></script>
<script src="photos/dist/partialviewslider.min.js"></script>
<script src="danmu.js"></script>
</html>
<script type="application/javascript">
    //弹幕初始化
    var offsetWid = document.documentElement.clientWidth;
    var offsetHei = document.documentElement.clientHeight;
    if (/(Android)/i.test(navigator.userAgent)){     // 判断是否为Android手机
        offsetWid = screen.width;
        offsetHei = screen.height;
    }else if(/(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent)){  // 判断是否为苹果手机
        offsetWid=document.documentElement.clientWidth;
        offsetHei=document.documentElement.clientHeight;
    }
    $("#danmu").danmu({
        height: offsetHei ,  //弹幕区高度
        width: offsetWid,   //弹幕区宽度
        zindex :100,   //弹幕区域z-index属性
        speed:7000,      //滚动弹幕的默认速度，这是数值值得是弹幕滚过每672像素所需要的时间（毫秒）
        sumTime:65535,   //弹幕流的总时间
        danmuLoop:false,   //是否循环播放弹幕
        defaultFontColor:"#FFFFFF",   //弹幕的默认颜色
        fontSizeSmall:16,     //小弹幕的字号大小
        FontSizeBig:24,       //大弹幕的字号大小
        opacity:"0.9",			//默认弹幕透明度
        topBottonDanmuTime:6000,   // 顶部底部弹幕持续时间（毫秒）
        SubtitleProtection:false,     //是否字幕保护
        positionOptimize:false,         //是否位置优化，位置优化是指像AB站那样弹幕主要漂浮于区域上半部分
        maxCountInScreen: 40,   //屏幕上的最大的显示弹幕数目,弹幕数量过多时,优先加载最新的。
        maxCountPerSec: 10      //每分秒钟最多的弹幕数目,弹幕数量过多时,优先加载最新的。
    });

    //后台获取所有弹幕并播放
    $.get("/barrage/list", function (data) {
        $('#danmu').danmu("addDanmu", data);//添加弹幕
        $('#danmu').danmu('danmuStart');//运行
    });

    //点击发送弹幕
    $("#submit_barraget").click(function () {
        send_danmu();
        $("#barrage_content").val("");
    })
    //回车发送弹幕
    $(window).keydown(function (e) {
        if(e.keyCode==13){
            send_danmu();
            $("#barrage_content").val("");
        }
    })

    $('#partial-view').partialViewSlider({
        controls:false,
        pauseOnHover:false,
        width:80
    })

    //每1秒钟获取一次text消息
    var msg;
    var user;
    function getText() {
        $.get("/wwsw/sendText",function (data) {
            if(data.text!=null && data.text !="" && data.text+data.userId != msg+user &&msg!=undefined){
                //获取弹幕内容
                text=data.text;
                //随机获取颜色
                var colors = ["white","red","grenn","blue","yellow","brown","purple","syan","gray"];
                var size=Math.round(Math.random()*(colors.length-1));
                var color = colors[size];
                //弹幕方式 0滚动 1顶部 2底部
                var position = 0;
                //弹幕大小 0小号 1大号
                var size = 1;
                //弹幕发送时间
                var time = $('#danmu').data("nowTime") +1;
                //构造字符串形式的弹幕对象
                var text_obj = '{"text":"' + text + '","color":"' + color + '","size":"' + size + '","position":"' + position + '","time":"' + time + '"}';
                // $.post("/barrage/save", text_obj);       //向服务器推送danmu对象的字符串形式
                $.ajax({
                    url: "/barrage/save",
                    type: "POST",
                    data: text_obj,
                    contentType: "application/json;charset=utf-8"
                });
                var new_obj = eval('(' + text_obj + ')');       //转化为js对象
                $('#danmu').danmu("addDanmu",new_obj);    //向插件中添加该danmu对象
            }
            msg=data.text;
            user=data.userId;
        });
    };
    window.setInterval(getText,100);

</script>
