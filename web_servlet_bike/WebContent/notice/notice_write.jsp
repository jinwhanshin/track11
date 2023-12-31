<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>    
<!-- 
http://localhost:8080/web_servlet_bike/Notice?t_gubun=writeForm
 -->
<c:if test="${sessionLevel ne 'admin'}">
	<script>
		alert("관리자 화면입니다!");
		location.href="Notice";
	</script>
</c:if>	
<script type="text/javascript">
	function goSave(){
		if(checkValue(noti.t_title,"제목을 입력하세요!"))return;
		/***  첨부파일 검사 ***/
		// 1.확장자 검사
		var fileName = noti.t_attach.value;
		if(fileName != ""){ 
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			//파일명.확장자
			if(extension != "pdf" && extension != "hwp" && extension != "jpg" && extension != "gif" && extension != "png")
			{
				alert(extension +" 허용하지않는 형식 파일은 업로드 안됩니다.");
				return;
			}		
		}
		// 2.첨부 용량 체크	
		var file = noti.t_attach;
		var fileMaxSize  = 1024 * 1024 * 10; // 첨부 최대 용량 설정
		if(file.value !=""){
			// 사이즈체크
			var maxSize  = 1024 * 1024 * fileMaxSize;
			var fileSize = 0;
			// 브라우저 확인
			var browser=navigator.appName;
			// 익스플로러일 경우
			if (browser=="Microsoft Internet Explorer"){
				var oas = new ActiveXObject("Scripting.FileSystemObject");
				fileSize = oas.getFile(file.value).size;
			}else {
			// 익스플로러가 아닐경우
				fileSize = file.files[0].size;
			}

			if(fileSize > maxSize){
				alert(" 첨부파일 사이즈는 "+fileMaxSize+"MB 이내로 등록 가능합니다. ");
				return;
			}
		}
		//noti.t_gubun.value="save";
		noti.method="post";
		noti.action="Notice?t_gubun=save";
		noti.submit();
		}


</script>
	<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<form name = "noti" enctype="multipart/form-data">
			
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
						<td colspan="3"><input type="text" name="t_title" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250"></textarea></td>
					</tr>
<script type="text/javascript">
	$(function(){					
		function readImage(input) {
		    // 인풋 태그에 파일이 있는 경우
		    if(input.files && input.files[0]) {
		        // 이미지 파일인지 검사 (생략)
		        // FileReader 인스턴스 생성
		        const reader = new FileReader()
		        // 이미지가 로드가 된 경우
		        reader.onload = e => {
		            const previewImage = document.getElementById("preview-image")
		            previewImage.src = e.target.result;
		        }
		        // reader가 이미지 읽도록 하기
		        reader.readAsDataURL(input.files[0])
		    } else {
		    	// 이미지 안올렸으면
				$("#preview-image").attr('src','');
				$("#preview-image").css("display","none");
		    }
		}
		// input file에 change 이벤트 부여
		const inputImage = document.getElementById("input-image");
		inputImage.addEventListener("change", e => {
			$("#preview-image").css("display","block");
		    readImage(e.target)
		})	
	});	
</script>						
<style>
	#preview-image{
		border:1px solid gray;
		width:500px;
		height:300px;
		margin-left:50px;
		margin-bottom:10px;
		display:none;
		
	}
</style>	
					<tr>
						<th>Attach</th>
						<td colspan="3">
						 <img id="preview-image">
						<input type="file" name="t_attach" id="ipnput-imageclass="input600"></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${sessionName}</td>
						<th>RegDate</th>
						<td></td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="Notice" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="../common_footer.jsp" %>	
</body>
</html>






