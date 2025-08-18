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
    <img class="col-lg-12 col-md-6 col-sm-6" src="img/banner/testkuanggo2.JPG">
  </div>
</div>