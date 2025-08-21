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
    .anchor-modal { position: fixed; z-index: 1000; width: 280px; max-width: calc(100vw - 32px); border-radius: 12px; border: 1px solid rgba(0,0,0,0.1); box-shadow: 0 12px 32px rgba(0,0,0,0.18); background: #fff; opacity: 0; transform: translateY(-6px); pointer-events: none; transition: opacity .18s ease, transform .18s ease; }
    .anchor-modal.open { opacity: 1; transform: translateY(0); pointer-events: auto; }
    .anchor-modal header { padding: 12px 14px 0; font-weight: 700; font-size: 15px; }
    .anchor-modal .body { padding: 10px 14px 14px; font-size: 14px; color: #333; }
    .anchor-modal .actions { display: flex; gap: 8px; padding: 0 14px 14px; }
    .anchor-modal .actions a, .anchor-modal .actions button { flex: 1; text-align: center; padding: 10px 12px; border-radius: 10px; border: 1px solid #ddd; background: #fff; font-size: 14px; text-decoration: none; color: #111; }
    .anchor-modal .actions a.primary { background: #111; color: #fff; border-color: #111; }

    /* 반투명 배경 (클릭으로 닫기) */
    .backdrop { position: fixed; inset: 0; background: rgba(0,0,0,0.2); opacity: 0; pointer-events: none; transition: opacity .18s ease; z-index: 999; }
    .backdrop.open { opacity: 1; pointer-events: auto; }

    /* 접근성: 키보드 포커스 링 */
    .anchor-modal .actions a:focus, .anchor-modal .actions button:focus, button:focus { outline: 3px solid #7aa7ff; outline-offset: 2px; }
</style>

<!-- Product Details Section Begin -->

<!--<p>${itemInfoList[0] }</p> -->
<div class="col-lg-7 ">
<div class="row ">

	<!--<div class="" > -->



	<div class="col-1 " id="thumbNail">
	<c:forEach var="i" begin="1" end="${itemInfoList.size()-1}" step="1">
    <img src="img/featured/${itemInfoList[i].itemImage}" alt="이미지 ${i}">
   </c:forEach>
					
		

	</div>

	<div class="col-5">
		<img id="thumbNailTarget"
			src="img/featured/${itemInfoList[0].itemImage }" alt="이미지 0">
	</div>




	<!-- </div> -->
	<div class="col-6 ">
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
			<div class="product__details__price">${itemInfoList[0].price }원</div>

		<div class="product__details__quantity">
			<div class="quantity">
				<div class="pro-qty">
					<input id = "selected_item_qty" type="text" value="1">
				</div>
			</div>
		</div>
		<br>
		<a href="#" class="primary-btn" id = "btnAddCart">장바구니</a> 
		<a href="#" class="primary-btn" id = "btnDirect">바로구매</a>
		<ul>
			<li><b>delivery</b> <span>${itemInfoList[0].delivery }</span></li>
			<li><b>deliveryPrice</b> <span>${itemInfoList[0].deliveryPrice }</span></li>


			</ul>
		</div>
	</div>

</div>
</div>

  <div id="backdrop" class="backdrop" aria-hidden="true"></div>
  <div id="anchorModal" class="anchor-modal" role="dialog" aria-modal="true" aria-labelledby="modalTitle" aria-describedby="modalDesc">
    <header id="modalTitle">장바구니에 담았습니다 🛒</header>
    <div id="modalDesc" class="body">
      쇼핑을 계속하시겠어요, 아니면 장바구니로 이동할까요?
    </div>
    <div class="actions">
      <button id="btnContinue">쇼핑 계속하기</button>
      <a id="btnGoCart" class="primary" href="myCart.do">장바구니 가기</a>
    </div>
  </div>
  
<div class="col-lg-2">
  <div class="row">

    <div class="col-lg-12 col-md-6 col-sm-6 sidebar__item">
                              <div class="latest-product__text">
                                  <h4>Latest Products</h4>


                                    <div class="latest-product__slider owl-carousel">
                                        <div class="latest-prdouct__slider__item">
                                            <c:forEach var="lastitems" items="${lastItemList }">
                                            <a  href="itemDetailView.do?itemCode=${lastitems.itemCode }" class="latest-product__item ">

                                                <div class="latest-product__item__pic">                                                
                                                    <img src="img/featured/${lastitems.itemImage }" alt="">                                                    
                                                </div >


                                            </a>
                                         </c:forEach>
                                        </div>

                                    </div>

                              </div>
              </div>
    <!-- <img class="col-lg-12 col-md-6 col-sm-6" src="img/banner/testkuanggo2.JPG"> -->
  </div>
</div>

<div class="col-lg-12">
	<div class="product__details__tab" style="padding-top: 0px"><!-- class="product__details__tab" -->
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
	const selectCount = "${selectCount }";
</script>
<script src="js/itemDetailViewService.js"></script>
<script src="js/itemDetailView.js"></script>
