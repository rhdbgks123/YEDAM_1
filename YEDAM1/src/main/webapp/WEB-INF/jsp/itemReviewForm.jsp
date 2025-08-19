<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<link href="./css/itemReview.css" rel="stylesheet" />
<c:set var="curDate" value="${empty orderHeader.ORDERDATE ? '' : orderHeader.ORDERDATE}" />
<h3 style="margin-top:24px;">${curDate} 주문 내역</h3>
<div class="order-box" style="border:1px solid #e6e9ef;border-radius:12px;margin:12px 0;overflow:hidden;">
    <div class="order-head" style="display:flex;justify-content:space-between;padding:12px 16px;background:#f3f5f9;font-weight:600;">
      <div>주문번호: <strong>${orderNo}</strong></div>
    </div>
    
	<div class="shoping__cart__table">
      <table>
        <thead>
          <tr>
            <th style="width:44%">상품명</th>
            <th style="width:12%">수량</th>
            <th style="width:16%">가격</th>
            <th style="width:16%">총액</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="d" items="${list}">
            <tr>
              <td style="text-align:left">${d.itemName}</td>
              <td>${d.itemQty}</td>
              <td>₩<fmt:formatNumber value="${d.itemPrice}" type="number"/></td>
              <td>₩<fmt:formatNumber value="${d.itemQty * d.itemPrice}" type="number"/></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <div style="padding:10px 16px; color:#666;">
      배송지: ${orderHeader.ADDRESS}
    </div>
  </div>

  <div class="review-card">
  <div class="head">리뷰 작성</div>
  <div class="body">
  
    <form action="itemReview.do" method="post">

        <input type="hidden" name="orderNo"  value="${orderNo}">
        <input type="hidden" name="itemCode" value="${itemCode}">

      <table class="review-table">
        <tr>
          <th>별점</th>
          <td>
            <div class="star-rating">
              <input type="radio" id="star5" name="starPoint" value="5"><label for="star5" title="5점">★</label>
              <input type="radio" id="star4" name="starPoint" value="4"><label for="star4" title="4점">★</label>
              <input type="radio" id="star3" name="starPoint" value="3" checked><label for="star3" title="3점">★</label>
              <input type="radio" id="star2" name="starPoint" value="2"><label for="star2" title="2점">★</label>
              <input type="radio" id="star1" name="starPoint" value="1"><label for="star1" title="1점">★</label>
            </div>
          </td>
        </tr>

        <tr>
          <th>상세리뷰</th>
          <td>
            <textarea name="reviewDetail" required
              placeholder="제품 사용 경험을 10자 이상 작성해 주세요."></textarea>
          </td>
        </tr>

        <tr>
          <th>사진첨부</th>
          <td>
            <input type="file" name="reviewImages" accept="image/*" multiple>
            <div style="color:#888; font-size:13px; margin-top:6px;">최대 3장 업로드 가능합니다.</div>
          </td>
        </tr>

        <tr>
          <th></th>
          <td>
            <div class="action-row">
              <a href="#">취소하기</a>
              <button type="submit" class="site-btn">등록하기</button>
            </div>
          </td>
        </tr>
      </table>
    </form>
  </div>
</div>

<script>
  function validateReview(form){
    var txt = form.reviewDetail ? form.reviewDetail.value.trim() : '';
    if (txt.length < 10) {
      alert('상세리뷰를 10자 이상 입력해 주세요.');
      if (form.reviewDetail) form.reviewDetail.focus();
      return false;
    }
    var files = form.reviewImages && form.reviewImages.files ? form.reviewImages.files : null;
    if (files && files.length > 3) {
      alert('이미지는 최대 3장까지 업로드할 수 있습니다.');
      return false;
    }
    return true;
  }
</script>