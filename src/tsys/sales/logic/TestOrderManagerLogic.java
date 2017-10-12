package tsys.sales.logic;

public class TestOrderManagerLogic {

	public static void main(String[] args) {
		OrderManagerLogic logic = new OrderManagerLogic();
		try {
			logic.insertOrder();
		} catch (SalesBusinessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
