package tsys.sales.dao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import tsys.sales.dao.ConnectionManager;
import tsys.sales.dao.PackageTourDAO;
import tsys.sales.entity.PackageTour;

public class TestPackageTourDAO {

	public static void main(String[] args) {

		Connection con = null;

		try {
			con = ConnectionManager.getConnection();

			/*DAO生成テスト*/
			PackageTourDAO pdao = new PackageTourDAO(con);
			System.out.println("PackageTourDAOの生成テスト：OK");

			/*商品一覧取得テスト*/
			ArrayList<PackageTour> packageTourList = new ArrayList<>();
			String destinationCode = "07";
			String year = "2016";
			//year = year.substring(2, 4);
			String month = "01";

			packageTourList = pdao.getPackageTour(destinationCode, year, month);
			if (packageTourList.size() == 0) {
				System.out.println("商品がありません");
				System.out.println("商品が取得できない環境であれば，OK");
			} else {
				System.out.println("商品一覧が表示されていたら，OK");
				for (PackageTour p : packageTourList) {
					System.out.println(p.getItemName());
					System.out.println(p.getDestinationName());
					System.out.println(p.getDate());
					System.out.println("-----------------------------");
				}
			}

			/*商品詳細情報の取得テスト*/
			PackageTour packageTour = new PackageTour();
			String itemCode = "TOR000001";
			packageTour = pdao.getPackageTour(itemCode);

			if(packageTour != null){
				System.out.println("カテゴリコード:" +packageTour.getCategoryCode());
				System.out.println("カテゴリ名:" +packageTour.getCategoryName());
				System.out.println("商品コード:" +packageTour.getItemCode());
				System.out.println("商品名:" +packageTour.getItemName());
				System.out.println("地区コード:" +packageTour.getDestinationCode());
				System.out.println("ホテル商品コード:" +packageTour.getHotel().getItemCode());
				System.out.println("フライト往路商品コード:" +packageTour.getHomeFlight().getDepartureAirportCode());
				System.out.println("フライト復路商品コード:" +packageTour.getHomeFlight().getArrivalAirportCode());
				System.out.println("日数:" + packageTour.getDays());
				System.out.println("宿泊数:" + packageTour.getNights());
				System.out.println("開催日:" + packageTour.getDate());
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
