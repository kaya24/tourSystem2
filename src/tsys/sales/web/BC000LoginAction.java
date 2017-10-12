package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;

/**
 * ログイン画面に遷移する。
 * @author kayashima
 *
 */
public class BC000LoginAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC100/b101G01_Login.jsp";

		return page;
	}
}
