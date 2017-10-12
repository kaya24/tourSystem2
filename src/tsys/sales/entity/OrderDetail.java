package tsys.sales.entity;

public class OrderDetail {

	private int OrderNo;
	private String categoryCode;
	private String itemCode;
	private String itemName;
	private int price;
	private int quantity;
	private int subTotal;
	/**
	 * @return orderNo
	 */
	public int getOrderNo() {
		return OrderNo;
	}
	/**
	 * @param orderNo セットする orderNo
	 */
	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}
	/**
	 * @return categoryCode
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * @param categoryCode セットする categoryCode
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * @return itemCode
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * @param itemCode セットする itemCode
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName セットする itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price セットする price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity セットする quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return subTotal
	 */
	public int getSubTotal() {
		return subTotal;
	}
	/**
	 * @param subTotal セットする subTotal
	 */
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}


}
