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
 * 顧客ヘッダーの[注文確認／キャンセル]リンク押下時のActionクラス
 *
 * @author kayashima
 * @version 1.0 2017/09/28
 */
public class BC000OrderListAction implements ActionInterface {

	public String execute(HttpServletRequest req) {
		String page = "/UC200/b203G01_OrderList.jsp";
		Member member = null;
		String message = "";
		try {
			// セッションの取得
			HttpSession session = req.getSession(false);

			// セッションチェック
			if (session.getAttribute("CommonLoginMember") == null) {
				// エラーメッセージ格納
				message = "ログインしてください。";
				req.setAttribute("errorMessage", message);
				// page = "";
			} else {
				member = (Member) req.getAttribute("CommonLoginMember");
				String memberCode = member.getMemberCode();
				OrderManagerLogic logic = new OrderManagerLogic();

				// 注文一覧情報を取得する
				ArrayList<Order> orderList = logic
						.showListOrderMaster(memberCode);

				if (orderList.size() == 0) {
					message = "注文キャンセル可能な商品がありません。";
					req.setAttribute("errorMessage", message);
				} else {
					// 注文一覧情報をリクエストスコープにセットする
					req.setAttribute("OrderList", orderList);
				}
			}

		} catch (SalesBusinessException e) {
			req.setAttribute("errorMessage", "商品がありません");
		} catch (SalesSystemException e) {
			page = "error.jsp";
		}

		return page;
	}
}
