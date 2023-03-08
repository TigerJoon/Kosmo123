<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%--load c3.css --%>
<link href="${pageContext.request.contextPath}/resources/css/c3.css" rel="stylesheet">
<style></style>
<!-- Load d3.js and c3.js -->
<script src="${pageContext.request.contextPath}/resources/js/d3-5.8.2.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/c3.min.js"></script>
<article>
    <header>
        <h1>Chart Demo</h1>
    </header>
    <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
    <div class="container">
    	<div id="chart"></div>
    </div>
</article>
<script>
// ������ json�� �Ľ��� ������
let jsondata ={};
jsondata.wheather =[];
jsondata.wheather.push({ ���ɾ��� : 120, �𸨴ϴ� : 666, �񰡿ɴϴ� : 500, �ȿɴϴ� : 200, ��ǳ�̿ɴϴ� : 54});
console.log(jsondata.wheather[0]);
// bar��Ʈ : ������� �����Ϳ��� ������� �̸��� axis.x.category
var chart = c3.generate({
	bindto: '#chart',
	// data.json api
    data: {
    	json: jsondata.wheather,
    	    keys: {
    	      // x: 'name', // it's possible to specify 'x' when category axis
    	      value: ['���ɾ���', '�𸨴ϴ�', '�񰡿ɴϴ�', '�ȿɴϴ�','��ǳ�̿ɴϴ�']
   	 	},
    // data: type
    type:'donut'
		},
		donut : {
			title : "���� �������� ����"
		},
    axis: {
        x: {
            type: 'category',
            categories: [jsondata.wheather[0].name]
        }
    }
});
console.log(typeof(jsondata.wheather));
</script>
</body>
</html>