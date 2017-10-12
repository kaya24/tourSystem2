package tsys.sales.entity;

import java.util.ArrayList;

public class Order {

	private int orderNo;
	private String orderDate;
	private int orderTotal;
	private String memberCode;
	private String memberName;
	private String payment;
	private String sendAddress;
	private ArrayList<OrderDetail> orderDetailList;

	/**
	 * @return orderNo
	 */
	public int getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo セットする orderNo
	 */
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * @return orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate セットする orderDate
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return orderTotal
	 */
	public int getOrderTotal() {
		return orderTotal;
	}
	/**
	 * @param orderTotal セットする orderTotal
	 */
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
	/**
	 * @return memberCode
	 */
	public String getMemberCode() {
		return memberCode;
	}
	/**
	 * @param memberCode セットする memberCode
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	/**
	 * @return memberName
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * @param memberName セットする memberName
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/**
	 * @return payment
	 */
	public String getPayment() {
		return payment;
	}
	/**
	 * @param payment セットする payment
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}
	/**
	 * @return sendAddress
	 */
	public String getSendAddress() {
		return sendAddress;
	}
	/**
	 * @param sendAddress セットする sendAddress
	 */
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	/**
	 * @return orderDetailList
	 */
	public ArrayList<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}
	/**
	 * @param orderDetailList セットする orderDetailList
	 */
	public void setOrderDetailList(ArrayList<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}


}
