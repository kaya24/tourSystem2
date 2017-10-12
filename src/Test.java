import java.util.ArrayList;

import tsys.sales.entity.PackageTour;

public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		ArrayList<PackageTour> pList = new ArrayList<PackageTour>();
		PackageTour p = null;

		p = new PackageTour();
		p.setBasicPrice(100);
		pList.add(p);

		p = new PackageTour();
		p.setBasicPrice(200);
		pList.add(p);

		for(PackageTour pp : pList){
			System.out.println("要素チェック" + pp.getBasicPrice());
		}

		PackageTour p1 = new PackageTour();
		PackageTour p2 = new PackageTour();

		p1.setBasicPrice(100);
		System.out.println(p1.getBasicPrice());
		p2.setBasicPrice(200);

		p1 = p2;
		System.out.println(p1.getBasicPrice());
		p1.setBasicPrice(999);
		System.out.println(p2.getBasicPrice());
	}

}
