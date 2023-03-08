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
	//jQuery ����
	$(function () {
		$('#listBtn').click(function() {
			
			//alert("Test"+$('#id').val());
			$.ajaxSetup({ // Ajax ĳ�ø� ����
				cache:false
			});
			$.ajax({
				url:"../listJsonView",
				success: function(jsonData) {
					$('#target').html(""); // ����
					// json�����͸� jQuery �ݺ��ڸ� ����ؼ� ����ϱ�
					$.each(jsonData, function(k, v) {
						$('#target').append("<tr>"+k+":"+v+"</tr>");
						$.each(v, function(k, v) {
							if(v !== null)
						$('#target').append("<td>"+k+":"+v+"</td>");
						});
					});
					// target�� �ڽ��� p �±׸� �����ؼ�
					// jQuery�� css�Լ��� ����ؼ� �������� css�� ������ �� �ִ�
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