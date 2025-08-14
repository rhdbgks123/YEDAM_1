<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-lg-6">


	<div class="row">
		<c:forEach var="items" items="${itemList }">
			<div class="col-lg-3 col-md-4 col-sm-6">
				<div class="featured__item">

					<a href="itemDetailView.do?itemCode=${items.itemCode }"><img src="img/featured/${items.itemImage}"></a>
					<div class="row">
						<div class="featured__item__text col-6">
							<h6>${items.itemName}</h6>
							<i class="fa fa-heart"></i><span>${items.starPoint}</span><i
								class="fa fa-pencil"></i><span>${items.reviewCnt}</span>

						</div>
						<div class="featured__item__text col-6">
							<h6>판매수</h6>
							<h6>재고</h6>
						</div>
					</div>
					<div class="row">
						<div class="col-12">${items.price}원</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>

</div>

<div class="col-lg-3">
<div>최근본상품 넣을곳</div>
<img src="img/banner/testkuanggo2.JPG">
</div>