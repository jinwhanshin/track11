<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp"%>
		<div id="b_left">
			<%@ include file="../common_menu_admin.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총회원수<span> 4 </span>명</p>
			</div>			
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="n.id" selected >ID</option>
					<option value="n.name"  >Name</option>
					<option value="n.mobile"  >Mobile</option>
				</select>
				<select name="t_displayCount" class="sel_box">
					<option value="5" selected>5명</option>
					<option value="10" >10명</option>
					<option value="20" >20명</option>
					<option value="50" >50명</option>
				</select>
				<input type="text" name="t_search" value="" class="sel_text">

				<button type="button"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			
			<table class="boardList">
				<colgroup>
					<col width="5%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="20%">
					<col width="15%">
					<col width="25%">
					<col width="5%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>ID</th>
						<th>성명</th>
						<th>지역</th>
						<th>연락처</th>
						<th>가입일자</th>
						<th>로그인정보</th>
						<th>탈퇴여부</th>
					</tr>
				</thead>
				<c:forEach items="${t_dtos}" var="dto">
				<tbody>
					<tr>
						<td>${dto.getNo()}</td>
						<td class="t_left"><a href="notice_view.html">${dto.getId()}</a></td>
						<td>${dto.getName()}</td>
						<td>${dto.getArea()}</td>
						<td>${dto.getMobile_1()}-${dto.getMobile_2()}-${dto.getMobile_3()}</td>
						<td>${dto.getReg_date()}</td>
						<td>${dto.getLast_login_date()}</td>
						<td>
							
						
						</td>						
					</tr>	
					
				</tbody>
				</c:forEach>
			</table>
			
			<div class="paging">
				${t_paging}
			</div>
		</div>	
	</div>
<%@ include file="../common_footer.jsp" %>
</body>
</html>

