<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<article>
    <header>
        <h1>memberListJsonDemo</h1>
    </header>
    <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
    <div class="container">
    <div class="row">
    <button id="listBtn">Click</button>
    	<div class="row justify-content-center">
    	<table class="table">
    	<thead>
    		<tr>
    			<td>Num</td>
    			<td>Id</td>
    			<td>Name</td>
    			<td>Age</td>
    			<td>Gender</td>
    		</tr>
    	</thead>
    	<tbody id="target">
    	</tbody>
    	</table>
    	</div>
    </div>
    </div>
</article>
<script>
	//jQuery 시작
	$(function () {
		$('#listBtn').click(function() {
			
			//alert("Test"+$('#id').val());
			$.ajaxSetup({ // Ajax 캐시를 삭제
				cache:false
			});
			$.ajax({
				url:"../listJsonView",
				success: function(jsonData) {
					$('#target').html(""); // 비우기
					// json데이터를 jQuery 반복자를 사용해서 출력하기
					$.each(jsonData, function(k, v) {
						$('#target').append("<tr>"+k+":"+v+"</tr>");
						$.each(v, function(k, v) {
							if(v !== null)
						$('#target').append("<td>"+k+":"+v+"</td>");
						});
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