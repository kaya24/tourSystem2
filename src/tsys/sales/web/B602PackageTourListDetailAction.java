package tsys.sales.web;


import javax.servlet.http.HttpServletRequest;

import tsys.sales.entity.PackageTour;
import tsys.sales.logic.PackageTourSalesLogic;
import tsys.sales.logic.SalesBusinessException;
import tsys.sales.logic.SalesSystemException;

/**
 * パッケージツアー商品一覧 商品コード(リンク)
 * @author kayashima
 *
 */
public class B602PackageTourListDetailAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC600/b601G01_PackageTourDetail.jsp";

		// 商品コードの取得
		String itemCode = req.getParameter("itemCode");

		try{
			PackageTourSalesLogic logic = new PackageTourSalesLogic();

			// パッケージツアー商品詳細情報を取得する。
			PackageTour packageTour = logic.getPackageTour(itemCode);

			// リクエストスコープにセットする。
			req.setAttribute("PackageTour", packageTour);

		}catch(SalesBusinessException e){
			req.setAttribute("errorMessage", "商品がありません");
		}catch(SalesSystemException e){
			page = "error.jsp";
		}

		return page;
	}

}
