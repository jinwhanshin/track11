package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;
import dao.MemberDao;

public class MemberPasswordUpdate implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		HttpSession session = request.getSession();
		String now_Pw = request.getParameter("t_now_pw");
		String new_Pw = request.getParameter("t_change_pw_1");
		int new_Pw_length = new_Pw.length();
		String id = (String)session.getAttribute("sessionId");
		String name = (String)session.getAttribute("sessionName");		
		String msg = "";
		if(id == null) {
			msg = "로그인 정보가 만료되었습니다. 다시 로그인하세요!";
		} else {
			try {
			     now_Pw = dao.encryptSHA256(now_Pw);
			     new_Pw = dao.encryptSHA256(new_Pw);
			}catch(NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			int pwCheck = dao.getCheckPassword(id, now_Pw);
			if(pwCheck == 1) {
				int result = dao.setMemberPassword(id, new_Pw , new_Pw_length);
				if(result == 1) {
					msg = name+"님 비밀번호 변경되었습니다.";
			}	else { 
					msg = name+"님 비밀번호 변경 실패. 관리자에게 문의하세요!";
					session.invalidate();
			}
		}
		
	}
		request.setAttribute("t_msg",msg);
		request.setAttribute("t_url","Member");
	}
	
}
