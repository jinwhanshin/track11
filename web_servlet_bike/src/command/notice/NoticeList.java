package command.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeList implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = new NoticeDao();
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		if(select == null){
			select ="n.title";
			search ="";
		}

		/* paging 설정 start*/
		int totalCount = dao.getTotalCount(select,search);
		int list_setup_count = 10;  //한페이지당 출력 행수 
		int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
		
		String nowPage = request.getParameter("t_nowPage");
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
		// 총계시글 수 - (현제페이지번호 -1) * 한페이지당 출력 행수 
		//9        -  (1      -    1)           * 5 = 9
		//9        -  (2      -    1)           * 5 = 4
		int order = totalCount - ((current_page -1) * list_setup_count);
		
		
		
//		ArrayList<NoticeDto> dtos = dao.getNoticeList(select,search);
		ArrayList<NoticeDto> dtos = 
				dao.getNoticeListPage(select,search,start,end);
		
		String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
		
		request.setAttribute("t_dtos", dtos);
		request.setAttribute("t_totalCount", totalCount);
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		request.setAttribute("t_paging", paging);
		request.setAttribute("t_order", order);

	}

}








