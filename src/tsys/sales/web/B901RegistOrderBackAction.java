package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;

/**
 * ログイン画面に遷移する。
 * @author kayashima
 *
 */
public class B901RegistOrderBackAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC200/b201G02_ConfirmOrder.jsp";

		return page;
	}
}
