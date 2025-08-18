<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<table>

	<thead>
		<tr style="text-align: center">
			<th style="width: 48px"><input type="checkbox" id="checkAll"></th>
			<th style="width: 18%">상품</th>
			<th style="width: 36%">스펙</th>
			<th style="width: 12%">가격</th>
			<th style="width: 15%">수량</th>
			<th style="width: 14%">총 금액</th>
			<th style="width: 48px"></th>
		</tr>
	</thead>

	<tbody>
			<tr style="text-align: center">
				<td><input type="checkbox" name="selectItem"
					value="${c.itemCode }"></td>
				<td class="shoping_cart_item"><img src="img/cart/cart-1.jpg"
					alt="${c.itemName }"></td>
				<td class="shoping_cart_spec"><h5>${c.itemName }</h5>스펙이 들어와야해</td>
				<td class="shoping_cart_price"><span class="itemPrice">
						<fmt:formatNumber
							value="${c.salePrice != 0 ? c.salePrice : c.price}" />
				</span></td>
				<td class="shoping_cart_quantity">
					<div class="quantity">
						<div class="pro-qty">
							<input type="number" value="${c.itemQty }" min="1">
						</div>
					</div>
				</td>
				<td class="shoping_cart_total"><span class="itemTotal"></span>
				</td>
				<td class="shoping_cart_item_close"><span class="icon_close"></span></td>
			</tr>
	</tbody>

</table>