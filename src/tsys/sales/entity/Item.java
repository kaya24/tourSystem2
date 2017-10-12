package tsys.sales.entity;

public class Item {

	private String categoryCode;
	private String categoryName;
	private String itemCode;
	private String itemName;
	/** 従業員が設定した商品単価 */
	private int unitPrice;
	private int quantity;
	private int subTotal;
	private int total;
	private int stock;

	public Item(){

	}

	// ショッピングカートにおけるItemのコンストラクタ
	public Item(String categoryCode, String itemCode, String itemName, int unitPrice, int stock){
		this.categoryCode = categoryCode;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.stock = stock;
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
	 * @return categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName セットする categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @param itemName セットする itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	/**
	 * @return total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total セットする total
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * @param stock セットする stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}


}
