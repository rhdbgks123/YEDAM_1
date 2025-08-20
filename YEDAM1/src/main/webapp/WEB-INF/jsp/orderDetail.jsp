<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<c:forEach var="h" items="${headers}" varStatus="st">
  <c:set var="curDate" value="${empty h.ORDERDATE ? '' : h.ORDERDATE}"/>
  <c:if test="${st.first or prevDate != curDate}">
    <h3 style="margin-top:24px;">${curDate} 주문 내역</h3>
    <c:set var="prevDate" value="${curDate}"/>
  </c:if>

  <div class="order-box" style="border:1px solid #e6e9ef;border-radius:12px;margin:12px 0;overflow:hidden;">
    <div class="order-head" style="display:flex;justify-content:space-between;padding:12px 16px;background:#f3f5f9;font-weight:600;">
      <div>주문번호: <strong>${h.ORDERNO}</strong></div>
      <div>합계: ₩<fmt:formatNumber value="${h.TOTALPRICE}" type="number"/></div>
    </div>

    <div class="shoping__cart__table">
      <table>
        <thead>
          <tr>
            <th style="width:18%">상품</th>
            <th style="width:26%">스펙</th>
            <th style="width:16%">가격</th>
            <th style="width:12%">수량</th>
            <th style="width:16%">총액</th>
            <th style="width:12%"></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="d" items="${h.details}">
            <tr>
			  <td class="shoping_cart_item">
			    <a href="itemDetailView.do?itemCode=${d.itemCode}">
			    <c:choose>
				<c:when test="${not empty d.itemImage}">
				  <img src="img/featured/${d.itemImage}" alt="${d.itemName}">
				</c:when>
				<c:otherwise>
				  <img src="img/cart/cart-2.jpg" alt="${d.itemName}">
				</c:otherwise>
			    </c:choose></a>
			  </td>
			  <td><h5>${d.itemName}</h5>스펙이 들어와야해</td>
              <td>₩<fmt:formatNumber value="${d.itemPrice}" type="number"/></td>
              <td>${d.itemQty}</td>
              <td>₩<fmt:formatNumber value="${d.itemQty * d.itemPrice}" type="number"/></td>
              <td><a href="itemReviewForm.do?orderNo=${d.orderNo }&itemCode=${d.itemCode }" class="primary-btn" style="padding:6px 12px;">리뷰작성</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <div style="padding:10px 16px; color:#666;">
      배송지: ${h.ADDRESS}
    </div>
  </div>
</c:forEach>
