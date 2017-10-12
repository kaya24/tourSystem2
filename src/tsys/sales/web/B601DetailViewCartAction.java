package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 *
 * パッケージツアー商品詳細[カートを見る]ボタン
 *
 * @author kayashima
 *
 */
public class B601DetailViewCartAction implements ActionInterface {

	public String execute(HttpServletRequest req) {
		String page = "/UC200/b201G01_ShoppingCart.jsp";

		// セッションの取得
		HttpSession session = req.getSession(false);

		// セッションが生成していなければ，生成する
		if (session.getAttribute("B201ShoppingCart") == null) {
			req.setAttribute("NoShoppingCart", "商品が入っていません");
		}

		return page;
	}

}