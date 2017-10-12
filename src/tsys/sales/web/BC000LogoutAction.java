package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BC000LogoutAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC100/b102G01_Logout.jsp";

		// 全てのセッションを削除する。
		HttpSession session = req.getSession();
		session.invalidate();

		return page;
	}

}
