<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp"%>
<script type="text/javascript">
	function goUpdate(){
		
		
		
		
		
		
		
		
		noti.t_gubun.value = "update";
		noti.method="post";
		noti.action="Notice";
		//noti.submit();
		
	}
</script>
	<div id="b_left">
		<%@ include file="../common_menu.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<form name="noti">
			
			<input type = "hidden" name = "t_gubun">
			<input type = "hidden" name = "t_no" value = "${t_dto.getNo()}">
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" name="t_title" class="input600" value="${t_dto.getTitle()}"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250">${t_dto.getContent()}</textarea></td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">
						<c:if test="${not empty t_dto.getAttach()}">
							${t_dto.getAttach()} 삭제<input type="checkbox" name="t_deleteCheckBox" value="${t_dto.getAttach()}"><br>
						</c:if>
							<input type="file" name="t_attach" class="input600">
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getReg_name()}</td>
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				
				<a href="javascript:goUpdate()" class="butt">Save</a>
				<a href="Notice" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="../common_footer.jsp" %>
</body>
</html>
