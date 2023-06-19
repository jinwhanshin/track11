package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.news.NewsDelete;
import command.news.NewsList;
import command.news.NewsSave;
import command.news.NewsUpdate;
import command.news.NewsView;
import common.CommonExcute;
import common.CommonToday;
import dao.NewsDao;

/**
 * Servlet implementation class News
 */
@WebServlet("/News")
public class News extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public News() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun ="list";
		String viewPage ="";	
		request.setAttribute("t_nowPage", "news");
		
		if(gubun.equals("list")) {
			CommonExcute news = new NewsList();
			news.execute(request);
			viewPage="news/news_list.jsp";
			
		} else if(gubun.equals("writeForm")){
			CommonExcute common = new CommonToday();
			common.execute(request);			
			viewPage="news/news_write.jsp";
			
		} else if(gubun.equals("save")){
			CommonExcute news = new NewsSave();
			news.execute(request);
			viewPage="common_alert.jsp";
			
		} else if(gubun.equals("view")){
			CommonExcute news = new NewsView();
			news.execute(request);
			viewPage="news/news_view.jsp";
			
		} else if(gubun.equals("updateForm")){
			CommonExcute news = new NewsView();
			news.execute(request);
			viewPage="news/news_update.jsp";
			
		} else if(gubun.equals("update")){
			CommonExcute news = new NewsUpdate();
			news.execute(request);
			viewPage="common_alert.jsp";
			
		} else if(gubun.equals("delete")){
			CommonExcute news = new NewsDelete();
			news.execute(request);			
			viewPage="common_alert.jsp";
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
