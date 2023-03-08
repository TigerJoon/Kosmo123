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
// 서버측 json을 파싱한 데이터
let wheather ={
		관심없음 : 120, 
		모릅니다 : 666, 
		비가옵니다 : 500, 
		안옵니다 : 200, 
		태풍이옵니다 : 54
};
// bar차트 : 사용자의 데이터에서 사용자의 이름을 axis.x.category
var chart = c3.generate({
	bindto: '#chart',
	// data.json api
    data: {
    	json: wheather,
    	  /*  keys: {
    	      // x: 'name', // it's possible to specify 'x' when category axis
    	      value: ['관심없음', '모릅니다', '비가옵니다', '안옵니다','태풍이옵니다']
   	 	},*/
    // data: type
    type:'donut'
		},
		donut : {
			title : "날씨 설문조사 내용"
		}
   /* axis: {
        x: {
            type: 'category',
            categories: [jsondata.wheather[0].name]
        }
    }*/
});
console.log(typeof(wheather));
</script>
</body>
</html>