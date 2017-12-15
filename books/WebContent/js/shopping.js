/*function sumCount() {
	var count = 0;// 数量
	var money = 0;// 价格
	var sumMoney = 0;

	$("td input").each(function(i2, e2) {
		count = $(this).val();

		money = $(this).parent().next().children("span").html();

		sumMoney += parseFloat(count * money);

	})
	$("span:last").html(sumMoney);

}
$(function() {
	sumCount();
	$(":text").blur(function() {
		sumCount();
	})
})*/
