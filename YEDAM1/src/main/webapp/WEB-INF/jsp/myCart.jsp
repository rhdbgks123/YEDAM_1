<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>


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
									<th style="width: 14%">총 금액</th>
									<th style="width: 48px"></th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="c" items="${cartList }">

									<tr style="text-align: center">
										<td><input type="checkbox" name="selectItem"
											value="${c.itemCode }"></td>
										<td class="shoping_cart_item"><img
											src="img/cart/cart-1.jpg" alt="${c.itemName }">
											</td>
										<td class="shoping_cart_spec"><h5>${c.itemName }</h5>스펙이 들어와야해</td>
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
										<td class="shoping_cart_item_close"><span
											class="icon_close"></span></td>
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
						<a href="#" class="primary-btn">결제하기</a>
					</div>
				</div>
			</div>
		</form>
	</div>
</section>
<!-- Shoping Cart Section End -->

<!--  js 연결 -->
<script src="<c:url value='/js/myCart.js'/>" defer></script>