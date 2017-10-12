package tsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import tsys.sales.dao.ConnectionManager;
import tsys.sales.dao.PackageTourDAO;
import tsys.sales.entity.PackageTour;

public class PackageTourSalesLogic {

	/**
	 * パッケージツアー販売商品一覧を取得する
	 * @param destinationCode
	 * @param year
	 * @param month
	 * @return
	 * @throws SalesBusinessException
	 * @throws SalesSystemException
	 */
	public ArrayList<PackageTour> searchPackageTour(String destinationCode, String year, String month) throws SalesBusinessException, SalesSystemException{

		Connection con = null;
		ArrayList<PackageTour> packageTourList = new ArrayList<>();

		try {
			con = ConnectionManager.getConnection();
			PackageTourDAO pdao = new PackageTourDAO(con);
			packageTourList = pdao.getPackageTour(destinationCode, year, month);

			if(packageTourList.size() == 0){
				throw new SalesBusinessException();
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new SalesSystemException();
		}

		return packageTourList;
	}

	/**
	 * パッケージツアー商品の詳細情報の取得
	 * @param itemCode
	 * @return パッケージツアー商品
	 * @throws SalesBusinessException
	 * @throws SalesSystemException
	 */
	public PackageTour getPackageTour(String itemCode) throws SalesBusinessException, SalesSystemException{

		Connection con = null;
		PackageTour packageTour = new PackageTour();

		try {
			con = ConnectionManager.getConnection();
			PackageTourDAO pdao = new PackageTourDAO(con);
			packageTour = pdao.getPackageTour(itemCode);

			if(packageTour.equals(null)){
				throw new SalesBusinessException();
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new SalesSystemException();
		}

		return packageTour;
	}
}
