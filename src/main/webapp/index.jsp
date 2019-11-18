<%@ page import="sprint.digital.postgrest.ConnectionTest" %>
<%
String results = "";
try{
	results = new ConnectionTest().fetchResults("pgres");
}catch(Exception ex){
	out.println("<br><font color=red>" + ex.getMessage() + "</font><br>");
}

%>
<html>
<head>
<meta content="en-us" http-equiv="Content-Language">
<title>PostGrest Connection Test</title>
</head>
<body>
<div align="center">
<table style="width: 600px">
	<tr>
		<td>
		<div align="center">
		<h2>PostGrest Connection Test</h2>
		</div>
		</td>
	</tr>
	<tr>
		<td><em>Query: select loc_type_nme,lat_long_nbr,enb_id from loc limit 5</em></td>
	</tr>
	<tr>
		<td>
		<table style="width: 100%">
			<tr>
				<td style="width:200pt"><strong>loc_type_nme</strong></td>
				<td style="width:200pt"><strong>lat_long_nbr</strong></td>
				<td style="width:200pt"><strong>enb_id</strong></td>
			</tr>
			<%= results %>
		</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>
