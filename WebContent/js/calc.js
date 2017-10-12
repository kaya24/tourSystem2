//カンマ区切りに変換する関数
function addFigure(str) {
	var num = new String(str).replace(/,/g, "");
	while (num != (num = num.replace(/^(-?\d+)(\d{3})/, "$1,$2")))
		;
	return num;
}

/* 初期値の計算 */
window.onload = function() { // 即時関数
	var all = 0;
	var unitPriceForm = document.getElementsByClassName("unitPrice");

	for (var i = 0; i < unitPriceForm.length; i++) {
		// 各商品のoptionタグのclass="quantity"要素のselected値を取得
		var quantity = document.getElementsByClassName('quantity')[i].value;
		// 商品のi番目のclass="unitPrice"要素を取得
		var price = unitPriceForm[i].innerHTML;
		// 数値からカンマを取り除く
		price = parseInt(price.split(',').join('').trim());
		// 小計の計算
		var subtotal = quantity * price;
		// 小計欄を書き込む
		document.getElementsByClassName("subtotal")[i].textContent = addFigure(subtotal);
		all += subtotal;
	}
	// 合計欄に書き込み
	document.getElementById("all").textContent = addFigure(all);
};

/* 数量変更時のアクション */
// 小計を変更しつつ、合計金額を計算し、反映する
/*
function change() {
	var all = 0;
	var unitPriceForm = document.getElementsByClassName("unitPrice");
	for (var i = 0; i < unitPriceForm.length; i++) {
		// 各商品のoptionタグのclass="quantity"要素のselected値を取得
		var quantity = document.getElementsByClassName('quantity')[i].value;
		// 商品のi番目のclass="unitPrice"要素を取得
		var price = unitPriceForm[i].innerHTML;
		price = parseInt(price.split(',').join('').trim());
		var subtotal = quantity * price;
		// 小計欄を書き込む
		document.getElementsByClassName("subtotal")[i].textContent = addFigure(subtotal);
		all += subtotal;
	}
	// 合計欄に書き込み
	document.getElementById("all").textContent = addFigure(all);
}
*/
function selChange() {
	document.form1.action = "/tourSystem/FrontCont?BUTTON_ID=B201CartPurchase&flag=1";
	document.form1.submit();
}