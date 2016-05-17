package net.answeris.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import net.answeris.web.model.Notice;

public class jdbcNoticeDao implements NoticeDao{
   

   @Override
   public List<Notice> get(String field, String query, int page) {
      
      
      int pageSize=10;
      int start=(page-1)*pageSize+1;
      int end=page*pageSize;
   
      
      
      
      String url="jdbc:oracle:thin:@211.238.142.251:1521:orcl";
      String sql=/*"SELECT *FROM(SELECT *FROM NOTICE ORDER BY REGDATE DESC) WHERE ROWNUM BETWEEN 1 AND 10";*/
            "SELECT * FROM NOTICE_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
   
      
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(url, "c##sist","dclass");
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,"%"+query+"%" );
            st.setInt(2, start);
            st.setInt(3, end);
            ResultSet rs=st.executeQuery();
            
            List list=new ArrayList();
            
            while(rs.next()){
               Notice notice=new Notice();
               notice.setCode(rs.getString("CODE"));
               notice.setTitle(rs.getString("TITLE"));
               notice.setContent(rs.getString("CONTENT"));
               notice.setWriter(rs.getString("WRITER"));
               notice.setRegdate(rs.getDate("REGDATE"));
               notice.setHit(rs.getInt("HIT"));
               notice.setWriterName(rs.getString("WRITER_NAME"));
               notice.setCmtCnt(rs.getInt("CMT_CNT"));
                 list.add(notice);            
            } 
            rs.close();
            st.close();
            con.close();
            
            return list;
         } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         return null;
         
   }

   @Override
   public List<Notice> get(int page) {
   
         return get("TITLE","", page);
         
   }
   public List<Notice> getNotice() {
      
      return get(1);
      
   }
}