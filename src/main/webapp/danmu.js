//发送新弹幕
function send_danmu() {
    //获取弹幕内容
    var text = $("#barrage_content").val();
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
