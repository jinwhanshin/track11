package command.product;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.ProductDao;
import dto.ProductDto;

public class ProductView implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		
		ProductDao dao = new ProductDao();
		String product_name = request.getParameter("t_product_name");
		ProductDto dto = dao.getProductView(product_name);
		//이전글 다음글 정보
		
		request.setAttribute("t_dto", dto);

		
		
		
	}

}
