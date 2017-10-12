package tsys.sales.web;

import javax.servlet.http.HttpServletRequest;

public class BC000TopAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC100/bc001G01_CustTop.jsp";

		return page;
	}
}
