<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 댓글관련 스타일 추가. -->
<style>
span {
	display: inline-block;
}

ul {
	list-style-type: none;
}
</style>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border-radius: 5px;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
	border-radius: 5px;
}
</style>

<!-- Product Details Section Begin -->

<!--<p>${itemInfoList[0] }</p> -->
<div class="col-6 col-lg-3 row">
	<!--<div class="" > -->



	<div class="col-3 " id="thumbNail">
		<img src="img/featured/${itemInfoList[1].itemImage }" alt="이미지 1">
		<img src="img/featured/${itemInfoList[2].itemImage }" alt="이미지 2">
		<img src="img/featured/${itemInfoList[3].itemImage }" alt="이미지 3">
		<img src="img/featured/${itemInfoList[4].itemImage }" alt="이미지 4">


	</div>

	<div class="col-9">
		<img id="thumbNailTarget"
			src="img/featured/${itemInfoList[0].itemImage }" alt="이미지 0">
	</div>



	<!-- </div> -->
</div>
<div class="col-6 col-lg-3 row">
	<div class="product__details__text">
		<h3>${itemInfoList[0].itemName }</h3>
		<div class="product__details__rating">
			<c:forEach var="i" begin="1"
				end="${Math.floor(itemInfoList[0].reviewStarPointAvg) }" step="1">
				<i class="fa fa-star"></i>
			</c:forEach>

			<c:if
				test="${Math.ceil(itemInfoList[0].reviewStarPointAvg) > Math.floor(itemInfoList[0].reviewStarPointAvg)}">
				<i class="fa fa-star-half-full"></i>
			</c:if>

			<c:forEach var="i" begin="1"
				end="${5- Math.ceil(itemInfoList[0].reviewStarPointAvg) }" step="1">
				<i class="fa fa-star-o"></i>
			</c:forEach>

			<span>(${itemInfoList[0].reviewCnt } reviews)</span>
		</div>
		<div class="product__details__price">$${itemInfoList[0].price }</div>

		<div class="product__details__quantity">
			<div class="quantity">
				<div class="pro-qty">
					<input type="text" value="1">
				</div>
			</div>
		</div>
		<a href="#" class="primary-btn">장바구니</a> <a href="#"
			class="primary-btn">바로구매</a>
		<ul>
			<li><b>delivery</b> <span>${itemInfoList[0].delivery }</span></li>
			<li><b>deliveryPrice</b> <span>${itemInfoList[0].deliveryPrice }</span></li>


		</ul>
	</div>
</div>

<div class="col-lg-2  row">
	<div>최근본상품 넣을곳</div>
	<img src="img/banner/testkuanggo2.JPG">
</div>

<div class="col-lg-12">
	<div class="product__details__tab">
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item"><a class="nav-link active"
				data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">상세정보</a>
			</li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#tabs-2" role="tab" aria-selected="false">리뷰</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#tabs-3" role="tab" aria-selected="false">문의사항</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="tabs-1" role="tabpanel">
				<div class="product__details__tab__desc">
					<h6>상세정보내역</h6>
					<p>${itemInfoList[0].description }</p>
				</div>
			</div>
			<div class="tab-pane" id="tabs-2" role="tabpanel">
				<div class="product__details__tab__desc">
					<h6>리뷰 게시판</h6>
					<div class="container reply">
						<!-- 댓글등록. -->

						<!-- 댓글목록. -->
						<div class="content">
							<ul>
								<li><span class="col-2">별점</span> <span class="col-6">내용</span>
									<span class="col-1">작성자</span> <span class="col-2">작성일시</span>
								</li>
								<li><hr /></li>
								<!--   <c:forEach var="replyInfo" items="${replyList }"> -->
								<li class="product__details__text"><span
									class="col-2 product__details__rating"> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</span> <span class="col-6">내용</span> <span class="col-1">작성자</span> <span
									class="col-2">작성일시</span></li>
								<!-- </c:forEach> -->

							</ul>
						</div>
						<!-- 댓글페이징. -->
						<div class="footerr" style="background: #F3F6FA;">
							<div class="pagination">
								<a href="#">&laquo;</a> <a href="#">1</a> <a href="#"
									class="active">2</a> <a href="#">3</a> <a href="#">4</a> <a
									href="#">5</a> <a href="#">6</a> <a href="#">&raquo;</a>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="tab-pane" id="tabs-3" role="tabpanel">
				<div class="product__details__tab__desc">
					<h6>문의처 전화번호</h6>
					<p>010-0000-0000</p>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- Product Details Section End -->
<script>
	const itemCode = "${itemCode }";
</script>
<script src="js/itemDetailViewService.js"></script>
<script src="js/itemDetailView.js"></script>
