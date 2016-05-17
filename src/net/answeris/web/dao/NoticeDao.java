package net.answeris.web.dao;

import java.util.List;

import net.answeris.web.model.Notice;

public interface NoticeDao {

   public List<Notice>get(String field, String query, int page);
   
   public List<Notice>get(int page);
   
   public List<Notice>get();
   
   public List<Notice>getPageCount(int page);
   
   public List<Notice>get(String code);
   
   public List<Notice>next(String code);
   
   public List<Notice>previous(String code);
   
   public List<Notice>add(Notice notice);
   
   public List<Notice>update(Notice notice);
   

   
}