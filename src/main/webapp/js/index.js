$(function () {
	// Slideshow 
	$("#slider").responsiveSlides({
		auto: true,
		pager: false,
		nav: true,
		speed: 500,
		timeout:4000,
		pager: true, 
		pauseControls: true,
		namespace: "callbacks"
		
	});
});


$(function(){
			$(".inter_content_r").eq(0).css("opacity","1").siblings(".inter_content_r").css("opacity","0");
		})
     $(document).ready(function(){
        $(".active1").mouseover(function(){
        	//alert("!23");
          $(".inter_content_r").eq(0).css("opacity","1").siblings(".inter_content_r").css("opacity","0");
         
        });
        
         $(".active2").mouseover(function(){
        	//alert("!23");
          $(".inter_content_r").eq(1).css("opacity","1").siblings(".inter_content_r").css("opacity","0");
         
        });
         $(".active3").mouseover(function(){
        	//alert("!23");
          $(".inter_content_r").eq(2).css("opacity","1").siblings(".inter_content_r").css("opacity","0");
         
        });
        
      })
     
