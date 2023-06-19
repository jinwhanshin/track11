package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.notice.NoticeList;
import command.notice.NoticeSave;
import command.notice.NoticeView;
import common.CommonExcute;
import common.CommonToday;

/**
 * Servlet implementation class Notice
 */
@WebServlet("/Notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notice() {

    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		//System.out.println("gubun ========="+gubun);
		if(gubun == null) gubun ="list"; 
		String viewPage ="";
		
		request.setAttribute("t_nowPage", "notice");
		//목록
		if(gubun.equals("list")){
			//NoticeList notice = new NoticeList();
			CommonExcute notice = new NoticeList();
			notice.execute(request);
			viewPage ="notice/notice_list.jsp";
		//글쓰기폼	
		} else if(gubun.equals("writeForm")){
			CommonExcute common = new CommonToday();
					;
			common.execute(request);
			viewPage ="notice/notice_write.jsp";
			//등록
		} else if(gubun.equals("save")){
			CommonExcute notice = new NoticeSave();
			notice.execute(request);			
			viewPage ="common_alert.jsp";	
			//글보기
		} else if(gubun.equals("view")){
			CommonExcute notice = new NoticeView();
			notice.execute(request);
			viewPage ="notice/notice_view.jsp";
			
		} else if(gubun.equals("updateForm")){
			CommonExcute notice = new NoticeView();
			notice.execute(request);
			viewPage ="notice/notice_update.jsp";
			
		} else if(gubun.equals("update")){
			
			viewPage ="common_alert.jsp";	
			
		} else if(gubun.equals("delete")){
			
			viewPage ="common_alert.jsp";	
		}
		
		RequestDispatcher rd = 
				request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
