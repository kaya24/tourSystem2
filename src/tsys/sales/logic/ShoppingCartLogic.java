package tsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import tsys.sales.dao.ConnectionManager;
import tsys.sales.dao.FlightDAO;
import tsys.sales.dao.HotelDAO;
import tsys.sales.dao.MemberDAO;
import tsys.sales.dao.OrderDetailDAO;
import tsys.sales.dao.OrderMasterDAO;
import tsys.sales.dao.PackageTourDAO;
import tsys.sales.entity.Item;
import tsys.sales.entity.Member;
import tsys.sales.entity.Order;
import tsys.sales.entity.OrderDetail;

/**
 * ショッピングカート管理を行うクラス
 *
 * @author kayashima
 * @version 1.0 2017/09/28
 */
public class ShoppingCartLogic {

	/**
	 * 引数で渡された電話番号をもとに会員情報を検索し、会員情報(Memberオブジェクト)を返却する。
	 *
	 * @param tel
	 *            電話番号
	 * @return 会員情報
	 */
	public Member getTelMember(String tel) throws SalesBusinessException,
			SalesSystemException {

		Connection con = null;
		Member member = null;

		try {
			con = ConnectionManager.getConnection();
			MemberDAO mdao = new MemberDAO(con);
			member = mdao.getTelMember(tel);
			if (member == null) {
				throw new SalesBusinessException();
			}
		} catch (SQLException e) {
			throw new SalesSystemException();
		}

		return member;
	}

	/**
	 * 引数で渡された注文情報をもとに注文情報を登録し、在庫不足商品情報リスト
	 * (ArrayList<Item>オブジェクト)を返却する。
	 *
	 * @param order 注文情報
	 * @return 在庫不足商品情報リスト
	 * @throws SalesBusinessException
	 * @throws SalesSystemException
	 */
	public ArrayList<Item> commitPurchase(Order order)
			throws SalesBusinessException, SalesSystemException {
		Connection con = null;
		ArrayList<Item> notStockItemList = new ArrayList<Item>();
		Item item = null;
		boolean updateCheck = true;
		boolean isNotStockItem = false;
		boolean insertCheck = true;
		try {
			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);

			PackageTourDAO pdao = new PackageTourDAO(con);
			FlightDAO fdao = new FlightDAO(con);
			HotelDAO hdao = new HotelDAO(con);

			// order.orderDetailListの要素数だけ繰り返す
			for(OrderDetail od: order.getOrderDetailList()){
				String itemCode = od.getItemCode();
				int quantity = od.getQuantity();

				if(od.getCategoryCode().equals("TOR")){
					updateCheck = pdao.updateStockPacakgeTour(itemCode, -quantity);
				}else if(od.getCategoryCode().equals("FLY")){
					updateCheck = fdao.updateStockFlight(itemCode, -quantity);
				}else if(od.getCategoryCode().equals("HTL")){
					updateCheck = hdao.updateStockHotel(itemCode, -quantity);
				}
				if(updateCheck == false){
					item = new Item();
					item.setItemCode(itemCode);
					notStockItemList.add(item);
					isNotStockItem = true;
				}
			}

			// 在庫不足商品がひとつもない場合、注文登録処理を実行する。
			if(isNotStockItem == false){
				OrderMasterDAO omdao = new OrderMasterDAO(con);
				OrderDetailDAO oddao = new OrderDetailDAO(con);

				insertCheck = omdao.insertOrderMaster(order);
				if(insertCheck == false){
					// ロールバックする
					con.rollback();
					throw new SalesSystemException();
				}

				// order.orderDetailListの要素数だけ繰り返す
				for(OrderDetail od: order.getOrderDetailList()){
					insertCheck = oddao.insertOrderDetail(od);
					if(insertCheck == false){
						// ロールバックする
						con.rollback();
						throw new SalesSystemException();
					}
				}

				// コミットする
				con.commit();
			}
			// クローズする
			con.close();

		} catch (SQLException e) {
			throw new SalesSystemException();
		}

		// 在庫不足商品情報リストを返却する
		return notStockItemList;
	}
}
