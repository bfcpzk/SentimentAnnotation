function showListByDate(){
	var year = $("#year").val();
	var month = $("#month").val();
	var day = $("#day").val();
	var lastId = "";
	$.ajax({
		type:"get",//请求类型
		contentType:"application/json;charset=utf-8",//发往服务端的数据类型
		url:"showListByDate.do",
		data:{
			"year" : year,
			"month" : month,
			"day" : day
		},
		dataType:"json",
        success : function(msg) {
        	if(msg != null){//查询成功
        		$("#tbody_content").empty();
        		$.each(msg, function (i, item) { 
    				$str1 = "<tr><td id='id_" + item.id + "'>" + item.id + "</td><td id='wid_" + item.id + "'>" + item.wid + "</td><td id='author_" + item.id + "'>" + item.author + "</td><td id='text_" + item.id + "'>" + item.text + "</td><td id='date_" + item.id + "'>" + item.date + "</td>";
					$str2 = "<td id='action_" + item.id +"'><a id='button_" + item.id + "_up' href='javascript:void' onclick='addAnnotation(" + item.id + ",1)' class='btn btn-success'>正性</a><a id='button_" + item.id + "_mid' href='javascript:void' onclick='addAnnotation(" + item.id + ",0)' class='btn btn-info'>中性</a><a id='button_" + item.id + "_down' href='javascript:void' onclick='addAnnotation(" + item.id + ",-1)' class='btn btn-danger'>负向</a></td>";
    				$str3 = "<td id='sent_label_" + item.id + "'>";
    				if(item.sent_label == -1){
    					$str3 += "<p style='color:red'>负向情感</p></td></tr>";
    				}else if(item.sent_label == 0){
    					$str3 += "<p style='color:blue'>中性情感</p></td></tr>";
    				}else if(item.sent_label == 1){
    					$str3 += "<p style='color:green'>正向情感</p></td></tr>";
    				}
					$("#tbody_content").append($str1+$str2+$str3);
    				lastId = item.id;
        		});
        		$("#lastId").val(lastId);
        	}else{
        		alert("查询失败,当天没有数据！");
        	}
        },
	});//end ajax
}

function addAnnotation(id,tag){
	$.ajax({
		type:"get",//请求类型
		contentType:"application/json;charset=utf-8",//发往服务端的数据类型
		url:"addAnnotation.do",
		data:{
			"tag" : tag,
			"id" : id,
		},
		dataType:"json",
        success : function(msg) {
        	if(msg){//更新成功
        		if(tag == -1){//负向
        			$("#sent_label_"+id).html("<p style='color:red'>负向情感</p>");
        		}else if(tag == 0){//中性
        			$("#sent_label_"+id).html("<p style='color:blue'>中性情感</p>");
        		}else if(tag == 1){//正向
        			$("#sent_label_"+id).html("<p style='color:green'>正向情感</p>");
        		}
        	}else{
        		alert("更新失败！");
        	}
        },
	});//end ajax
}

function getWeiboByKeyword(keyword){
	var lastId = "";
	$.ajax({
		type:"get",//请求类型
		contentType:"application/json;charset=utf-8",//发往服务端的数据类型
		url:"getWeiboByKeyword.do",
		data:{
			"keyword" : keyword,
		},
		dataType:"json",
        success : function(msg) {
        	if(msg){//查询成功
        		$("#tbody_content").empty();
        		$.each(msg, function (i, item) { 
    				$str1 = "<tr><td id='id_" + item.id + "'>" + item.id + "</td><td id='wid_" + item.id + "'>" + item.wid + "</td><td id='author_" + item.id + "'>" + item.author + "</td><td id='text_" + item.id + "'>" + item.text + "</td><td id='date_" + item.id + "'>" + item.date + "</td>";
					$str2 = "<td id='action_" + item.id +"'><a id='button_" + item.id + "_up' href='javascript:void' onclick='addAnnotation(" + item.id + ",1)' class='btn btn-success'>正性</a><a id='button_" + item.id + "_mid' href='javascript:void' onclick='addAnnotation(" + item.id + ",0)' class='btn btn-info'>中性</a><a id='button_" + item.id + "_down' href='javascript:void' onclick='addAnnotation(" + item.id + ",-1)' class='btn btn-danger'>负向</a></td>";
    				$str3 = "<td id='sent_label_" + item.id + "'>";
    				if(item.sent_label == -1){
    					$str3 += "<p style='color:red'>负向情感</p></td></tr>";
    				}else if(item.sent_label == 0){
    					$str3 += "<p style='color:blue'>中性情感</p></td></tr>";
    				}else if(item.sent_label == 1){
    					$str3 += "<p style='color:green'>正向情感</p></td></tr>";
    				}
					$("#tbody_content").append($str1+$str2+$str3);
    				lastId = item.id;
        		});
        		$("#lastId").val(lastId);
        	}else{
        		alert("查询失败！没有关于这个词的相关微博信息");
        	}
        },
	});//end ajax
}



function judgeDay(){
	var year = $("#year").val();
	var month = $("#month").val();
	if(year != "-请选择-" && month != "-请选择-"){
		$.ajax({
			type:"get",//请求类型
			contentType:"application/json;charset=utf-8",//发往服务端的数据类型
			url:"judgeDay.do",
			data:{
				"year" : year,
				"month" : month,
			},
			dataType:"json",
	        success : function(msg) {
	        	if(msg!=null){//成功
	        		$("#day").empty();
	        		$.each(msg, function (i, item) { 
	        			var $str = "";
	    				$str = "<option>" + item + "</option>";
	    				$("#day").append($str);
	        		});
	        	}
	        },
		});//end ajax
	}
}

function getWeiboByKeyword(){
	var lastId = "";
	var keyword = $("#keyword").val();
	if(keyword == null || keyword == ""){
		alert("输入不能为空！");
	}else{
		$.ajax({
			type:"get",//请求类型
			contentType:"application/json;charset=utf-8",//发往服务端的数据类型
			url:"getWeiboByKeyword.do",
			data:{
				"keyword" : keyword,
			},
			dataType:"json",
	        success : function(msg) {
	        	if(msg){//更新成功
	        		$("#tbody_content").empty();
	        		$.each(msg, function (i, item) { 
	    				$str1 = "<tr><td id='id_" + item.id + "'>" + item.id + "</td><td id='wid_" + item.id + "'>" + item.wid + "</td><td id='author_" + item.id + "'>" + item.author + "</td><td id='text_" + item.id + "'>" + item.text + "</td><td id='date_" + item.id + "'>" + item.date + "</td>";
						$str2 = "<td id='action_" + item.id +"'><a id='button_" + item.id + "_up' href='javascript:void' onclick='addAnnotation(" + item.id + ",1)' class='btn btn-success'>正性</a><a id='button_" + item.id + "_mid' href='javascript:void' onclick='addAnnotation(" + item.id + ",0)' class='btn btn-info'>中性</a><a id='button_" + item.id + "_down' href='javascript:void' onclick='addAnnotation(" + item.id + ",-1)' class='btn btn-danger'>负向</a></td>";
	    				$str3 = "<td id='sent_label_" + item.id + "'>";
	    				if(item.sent_label == -1){
	    					$str3 += "<p style='color:red'>负向情感</p></td></tr>";
	    				}else if(item.sent_label == 0){
	    					$str3 += "<p style='color:blue'>中性情感</p></td></tr>";
	    				}else if(item.sent_label == 1){
	    					$str3 += "<p style='color:green'>正向情感</p></td></tr>";
	    				}
						$("#tbody_content").append($str1+$str2+$str3);
	    				lastId = item.id;
	        		});
	        		$("#lastId").val(lastId);
	        	}else{
	        		alert("更新失败！");
	        	}
	        },
		});//end ajax
	}
}


$(document).ready(function(){
	var browser_height = document.documentElement.clientHeight;
	$(".set").css("height",browser_height-100); 
});

$(document).ready(function(){
	var flag = 1;
	$("#content").scroll(function(){
	    var clientHeight =$(this).height();//可见高度
	    //alert("clientHeight" + clientHeight);
	    var scrollHeight =$(this)[0].scrollHeight;
	    //alert(scrollHeight);
	    var scrollTop =$(this).scrollTop();//滚动高度
	    //alert(scrollTop);
	    var lastId = $("#lastId").val();
	    if(scrollTop + clientHeight > 0.95 * scrollHeight && flag == 1){
	        flag = 0;
	    	// 这里加载数据..
	    	$.ajax({
		    	type:"get",//请求类型
		    	contentType:"application/json;charset=utf-8",//发往服务端的数据类型
		    	url:"addListByRoller.do",
		    	data:{
		   	      	"lastId" : lastId,
		    	},
		    	dataType:"json",
		        success : function(msg) {
		            if(msg != null){
		            	$.each(msg, function (i, item) { 
		            		$str1 = "<tr><td id='id_" + item.id + "'>" + item.id + "</td><td id='wid_" + item.id + "'>" + item.wid + "</td><td id='author_" + item.id + "'>" + item.author + "</td><td id='text_" + item.id + "'>" + item.text + "</td><td id='date_" + item.id + "'>" + item.date + "</td>";
		    				$str2 = "<td id='action_" + item.id +"'><a id='button_" + item.id + "_up' href='javascript:void' onclick='addAnnotation(" + item.id + ",1)' class='btn btn-success'>正性</a><a id='button_" + item.id + "_mid' href='javascript:void' onclick='addAnnotation(" + item.id + ",0)' class='btn btn-info'>中性</a><a id='button_" + item.id + "_down' href='javascript:void' onclick='addAnnotation(" + item.id + ",-1)' class='btn btn-danger'>负向</a></td>";
		        			$str3 = "<td id='sent_label_" + item.id + "'>";
		        			if(item.sent_label == -1){
		        				$str3 += "<p style='color:red'>负向情感</p></td></tr>";
		        			}else if(item.sent_label == 0){
		        				$str3 += "<p style='color:blue'>中性情感</p></td></tr>";
		        			}else if(item.sent_label == 1){
		        				$str3 += "<p style='color:green'>正向情感</p></td></tr>";
		        			}
		    				$("#tbody_content").append($str1+$str2+$str3);
		        			lastId = item.id;
		            	});
		            	$("#lastId").val(lastId);//查询到新数据后对状态值更新
		            }else{
		            	alert("没有数据了");
		            }
		        }
		   	});//end ajax
	    }else{
	    	if(scrollTop + clientHeight < 0.9*scrollHeight){
		    	flag = 1;
	    	}
	    }
	});
});