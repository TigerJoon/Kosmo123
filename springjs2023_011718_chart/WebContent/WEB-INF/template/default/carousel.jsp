<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
margin-bottom
:
 
5%;
min-height
:
 
200
px
;


}
.card-caption h4 {
	margin-bottom: 8px;
	font-style: bold;
}

.card button {
	margin-top: 16px;
}

.card-text {
	margin: 8px 0;
	color: #232323;
}

#map {
	display: flex;
	width: 100%;
	min-height: 300px;
	height: 100%;
}
</style>
<div id="demo" class="carousel slide" data-bs-ride="carousel">
	<!-- Indicators/dots -->
	<div class="carousel-indicators">
		<button type="button" data-bs-target="#demo" data-bs-slide-to="0"
			class="active"></button>
		<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
		<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
	</div>

	<!-- The slideshow/carousel -->
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="${pageContext.request.contextPath}/resources/image/d1.jpg"
				alt="Kosmo113" class="d-block" style="width: 100%">
			<div class="carousel-caption">
				<h3>UI 요구사항 확인하기,UI 설계하기</h3>
				<p>
					<c:choose>
						<c:when test="${sessionScope.sessionID != null }">
        	${sessionScope.sessionName}님 반가워요. 오늘 날씨가 너무 좋네요 
        </c:when>
						<c:otherwise>
         	jQuery 를 이용하여 제공받은 샘플파일에서 아래 요구사항대로 구현합니다.
        </c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
		<div class="carousel-item">
			<img src="${pageContext.request.contextPath}/resources/image/d2.jpg"
				alt="Carousel" class="d-block" style="width: 100%">
			<div class="carousel-caption">
				<h3>오프라인 jQuery 스터디 모임</h3>
				<p>
					<c:choose>
						<c:when test="${sessionScope.sessionID != null }">
        	${sessionScope.sessionName}님 반가워요. 오늘 날씨가 너무 좋네요 
        	 	<div class="card">
						<div class="row no-gutters">
								<div class="col-8">
									<div id="map"></div>
								</div>
									<div class="col-4">
										<div class="card-body">
											<h4 class="card-text">jQuery스터디 모임</h4>
											<p class="card-text">서울 금천구 가산디지털1로 151 2층 B강의실</p>
											<button type="button" class="btn btn-dark"
												onclick="alert('Open 준비중!')">jQuery스터디 모임 확인</button>
										</div>
									</div>
								</div>
							</div>
						</c:when>
						<c:otherwise>
         	jQueary 를 이용하여 제공받은 샘플파일에서 아래 요구사항대로 구현합니다.
         	로그인을 하면 장소를 확인 할 수 있어요
        </c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
		<div class="carousel-item">
			<%-- image를 세션값이 따라 변경 해보는 데모 --%>
			<c:choose>
				<c:when test="${sessionScope.sessionID != null }">
					<c:set var="imgv3" value="d9.jpg" scope="page" />
				</c:when>
				<c:otherwise>
					<c:set var="imgv3" value="d3.jpg" scope="page" />
				</c:otherwise>
			</c:choose>
			<img
				src="${pageContext.request.contextPath}/resources/image/${imgv3}"
				alt="JSP" class="d-block" style="width: 100%">
			<div class="carousel-caption">
				<h3>UI 요구사항 확인하기,UI 설계하기</h3>
				<p>
					<%--image를 세션값에 따라 메세지 변경 해보는 데모 --%>
					<c:choose>
						<c:when test="${sessionScope.sessionID != null }">
        	${sessionScope.sessionName}님 반가워요. 당신이 좋아하는 선물은?
        </c:when>
						<c:otherwise>
        	 오늘의 날씨 같은거 출력 해주면 어떨까?
        </c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
	</div>

	<!-- Left and right controls/icons -->
	<button class="carousel-control-prev" type="button"
		data-bs-target="#demo" data-bs-slide="prev">
		<span class="carousel-control-prev-icon"></span>
	</button>
	<button class="carousel-control-next" type="button"
		data-bs-target="#demo" data-bs-slide="next">
		<span class="carousel-control-next-icon"></span>
	</button>
</div>
<%--kakao map API --%>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f2d9a4b6a086417e1d0f52473d5aeae&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 

//마커를 생성합니다
var marker = new kakao.maps.Marker({
position: markerPosition
});

//마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);
</script>