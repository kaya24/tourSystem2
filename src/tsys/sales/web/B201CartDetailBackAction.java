package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;
import tsys.sales.entity.PackageTour;
import tsys.sales.logic.PackageTourSalesLogic;
import tsys.sales.logic.SalesBusinessException;
import tsys.sales.logic.SalesSystemException;

public class B201CartDetailBackAction implements ActionInterface{

	public String execute(HttpServletRequest req) {
		String page = "/UC600/b601G01_PackageTourDetail.jsp";

		// hiddenパラメータの取得
		String itemCode = req.getParameter("itemCode");
		String categoryCode = req.getParameter("categoryCode");

		try {
			// CategoryCodeで業務ロジック生成の条件分岐
			if (categoryCode.equals("TOR")) {
				PackageTourSalesLogic logic = new PackageTourSalesLogic();
				PackageTour packageTour = logic.getPackageTour(itemCode);
				req.setAttribute("PackageTour", packageTour);
				page = "/UC600/b601G01_PackageTourDetail.jsp";
			}else if(categoryCode.equals("FLY")){

			}else if(categoryCode.equals("HTL")){

			}


		} catch (SalesBusinessException e) {
			req.setAttribute("errorMessage", "商品がありません");
		} catch (SalesSystemException e) {
			page = "error.jsp";
		}

		return page;
	}
}
