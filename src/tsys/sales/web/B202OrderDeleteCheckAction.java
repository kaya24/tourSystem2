package tsys.sales.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tsys.sales.entity.Item;

public class B202OrderDeleteCheckAction implements ActionInterface{

	public String execute(HttpServletRequest req){
		String page = "/UC200/b202G02_OrderConfirm.jsp";

		//String itemCode = req.getParameter("itemCode");
		String[] check = req.getParameterValues("chkbutton");


		ArrayList<Item> orderDeleteList = new ArrayList<>();

		for( String c: check){
			if(c != null){
				Item item = new Item();
				item.setItemCode(c);
				orderDeleteList.add(item);
			}
		}

		req.setAttribute("B202OrderDelete", orderDeleteList);

		return page;
	}
}
