<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<script src="/js/myCart.js"></script>

<section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping_cart_table">
                        <table>
                        
                            <thead>
                                <tr>
                                    <th class="shoping_product">상품</th>
                                    <th>가격</th>
                                    <th>수량</th>
                                    <th>총 금액</th>
                                    <th></th>
                                </tr>
                            </thead>
                            
                            <form id="cartForm">
                            <tbody>
                            <c:forEach var="c" items="${cartList }">
                                <tr>
                     		        <input type="checkbox" name="selectItem" value="${c.itemCode }">
                                    <td class="shoping_cart_item">
                                        <img src="img/cart/cart-1.jpg" alt="${c.itemName }">
                                        <h5>${c.itemName }</h5>
                                    </td>
                                    <td class="shoping_cart_price">
                                    	<span class="itemPrice">
                                    		<fmt:formatNumber value="${c.salePrice != 0 ? c.salePrice : c.price}" type="currency"/>
                                    	</span>
                                    </td>
                                    <td class="shoping_cart_quantity">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                <input type="number" name="qty_${c.itemCode }" value="${c.itemQty }" min="1">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="shoping_cart_total">
                                   		<!-- js에서 -->
                                        <span class="itemTotal"></span>
                                    </td>
                                    <td class="shoping_cart_item_close">
                                        <span class="icon_close"></span>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            </form>
                            
                        </table>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Cart Total</h5>
                        <ul>
                            <li>선택한 상품 금액 <span id="selectedItemTotal"></span></li>
                            <li>배송비 <span>$454.98</span></li>
                            <li>총 주문금액 <span>$454.98</span></li>
                        </ul>
                        <a href="#" class="primary-btn">결제하기</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->