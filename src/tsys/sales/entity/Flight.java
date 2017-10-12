package tsys.sales.entity;

/**
 * @author kayashima
 *
 */
public class Flight extends Item{

	private String flgihtCode;
	private String date;
	private String depatureTime;
	private String arrivalTime;
	private String departureAirportCode;
	private String arrivalAirportCode;
	private String airportCode;
	private String airportName;
	private int basicPrice;
	/**
	 * @return flgihtCode
	 */
	public String getFlgihtCode() {
		return flgihtCode;
	}
	/**
	 * @param flgihtCode セットする flgihtCode
	 */
	public void setFlgihtCode(String flgihtCode) {
		this.flgihtCode = flgihtCode;
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
	 * @return depatureTime
	 */
	public String getDepatureTime() {
		return depatureTime;
	}
	/**
	 * @param depatureTime セットする depatureTime
	 */
	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}
	/**
	 * @return arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * @param arrivalTime セットする arrivalTime
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/**
	 * @return departureAirportCode
	 */
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}
	/**
	 * @param departureAirportCode セットする departureAirportCode
	 */
	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}
	/**
	 * @return arrivalAirportCode
	 */
	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}
	/**
	 * @param arrivalAirportCode セットする arrivalAirportCode
	 */
	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}
	/**
	 * @return airportCode
	 */
	public String getAirportCode() {
		return airportCode;
	}
	/**
	 * @param airportCode セットする airportCode
	 */
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	/**
	 * @return airportName
	 */
	public String getAirportName() {
		return airportName;
	}
	/**
	 * @param airportName セットする airportName
	 */
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	/**
	 * @return basicPrice
	 */
	public int getBasicPrice() {
		return basicPrice;
	}
	/**
	 * @param basicPrice セットする basicPrice
	 */
	public void setBasicPrice(int basicPrice) {
		this.basicPrice = basicPrice;
	}


}
