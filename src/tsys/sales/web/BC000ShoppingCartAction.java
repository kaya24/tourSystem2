package tsys.sales.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tsys.sales.entity.Item;

public class BC000ShoppingCartAction implements ActionInterface{

	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest req){
		String page = "/UC200/b201G01_ShoppingCart.jsp";

		ArrayList<Item> itemList = null;

		HttpSession session = req.getSession(false);

		// "B201ShoppingCart"セッションの取得
		if (session.getAttribute("B201ShoppingCart") == null) {
			session = req.getSession();
			itemList = new ArrayList<>();
			req.setAttribute("NoShoppingCart", "お客様のショッピングカートに商品が入っていません。");
		} else {
			itemList = (ArrayList<Item>) session.getAttribute("B201ShoppingCart");
			if(itemList.size()==0){
				req.setAttribute("NoShoppingCart", "お客様のショッピングカートに商品が入っていません。");
			}
		}

		return page;
	}
}
