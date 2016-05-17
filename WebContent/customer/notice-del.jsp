<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
   String code = request.getParameter("c");
   String title = request.getParameter("title");
   String writer = "이정우";
   String content = request.getParameter("content");

   String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
   Class.forName("oracle.jdbc.driver.OracleDriver");

   Connection con = DriverManager.getConnection(url, "c##sist", "dclass");

   /* ---------------게시글 등록--------------- */
   String sql = "DELETE FROM NOTICE WHERE CODE="+code;
   Statement st = con.createStatement();
   

   st.executeUpdate(sql);

   response.sendRedirect("notice.jsp");
%>