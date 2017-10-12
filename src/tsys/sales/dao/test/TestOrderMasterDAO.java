package tsys.sales.dao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import tsys.sales.dao.ConnectionManager;
import tsys.sales.dao.OrderMasterDAO;
import tsys.sales.entity.Aggregate;
import tsys.sales.entity.Order;
import tsys.sales.entity.OrderDetail;

public class TestOrderMasterDAO {

	public static void main(String[] args) {

		Connection con = null;
		boolean insertCheck = false;
		boolean deleteCheck = false;
		boolean updateCheck = false;

		// テストデータ変数宣言
		int orderNo;
		int orderTotal;
		String memberCode;
		String payment;
		String itemCode;
		Order order = new Order();
		OrderDetail orderDetail = new OrderDetail();
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<OrderDetail> orderDetailList = new ArrayList<>();
		String year, month;
		try {
			con = ConnectionManager.getConnection();

			/*
			 * テストケース番号：OM001
			 */
			OrderMasterDAO omdao = new OrderMasterDAO(con);
			System.out.println("*************************");
			System.out.print("OM001：");
			if (omdao != null) {
				System.out.println("OrderMasterDAOの生成テスト：OK");
			}
			System.out.println("*************************");

			/*
			 * テストケース番号：OMXXX insertOrderMasterメソッド
			 */
			// テストデータ作成
			orderTotal = 10000; // 適切に作成
			memberCode = "CMXXXX"; // 適切に作成
			payment = "01"; // 適切に作成
			order.setOrderTotal(orderTotal);
			order.setMemberCode(memberCode);
			order.setPayment(payment);

			// テスト実行
			insertCheck = omdao.insertOrderMaster(order);
			System.out.println("*************************");
			System.out.print("OMXXX：");
			System.out.println(insertCheck);
			System.out.println("*************************");

			/*
			 * テストケース番号：OMXXX getOrderMasterメソッド
			 */
			// テストデータ作成
			memberCode = "CMXXXX";
			// テスト実行
			orderList = omdao.getOrderMaster(memberCode);
			System.out.println("*************************");
			System.out.println("OMXXX：");
			for (int i = 0; i < orderList.size(); i++) {
				System.out.println("注文番号：" + orderList.get(i).getOrderNo());
				System.out.println("注文日付：" + orderList.get(i).getOrderDate());
				System.out.println("合計：" + orderList.get(i).getOrderTotal());
				System.out.println("メンバーコード："
						+ orderList.get(i).getMemberCode());
				System.out.println("決済方法：" + orderList.get(i).getPayment());
				System.out.println("-----------------------------");
			}
			System.out.println("*************************");
			if (orderList.size() == 0) {
				System.out.println("*************************");
				System.out.print("OMXXX：");
				System.out.println("OrderMasterテーブルのレコード0件の環境であれば、OK");
				System.out.println("*************************");
			}

			/*
			 * テストケース番号：OMXXX deleteOrderMasterメソッド
			 */
			// テストデータ作成
			orderNo = 10; // 適切に設定
			itemCode = "FLY000138";
			order.setOrderNo(orderNo);
			orderDetail.setItemCode(itemCode);
			orderDetailList.add(orderDetail);
			order.setOrderDetailList(orderDetailList);
			// テスト実行
			System.out.println("*************************");
			System.out.print("OMXXX：deleteCheck ");
			deleteCheck = omdao.deleteOrderMaster(order);
			System.out.println(deleteCheck);
			System.out.println("*************************");

			/*
			 * テストケース番号：OMXXX updateOrderMasterメソッド
			 */
			// テストデータ作成
			orderNo = 4; // 適切に設定
			orderTotal = 10; // 適切に設定
			order.setOrderNo(orderNo);
			order.setOrderTotal(orderTotal);
			// テスト実行
			System.out.println("*************************");
			System.out.print("OMXXX：updateCheck ");
			updateCheck = omdao.updateOrderMaster(order);
			System.out.println(updateCheck);
			System.out.println("*************************");

			/*
			 * テストケース番号：OMXXX getMonthOrderAggregateメソッド
			 */
			// テストデータ作成
			ArrayList<Aggregate> aggregateMonthList = new ArrayList<Aggregate>();
			year = "2016";
			month = "01";
			// テスト実行
			System.out.println("*************************");
			aggregateMonthList = omdao.getMonthOrderAggregate(year, month);
			for (Aggregate a : aggregateMonthList) {
				System.out.println(a.getMemberCode());
				System.out.println(a.getMemberName());
				System.out.println(a.getTotal());
				System.out.println("-----------------------------");
			}
			System.out.println("*************************");
			if (aggregateMonthList.size() == 0) {
				System.out.println("*************************");
				System.out.print("OMXXX：");
				System.out.println("レコード0件の環境であれば，OK");
				System.out.println("*************************");
			}

			/*
			 * テストケース番号：OMXXX getYearOrderAggregateメソッド
			 */
			// テストデータ作成
			ArrayList<Aggregate> aggregateYearList = new ArrayList<Aggregate>();
			year = "2016";
			// テスト実行
			aggregateYearList = omdao.getYearOrderAggregate(year);
			for (Aggregate a : aggregateYearList) {
				System.out.println(a.getMemberCode());
				System.out.println(a.getMemberName());
				System.out.println(a.getTotal());
				System.out.println("-----------------------------");
			}
			System.out.println("*************************");
			if (aggregateYearList.size() == 0) {
				System.out.println("*************************");
				System.out.print("OMXXX：");
				System.out.println("レコード0件の環境であれば，OK");
				System.out.println("*************************");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}

	}
}
