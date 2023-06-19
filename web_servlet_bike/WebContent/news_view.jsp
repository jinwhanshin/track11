<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
		<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NEWS
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
						<th>Title</th>
						<td colspan="2">${t_dto.getTitle()}</td>
						<td> <i class="far fa-eye"></i> ${t_dto.getHit()}</td>
					</tr>
<style>
	.viewImg{
		width:500px;
		height:300px;
	}
	.imgDiv{
		width:500px;
		height:300px;	
		padding: 10px;
		margin: 10px 90px;			
		border:1px solid gray;
	}
</style>					
					<tr>
						<td colspan="4">
							<div class="imgDiv">
								<img src="attach/news/${t_dto.getAttach()}" class="viewImg">
							</div>
						</td>
					</tr>						
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getContent()}</textarea>
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
			<div class="preNext">
				<a href="javascript:goView('N002')">
					<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
						<span class="preNextTitle">
									이전 게시물 제목...
						</span>
					</p>
				</a>
				<a href="javascript:goView('N004')">
					<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
						<span class="preNextTitle">
									다음 게시물 제목...
						</span>
					</p>
				</a>
				
			</div>			
			<div class="buttonGroup">
				<a href="" class="butt">Delete</a>
				<a href="notice_update.html" class="butt">Update</a>
				<a href="notice_list.html" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="../common_footer.jsp" %>
</body>
</html>