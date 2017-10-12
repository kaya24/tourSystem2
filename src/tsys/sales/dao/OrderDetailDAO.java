package tsys.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tsys.sales.entity.ByItemAggregate;
import tsys.sales.entity.OrderDetail;

/**
 * @author kayashima
 *
 */
public class OrderDetailDAO {

	/** 接続オブジェクトを保持する変数 */
	Connection con;

	/**
	 * コンストラクタ
	 *
	 * @param con
	 *            接続オブジェクト
	 */
	public OrderDetailDAO(Connection con) {
		this.con = con;
	}

	/**
	 * 引数から取得した商品別注文情報を、OrderDetailテーブルの新規レコードに挿入し、 処理判定結果(boolean)を返却する。
	 *
	 * @param orderDetail
	 *            商品別注文情報
	 * @return 処理判定結果
	 * @throws SQLException
	 */
	public boolean insertOrderDetail(OrderDetail orderDetail)
			throws SQLException {

		// 処理判定結果のための変数宣言
		boolean insertCheck = false;

		String sql = "insert into orderdetail (OrderNo, ItemCode, Price, Quantity) "
				+ "values ((select last_insert_id()), ?, ?, ?)";

		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			// 以下の値を設定する。
			stmt.setString(1, orderDetail.getItemCode());
			stmt.setInt(2, orderDetail.getPrice());
			stmt.setInt(3, orderDetail.getQuantity());

			// SQLを実行する。
			int count = stmt.executeUpdate();

			// 更新数が1のとき、insertCheckをtrueに更新する。
			if (count == 1) {
				insertCheck = true;
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return insertCheck;
	}

	/**
	 * 引数から取得した商品別注文取消情報をもとに、該当するレコードをOrderDetailテーブルから削除し、
	 * 処理判定結果(boolean)を返却する。
	 *
	 * @param deleteOrderDetail
	 *            商品別注文取消情報
	 * @return 処理判定結果
	 * @throws SQLException
	 */
	public boolean deleteOrderDetail(OrderDetail deleteOrderDetail)
			throws SQLException {
		// 処理判定結果のための変数宣言
		boolean deleteCheck = false;

		String sql = "delete from orderdetail where OrderNo=? and ItemCode =?";
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			// 以下の値を設定する。
			stmt.setInt(1, deleteOrderDetail.getOrderNo());
			stmt.setString(2, deleteOrderDetail.getItemCode());

			// SQLを実行する。
			int count = stmt.executeUpdate();

			// 更新数が1のとき、insertCheckをtrueに更新する。
			if (count == 1) {
				deleteCheck = true;
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return deleteCheck;
	}

	/**
	 * 引数から取得したメンバーコードをもとに、OrderDetailテーブル、Tourテーブル、TourMasterテーブル、Hotelテーブル、
	 * HotelMasterテーブル、 Flightテーブル、FlightMasterテーブルから検索し、商品別集計情報リストを返却する。
	 *
	 * @param memberCode
	 *            メンバーコード
	 * @return 商品別集計情報リスト
	 * @throws SQLException
	 */
	public ArrayList<ByItemAggregate> getAllOrderDetail(String memberCode)
			throws SQLException {
		ArrayList<ByItemAggregate> byItemAggregateList = new ArrayList<ByItemAggregate>();
		ByItemAggregate byItemAggregate = null;

		String sql = "select ordermaster.MemberCode, orderdetail.OrderNo, "
				+ "tour.ItemCode, tourmaster.Name,orderdetail.Price, orderdetail.Quantity,"
				+ "(orderdetail.Price*orderdetail.Quantity) as SubTotal "
				+ "from ((orderdetail inner join tour on orderdetail.ItemCode = tour.ItemCode) "
				+ "inner join tourmaster on tour.TourCode = tourmaster.TourCode) "
				+ "inner join ordermaster on orderdetail.OrderNo = ordermaster.OrderNo where ordermaster.MemberCode = ? "
				+ "union "
				+ "select ordermaster.MemberCode, orderdetail.OrderNo, hotel.ItemCode, hotelmaster.Name, "
				+ "orderdetail.Price, orderdetail.Quantity, (orderdetail.Price*orderdetail.Quantity) as SubTotal "
				+ "from ((orderdetail inner join hotel on orderdetail.ItemCode = hotel.ItemCode) "
				+ "inner join hotelmaster on hotel.HotelCode = hotelmaster.HotelCode) "
				+ "inner join ordermaster on orderdetail.OrderNo = ordermaster.OrderNo where ordermaster.MemberCode = ? "
				+ "union "
				+ "select ordermaster.MemberCode, orderdetail.OrderNo, flight.Itemcode, flightmaster.FlightCode, "
				+ "orderdetail.Price, orderdetail.Quantity, "
				+ "(orderdetail.Price*orderdetail.Quantity) as SubTotal "
				+ "from ((orderdetail inner join flight on orderdetail.ItemCode = flight.ItemCode) "
				+ "inner join flightmaster on flight.FlightCode = flightmaster.FlightCode) "
				+ "inner join ordermaster on orderdetail.OrderNo = ordermaster.OrderNo where ordermaster.MemberCode = ? "
				+ "order by Price desc, ItemCode, MemberCode;";

		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, memberCode);
			stmt.setString(2, memberCode);
			stmt.setString(3, memberCode);

			// SQLを実行する
			res = stmt.executeQuery();

			while (res.next()) {
				byItemAggregate = new ByItemAggregate();
				byItemAggregate.setMemberCode(res.getString("MemberCode"));
				byItemAggregate.setItemCode(res.getString("ItemCode"));
				byItemAggregate.setItemName(res.getString("Name"));
				byItemAggregate.setUnitPrice(res.getInt("Price"));
				byItemAggregateList.add(byItemAggregate);
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return byItemAggregateList;
	}

	/**
	 * OrderDetailテーブル、Tourテーブル、TourMasterテーブル、Hotelテーブル、
	 * HotelMasterテーブル、Flightテーブル、FlightMasterテーブルから商品別集計情報を
	 * 全レコード取得し、商品別集計情報リストを返却する。
	 *
	 * @return 商品別集計情報リスト
	 * @throws SQLException
	 */
	public ArrayList<ByItemAggregate> getAllOrderDetail() throws SQLException {

		ArrayList<ByItemAggregate> byItemAggregateList = new ArrayList<ByItemAggregate>();
		ByItemAggregate byItemAggregate = null;
		String sql = "select ordermaster.MemberCode, orderdetail.OrderNo, "
				+ "tour.ItemCode, tourmaster.Name,orderdetail.Price, orderdetail.Quantity,"
				+ "(orderdetail.Price*orderdetail.Quantity) as SubTotal "
				+ "from ((orderdetail inner join tour on orderdetail.ItemCode = tour.ItemCode) "
				+ "inner join tourmaster on tour.TourCode = tourmaster.TourCode) "
				+ "inner join ordermaster on orderdetail.OrderNo = ordermaster.OrderNo "
				+ "union "
				+ "select ordermaster.MemberCode, orderdetail.OrderNo, hotel.ItemCode, hotelmaster.Name, "
				+ "orderdetail.Price, orderdetail.Quantity, (orderdetail.Price*orderdetail.Quantity) as SubTotal "
				+ "from ((orderdetail inner join hotel on orderdetail.ItemCode = hotel.ItemCode) "
				+ "inner join hotelmaster on hotel.HotelCode = hotelmaster.HotelCode) "
				+ "inner join ordermaster on orderdetail.OrderNo = ordermaster.OrderNo "
				+ "union "
				+ "select ordermaster.MemberCode, orderdetail.OrderNo, flight.Itemcode, flightmaster.FlightCode, "
				+ "orderdetail.Price, orderdetail.Quantity, "
				+ "(orderdetail.Price*orderdetail.Quantity) as SubTotal "
				+ "from ((orderdetail inner join flight on orderdetail.ItemCode = flight.ItemCode) "
				+ "inner join flightmaster on flight.FlightCode = flightmaster.FlightCode) "
				+ "inner join ordermaster on orderdetail.OrderNo = ordermaster.OrderNo "
				+ "order by Price desc, ItemCode, MemberCode;";

		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			// SQLを実行する
			res = stmt.executeQuery();

			while (res.next()) {
				byItemAggregate = new ByItemAggregate();
				byItemAggregate.setMemberCode(res.getString("MemberCode"));
				byItemAggregate.setItemCode(res.getString("ItemCode"));
				byItemAggregate.setItemName(res.getString("Name"));
				byItemAggregate.setUnitPrice(res.getInt("Price"));
				byItemAggregate.setQuantity(res.getInt("Quantity"));
				byItemAggregate.setTotal(res.getInt("SubTotal"));
				byItemAggregateList.add(byItemAggregate);
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return byItemAggregateList;
	}

	/**
	 * 引数から取得した注文番号をもとに、OrderDetailテーブル、Tourテーブル、TourMasterテーブル、Hotelテーブル、
	 * HotelMasterテーブル、Flightテーブル、FlightMasterテーブルから商品別注文情報を検索し、商品別注文情報リストを返却する。
	 *
	 * @param orderNo
	 *            注文番号
	 * @return 商品別注文情報リスト
	 * @throws SQLException
	 */
	public ArrayList<OrderDetail> getOrderDetail(int orderNo)
			throws SQLException {
		ArrayList<OrderDetail> orderDetailList = new ArrayList<>();
		OrderDetail orderDetail = null;

		String sql = "select ordermaster.MemberCode, orderdetail.OrderNo, "
				+ "tour.ItemCode, tourmaster.Name,orderdetail.Price, orderdetail.Quantity,"
				+ "(orderdetail.Price*orderdetail.Quantity) as SubTotal "
				+ "from ((orderdetail inner join tour on orderdetail.ItemCode = tour.ItemCode) "
				+ "inner join tourmaster on tour.TourCode = tourmaster.TourCode) "
				+ "inner join ordermaster on orderdetail.OrderNo = ? "
				+ "union "
				+ "select ordermaster.MemberCode, orderdetail.OrderNo, hotel.ItemCode, hotelmaster.Name, "
				+ "orderdetail.Price, orderdetail.Quantity, (orderdetail.Price*orderdetail.Quantity) as SubTotal "
				+ "from ((orderdetail inner join hotel on orderdetail.ItemCode = hotel.ItemCode) "
				+ "inner join hotelmaster on hotel.HotelCode = hotelmaster.HotelCode) "
				+ "inner join ordermaster on orderdetail.OrderNo = ? "
				+ "union "
				+ "select ordermaster.MemberCode, orderdetail.OrderNo, flight.Itemcode, flightmaster.FlightCode, "
				+ "orderdetail.Price, orderdetail.Quantity, "
				+ "(orderdetail.Price*orderdetail.Quantity) as SubTotal "
				+ "from ((orderdetail inner join flight on orderdetail.ItemCode = flight.ItemCode) "
				+ "inner join flightmaster on flight.FlightCode = flightmaster.FlightCode) "
				+ "inner join ordermaster on orderdetail.OrderNo = ? "
				+ "order by Price desc, ItemCode, MemberCode;";

		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, orderNo);
			stmt.setInt(2, orderNo);
			stmt.setInt(3, orderNo);

			// SQLを実行する
			res = stmt.executeQuery();

			while (res.next()) {
				orderDetail = new OrderDetail();
				orderDetail.setOrderNo(res.getInt("OrderNo"));
				orderDetail.setItemCode(res.getString("ItemCode"));
				orderDetail.setItemName(res.getString("Name"));
				orderDetail.setPrice(res.getInt("Price"));
				orderDetail.setQuantity(res.getInt("Quantity"));
				orderDetail.setSubTotal(res.getInt("SubTotal"));
				orderDetailList.add(orderDetail);
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return orderDetailList;
	}

	/**
	 * 引数から取得した商品コードをもとにOrderDetailテーブルから該当するレコードを取得し、日付を返却する。
	 *
	 * @param itemCode
	 *            商品コード
	 * @return 日付（開催日、運航日、宿泊日）
	 * @throws SQLException
	 */
	public String getDateOrderDetail(String itemCode) throws SQLException {
		String date = null;
		String sql = "select Tour.ItemCode,Tour.Date from Tour where ItemCode in (select ItemCode from OrderDetail where ItemCode = ?) "
				+ "union "
				+ "select Flight.ItemCode, Flight.Date from Flight where ItemCode in (select ItemCode from OrderDetail where ItemCode = ?) "
				+ "union "
				+ "select Hotel.ItemCode, Hotel.Date from Hotel where ItemCode in (select ItemCode from OrderDetail where ItemCode = ?)";
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, itemCode);
			stmt.setString(2, itemCode);
			stmt.setString(3, itemCode);

			// SQLを実行する
			res = stmt.executeQuery();

			if (res.next()) {
				date = res.getString("Date");
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return date;
	}
}
