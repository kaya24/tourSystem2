package tsys.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tsys.sales.entity.Aggregate;
import tsys.sales.entity.Order;

public class OrderMasterDAO {

	/** 接続オブジェクトを保持する変数 */
	Connection con;

	/**
	 * コンストラクタ
	 *
	 * @param con
	 *            接続オブジェクト
	 */
	public OrderMasterDAO(Connection con) {
		this.con = con;
	}

	/**
	 * 引数から取得した注文情報を、OrderMasterテーブルの新規レコードに挿入し、処理判定結果(boolean)を返却する。
	 *
	 * @param order
	 *            注文情報
	 * @return 処理判定結果
	 * @throws SQLException
	 */
	public boolean insertOrderMaster(Order order) throws SQLException {
		// 処理判定結果を宣言する。
		boolean insertCheck = false;
		String sql = "insert into ordermaster (OrderDate, OrderTotal, MemberCode, Payment) values (current_timestamp(), ?, ?, ?)";

		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, order.getOrderTotal());
			stmt.setString(2, order.getMemberCode());
			stmt.setString(3, order.getPayment());

			int count = stmt.executeUpdate();

			// 更新数が1のとき、処理判定結果を更新する。
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
	 * 引数から取得したメンバーコードをもとに、OrderMasterテーブルから注文情報を検索し、 注文情報リストを返却する。
	 *
	 * @param memberCode
	 *            メンバーコード
	 * @return 注文情報リスト
	 * @throws SQLException
	 */
	public ArrayList<Order> getOrderMaster(String memberCode)
			throws SQLException {
		ArrayList<Order> orderList = new ArrayList<>();
		Order order = null;

		String sql = "select * from ordermaster where MemberCode = ? "
				+ "and timediff(current_timestamp(), OrderDate) <= '03:00:00'";

		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, memberCode);

			// SQLを実行する。
			res = stmt.executeQuery();

			while (res.next()) {
				order = new Order();
				order.setOrderNo(res.getInt("OrderNo"));
				order.setOrderDate(res.getString("OrderDate"));
				order.setOrderTotal(res.getInt("OrderTotal"));
				order.setMemberCode(res.getString("MemberCode"));
				order.setPayment(res.getString("Payment"));
				orderList.add(order);
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return orderList;
	}

	/**
	 * 引数の注文情報をもとに、該当するレコードをOrderMasterテーブル、OrderDetailテーブルから削除し、
	 * 処理判定結果(boolean)を返却する。
	 *
	 * @param order
	 *            注文情報
	 * @return 処理判定結果
	 * @throws SQLException
	 */
	public boolean deleteOrderMaster(Order order) throws SQLException {
		boolean deleteCheck = false;

		String sql = "delete om, od from ordermaster om, orderdetail od "
				+ "where om.OrderNo in (?) and om.OrderNo=od.OrderNo";
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, order.getOrderNo());

			// SQLを実行する。
			int count = stmt.executeUpdate();

			if (count == (order.getOrderDetailList().size() + 1)) {
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

	public boolean updateOrderMaster(Order order) throws SQLException {
		boolean updateCheck = false;
		String sql = "update ordermaster set OrderTotal = ? where OrderNo = ?";
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, order.getOrderTotal());
			stmt.setInt(2, order.getOrderNo());

			// SQLを実行する。
			int count = stmt.executeUpdate();

			if (count == 1) {
				updateCheck = true;
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return updateCheck;
	}

	/**
	 * 引数から取得した年と月に該当するレコードを、Memberテーブル、OrderMasterテーブルから検索し、 月別集計情報を返却する。
	 *
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return 月別集計情報
	 * @throws SQLException
	 */
	public ArrayList<Aggregate> getMonthOrderAggregate(String year, String month)
			throws SQLException {

		ArrayList<Aggregate> aggregateMonthList = new ArrayList<Aggregate>();
		Aggregate aggregate = null;
		String sql = "select ordermaster.MemberCode, ordermaster.OrderDate, member.Name, "
				+ "ordermaster.OrderTotal from ordermaster, member "
				+ "where ordermaster.MemberCode = member.MemberCode "
				+ "and ordermaster.OrderDate like ?";

		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + year + "-" + month + "%");

			res = stmt.executeQuery();

			while (res.next()) {
				aggregate = new Aggregate();
				aggregate.setMemberCode(res.getString("MemberCode"));
				aggregate.setMemberName(res.getString("Name"));
				aggregate.setTotal(res.getInt("OrderTotal"));
				aggregateMonthList.add(aggregate);
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return aggregateMonthList;
	}

	/**
	 * 引数から取得した年と月に該当するレコードを、Memberテーブル、OrderMasterテーブルから検索し、 年別集計情報を返却する。
	 *
	 * @param year
	 *            年
	 * @return 年別集計情報
	 * @throws SQLException
	 */
	public ArrayList<Aggregate> getYearOrderAggregate(String year)
			throws SQLException {

		String sql = "select ordermaster.MemberCode, ordermaster.OrderDate, member.Name, "
				+ "ordermaster.OrderTotal from ordermaster, member "
				+ "where ordermaster.MemberCode = member.MemberCode "
				+ "and ordermaster.OrderDate like ?";

		PreparedStatement stmt = null;
		ResultSet res = null;
		ArrayList<Aggregate> aggregateYearList = new ArrayList<Aggregate>();
		Aggregate aggregate = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + year + "%");

			res = stmt.executeQuery();

			while (res.next()) {
				aggregate = new Aggregate();
				aggregate.setMemberCode(res.getString("MemberCode"));
				aggregate.setMemberName(res.getString("Name"));
				aggregate.setTotal(res.getInt("OrderTotal"));
				aggregateYearList.add(aggregate);
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return aggregateYearList;
	}

}
