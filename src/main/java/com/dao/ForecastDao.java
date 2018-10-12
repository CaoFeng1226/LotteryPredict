/*    */ package com.dao;
/*    */ 
/*    */ import com.db.ConnMySQL;
/*    */ import com.model.Forecast;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class ForecastDao
/*    */ {
/*    */   public Boolean addForecastDao(int number, String seven)
/*    */   {
/* 14 */     Forecast fr = new Forecast();
/* 15 */     char[] sevens = seven.toCharArray();
/* 16 */     fr.setNumber(number);
/*    */ 
/* 18 */     fr.setA(Character.getNumericValue(sevens[0]));
/* 19 */     fr.setB(Character.getNumericValue(sevens[1]));
/* 20 */     fr.setC(Character.getNumericValue(sevens[2]));
/* 21 */     fr.setD(Character.getNumericValue(sevens[3]));
/* 22 */     fr.setE(Character.getNumericValue(sevens[4]));
/* 23 */     fr.setF(Character.getNumericValue(sevens[5]));
/* 24 */     fr.setG(Character.getNumericValue(sevens[6]));
/* 25 */     Date date = new Date();
/* 26 */     SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
/* 27 */     String data = sf.format(date);
/* 28 */     fr.setForecasttime(data);
/* 29 */     ConnMySQL csql = new ConnMySQL();
/* 30 */     return csql.addForecast(fr);
/*    */   }
/*    */ 
/*    */   public void awardEvaluate(int number) throws SQLException {
/* 34 */     ConnMySQL con = new ConnMySQL();
/* 35 */     String sql = "select * from tb_history where number=" + number;
/* 36 */     ResultSet rs1 = con.showAll(sql);
/* 37 */     int[] s1 = null;
/* 38 */     int i = 0;
/* 39 */     if (rs1 != null) {
/* 40 */       while (rs1.next())
/* 41 */         s1 = new int[] { rs1.getInt("a"), rs1.getInt("b"), rs1.getInt("c"), rs1.getInt("d"), rs1.getInt("e"), 
/* 42 */           rs1.getInt("f"), rs1.getInt("g") };
/*    */     }
/* 44 */     sql = "select * from tb_forecast where number=" + number;
/* 45 */     ResultSet rs2 = con.showAll(sql);
/* 46 */     int[] s2 = null;
/* 47 */     if (rs2 != null) {
/* 48 */       while (rs2.next()) {
/* 49 */         s2 = new int[] { rs2.getInt("a"), rs2.getInt("b"), rs2.getInt("c"), rs2.getInt("d"), rs2.getInt("e"), 
/* 50 */           rs2.getInt("f"), rs2.getInt("g") };
/* 51 */         LotteryValidate lv = new LotteryValidate();
/* 52 */         i = lv.computeBonus(s1, s2);
/* 53 */         int id = rs2.getInt("id");
/* 54 */         int money = 0;
/* 55 */         switch (i) {
/*    */         case 6:
/* 57 */           money = 5;
/* 58 */           break;
/*    */         case 5:
/* 60 */           money = 20;
/* 61 */           break;
/*    */         case 4:
/* 63 */           money = 300;
/* 64 */           break;
/*    */         case 3:
/* 66 */           money = 1800;
/* 67 */           break;
/*    */         case 2:
/* 69 */           money = 50000;
/* 70 */           break;
/*    */         case 1:
/* 72 */           money = 5000000;
/*    */         }
/*    */ 
/* 75 */         con.updataMoney(id, money);
/*    */       }
/*    */     }
/* 78 */     con.closeConnection();
/*    */   }
/*    */ }

/* Location:           C:\Develop_file\Java Decompiler\mrcpdao\
 * Qualified Name:     com.dao.ForecastDao
 * JD-Core Version:    0.6.0
 */