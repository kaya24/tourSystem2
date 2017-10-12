package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tsys.sales.entity.Member;
import tsys.sales.entity.PackageTour;
import tsys.sales.logic.MemberManagerLogic;
import tsys.sales.logic.SalesBusinessException;

public class B301RegistSearchAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC300/b301G01_RegistSearch.jsp";

		// Form情報の取得
		String tourCode = req.getParameter("tourCode");

		PackageTour packageTour = new PackageTour();

		// Logicから情報を取得できたとする
		//packageTour.setTourCode(tourCode);
		packageTour.setTourCode("あいうえお");
		packageTour.setTourName("博多グルメ食べ尽しツアー");
		packageTour.setDestinationName("九州");
		packageTour.setDate("3");
		packageTour.setDays(2);

		// セッションに格納
		HttpSession session = req.getSession();
		session.setAttribute("B301RegistPackageTour", packageTour);

		return page;
	}

}
