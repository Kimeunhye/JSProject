package net.answeris.web.model;

import java.util.Date;

public class Notice {

   private String code;
   private String title;
   private String content;
   private Date regdate;
   private String writer;
   private int hit;
   private String writerName;
   private int cmtCnt;
   
   public String getWriterName() {
      return writerName;
   }
   public void setWriterName(String writerName) {
      this.writerName = writerName;
   }
   public int getCmtCnt() {
      return cmtCnt;
   }
   public void setCmtCnt(int cmtCnt) {
      this.cmtCnt = cmtCnt;
   }
   public String getCode() {
      return code;
   }
   public void setCode(String code) {
      this.code = code;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public Date getRegdate() {
      return regdate;
   }
   public void setRegdate(Date regdate) {
      this.regdate = regdate;
   }
   public String getWriter() {
      return writer;
   }
   public void setWriter(String writer) {
      this.writer = writer;
   }
   public int getHit() {
      return hit;
   }
   public void setHit(int hit) {
      this.hit = hit;
   }
}