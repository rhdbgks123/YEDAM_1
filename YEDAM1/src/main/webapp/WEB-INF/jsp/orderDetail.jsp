<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매 내역</title>
</head>
<body>
	<section class="shoping-cart spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__table">
						<table>
							<thead>
								<tr>
									<th class="shoping__product">주문번호</th>
									<th>주문일자</th>
									<th>상품명</th>
									<th>수량</th>
									<th>가격</th>
									<th>총액</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="prevNo" value="" />
								<c:forEach var="row" items="${orders}">
									<tr>
										<c:choose>
											<c:when test="${prevNo != row.orderNo}">
												<td>${row.orderNo}</td>
												<td><fmt:formatDate value="${row.orderDate}"
														pattern="yyyy-MM-dd" /></td>
											</c:when>
											<c:otherwise>
												<td></td>
												<td></td>
											</c:otherwise>
										</c:choose>

										<td class="shoping__cart__item">${row.itemName}</td>
										<td class="shoping__cart__quantity">${row.itemQty}</td>
										<td class="shoping__cart__price">₩<fmt:formatNumber
												value="${row.itemPrice}" type="number" />
										</td>
									</tr>
									<c:set var="prevNo" value="${row.orderNo}" />
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>