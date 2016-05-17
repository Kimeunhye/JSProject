<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%

		String code = "";
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = "newlec";
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");


		/* -------------------------게시글 등록-------------*/
		String sql = "UPDATE INTO NOTICE SET TITLE =?, CONTENT=? WHERE CODE=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, title);
		pst.setString(2, content);
		pst.setString(3, code);

		pst.executeUpdate();

		con.commit();

		response.sendRedirect("notice-detail.jsp?c="+code);

%>