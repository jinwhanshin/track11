package command.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberList implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");		
		String displayCount = request.getParameter("t_displayCount");
		if(displayCount == null)
		{
			displayCount = "5";
		}
		if(select == null) {
			select ="id";
			search ="";
		}
//		System.out.println(select + search);

		/* paging 설정 start*/
		int totalCount = dao.getTotalCount(select,search);
		int list_setup_count = Integer.parseInt(displayCount);  //한페이지당 출력 행수 
		int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
		
		String nowPage = request.getParameter("t_nowPage");
//		System.out.println(nowPage);
		int current_page = 0; // 현재페이지 번호
		int total_page = 0;    // 전체 페이지 수
		
		if(nowPage == null || nowPage.equals("")) current_page = 1; 
		else current_page = Integer.parseInt(nowPage);
		
		total_page = totalCount / list_setup_count;  // 몫 : 2
		int rest = 	totalCount % list_setup_count;   // 나머지:1
		if(rest !=0) total_page = total_page + 1;     // 3
		
		int start = (current_page -1) * list_setup_count + 1;
		int end   = current_page * list_setup_count;
		/* paging 설정 end*/			
		int order = totalCount - ((current_page -1) * list_setup_count);		
		
		ArrayList<MemberDto> dtos = dao.getMemberList(select,search, start, end);
		String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
		
		request.setAttribute("t_dtos", dtos);
		
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		request.setAttribute("t_paging", paging);
		request.setAttribute("t_totalCount", totalCount);
		request.setAttribute("t_order", order);
		request.setAttribute("t_displayCount", displayCount);
//		System.out.println(dtos.get(0).getNo());
//
//		for(int i=0; i < dtos.size() ; i++)
//		{
//			System.out.println("id" + dtos.get(i).getId());
//		}
//		
	}

}
