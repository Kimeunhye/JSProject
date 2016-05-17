package net.answeris.web.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import net.answeris.web.dao.jdbcNoticeDao;
import net.answeris.web.dao.jdbcNoticeDao;
import net.answeris.web.model.Notice;


@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet{
      
   
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*String url="jdbc:oracle:thin:@211.238.142.251:1521:orcl";
      String sql="SELECT *FROM(SELECT *FROM NOTICE ORDER BY REGDATE DESC) WHERE ROWNUM BETWEEN 1 AND 10";
      List list=new ArrayList();
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con=DriverManager.getConnection(url, "c##sist","dclass");
         Statement st= con.createStatement();
         ResultSet rs=st.executeQuery(sql);
         
         while(rs.next()){
            Notice notice=new Notice();
            notice.setCode(rs.getString("CODE"));
            notice.setTitle(rs.getString("TITLE"));
            notice.setContent(rs.getString("CONTENT"));
            notice.setWriter(rs.getString("WRITER"));
            notice.setRegdate(rs.getDate("REGDATE"));
            notice.setHit(rs.getInt("HIT"));
              list.add(notice);            
         } 
         rs.close();
         st.close();
         con.close();*/
      
      
      
       String _page=request.getParameter("pg");
       String _field=request.getParameter("f");
       String _query=request.getParameter("q");
       
       int page=1;
       String field="TITLE";
       String query="";
       
       if(_page!=null && !(_page.equals(""))){
          page=Integer.parseInt(_page);
          
       }
      
       if(_field!=null && !(_field.equals(""))){
          field=_field;
          
       }
       if(_query!=null && !(_query.equals(""))){
          query=_query;
          
       }
      
          List<Notice> list=new jdbcNoticeDao().get(field,query,page);
      
          request.setAttribute("list", list);
         
         RequestDispatcher dispatcher= request.getRequestDispatcher("notice.jsp");
         dispatcher.forward(request, response);
      
   
   }
}