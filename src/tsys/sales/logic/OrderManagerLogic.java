package tsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import tsys.sales.dao.FlightDAO;
import tsys.sales.dao.HotelDAO;
import tsys.sales.dao.OrderDetailDAO;
import tsys.sales.dao.OrderMasterDAO;
import tsys.sales.dao.PackageTourDAO;
import tsys.sales.entity.Order;
import tsys.sales.entity.OrderDetail;
import tsys.sales.dao.ConnectionManager;

/**
 * 注文情報管理を行うクラス
 *
 * @author kayashima
 * @version 1.0 2017/09/28
 */
public class OrderManagerLogic {

	/**
	 * 引数で渡された注文番号をもとに、注文情報を検索し、注文一覧(ArrayList<Order>オブジェクト)を返却する。
	 *
	 * @param memberCode
	 *            メンバーコード
	 * @return 注文一覧
	 * @throws SalesSystemException
	 * @throws SalesBusinessException
	 */
	public ArrayList<Order> showListOrderMaster(String memberCode)
			throws SalesSystemException, SalesBusinessException {

		Connection con = null;
		ArrayList<Order> orderList = new ArrayList<Order>();

		try {
			con = ConnectionManager.getConnection();
			OrderMasterDAO omdao = new OrderMasterDAO(con);
			orderList = omdao.getOrderMaster(memberCode);
			if (orderList.size() == 0) {
				throw new SalesBusinessException();
			}

			// 接続オブジェクトをクローズする
			con.close();

		} catch (SQLException e) {
			throw new SalesSystemException();
		}

		// 注文一覧を返却する
		return orderList;
	}

	/**
	 * @param orderNo
	 *            注文番号
	 * @return 商品別注文情報リスト
	 * @throws SalesSystemException
	 * @throws SalesBusinessException
	 */
	public ArrayList<OrderDetail> showListOrderDetail(int orderNo)
			throws SalesSystemException, SalesBusinessException {

		Connection con = null;
		ArrayList<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

		try {
			con = ConnectionManager.getConnection();
			OrderDetailDAO oddao = new OrderDetailDAO(con);
			orderDetailList = oddao.getOrderDetail(orderNo);

			if (orderDetailList.size() == 0) {
				throw new SalesBusinessException();
			}

			// 接続オブジェクトをクローズする
			con.close();

		} catch (SQLException e) {
			throw new SalesSystemException();
		}

		// 商品別注文情報リスト
		return orderDetailList;
	}

	public boolean deleteCommitOrder(Order order,
			ArrayList<OrderDetail> deleteOrderDetailList)
			throws SalesSystemException, SalesBusinessException {
		boolean deleteCheck = true;
		boolean updateCheck = true;
		int deleteOrderTotal = 0;
		Connection con = null;
		try {
			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);

			PackageTourDAO pdao = new PackageTourDAO(con);
			FlightDAO fdao = new FlightDAO(con);
			HotelDAO hdao = new HotelDAO(con);

			// deleteOrderDetailListの要素数だけ繰り返す
			// 取消商品の合計金額も計算しておく
			for (OrderDetail od : deleteOrderDetailList) {

				String itemCode = od.getItemCode();
				int quantity = od.getQuantity();

				if (od.getCategoryCode().equals("TOR")) {
					updateCheck = pdao.updateStockPacakgeTour(itemCode,
							quantity);
				} else if (od.getCategoryCode().equals("FLY")) {
					updateCheck = fdao.updateStockFlight(itemCode, quantity);
				} else if (od.getCategoryCode().equals("HTL")) {
					updateCheck = hdao.updateStockHotel(itemCode, quantity);
				}
				if (updateCheck == false) {
					// ロールバックする
					con.rollback();
					throw new SalesSystemException();
				}
				deleteOrderTotal += od.getSubTotal();
			}

			OrderMasterDAO omdao = new OrderMasterDAO(con);
			OrderDetailDAO oddao = new OrderDetailDAO(con);
			if (order.getOrderDetailList().size() == deleteOrderDetailList
					.size()) {
				deleteCheck = omdao.deleteOrderMaster(order);
				if (deleteCheck == false) {
					// ロールバックする
					con.rollback();
					throw new SalesSystemException();
				}
			} else {
				// 注文取消商品を除いた注文情報の合計金額を設定
				order.setOrderTotal(order.getOrderTotal() - deleteOrderTotal);
				updateCheck = omdao.updateOrderMaster(order);
				if (updateCheck == false) {
					// ロールバックする
					con.rollback();
					throw new SalesSystemException();
				}

				// deleteOrderDetailListの要素数だけ繰り返す
				for (OrderDetail od : deleteOrderDetailList) {
					deleteCheck = oddao.deleteOrderDetail(od);
					if (deleteCheck == false) {
						// ロールバックする
						con.rollback();
						throw new SalesSystemException();
					}
				}

			}
			// コミットする
			con.commit();
			// 接続オブジェクトをクローズする
			con.close();
		} catch (SQLException e) {
			throw new SalesSystemException();
		}

		return deleteCheck;
	}

	public boolean insertOrder() throws SalesBusinessException {

		boolean insertCheck = true;
		Connection con = null;
		try {
			con = ConnectionManager.getConnection();
			OrderMasterDAO omdao = new OrderMasterDAO(con);
			OrderDetailDAO oddao = new OrderDetailDAO(con);

			// テストデータ変数宣言
			Order order = new Order();
			int orderTotal;
			String memberCode;
			String payment;
			orderTotal = 10000; // 適切に作成
			memberCode = "CMYYYY"; // 適切に作成
			payment = "01"; // 適切に作成
			order.setOrderTotal(orderTotal);
			order.setMemberCode(memberCode);
			order.setPayment(payment);
			insertCheck = omdao.insertOrderMaster(order);
			if (insertCheck == false) {
				System.out.println("insertOrderMaster　失敗");
			}

			// テストデータ変数宣言
			OrderDetail orderDetail = new OrderDetail();
			String itemCode;
			int price;
			int quantity;
			// テストデータ作成
			itemCode = "FLY000138";
			price = 13000;
			quantity = 1;
			orderDetail.setItemCode(itemCode);
			orderDetail.setPrice(price);
			orderDetail.setQuantity(quantity);
			insertCheck = oddao.insertOrderDetail(orderDetail);
			System.out.println(insertCheck);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return true;
	}
}
