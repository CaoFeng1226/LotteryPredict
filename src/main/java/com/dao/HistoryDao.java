/*     */ package com.dao;
/*     */ 
/*     */ import com.db.ConnMySQL;
/*     */ import com.model.History;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ public class HistoryDao
/*     */ {
/*     */   public Boolean addHistoryDao(int number, String seven, String data)
/*     */   {
/*  17 */     History his = new History();
/*  18 */     char[] sevens = seven.toCharArray();
/*  19 */     his.setNumber(number);
/*     */ 
/*  21 */     his.setA(Character.getNumericValue(sevens[0]));
/*  22 */     his.setB(Character.getNumericValue(sevens[1]));
/*  23 */     his.setC(Character.getNumericValue(sevens[2]));
/*  24 */     his.setD(Character.getNumericValue(sevens[3]));
/*  25 */     his.setE(Character.getNumericValue(sevens[4]));
/*  26 */     his.setF(Character.getNumericValue(sevens[5]));
/*  27 */     his.setG(Character.getNumericValue(sevens[6]));
/*  28 */     his.setHistorytime(data);
/*  29 */     ConnMySQL csql = new ConnMySQL();
/*  30 */     return csql.addHistory(his);
/*     */   }
/*     */ 
/*     */   public int selectNumber() {
/*  34 */     int number = 10001;
/*  35 */     String sql = "select max(number) number from tb_history";
/*  36 */     ConnMySQL csql = new ConnMySQL();
/*  37 */     number = csql.selectNumber(sql);
/*  38 */     csql.closeConnection();
/*  39 */     return number + 1;
/*     */   }
/*     */ 
/*     */   public Boolean updateNumber(int number, String seven, String data) {
/*  43 */     History his = new History();
/*  44 */     char[] sevens = seven.toCharArray();
/*  45 */     his.setNumber(number);
/*     */ 
/*  47 */     his.setA(Character.getNumericValue(sevens[0]));
/*  48 */     his.setB(Character.getNumericValue(sevens[1]));
/*  49 */     his.setC(Character.getNumericValue(sevens[2]));
/*  50 */     his.setD(Character.getNumericValue(sevens[3]));
/*  51 */     his.setE(Character.getNumericValue(sevens[4]));
/*  52 */     his.setF(Character.getNumericValue(sevens[5]));
/*  53 */     his.setG(Character.getNumericValue(sevens[6]));
/*  54 */     his.setHistorytime(data);
/*  55 */     ConnMySQL csql = new ConnMySQL();
/*  56 */     return csql.updataNumber(his);
/*     */   }
/*     */ 
/*     */   public boolean allAddNumber(String file) {
/*  60 */     LotteryValidate lv = new LotteryValidate();
/*  61 */     FileReader f = null;
/*  62 */     String str = "";
/*     */     try {
/*  64 */       f = new FileReader(file);
/*  65 */       BufferedReader rd = new BufferedReader(f);
/*  66 */       while ((str = rd.readLine()) != null) {
/*  67 */         String[] historys = str.split("/");
/*  68 */         ResultSet rs = null;
/*  69 */         if (historys.length != 3) {
/*  70 */           JOptionPane.showMessageDialog(null, "警告：文本格式不符合要求！", "警告", 2);
/*     */           return false;
/*     */         }
/*  73 */         int number = Integer.parseInt(historys[0]);
/*  74 */         String sql = "select * from tb_history where number=" + number;
/*  75 */         ConnMySQL con = new ConnMySQL();
/*  76 */         rs = con.showAll(sql);
/*     */         try {
/*  78 */           if (rs.next()) {
/*  79 */             JOptionPane.showMessageDialog(null, "警告：开奖信息已存在！", "警告", 2);
/*     */             try
/*     */             {
/*  97 */               if (f != null)
/*  98 */                 f.close();
/*     */             } catch (IOException e) {
/* 100 */               System.out.println("无此文件");
/*     */             }
/*  80 */             return false;
/*     */           }
/*     */         } catch (SQLException e) {
/*  83 */           e.printStackTrace();
/*     */ 
/*  85 */           if ((LotteryValidate.validateNumber(historys[1]).booleanValue()) && (LotteryValidate.validateData(historys[2]).booleanValue()))
/*  86 */             addHistoryDao(number, historys[1], historys[2]);
/*     */         }
/*     */       }
/*     */     } catch (FileNotFoundException e) {
/*  90 */       System.out.println("无此文件");
/*     */       return false;
/*     */     } catch (IOException e) {
/*  93 */       System.out.println("提取文件错误");
/*     */       return false;
/*     */     } finally {
/*     */       try {
/*  97 */         if (f != null)
/*  98 */           f.close();
/*     */       } catch (IOException e) {
/* 100 */         System.out.println("无此文件");
/*     */       }
/*     */     }
/*     */     try
/*     */     {
/*  97 */       if (f != null)
/*  98 */         f.close();
/*     */     } catch (IOException e) {
/* 100 */       System.out.println("无此文件");
/*     */     }
/*     */ 
/* 103 */     return true;
/*     */   }
/*     */ 
/*     */   public History getOneHistory(int number) {
/* 107 */     String sql = "select * from tb_history where number=" + number;
/* 108 */     ConnMySQL con = new ConnMySQL();
/* 109 */     ResultSet rs = con.showAll(sql);
/* 110 */     History his = new History();
/*     */     try {
/* 112 */       while (rs.next()) {
/* 113 */         System.out.println(rs.getString(1));
/* 114 */         his.setId(rs.getInt("id"));
/* 115 */         his.setNumber(rs.getInt("number"));
/*     */ 
/* 117 */         his.setA(rs.getInt("a"));
/* 118 */         his.setB(rs.getInt("b"));
/* 119 */         his.setC(rs.getInt("c"));
/* 120 */         his.setD(rs.getInt("d"));
/* 121 */         his.setE(rs.getInt("e"));
/* 122 */         his.setF(rs.getInt("f"));
/* 123 */         his.setG(rs.getInt("g"));
/* 124 */         his.setHistorytime(rs.getString("historytime"));
/*     */       }
/*     */     } catch (SQLException e) {
/* 127 */       e.printStackTrace();
/*     */     } finally {
/* 129 */       con.closeConnection();
/*     */     }
/* 131 */     return his;
/*     */   }
/*     */ }

/* Location:           C:\Develop_file\Java Decompiler\mrcpdao\
 * Qualified Name:     com.dao.HistoryDao
 * JD-Core Version:    0.6.0
 */