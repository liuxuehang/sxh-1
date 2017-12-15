<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% int month=0;%>
<script>
	function doMouth(){
		var m = document.getElementById("mouth");
		m.value = "5";
	}
</script>
</head>
<body>
  
  <%
   String[] days = new String[42];
   for (int i = 0; i < 42; i++) {
    	days[i]="";
   }
  %>
 <%--  <%
    Scanner s = new Scanner(System.in);
   	System.out.println("请输入你要查询的月份：");
   	int a = s.nextInt();
   	int b = a-1;
   	month=b;
  %> --%>
  2017年<input type="text" id="mouth" value="" >月25日
  <%
   int today = 25;
   int year = 2017;
   
   out.println(year + "年" + (month+1) + "月" + today + "日");
   
   Calendar thisMonth = Calendar.getInstance();
   thisMonth.set(Calendar.MONTH, month);
   thisMonth.set(Calendar.YEAR, year);
   thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
   thisMonth.set(Calendar.DAY_OF_MONTH, 1);
  
   int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
   int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
   for (int i = 0; i < maxIndex; i++) {
	   days[firstIndex + i] = String.valueOf(i + 1);
	   
   }
  %>
 
  
  <div style="border: 1px solid black; width: 230px; height: 230px; background-color: beige;">
	  <table border="0" width="168" height="81" style="text-align: center; border-collapse:separate; border-spacing:12px 10px;">
	   <tr>
	    <th>
	     <font color="red">日</font>
	    </th>
	    <th>一</th>
	    <th>二</th>
	    <th>三</th>
	    <th>四</th>
	    <th>五</th>
	    <th>
	     <font color="red">六</font>
	    </th>
	   </tr>
	   <%
	   for (int j = 0; j < 6; j++) {
		   %>
		   <tr>
		    <%
		    for (int i = j * 7; i < (j + 1) * 7; i++) {
			    %>
			    <td>
			     <%
			     if ((i - firstIndex + 1) == today) {
			     %>
			     <font color="red"><%=days[i]%> </font>
			     <%
			     } else {
			     %>
			     <%=days[i]%>
			     <%
			       }
		       }
	      }
	     %>
	    </td>
	   </tr>
	  </table>
  </div>
</body>
</html>