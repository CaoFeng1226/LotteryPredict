 package com.dao;
 
 import com.db.ConnMySQL;
 import com.model.History;
 import java.io.BufferedReader;
 import java.io.FileNotFoundException;
 import java.io.FileReader;
 import java.io.IOException;
 import java.io.PrintStream;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import javax.swing.JOptionPane;
 
 public class HistoryDao
 {
   public Boolean addHistoryDao(int number, String seven, String data)
   {
     History his = new History();
     char[] sevens = seven.toCharArray();
     his.setNumber(number);
 
     his.setA(Character.getNumericValue(sevens[0]));
     his.setB(Character.getNumericValue(sevens[1]));
     his.setC(Character.getNumericValue(sevens[2]));
     his.setD(Character.getNumericValue(sevens[3]));
     his.setE(Character.getNumericValue(sevens[4]));
     his.setF(Character.getNumericValue(sevens[5]));
     his.setG(Character.getNumericValue(sevens[6]));
     his.setHistorytime(data);
     ConnMySQL csql = new ConnMySQL();
     return csql.addHistory(his);
   }
 
   public int selectNumber() {
     int number = 10001;
     String sql = "select max(number) number from tb_history";
     ConnMySQL csql = new ConnMySQL();
     number = csql.selectNumber(sql);
     csql.closeConnection();
     return number + 1;
   }
 
   public Boolean updateNumber(int number, String seven, String data) {
     History his = new History();
     char[] sevens = seven.toCharArray();
     his.setNumber(number);
 
     his.setA(Character.getNumericValue(sevens[0]));
     his.setB(Character.getNumericValue(sevens[1]));
     his.setC(Character.getNumericValue(sevens[2]));
     his.setD(Character.getNumericValue(sevens[3]));
     his.setE(Character.getNumericValue(sevens[4]));
     his.setF(Character.getNumericValue(sevens[5]));
     his.setG(Character.getNumericValue(sevens[6]));
     his.setHistorytime(data);
     ConnMySQL csql = new ConnMySQL();
     return csql.updataNumber(his);
   }
 
   public boolean allAddNumber(String file) {
     LotteryValidate lv = new LotteryValidate();
     FileReader f = null;
     String str = "";
     try {
       f = new FileReader(file);
       BufferedReader rd = new BufferedReader(f);
       while ((str = rd.readLine()) != null) {
         String[] historys = str.split("/");
         ResultSet rs = null;
         if (historys.length != 3) {
           JOptionPane.showMessageDialog(null, "警告：文本格式不符合要求！", "警告", 2);
           return false;
         }
         int number = Integer.parseInt(historys[0]);
         String sql = "select * from tb_history where number=" + number;
         ConnMySQL con = new ConnMySQL();
         rs = con.showAll(sql);
         try {
           if (rs.next()) {
             JOptionPane.showMessageDialog(null, "警告：开奖信息已存在！", "警告", 2);
             try
             {
               if (f != null)
                 f.close();
             } catch (IOException e) {
               System.out.println("无此文件");
             }
             return false;
           }
         } catch (SQLException e) {
           e.printStackTrace();
 
           if ((LotteryValidate.validateNumber(historys[1]).booleanValue()) && (LotteryValidate.validateData(historys[2]).booleanValue()))
             addHistoryDao(number, historys[1], historys[2]);
         }
       }
     } catch (FileNotFoundException e) {
       System.out.println("无此文件");
       return false;
     } catch (IOException e) {
       System.out.println("提取文件错误");
       return false;
     } finally {
       try {
         if (f != null)
           f.close();
       } catch (IOException e) {
         System.out.println("无此文件");
       }
     }
     try
     {
       if (f != null)
         f.close();
     } catch (IOException e) {
       System.out.println("无此文件");
     }
 
     return true;
   }
 
   public History getOneHistory(int number) {
     String sql = "select * from tb_history where number=" + number;
     ConnMySQL con = new ConnMySQL();
     ResultSet rs = con.showAll(sql);
     History his = new History();
     try {
       while (rs.next()) {
         System.out.println(rs.getString(1));
         his.setId(rs.getInt("id"));
         his.setNumber(rs.getInt("number"));
 
         his.setA(rs.getInt("a"));
         his.setB(rs.getInt("b"));
         his.setC(rs.getInt("c"));
         his.setD(rs.getInt("d"));
         his.setE(rs.getInt("e"));
         his.setF(rs.getInt("f"));
         his.setG(rs.getInt("g"));
         his.setHistorytime(rs.getString("historytime"));
       }
     } catch (SQLException e) {
       e.printStackTrace();
     } finally {
       con.closeConnection();
     }
     return his;
   }
 }

