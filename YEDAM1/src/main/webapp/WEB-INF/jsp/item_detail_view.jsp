<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Product Details Section Begin -->
    
            
                <div class="col-lg-3 col-md-3">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large"
                                src="img/featured/${itemInfoList[0].itemImage }" alt="">
                        </div>
                        <div class="product__details__pic__slider owl-carousel">
                            <img data-imgbigurl="img/featured/${itemInfoList[1].itemImage }"
                                src="img/featured/${itemInfoList[1].itemImage }" alt="">
                            <img data-imgbigurl="img/featured/${itemInfoList[2].itemImage }"
                                src="img/featured/${itemInfoList[2].itemImage }" alt="">
                            <img data-imgbigurl="img/featured/${itemInfoList[3].itemImage }"
                                src="img/featured/${itemInfoList[3].itemImage }" alt="">
                            <img data-imgbigurl="img/featured/${itemInfoList[4].itemImage }"
                                src="img/featured/${itemInfoList[4].itemImage }" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3">
                    <div class="product__details__text">
                        <h3>${itemInfoList[0].itemName }</h3>
                        <div class="product__details__rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-half-o"></i>
                            <span>(18 reviews)</span>
                        </div>
                        <div class="product__details__price">$${itemInfoList[0].price }</div>
                        <p>Mauris </p>
                        <div class="product__details__quantity">
                            <div class="quantity">
                                <div class="pro-qty">
                                    <input type="text" value="1">
                                </div>
                            </div>
                        </div>
                        <a href="#" class="primary-btn">ADD TO CARD</a>
                        <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
                        <ul>
                            <li><b>delivery</b> <span>${itemInfoList[0].delivery }</span></li>
                            <li><b>deliveryPrice</b> <span>${itemInfoList[0].deliveryPrice }</span></li>
                            
                            
                        </ul>
                    </div>
                </div>
                
                <div class="col-lg-2">
<div>최근본상품 넣을곳</div>
<img src="img/banner/testkuanggo2.JPG">
</div>
                
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                    aria-selected="true">Description</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                                    aria-selected="false">Information</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                    aria-selected="false">Reviews <span>(1)</span></a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Products Infomation</h6>
                                    <p>Vestibulum ac diam sit amet 111 </p>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Products Infomation</h6>
                                    <p>Vestibulum ac diam 222.</p>
                                    
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Products Infomation</h6>
                                    <p>Vestibulum ac 3333 </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            
        
    <!-- Product Details Section End -->

