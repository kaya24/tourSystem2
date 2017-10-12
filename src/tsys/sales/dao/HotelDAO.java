package tsys.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tsys.sales.entity.Flight;
import tsys.sales.entity.Hotel;
import tsys.sales.entity.PackageTour;

public class HotelDAO {

	Connection con;

	public HotelDAO(Connection con) {
		this.con = con;
	}

	public boolean updateStockHotel(String itemCode, int quanitity){
		boolean updateCheck = false;

		return updateCheck;
	}

	/**
	 * パッケージツアー商品一覧を取得する
	 * @param destinationCode
	 * @param year
	 * @param month
	 * @return パッケージツアー商品リスト
	 * @throws SQLException
	 */
	public ArrayList<PackageTour> getPackageTour(String destinationCode,
			String year, String month) throws SQLException{
		String sql = "select tour.itemcode, tourmaster.name as itemname, "
				+ "destination.destinationcode, destination.name as destinationname, "
				+ "tourmaster.days, tourmaster.nights, tour.Date, "
				//+ "date_format(tour.Date, '%y%m') as ym, "
				+ "tour.price, tour.firsthotelitemcode, "
				+ "tour.outwardflightitemcode, tour.homewardflightitemcode, tour.stock, "
				+ "tourmaster.basicprice, tourmaster.hotelcode, tourmaster.outwardflightcode, "
				+ "tourmaster.homewardflightcode, categorycode, categoryname, tourmaster.tourcode "
				+ "from (( tour inner join tourmaster on tour.tourcode = tourmaster.tourcode ) "
				+ "inner join destination on tourmaster.destinationcode = destination.destinationcode), category "
				+ "where substr(tour.itemcode from 1 for 3) = category.categorycode "
				+ "and destination.destinationcode=? and tour.Date like ?";
				//+ "and date_format(tour.Date, '%y%m') = ?";

		PreparedStatement stmt = null;
		ResultSet res = null;
		ArrayList<PackageTour> packageTourList = new ArrayList<>();

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, destinationCode);
			//String ym = year.substring(2,4) + month;
			//stmt.setString(2, ym);
			stmt.setString(2, "%"+year+"-"+month+"%");
			res = stmt.executeQuery();

			while (res.next()) {
				PackageTour packageTour = new PackageTour();
				packageTour.setCategoryCode(res.getString("categoryCode")); // カテゴリコード
				packageTour.setItemCode(res.getString("itemcode")); // 商品コード
				packageTour.setItemName(res.getString("itemname")); // 商品名
				packageTour.setDestinationCode(res.getString("destinationcode")); // 地区コード
				packageTour.setDestinationName(res.getString("destinationname")); // 地区名
				packageTour.setDays(res.getInt("days")); // 日数
				packageTour.setNights(res.getInt("nights")); // 宿泊数
				packageTour.setDate(res.getString("date")); // 日付
				packageTour.setUnitPrice(res.getInt("price")); // 料金
				packageTour.setStock(res.getInt("stock")); // 在庫
				packageTour.setBasicPrice(res.getInt("basicprice")); // 基本料金
				packageTourList.add(packageTour);
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return packageTourList;
	}

	/**
	 * パッケージツアー販売商品の詳細情報を取得する．
	 * @param itemCode
	 * @return パッケージツアー販売商品の詳細情報
	 * @throws SQLException
	 */
	public PackageTour getPackageTour(String itemCode) throws SQLException{
		String sql = "select tour.itemcode, tourmaster.name as itemname, destination.destinationcode,"
				+ "destination.name as destinationname, "
				+ "tourmaster.days, tourmaster.nights,tour.Date, tour.price, tour.firsthotelitemcode, "
				+ "tour.outwardflightitemcode, tour.homewardflightitemcode, "
				+ "tour.stock, tourmaster.basicprice, tourmaster.hotelcode, "
				+ "tourmaster.outwardflightcode, tourmaster.homewardflightcode, "
				+ "categorycode, categoryname, tourmaster.tourcode "
				+ "from (( tour inner join tourmaster on tour.tourcode = tourmaster.tourcode ) "
				+ "inner join destination on tourmaster.destinationcode = destination.destinationcode), "
				+ "category where substr(tour.itemcode from 1 for 3) = category.categorycode "
				+ "and tour.itemcode = ?";

		PreparedStatement stmt = null;
		ResultSet res = null;
		PackageTour packageTour = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, itemCode);
			res = stmt.executeQuery();

			if (res.next()) {
				packageTour = new PackageTour();
				packageTour.setCategoryCode(res.getString("categorycode"));
				packageTour.setCategoryName(res.getString("categoryname"));
				packageTour.setItemCode(res.getString("itemcode")); // 商品コード
				packageTour.setItemName(res.getString("itemname")); // 商品名
				packageTour.setDestinationCode(res.getString("destinationcode")); // 地区コード
				packageTour.setDestinationName(res.getString("destinationname")); // 地区名

				Hotel hotel = new Hotel();
				hotel.setItemCode(res.getString("firsthotelitemcode"));
				packageTour.setHotel(hotel);//初日の宿泊ホテル

				Flight flight = new Flight();
				flight.setDepartureAirportCode(res.getString("outwardflightitemcode"));
				flight.setArrivalAirportCode(res.getString("homewardflightitemcode"));
				packageTour.setHomeFlight(flight);

				packageTour.setDays(res.getInt("days")); // 日数
				packageTour.setNights(res.getInt("nights")); // 宿泊数
				packageTour.setDate(res.getString("date")); // 日付
				packageTour.setUnitPrice(res.getInt("price")); // 料金
				packageTour.setStock(res.getInt("stock")); // 在庫
				packageTour.setBasicPrice(res.getInt("basicprice")); // 基本料金
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return packageTour;
	}
}
