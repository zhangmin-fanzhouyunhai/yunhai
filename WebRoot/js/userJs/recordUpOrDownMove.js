//recordUpOrDownMove 
function recordUpOrDownMove(element) {
	var text = $(element).text();
	//alert("inside！")
	/* alert("name="+$(element).attr("name")+",value="+$(element).attr("value")); */
	if (text == "上移") {
		//alert($.trim($(element)c.parent().find("td").eq(2).text()));
		/*下面一行代码获取所有的行。$(element)取得当前控件对象（按钮），
		$(element).parent(),获取的为包含此控件对象的上一级控件对象(单元格<td>)，
		$(element).parent().parent(),获取的为包含此控件对象的上上一级控件对象(行<tr>)，
		*/
		var prevTdAll = $(element).parent().prevAll();
		//alert("prevTdAll.length="+prevTdAll.length);
		var prevTr = $(element).parent().parent().prevAll();
		//alert("prevTr.length="+prevTr.length);
		var prevTb = $(element).parent().parent().parent().prevAll();
		var firstTr = $(element).parent().parent().first();
		//alert("prevTb.length="+prevTb.length);
		/**如果当前行不是第一行，则上移它，length返回的是第几个元素（从0开始）？*/
		if (prevTr.length > 0) {
			//alert("firstTr.child().children()="+firstTr.children().children().text());
			var preTemp = $(element).parent().parent().prev(); //当前行的前一行 
			var thisHr = $(element).parent().parent(); //当前行
			//最后一列为调整排序的按钮所在的列。
			preTempValue=preTemp.find("td").eq(preTemp.find("td").length-1).text()
			thisHrValue=thisHr.find("td").eq(firstTr.find("td").length-1).text()
			/*通过判断最后一列的值是否相同，来判断是否与表头进行换行，这个方案不是很好*/
			if (preTempValue== thisHrValue) {
				//alert($.trim(thisHr.find("td").eq(2).text()));
				//alert($.trim(preTemp.find("td").eq(2).text())); 
				//var thisIndexof = parseInt(thisHr.find("td").eq(2).text()) - 1;
				//var preTempIndexof = parseInt(preTemp.find("td").eq(2).text()) + 1;
				//preTemp.find("td").eq(2).html(preTempIndexof);
				//thisHr.find("td").eq(2).html(thisIndexof);
				//thisHr.html();
				//alert(preTemp.html())
				/**将上一行与本行交互内容，replaceWith 方法内容为 html 内容
				 * 可参考文档：http://www.w3school.com.cn/jquery/manipulation_replacewith.asp*/
				thisHr.replaceWith("<tr align='center' style='FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none'>" + preTemp.html() + "</tr>");
				preTemp.replaceWith("<tr align='center' style='FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none'>" + thisHr.html() + "</tr>");
			}
		}
	} else if (text == "下移") {
		var nextTr = $(element).parent().parent().next();
		if (nextTr.length > 0) {
			var thisHr = $(element).parent().parent();
			/* alert($.trim(thisHr.find("td").eq(2).text()));
			alert($.trim(nextTr.find("td").eq(2).text())); //获取当前所在行的第3列表格中的文本，可以通过parseInt将其转换成整形，
			转换成浮点型的方法是parseFloat(Str).
			*/
			//var thisIndexof = parseInt(thisHr.find("td").eq(2).text()) + 1;
			//var nextTrIndexof = parseInt(nextTr.find("td").eq(2).text()) - 1;
			//nextTr.find("td").eq(2).html(nextTrIndexof);
			//thisHr.find("td").eq(2).html(thisIndexof);
			/**将本行与下一行交互内容，replaceWith 方法内容为 html 内容 */
			thisHr.replaceWith("<tr align='center' style='FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none'>" + nextTr.html() + "</tr>");
			nextTr.replaceWith("<tr align='center' style='FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none'>" + thisHr.html() + "</tr>");
		}
	}

}