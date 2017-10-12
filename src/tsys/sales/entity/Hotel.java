package tsys.sales.entity;

public class Hotel extends Item{

	private String hotelCode;
	private String hotelName;
	private String date;
	private String cityName;
	private String grade;
	private String basicPrice;
	/**
	 * @return hotelCode
	 */
	public String getHotelCode() {
		return hotelCode;
	}
	/**
	 * @param hotelCode セットする hotelCode
	 */
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}
	/**
	 * @return hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}
	/**
	 * @param hotelName セットする hotelName
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	/**
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date セットする date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName セットする cityName
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade セットする grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return basicPrice
	 */
	public String getBasicPrice() {
		return basicPrice;
	}
	/**
	 * @param basicPrice セットする basicPrice
	 */
	public void setBasicPrice(String basicPrice) {
		this.basicPrice = basicPrice;
	}


}
