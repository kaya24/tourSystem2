package tsys.sales.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tsys.sales.entity.Member;
import tsys.sales.entity.Order;
import tsys.sales.logic.OrderManagerLogic;
import tsys.sales.logic.SalesBusinessException;
import tsys.sales.logic.SalesSystemException;

/**
 * 顧客ヘッダーの[会員情報照会]リンク押下時のActionクラス
 *
 * @author kayashima
 * @version 1.0 2017/09/28
 */
public class BC000MemberDetailAction implements ActionInterface {

	public String execute(HttpServletRequest req) {
		String page = "/UC900/b904G02_MemberDetail.jsp";
		Member member = null;
		String message = "";

		// セッションの取得
		HttpSession session = req.getSession(false);

		// セッションチェック
		if (session.getAttribute("CommonLoginMember") == null) {
			// エラーメッセージ格納
			message = "セッションが切れました。再度ログインしてください。";
			req.setAttribute("errorMessage", message);
			// page = "";
		} else {
			//member = (Member) req.getAttribute("CommonLoginMember");
			//新しくセッションを生成するなら、以降に記述

		}

		return page;
	}
}
