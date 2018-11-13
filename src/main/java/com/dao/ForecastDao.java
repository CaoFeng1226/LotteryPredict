 package com.dao;
 
 import com.db.ConnMySQL;
 import com.model.Forecast;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 
 public class ForecastDao
 {
   public Boolean addForecastDao(int number, String seven)
   {
     Forecast fr = new Forecast();
     char[] sevens = seven.toCharArray();
     fr.setNumber(number);
 
     fr.setA(Character.getNumericValue(sevens[0]));
     fr.setB(Character.getNumericValue(sevens[1]));
     fr.setC(Character.getNumericValue(sevens[2]));
     fr.setD(Character.getNumericValue(sevens[3]));
     fr.setE(Character.getNumericValue(sevens[4]));
     fr.setF(Character.getNumericValue(sevens[5]));
     fr.setG(Character.getNumericValue(sevens[6]));
     Date date = new Date();
     SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
     String data = sf.format(date);
     fr.setForecasttime(data);
     ConnMySQL csql = new ConnMySQL();
     return csql.addForecast(fr);
   }
 
   public void awardEvaluate(int number) throws SQLException {
     ConnMySQL con = new ConnMySQL();
     String sql = "select * from tb_history where number=" + number;
     ResultSet rs1 = con.showAll(sql);
     int[] s1 = null;
     int i = 0;
     if (rs1 != null) {
       while (rs1.next())
         s1 = new int[] { rs1.getInt("a"), rs1.getInt("b"), rs1.getInt("c"), rs1.getInt("d"), rs1.getInt("e"), 
           rs1.getInt("f"), rs1.getInt("g") };
     }
     sql = "select * from tb_forecast where number=" + number;
     ResultSet rs2 = con.showAll(sql);
     int[] s2 = null;
     if (rs2 != null) {
       while (rs2.next()) {
         s2 = new int[] { rs2.getInt("a"), rs2.getInt("b"), rs2.getInt("c"), rs2.getInt("d"), rs2.getInt("e"), 
           rs2.getInt("f"), rs2.getInt("g") };
         LotteryValidate lv = new LotteryValidate();
         i = lv.computeBonus(s1, s2);
         int id = rs2.getInt("id");
         int money = 0;
         switch (i) {
         case 6:
           money = 5;
           break;
         case 5:
           money = 20;
           break;
         case 4:
           money = 300;
           break;
         case 3:
           money = 1800;
           break;
         case 2:
           money = 50000;
           break;
         case 1:
           money = 5000000;
         }
 
         con.updataMoney(id, money);
       }
     }
     con.closeConnection();
   }
 }

