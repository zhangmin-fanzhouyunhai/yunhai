
	function edit(element) {
		var oldhtml = $.trim(element.innerHTML); //获得元素之前的内容
		//alert(oldhtml);
		//alert(productId);
		var newobj =null;
		//当文本的内容超过30个字符时，创建textarea类的多行多列编辑框
		var lengthLimitValue=30
		if(oldhtml.length>lengthLimitValue) {
			newobj = document.createElement('textarea'); //创建一个input元素
			newobj.type = 'text'; //为newobj元素添加类型
			newobj.value = oldhtml;
			newobj.cols=lengthLimitValue;
			newobj.rows=3;
		}else{
			//当文本的内容小于等于30个字符时，创建input类type="text"的单行编辑框
			newobj = document.createElement('input'); //创建一个input元素
			newobj.type = 'text'; //为newobj元素添加类型
			newobj.value = oldhtml;
			newobj.size = oldhtml.length+5;
			//alert(newobj.size);
		}
		//alert(oldhtml.length);
		
		element.innerHTML = ''; //设置元素内容为空
		element.appendChild(newobj); //添加子元素
		newobj.focus(); //获得焦点
		//设置newobj失去焦点的事件
		newobj.onblur = function() {
			//下面应该判断是否做了修改并使用ajax代码请求服务端将id与修改后的数据提交
			//alert(element.id);
			//当触发时判断newobj的值是否为空，为空则不修改，并返回oldhtml
			element.innerHTML = $.trim(this.value) ? $.trim(this.value) :$.trim(oldhtml);
		}
	}

