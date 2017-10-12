package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;

/**
 * 顧客ヘッダーの[社名]リンク押下時のActionクラス
 *
 * @author kayashima
 * @version 1.0 2017/09/28
 */
public class BC000LogoAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC100/bc001G01_CustTop.jsp";

		return page;
	}
}
