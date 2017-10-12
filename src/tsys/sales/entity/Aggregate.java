package tsys.sales.entity;

public class Aggregate {

	private String memberCode;
	private String memberName;
	private int total;
	private int grandTotal;
	private String year;
	private String month;
	private String day;
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
	 * @return grandTotal
	 */
	public int getGrandTotal() {
		return grandTotal;
	}
	/**
	 * @param grandTotal セットする grandTotal
	 */
	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	/**
	 * @return year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year セットする year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month セットする month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day セットする day
	 */
	public void setDay(String day) {
		this.day = day;
	}


}
