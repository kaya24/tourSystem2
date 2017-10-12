package tsys.sales.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tsys.sales.entity.Item;

public class B201ShoppingCartBackAction implements ActionInterface{

	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest req) {
		String page = "/UC200/b201G01_ShoppingCart.jsp";

		return page;
	}
}
