package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tsys.sales.entity.Member;
import tsys.sales.logic.MemberManagerLogic;
import tsys.sales.logic.SalesBusinessException;

/**
 * ログイン画面の[新規会員登録]ボタン押下時のActionクラス
 *
 * @author kayashima
 * @version 1.0 2017/09/28
 */
public class B101LoginMemberRegistAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC900/b901G01_MemberRegist.jsp";

		String isFromShoppingCart = req.getParameter("FromShoppingCart");
		req.setAttribute("FromShoppingCart", isFromShoppingCart);

		return page;
	}

}
