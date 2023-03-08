<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<article>
    <header>
        <h1>[회원찾기]deptJsonDemo</h1>
    </header>
    <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
    <div class="container">
    <div class="row">
 	<input type="text" id="id" name="id" placeholder="아이디를 입력해보세요">
 	<hr>
    <button id="jsonAjaxTest">Click</button>
    	<div id="target" class="row justify-content-center">Target!</div>
    </div>
    </div>
</article>
<script>
	//jQuery 시작
	$(function () {
		$('#jsonAjaxTest').click(function() {
			
			alert("Test"+$('#id').val());
			$.ajaxSetup({ // Ajax 캐시를 삭제
				cache:false
			});
			$.ajax({
				url:"../deptJsonView1?id="+$('#id').val(),
				success: function(jsonData) {
					$('#target').html(""); // 비우기
					console.log(jsonData);
					console.log(Object.keys(jsonData));
					console.log(Object.valueOf(jsonData));
					console.log(typeof(jsonData));
					// json데이터를 jQuery 반복자를 사용해서 출력하기
					$.each(jsonData, function(k, v) {
						console.log(k+":"+v);
						$('#target').append("<p>"+k+":"+v+"</p>");
					});
					// target의 자식인 p 태그를 선택해서
					// jQuery의 css함수를 사용해서 동적으로 css를 적용할 수 있다
					$('#target>p').css("background","pink")
					.css("text-align","center")
					.css("color","#ffffff");
				}
			});
		});
	});
</script>
</body>
</html>