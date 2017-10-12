package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tsys.sales.entity.Member;
import tsys.sales.logic.MemberManagerLogic;
import tsys.sales.logic.SalesBusinessException;

public class B301RegistEntryAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC100/bc001G01_CustTop.jsp";

		String memberCode = req.getParameter("memberCode");
		String password = req.getParameter("password");

		try{
			MemberManagerLogic logic = new MemberManagerLogic();
			Member member = logic.loginMember(memberCode, password);

			if( member == null){
				page = "/UC100/b101G01_Login.jsp";
				req.setAttribute("errorMessage", "ログインに失敗しました。");
			}
			HttpSession session = req.getSession();
			session.setAttribute("CommonLoginMember", member);

		}catch(SalesBusinessException e){
			req.setAttribute("errorMessage", "メンバーコードとパスワードが一致しません．");
		}

		return page;
	}

}
