package command.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberView implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub

			String id = request.getParameter("t_id");
			
			MemberDao dao = new MemberDao();

			
			MemberDto dto = dao.getMemberInfo(id);
			request.setAttribute("t_dto", dto);
			
			
		
		
	}

}
