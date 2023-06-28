package command.product;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExcute;
import common.CommonUtil;
import dao.*;
import dto.*;

public class ProductSave implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		
		
		ProductDao dao = new ProductDao();
		String productDir = CommonUtil.getFile_dir_product();
		int maxSize = 1024 * 1024 * 5;
		String msg = "등록 되었습니다.";
		
		MultipartRequest mpr = null;
		
		try {
			mpr = new MultipartRequest(request, productDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
			
			String product_name 	= mpr.getParameter("t_product_name");
			String detail 	= mpr.getParameter("t_detail");
			int price 	= Integer.parseInt(mpr.getParameter("t_price"));
			String product_size  	= mpr.getParameter("t_product_size");
			String reg_company = mpr.getParameter("t_reg_company");
			String priority = mpr.getParameter("t_priority");
			String attach = mpr.getFilesystemName("t_attach");
			HttpSession session = request.getSession();
			String reg_id = (String)session.getAttribute("sessionId");
			String reg_date = CommonUtil.getTodayTime();
			
			ProductDto dto = new ProductDto(product_name, detail, product_size, reg_company, priority, attach, reg_id, reg_date, price, 0);
			int result = dao.productSave(dto);
			if (result != 1) msg = "등록 실패!";
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Product");		
		




		
		
		
		
		
		
		
		
		


	}

}


