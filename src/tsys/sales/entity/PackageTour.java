package tsys.sales.entity;

public class PackageTour extends Item{

	/** ツアーコード（マスターコード）*/
	private String tourCode;
	private String tourName;
	private String destinationCode;
	private String destinationName;
	private int days;
	private int nights;
	private String date;
	private int basicPrice;
	private Flight homeFlight;
	private Flight outFlight;
	private Hotel hotel;

	/**
	 * @return tourCode
	 */
	public String getTourCode() {
		return tourCode;
	}
	/**
	 * @param tourCode セットする tourCode
	 */
	public void setTourCode(String tourCode) {
		this.tourCode = tourCode;
	}
	/**
	 * @return tourName
	 */
	public String getTourName() {
		return tourName;
	}
	/**
	 * @param tourName セットする tourName
	 */
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public String getDestinationCode() {
		return destinationCode;
	}
	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}
	/**
	 * @return destinationName
	 */
	public String getDestinationName() {
		return destinationName;
	}
	/**
	 * @param destinationName セットする destinationName
	 */
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	/**
	 * @return days
	 */
	public int getDays() {
		return days;
	}
	/**
	 * @param days セットする days
	 */
	public void setDays(int days) {
		this.days = days;
	}
	/**
	 * @return nights
	 */
	public int getNights() {
		return nights;
	}
	/**
	 * @param nights セットする nights
	 */
	public void setNights(int nights) {
		this.nights = nights;
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
	public int getBasicPrice() {
		return basicPrice;
	}
	public void setBasicPrice(int basicPrice) {
		this.basicPrice = basicPrice;
	}

	/**
	 * @return homeFlight
	 */
	public Flight getHomeFlight() {
		return homeFlight;
	}
	/**
	 * @param homeFlight セットする homeFlight
	 */
	public void setHomeFlight(Flight homeFlight) {
		this.homeFlight = homeFlight;
	}
	/**
	 * @return outFlight
	 */
	public Flight getOutFlight() {
		return outFlight;
	}
	/**
	 * @param outFlight セットする outFlight
	 */
	public void setOutFlight(Flight outFlight) {
		this.outFlight = outFlight;
	}
	/**
	 * @return hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}
	/**
	 * @param hotel セットする hotel
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}



}
