package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;

/**
 * ログイン画面に遷移する。
 * @author kayashima
 *
 */
public class B901RegistCommitAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC900/b901G03_MemberRegistCommit.jsp";

		return page;
	}
}
