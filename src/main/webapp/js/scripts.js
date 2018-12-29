/* -- TWITTER MAKE IT WORK ( JUST REMPLACE MY USERNAME BY YOURS -- */
/*
     jQuery(function($){
        $("#ticker").tweet({
          username: "Supview",
          page: 1,
          avatar_size: 0,
          count: 10,
		  template: "{text}{time}",
		  filter: function(t){ return ! /^@\w+/.test(t.tweet_raw_text); },
          loading_text: "loading ..."
        }).bind("loaded", function() {
          var ul = $(this).find(".tweet_list");
          var ticker = function() {
            setTimeout(function() {
              ul.find('li:first').animate( {marginTop: '-30px'}, 500, function() {
                $(this).detach().appendTo(ul).removeAttr('style');
              });
              ticker();
            }, 5000);
          };
          ticker();
        });
      });
*/

jQuery(function($) {
/* -- SELECTED CLASS ON SCROLLING -- */

var header_height = $('#nav').outerHeight();
var sections = [];
	$('#nav a').each(function(){
		if (this.hash && $(this.hash).length > 0) {
			var section = $(this.hash).offset()
			sections.push({
				'link':$(this).parent(),
				'top' : $(this.hash).offset().top-header_height,
				'bottom' : $(this.hash).offset().top + $(this.hash).outerHeight() -header_height
			});
		}
		
	});
	

	$('#nav a, #tab a').click(function (e) {
		var t = e.currentTarget;
		if (this.hash && $(this.hash).length > 0) {
			e.preventDefault();
			$('html,body').animate({
				scrollTop: $(this.hash).offset().top - header_height
			}, 500);
		}
	});
    
    
$(window).scroll(function(){   
    for(var i = 0; i < sections.length; i++)
        if($(window).scrollTop() >= sections[i].top &&
           $(window).scrollTop() <= sections[i].bottom){
            sections[i].link.addClass('selected')
                .siblings().removeClass('selected');
        }
});


/* -- STICKY NAV -- */

$(document).ready(function() {
	$('.my-sticky-nav').waypoint('sticky');
});



/* -- ROLES OF HEADER -- */

var current = 1; 
var height = $('.roles').height(); 
var numberDivs = $('.roles').children().length; 
var first = $('.roles div:nth-child(1)'); 
setInterval(function() {
    var number = current * -height;
    first.css('margin-top', number + 'px');
    if (current === numberDivs) {
        first.css('margin-top', '0px');
        current = 1;
    } else current++;
}, 2000);


/* -- MOBILE NAVIGATION -- */

	 $(function() {
	   
      // Create the dropdown base
      $("<select />").appendTo("#nav");
		 
      // Create default option "Go to..."
      $("<option />", {
         "selected": "selected",
         "value"   : "",
          "text"    : $("#nav").attr("data-mobile")
      }).appendTo("nav select");
		 
		 // Populate dropdown with menu items
      $("nav li a").each(function() {
       var el = $(this);
       $("<option />", {
           "value"   : el.attr("href"),
           "text"    : el.text()
       }).appendTo("nav select");
      });
      
	   // To make dropdown actually work
		 $("nav select").change(function() {
			 var l = $(this).find("option:selected").val();
			 if (l) {
				 window.location = l;
			 }
      });
	 
	 });


/* -- WORKS GRID LOADER -- */

			//$(function() {
				Grid.init();
			//});


});