package tsys.sales.dao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import tsys.sales.dao.ConnectionManager;
import tsys.sales.dao.OrderDetailDAO;
import tsys.sales.dao.OrderMasterDAO;
import tsys.sales.entity.Aggregate;
import tsys.sales.entity.Order;
import tsys.sales.entity.OrderDetail;

public class TestOrderDetailDAO {

	public static void main(String[] args) {

		Connection con = null;
		boolean insertCheck = false;
		boolean deleteCheck = false;
		boolean updateCheck = false;

		// テストデータ変数宣言
		OrderDetail orderDetail = new OrderDetail();
		int orderNo;
		String itemCode;
		int price;
		int quantity;
		ArrayList<OrderDetail> odList = new ArrayList<OrderDetail>();

		try {
			con = ConnectionManager.getConnection();

			/*
			 * テストケース番号：OD001
			 */
			OrderDetailDAO oddao = new OrderDetailDAO(con);
			System.out.print("OD001：");
			if (oddao != null) {
				System.out.println("OrderMasterDAOの生成テスト：OK");
			}
			System.out.println("*************************");

			/*
			 * テストケース番号：ODXXX insertOrderDetailメソッド
			 */
			// テストデータ作成
			itemCode = "FLY000138";
			price = 13000;
			quantity = 1;
			orderDetail.setItemCode(itemCode);
			orderDetail.setPrice(price);
			orderDetail.setQuantity(quantity);
			// テスト実行
			insertCheck = oddao.insertOrderDetail(orderDetail);
			System.out.print("ODXXX：");
			System.out.println(insertCheck);
			System.out.println("*************************");

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
