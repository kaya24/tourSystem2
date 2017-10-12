import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

import tsys.sales.web.ActionInterface;
import tsys.sales.web.*;

public class ReflectionSample {
	public static void main(String[] args) {
		try {
			String targetClassName = "BC000Top";
			Class clazz = Class.forName("tsys.sales.web."+targetClassName+"Action");
			Object obj = clazz.newInstance();
			System.out.println(obj.getClass());
			ActionInterface action = (ActionInterface)obj;
			System.out.println(action.getClass());

		} catch (ClassNotFoundException e) {
			// クラスが存在しない
			e.printStackTrace();
		} catch (InstantiationException e) {
			// インスタンス作成不可
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// 呼び出し:アクセス違反, 保護されている
			e.printStackTrace();
		}

		Foo foo2 = new Foo();
		try {
			// 引数なし
			Method method = foo2.getClass().getMethod("bar");
			method.invoke(foo2);

			// 引数あり
			Method method2 = foo2.getClass().getMethod("pee", int.class);
			method2.invoke(foo2, 1);
		} catch (NoSuchMethodException e) {
			// メソッドが存在しない
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// 呼び出し:引数が異なる
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// 呼び出し:アクセス違反, 保護されている
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// ターゲットとなるメソッド自身の例外処理
			e.printStackTrace();
		}
	}
}
