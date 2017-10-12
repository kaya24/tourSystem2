package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;

/**
 * 顧客ヘッダーの[新規会員登録]リンク押下時のActionクラス
 *
 * @author kayashima
 * @version 1.0 2017/09/28
 */
public class BC000MemberRegistAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC900/b901G01_MemberRegist.jsp";

		return page;
	}
}
