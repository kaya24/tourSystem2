package tsys.sales.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tsys.sales.entity.Item;
import tsys.sales.entity.PackageTour;
import tsys.sales.logic.PackageTourSalesLogic;
import tsys.sales.logic.SalesBusinessException;
import tsys.sales.logic.SalesSystemException;

/**
 * パッケージツアー商品詳細[カートに入れる]ボタン
 *
 * @author kayashima
 *
 */
public class B601DetailPutCartAction implements ActionInterface {

	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest req) {
		String page = "/UC600/b601G01_PackageTourDetail.jsp";
		boolean addCheck = true;

		ArrayList<Item> itemList = null;
		String categoryCode = req.getParameter("categoryCode");
		String itemCode = req.getParameter("itemCode");
		String itemName = req.getParameter("itemName");
		int unitPrice = Integer.parseInt(req.getParameter("unitPrice"));
		int stock = Integer.parseInt(req.getParameter("stock"));
		Item item = new Item(categoryCode, itemCode, itemName, unitPrice, stock);
		// カートに入れるitemのQuantityを1に設定する
		item.setQuantity(1);

		// セッションの取得
		HttpSession session = req.getSession(false);

		PackageTourSalesLogic logic = new PackageTourSalesLogic();
		try {
			PackageTour packageTour = logic.getPackageTour(itemCode);

			// "B201ShoppingCart"セッションの取得
			if (session.getAttribute("B201ShoppingCart") == null) {
				session = req.getSession();
				itemList = new ArrayList<>();
			} else {
				itemList = (ArrayList<Item>) session
						.getAttribute("B201ShoppingCart");
			}

			// すでにカートに入ってる商品に、同じ商品が存在している場合
			for (int i = 0; i < itemList.size(); i++) {
				if (itemList.get(i).getItemCode().equals(item.getItemCode())) { // 商品コードの一致チェック
					String message = "この商品はすでにショッピングカートに入っています。";
					addCheck = false;
					req.setAttribute("PutCartMessage", message);
					// int currentQuantity = itemList.get(i).getQuantity(); //
					// 商品の現在のQuantityを取得
					// itemList.get(i).setQuantity(currentQuantity + 1);
				}
			}
			// 新しくitemListに追加する
			if (addCheck == true) {
				itemList.add(item);
				String message = item.getItemName() + "をカートに入れました";
				req.setAttribute("PutCartMessage", message);
			}
			session.setAttribute("B201ShoppingCart", itemList);
			req.setAttribute("PackageTour", packageTour);

		} catch (SalesBusinessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SalesSystemException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return page;
	}
}