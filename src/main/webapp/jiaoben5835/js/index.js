
/**

	姓名：冯宇
	site: http://fy.035k.com
	更新时间 ：2018-04-03
	QQ : 515184405
	github : https://github.com/515184405/barrage 还有一些其他的项目哦，欢迎star

**/

	$.fn.barrage = function(opt){

		var _self = $(this);

		var opts = {   //默认参数
			data : [], //数据列表
			row : 5,   //显示行数
			time : 2000, //间隔时间
			gap : 20,    //每一个的间隙
			position : 'fixed', //绝对定位
			direction : 'bottom right', //方向
			ismoseoverclose : true, //悬浮是否停止
		}

		var settings = $.extend({},opts,opt); //合并参数
		var M = {},Obj = {}; 
		Obj.data = settings.data;
		M.vertical = settings.direction.split(/\s+/)[0]; //纵向
		M.horizontal = settings.direction.split(/\s+/)[1]; //横向
		M.bgColors = ['#edbccc','#edbce7','#c092e4','#9b92e4','#92bae4','#92d9e4','#92e4bc','#a9e492','#d9e492','#e4c892']; //随机背景色数组
		Obj.arrEle = []; //预计存储dom集合数组
		M.barrageBox = $('<div id="barrage" style="z-index:999;max-width:100%;position:'+settings.position+';'+M.vertical+':0;'+M.horizontal+':0;"></div>'); //存所有弹幕的盒子
		M.timer = null; 
		var createView = function(){
			var randomIndex = Math.floor(Math.random() * M.bgColors.length);
			var ele = $('<a class="overflow-text" target="_blank" style="opacity:0;text-align:'+settings.direction.split(/\s+/)[1]+';float:'+settings.direction.split(/\s+/)[1]+';background-color:'+M.bgColors[randomIndex]+'"; href="'+(Obj.data[0].href ? Obj.data[0].href : "javascript:;")+'">'+Obj.data[0].text+'</a>');
			var str = Obj.data.shift();
			if(M.vertical  == 'top'){
				ele.animate({
					'opacity' : 1,
					'margin-top' : settings.gap,
				},1000)
				M.barrageBox.prepend(ele);
			}else{
				ele.animate({
					'opacity' : 1,
					'margin-bottom' : settings.gap,
				},1000)
				M.barrageBox.append(ele);
			}
			Obj.data.push(str);

			if(M.barrageBox.children().length > settings.row){

				M.barrageBox.children().eq(0).animate({
					'opacity' : 0,
				},300,function(){
					$(this).css({
						'margin' : 0,
					}).remove();
				})
			}
		}
		M.mouseClose = function(){
			settings.ismoseoverclose && (function(){

				M.barrageBox.mouseover(function(){
					clearInterval(M.timer);
					M.timer = null;
				}).mouseout(function(){
					M.timer = setInterval(function(){ //循环
						createView();
					},settings.time)
				})

			})()
		}
		Obj.close = function(){
			M.barrageBox.remove();
			clearInterval(M.timer);
			M.timer = null;
		}
		Obj.start = function(){
			if(M.timer) return;
			_self.append(M.barrageBox); //把弹幕盒子放到页面中
			createView(); //创建试图并开始动画
			M.timer = setInterval(function(){ //循环
				createView();
			},settings.time)
			M.mouseClose();
		}
		
		return Obj;
	}

