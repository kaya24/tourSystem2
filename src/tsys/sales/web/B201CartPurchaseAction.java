package tsys.sales.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tsys.sales.entity.Item;
import tsys.sales.entity.Member;
import tsys.sales.entity.Order;
import tsys.sales.entity.OrderDetail;

public class B201CartPurchaseAction implements ActionInterface {

	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest req) {
		String page = "/UC200/b201G02_ConfirmOrder.jsp";

		// Form情報の取得
		String[] quantity = req.getParameterValues("quantity");
		// String memberCode = null;
		// String memberName = null;
		// String sendAddress = null;
		// Member member = null;
		for (String q : quantity) {
			System.out.println(q);
		}
		String flag = "0";
		flag = req.getParameter("flag");
		System.out.println("flag:" + flag);
		String itemCode = req.getParameter("itemCode");
		System.out.println("itemCode:" + itemCode);

		// セッションの取得
		HttpSession session = req.getSession(false);
		ArrayList<Item> itemList = null;

		// "B201ShoppingCart"セッションチェック
		if (session.getAttribute("B201ShoppingCart") == null) {
			// セッションアウト
			page = "error.jsp";
			System.out.println("ショッピングカートの購入ボタンでエラー発生");
		} else {
			itemList = (ArrayList<Item>) session.getAttribute("B201ShoppingCart");
		}

		// 注文合計金額を計算する
		int orderTotal = 0;
		for (int i = 0; i < itemList.size(); i++) {
			int n = Integer.parseInt(quantity[i]);
			itemList.get(i).setQuantity(n);
			int unitPrice = itemList.get(i).getUnitPrice();
			itemList.get(i).setSubTotal(unitPrice * n);
			orderTotal += unitPrice * n;
		}
		// itemListの先頭に合計金額を格納する
		itemList.get(0).setTotal(orderTotal);
		// req.setAttribute("OrderTotal", orderTotal);
		// session.setAttribute("B201ShoppingCart", itemList);

		// ショッピングカート情報からOrderオブジェクトの生成
		Order orderInfo = new Order();
		ArrayList<OrderDetail> orderDetailList = new ArrayList<>();
		for (Item item : itemList) {
			OrderDetail orderDetail = new OrderDetail();
			// orderDetail.setCategoryCode(item.getCategoryCode());
			orderDetail.setItemCode(item.getItemCode());
			orderDetail.setItemName(item.getItemName());
			orderDetail.setPrice(item.getUnitPrice());
			orderDetail.setQuantity(item.getQuantity());
			orderDetail.setSubTotal(item.getSubTotal());
			orderDetailList.add(orderDetail);
		}
		orderInfo.setOrderDetailList(orderDetailList);
		orderInfo.setOrderTotal(orderTotal);

		// セッション新規作成
		session.setAttribute("B201OrderInfo", orderInfo);

		if(flag.equals("1")){
			page = "/UC200/b201G01_ShoppingCart.jsp";
		}

		return page;
	}
}
