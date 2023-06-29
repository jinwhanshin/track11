<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<script>
	function goUpdateForm()
	{

		product.t_gubun.value = "updateForm";
		product.method="post";
		product.action="Product";
		product.submit();
	}
	function goDelete()
	{
		if(confirm("정말 삭제하시겠습니까?"))
		{
			alert("${t_dto.getProduct_name()}");
			product.t_gubun.value="delete";
			product.method="post";
			product.action="Product";
			product.submit();				
		}
	}
	function goBuy()
	{
		product.t_gubun.value="buyForm";
		product.method="post";
		product.action="Product";
		product.submit();			
	}
</script>
<form name="product">
	<input type="hidden" name="t_Product_name" value="${t_dto.getProduct_name()}">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_attach" value="${t_dto.getAttach()}">

<html>
<head>
</head>

	
		<div id="b_left">
			<%@include file="../common_menu.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				Product
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="55%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>Product number</th>
						<td colspan="2">${t_dto.getProduct_num()}</td>
					</tr>	
					<tr>
						<th>Product name</th>
						<td colspan="2">${t_dto.getProduct_name()}</td>
					</tr>	
					<tr>
						<th>Detail</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getDetail()}</textarea>
						</td>
					</tr>
					<tr>	
						<th>Picture</th>
						<td colspan="2">
							<img src="attach/product/${t_dto.getAttach()}" class="viewImg">
						</td>
					</tr>	
						
					<tr>
					
						<th>Attach</th>
						<td colspan="3">
							<a href="FileDown?t_fileDir=notice&t_fileName=${t_dto.getAttach()}">${t_dto.getAttach()}</a>
						</td>
						
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getReg_id()}</td>		
						<th>Company</th>
						<td>${t_dto.getReg_company()}</td>
					</tr>
					<tr>	
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>

				</tbody>
			</table>
			<div class="buttonGroup">
				
				<c:if test="${sessionLevel eq 'member' }">
				<a href="javascript:goBuy()" class="butt">구매</a>
				</c:if>
			
				<c:if test="${sessionLevel eq 'admin' }">
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdateForm()" class="butt">Update</a>
				</c:if>
				<a href="Product" class="butt">List</a>
				
			</div>	
			</div>	
				
				
</form>
				
	
		<%@ include file="../common_footer.jsp" %>
</body>
</html>