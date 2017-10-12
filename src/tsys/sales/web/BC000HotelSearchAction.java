package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;

/**
 * 顧客ヘッダーの[ホテル]ボタン押下時のActionクラス
 * @author kayashima
 * @version 1.0 2017/09/28
 */
public class BC000HotelSearchAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC800/b802G01_HotelSearch.jsp";

		return page;
	}
}
