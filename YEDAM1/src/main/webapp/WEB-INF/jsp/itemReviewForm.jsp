<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

  <section class="checkout spad">
    <div class="container">
      <div class="checkout__form">
        <h4>상품 리뷰 작성</h4>

        <form action="itemReview.do" method="post" enctype="multipart/form-data">
          <div class="checkout__input">
            <label>상품명</label>
            <input type="text" value="${param.itemName}" readonly>
            <input type="hidden" name="itemCode" value="${param.itemCode}">
          </div>

          <div class="checkout__input">
            <label>별점</label>
            <div class="rating">
              <input type="radio" id="star5" name="starPoint" value="5"><label for="star5">★</label>
              <input type="radio" id="star4" name="starPoint" value="4"><label for="star4">★</label>
              <input type="radio" id="star3" name="starPoint" value="3"><label for="star3">★</label>
              <input type="radio" id="star2" name="starPoint" value="2"><label for="star2">★</label>
              <input type="radio" id="star1" name="starPoint" value="1"><label for="star1">★</label>
            </div>
          </div>

          <div class="checkout__input">
            <label>리뷰 내용</label>
            <textarea name="reviewDetail" rows="5" placeholder="리뷰를 입력하세요" class="checkout__textarea"></textarea>
          </div>

          <div class="checkout__input">
            <label>사진 업로드 (선택)</label>
            <input type="file" name="reviewImage">
          </div>

          <div class="checkout__input__checkbox" style="text-align:center; margin-top:20px;">
            <button type="submit" class="site-btn">등록하기</button>
            <a href="myOrderList.do" class="site-btn" style="background:#999;">취소</a>
          </div>

        </form>
      </div>
    </div>
  </section>

</body>
</html>