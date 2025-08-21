<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<head>
</head>


<h3 id="itemCode" style="display:none;">${empty itemCode ? '' : itemCode}</h3>
<section class="shoping-cart spad">
	<div class="container">
		<form id="cartForm" action="payments.do" method="post">
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__table">
						<table>

							<thead>
								<tr style="text-align: center">
									<th style="width: 48px"><input type="checkbox"
										id="checkAll"></th>
									<th style="width: 18%">상품</th>
									<th style="width: 36%">스펙</th>
									<th style="width: 12%">가격</th>
									<th style="width: 15%">수량</th>
									<th style="width: 14%">총액</th>
									<th style="width: 48px"></th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="c" items="${cartList }">

									<tr style="text-align: center">
										<td><input type="checkbox" name="selectItem"
											value="${c.itemCode }"></td>
										<td class="shoping_cart_item">
										<a href="itemDetailView.do?itemCode=${c.itemCode}">
										<c:choose>
										  <c:when test="${not empty c.itemImage}">
  										    <img src="img/featured/${c.itemImage}" alt="${c.itemName}">
										  </c:when>
										  <c:otherwise>
  										    <img src="img/cart/cart-2.jpg" alt="${c.itemName}">
										  </c:otherwise>
										</c:choose>
										</a>
										</td>
										<td class="shoping_cart_spec"><h5>${c.itemName }</h5>${c.itemName} 스펙</td>
										<td class="shoping_cart_price"><span class="itemPrice">
												<fmt:formatNumber
													value="${c.salePrice != 0 ? c.salePrice : c.price}" />
										</span></td>
										<td class="shoping_cart_quantity">
											<div class="quantity">
												<div class="pro-qty">
													<input type="number" name="qty_${c.itemCode}"  value="${c.itemQty }" min="1">
												</div>
											</div>
										</td>
										<td class="shoping_cart_total"><span class="itemTotal"></span>
										</td>
										<td class="shoping_cart_item_close">
										<span class="icon_close" data-itemCode="${c.itemCode}"></span></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-6" style="margin: 0 auto">
					<div class="shoping__checkout">
						<h5>주문 예상 금액</h5>
						<ul>
							<li>총 상품 가격 <span id="selectedItemTotal"></span></li>
							<li>총 배송비 <span id="deliveryPrice"></span></li>
							<li>총 주문 금액 <span id="orderTotal"></span></li>
						</ul>
						<a href="#" id="openPayModal" class="primary-btn">결제하기</a> 
						
					</div>
				</div>
			</div>
		</form>
	</div>
</section>

<!--  js 연결 -->
<script>const rmItem = "${cartList }";</script>
<script src="<c:url value='/js/myCart.js'/>" defer></script>