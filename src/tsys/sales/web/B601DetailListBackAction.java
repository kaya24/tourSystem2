package tsys.sales.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import tsys.sales.entity.PackageTour;
import tsys.sales.logic.PackageTourSalesLogic;
import tsys.sales.logic.SalesBusinessException;
import tsys.sales.logic.SalesSystemException;

/**
 * パッケージツアー商品詳細 [戻る]ボタンアクション
 * @author kayashima
 *
 */
public class B601DetailListBackAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC600/b602G02_PackageTourList.jsp";

		String destinationCode = req.getParameter("destination");
		String date = req.getParameter("date");
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		try{
			PackageTourSalesLogic logic = new PackageTourSalesLogic();
			ArrayList<PackageTour> packageTourList = logic.searchPackageTour(destinationCode, year, month);

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
