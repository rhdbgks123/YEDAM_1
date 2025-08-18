<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-lg-7">


	<div class="row">
		<c:forEach var="items" items="${itemList }">
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="featured__item">

					<a href="itemDetailView.do?itemCode=${items.itemCode }"><img src="img/featured/${items.itemImage}"></a>
					<div class="row">
						<div class="featured__item__text col-6">
							<h6>${items.itemName}</h6>
							<i class="fa fa-heart"></i><span>${items.reviewStarPointAvg}</span><i
								class="fa fa-pencil"></i><span>${items.reviewCnt}</span>

						</div>
						<div class="featured__item__text col-6">
							<h6>판매금액</h6>
							<h6>${items.price}원</h6>
						</div>
					</div>
					
				</div>
			</div>
		</c:forEach>

	</div>

</div>

<div class="col-lg-2">
<div>최근본상품 넣을곳</div>
<img src="img/banner/testkuanggo2.JPG">
</div>