package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tsys.sales.entity.Member;
import tsys.sales.logic.MemberManagerLogic;
import tsys.sales.logic.SalesBusinessException;

/**
 * ログイン画面の[ログイン]ボタン押下時のActionクラス
 *
 * @author kayashima
 * @version 1.0 2017/09/28
 */
public class B101LoginAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC100/bc001G01_CustTop.jsp";

		String memberCode = req.getParameter("memberCode");
		String password = req.getParameter("password");
		String isFromShoppingCart = req.getParameter("FromShoppingCart");

		try{
			MemberManagerLogic logic = new MemberManagerLogic();
			Member member = logic.loginMember(memberCode, password);

			if( member == null){
				page = "/UC100/b101G01_Login.jsp";
				System.out.println("ログイン失敗");
				req.setAttribute("errorMessage", "ログインに失敗しました。");
			}
			// セッションの生成
			HttpSession session = req.getSession();
			session.setAttribute("CommonLoginMember", member);

			if( member.getRole().equals("Employee")){
				// 従業員トップ画面に遷移する
				//page = "";
			}

		}catch(SalesBusinessException e){
			req.setAttribute("errorMessage", "メンバーコードとパスワードが一致しません．");
			page = "/UC100/b101G01_Login.jsp";
		}

		return page;
	}

}
