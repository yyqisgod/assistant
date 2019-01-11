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
        * {
            padding: 0;
            margin: 0;
        }

        a {
            text-decoration: none;
        }

        .btn {
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

        @keyframes colorchange {
            0% {
                color: red;
            }
            50% {
                color: green;
            }
            100% {
                color: #6993f9;
            }
        }

    </style>
    <link rel="stylesheet" type="text/css" href="photos/dist/partialviewslider.min.css">
    <link rel="stylesheet" type="text/css" href="jquery.barrager.js-master/static/css/bootstrap.min.css"
          media="screen"/>
    <link rel="stylesheet" type="text/css" href="jquery.barrager.js-master/static/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="jquery.barrager.js-master/dist/css/barrager.css">
    <link rel="stylesheet" type="text/css"
          href="jquery.barrager.js-master/static/pick-a-color/css/pick-a-color-1.2.3.min.css">
    <link type="text/css" rel="stylesheet"
          href="jquery.barrager.js-master/static/syntaxhighlighter/styles/shCoreDefault.css"/>
</head>
<body>
<ul id="partial-view" style="height: 100%;">
    <li>
        <img src="imgs/timg.jpg" />
    </li>
    <li>
        <img src="imgs/2.jpg"/>
    </li>
    <li>
        <img src="imgs/3.jpg"/>
    </li>
    <li>
        <img src="imgs/4.jpg"/>
    </li>
</ul>

<div id="input" style="position:absolute; left: 40%; top: 95% ;z-index:9999">
    <%--<button id="stop" class="btn btn-primary">停止</button>
    <button id="open" class="btn btn-primary">显示</button>
    <input type="text" class="form-control" name="" id="barrage_content" placeholder="添加弹幕内容">--%>
    <button class="btn btn-primary" id="submit_barraget" style="margin-left: 99px">进入抽奖环节</button>
</div>
<div style="display: none" class="audio-box">
    <div class="audio-container">
        <div class="audio-cover"></div>
        <div class="audio-view">
            <h3 class="audio-title">未知歌曲</h3>
            <div class="audio-body">
                <div class="audio-backs">
                    <div class="audio-this-time">00:00</div>
                    <div class="audio-count-time">00:00</div>
                    <div class="audio-setbacks">
                        <i class="audio-this-setbacks">
                            <span class="audio-backs-btn"></span>
                        </i>
                        <span class="audio-cache-setbacks">
							</span>
                    </div>
                </div>
            </div>
            <div class="audio-btn">
                <div class="audio-select">
                    <div class="audio-prev"></div>
                    <div class="audio-play"></div>
                    <div class="audio-next"></div>
                    <div class="audio-menu"></div>
                    <div class="audio-volume"></div>
                </div>
                <div class="audio-set-volume">
                    <div class="volume-box">
                        <i><span></span></i>
                    </div>
                </div>
                <div class="audio-list">
                    <div class="audio-list-head">
                        <p>?随心听</p>
                        <span class="menu-close">关闭</span>
                    </div>
                    <ul class="audio-inline">
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="jquery.barrager.js-master/static/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="jquery.barrager.js-master/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="jquery.barrager.js-master/static/js/tinycolor-0.9.15.min.js"></script>
<script type="text/javascript" src="jquery.barrager.js-master/dist/js/jquery.barrager.js"></script>
<script type="text/javascript" src="jquery.barrager.js-master/static/syntaxhighlighter/scripts/shCore.js"></script>
<script type="text/javascript"
        src="jquery.barrager.js-master/static/syntaxhighlighter/scripts/shBrushJScript.js"></script>
<script type="text/javascript" src="jquery.barrager.js-master/static/syntaxhighlighter/scripts/shBrushPhp.js"></script>
<script type="text/javascript"
        src="jquery.barrager.js-master/static/pick-a-color/js/pick-a-color-1.2.3.min.js"></script>
<script src="jiaoben5835/js/index.js"></script>
<script src="photos/dist/partialviewslider.min.js"></script>
<%--音乐引用--%>
<script type="text/javascript" src="LoginMusic/js/audio.js"></script>
<link rel="stylesheet" type="text/css" href="LoginMusic/css/audio.css">
</html>
<script type="application/javascript">
    //音乐
    $(function () {
        var song = [
            {
                'cover': 'LoginMusic/images/zy.jpg',
                'src': 'LoginMusic/song/wedding.mp3',
                'title': 'song'
            }
        ];

        var audioFn = audioPlay({
            song: song,
            autoPlay: true  //是否立即播放第一首，autoPlay为true且song为空，会alert文本提示并退出
        });

        /* 向歌单中添加新曲目，第二个参数true为新增后立即播放该曲目，false则不播放 */
        audioFn.newSong({
            'cover': 'LoginMusic/images/cover.jpg',
            'src': 'LoginMusic/song/wedding.mp3',
            'title': 'the xx'
        }, false);

        /* 暂停播放 */
        //audioFn.stopAudio();

        /* 开启播放 */
        //audioFn.playAudio();

        /* 选择歌单中索引为3的曲目(索引是从0开始的)，第二个参数true立即播放该曲目，false则不播放 */
        //audioFn.selectMenu(3,true);

        /* 查看歌单中的曲目 */
        //console.log(audioFn.song);

        /* 当前播放曲目的对象 */
        //console.log(audioFn.audio);
    });

    //后台获取所有弹幕并播放
    $.get("/barrage/list", function (data) {
        if (data.length !== 0) {
            //每条弹幕发送间隔
            var looper_time = 500;
            var items = data;
            //弹幕总数
            var total = data.length;
            //是否首次执行
            var run_once = true;
            //弹幕索引
            var index = 0;
            //先执行一次
            barrager();

            function barrager() {
                if (run_once) {
                    //如果是首次执行,则设置一个定时器,并且把首次执行置为false
                    looper = setInterval(barrager, looper_time);
                    run_once = false;
                }
                //发布一个弹幕
                $('body').barrager(items[index]);
                //索引自增
                index++;
                //所有弹幕发布完毕，清除计时器。
                if (index == total) {
                    clearInterval(looper);
                    return false;
                }
            }
        }
    });

    //点击进去抽奖环节
    $("#submit_barraget").click(function () {
        window.open("/luckydraw.jsp");
    })

    $('#partial-view').partialViewSlider({
        controls: false,
        pauseOnHover: false,
        width: 80
    })

    //每1秒钟获取一次text消息
    var msg;
    var user;

    function getText() {
        $.get("/wwsw/sendText", function (data) {
            if (data.text != null && data.text !== "" && data.text + data.userId !== msg + user && msg !== undefined) {
                //获取弹幕内容,前缀添加时间修饰
                var info = data.text;
                //随机获取颜色
                var colors = ["white", "red", "grenn", "blue", "yellow", "brown", "purple", "syan", "gray"];
                var size = Math.round(Math.random() * (colors.length - 1));
                var color = colors[size];
                //随机获取头像
                var imgs = ["jquery.barrager.js-master/static/img/haha.gif",
                    "jquery.barrager.js-master/static/img/cute.png",
                    "jquery.barrager.js-master/static/img/heisenberg.png"];
                var length = Math.round(Math.random() * (imgs.length - 1));
                var img = imgs[length];
                //点击弹幕跳转路径，默认wedding的github路径
                var href = "https://github.com/yyqisgod/wedding";
                //弹幕移动速度
                var speed = Math.round(Math.random() * 5) + 10;
                //构造字符串形式的弹幕对象
                var text_obj = '{"info":"' + info + '","color":"' + color + '","img":"' + img + '","href":"' + href + '","speed":"' + speed + '"}';
                $.ajax({
                     url: "/barrage/save",
                     type: "POST",
                     data: text_obj,
                     contentType: "application/json;charset=utf-8"
                 });
                var new_obj = eval('(' + text_obj + ')');       //转化为js对象
                $('body').barrager(new_obj);    //向插件中添加该danmu对象
            }
            msg = data.text;
            user = data.userId;
        });
    };
    window.setInterval(getText, 100);

</script>
