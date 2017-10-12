package tsys.sales.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tsys.sales.entity.Item;

public class B201CartDeleteAction implements ActionInterface{

	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest req) {
		String page = "/UC200/b201G01_ShoppingCart.jsp";

		String itemCode = req.getParameter("itemCode");
		ArrayList<Item> itemList = null;

		// セッションの取得
		HttpSession session = req.getSession(false);

		// "B201ShoppingCart"セッションの取得
		if (session.getAttribute("B201ShoppingCart") == null) {
			page = "error.jsp";
			System.out.println("ショッピングカートの削除ボタンでエラー発生");
		} else {
			itemList = (ArrayList<Item>) session.getAttribute("B201ShoppingCart");
		}

		// 削除する商品コードの探索
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getItemCode().equals(itemCode)) {
				itemList.remove(i); // 削除
			}
		}
		if(itemList.size() == 0){
			session.removeAttribute("B201ShoppingCart");
			req.setAttribute("NoShoppingCart", "商品が入っていません。");
			req.setAttribute("RemoveMessage", itemCode +"を削除しました。");
		}
		session.setAttribute("B201ShoppingCart", itemList);
		req.setAttribute("RemoveMessage", itemCode +"を削除しました。");
		return page;
	}
}
