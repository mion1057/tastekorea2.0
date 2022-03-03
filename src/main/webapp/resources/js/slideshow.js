$(document).ready(function () {
            $(".mySlideDiv").not(".active").hide(); 
            
            setInterval(nextSlide, 4000); 
        });
        
        //이전 슬라이드
        function prevSlide() {
            $(".mySlideDiv").hide(); 
            var allSlide = $(".mySlideDiv"); 
            var currentIndex = 0; 
            
            $(".mySlideDiv").each(function(index,item){ 
                if($(this).hasClass("active")) {
                    currentIndex = index;
                }
                
            });
            
            //새롭게 나타낼 div의 index
            var newIndex = 0;
            
            if(currentIndex <= 0) {
                newIndex = allSlide.length-1;
            } else {
                newIndex = currentIndex-1;
            }
        
            //모든 div에서 active 클래스 제거
            $(".mySlideDiv").removeClass("active");
            
            //새롭게 지정한 index번째 슬라이드에 active 클래스 부여 후 show()
            $(".mySlideDiv").eq(newIndex).addClass("active");
            $(".mySlideDiv").eq(newIndex).show();
        
        }
        
        //다음 슬라이드
        function nextSlide() {
            $(".mySlideDiv").hide();
            var allSlide = $(".mySlideDiv");
            var currentIndex = 0;
            
            $(".mySlideDiv").each(function(index,item){
                if($(this).hasClass("active")) {
                    currentIndex = index;
                }
                
            });
            
            var newIndex = 0;
            
            if(currentIndex >= allSlide.length-1) {
                newIndex = 0;
            } else {
                newIndex = currentIndex+1;
            }
        
            $(".mySlideDiv").removeClass("active");
            $(".mySlideDiv").eq(newIndex).addClass("active");
            $(".mySlideDiv").eq(newIndex).show();
            
        }