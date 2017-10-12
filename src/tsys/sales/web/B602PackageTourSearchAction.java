package tsys.sales.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import tsys.sales.entity.PackageTour;
import tsys.sales.logic.PackageTourSalesLogic;
import tsys.sales.logic.SalesBusinessException;
import tsys.sales.logic.SalesSystemException;

/**
 * パッケージツアー商品検索 [検索]ボタンアクション
 * @author kayashima
 *
 */
public class B602PackageTourSearchAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC600/b602G02_PackageTourList.jsp";

		String destinationCode = req.getParameter("destination"); // 地区コードの取得
		String year = req.getParameter("year"); // 年の取得
		String month = req.getParameter("month"); // 月の取得

		try{
			PackageTourSalesLogic logic = new PackageTourSalesLogic();

			// パッケージツアー商品一覧情報の取得
			ArrayList<PackageTour> packageTourList = logic.searchPackageTour(destinationCode, year, month);

			req.setAttribute("DestinationCode", destinationCode);
			req.setAttribute("DestinationName", packageTourList.get(0).getDestinationName());
			req.setAttribute("Year", year);
			req.setAttribute("Month", month);
			req.setAttribute("PackageTourList", packageTourList);

		}catch(SalesBusinessException e){
			req.setAttribute("errorMessage", "商品がありません");
		}catch(SalesSystemException e){
			page = "error.jsp";
		}

		return page;
	}

}
