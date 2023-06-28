package command.product;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExcute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductDto;

public class ProductDelete implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		
		int maxSize = 1024 * 1024 * 20;
		MultipartRequest mpr = null;
		ProductDao dao = new ProductDao();
		try {
			mpr = new MultipartRequest(request, CommonUtil.getFile_dir_product(),maxSize,"utf-8", new DefaultFileRenamePolicy());
		}catch(IOException e) {
			e.printStackTrace();
		}
		 String no = mpr.getParameter("t_no");
		 String title = mpr.getParameter("t_title");
		 String content = mpr.getParameter("t_content");
		 String attach = mpr.getFilesystemName("t_attach");
		 if(attach == null) attach = "";
		 
		 
		 String oriAttach = mpr.getParameter("t_oriAttach");
		 if(oriAttach == null) oriAttach = "";
		 String saveAttachName = "";
		 
		 String deleteAttach = mpr.getParameter("t_deleteCheckBox");
		 boolean delAttach = true;
		 if(deleteAttach != null)
		 {
			 File file = new File(CommonUtil.getFile_dir_product(), deleteAttach);
			 boolean tf = file.delete();
			 delAttach = false;
			 if(!tf)System.out.println("공지사항 첨부파일 삭제 오류");
		 }else {
			 saveAttachName = oriAttach;
		 }if(!attach.equals("")) {
			 if(!oriAttach.equals("")&& delAttach)
			 {
				File file = new File(CommonUtil.getFile_dir_product(),oriAttach);
				boolean tf = file.delete();
				if(!tf) System.out.println("공지사항 기존 첨부파일 삭제 오류");
			 }
			 saveAttachName = attach;
			 
		 }
		  ProductDto dto = new ProductDto(no,title,content,saveAttachName);
		  int result = dao.noticeUpdate(dto);
		  
		  String msg = "수정되었습니다.";
		  if(result != 1) {
			  
			  msg = "수정실패";
		  }
		  
		  request.setAttribute("t_msg", msg);
		  request.setAttribute("t_url", "Notice");
	}

}
