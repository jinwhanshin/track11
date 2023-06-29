<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>

<script>

	function goView(product_name)
	{
		product.t_product_name.value = product_name;
		product.t_gubun.value = "productView";
		product.method="post";
		product.action="Product";
		product.submit();
	}

	function goPage(pageNum){
		
		product.t_gubun.value = "productList";
		product.t_nowPage.value = pageNum;
		product.method="post";
		product.action="Product";
		product.submit();		
	}

	function goSearch(){

		product.t_gubun.value = "productList";
		product.method="post";
		product.action="Product";
		product.submit();
	}
	function goProductForm(){
		product.t_gubun.value ="productForm";
		product.method="post";
		product.action="Product";
		product.submit();
	}
	
</script>
<form name="product">
	<input type="hidden" name="t_nowPage">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_product_name">
	
<div id="b_left">
	<%@ include file="../common_menu_admin.jsp" %>
</div>
		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총물품수<span> ${t_totalCount } </span>개</p>
			</div>			
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="id"  <c:if test="${t_select eq 'id' }">selected </c:if>>제품명</option>
					<option value="name"  <c:if test="${t_select eq 'name' }">selected </c:if>>회사명</option>
				</select>
				<select name="t_displayCount" class="sel_box">
					<option value="5"  <c:if test="${t_displayCount eq 5 }">selected </c:if>>  5명</option>
					<option value="10"  <c:if test="${t_displayCount eq 10 }">selected </c:if>> 10명</option>
					<option value="20"  <c:if test="${t_displayCount eq 20 }">selected </c:if>> 20명</option>
					<option value="50"  <c:if test="${t_displayCount eq 50 }">selected </c:if>> 50명</option>
				</select>
				<input type="text" name="t_search"  value="${t_search }" class="sel_text">

				<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			
			<table class="boardList">
				<colgroup>
					<col width="5%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="5%">
					<col width="30%">
					<col width="25%">
					<col width="5%">
				</colgroup>
				<thead>
					<tr>
						<th>Product Number</th>
						<th>Image</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Product Size</th>
						<th>Reg Date</th>
						<th>Reg Company</th>
						<th>Reg Id</th>
					</tr>
				</thead>
				<c:set var="order" value="${t_order}"></c:set>				
				<c:forEach items="${t_dtos}" var="dto">
				<tbody>
					<tr>
						<td>
							${order}
							<c:set var="order" value="${order -1}"></c:set>
						</td>
						<td><img src="attach/product/${dto.getAttach()}"></img></td>
						<td class="t_left"><a href="javascript:goView('${dto.getProduct_name() }')">${dto.getProduct_name() }</a></td>
						<td>${dto.getPrice()}</td>
						<td>${dto.getProduct_size()}</td>
						<td>${dto.getReg_date()}</td>
						<td>${dto.getReg_company()}</td>
						<td>${dto.getReg_id()}</td>
					</tr>	
					
				</tbody>
				</c:forEach>
			</table>
			
			<div class="paging">
				${t_paging}
				
			</div>
			<div class="buttonGroup">
				<a href="javascript:goProductForm()" class="butt">상품추가</a>
			</div>	

		</div>	
	</form>

<%@include file = "../common_footer.jsp" %>
</body>
</html>