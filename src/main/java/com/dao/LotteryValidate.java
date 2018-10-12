/*    */ package com.dao;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class LotteryValidate
/*    */ {
/*    */   public int computeBonus(int[] s1, int[] s2)
/*    */   {
/* 10 */     String s = "";
/* 11 */     for (int i = 0; i < s1.length; i++) {
/* 12 */       if (s1[i] == s2[i]) {
/* 13 */         s = s + i;
/*    */       }
/*    */     }
/* 16 */     int count = 0;
/*    */ 
/* 18 */     if ((s.indexOf("01") != -1) || (s.indexOf("12") != -1) || (s.indexOf("23") != -1) || (s.indexOf("34") != -1) || 
/* 19 */       (s.indexOf("45") != -1) || (s.indexOf("56") != -1)) {
/* 20 */       count = 6;
/*    */     }
/*    */ 
/* 23 */     if ((s.indexOf("012") != -1) || (s.indexOf("123") != -1) || (s.indexOf("234") != -1) || (s.indexOf("345") != -1) || 
/* 24 */       (s.indexOf("456") != -1)) {
/* 25 */       count = 5;
/*    */     }
/*    */ 
/* 28 */     if ((s.indexOf("0123") != -1) || (s.indexOf("1234") != -1) || (s.indexOf("2345") > 0) || 
/* 29 */       (s.indexOf("3456") != -1)) {
/* 30 */       count = 4;
/*    */     }
/*    */ 
/* 33 */     if ((s.indexOf("01234") != -1) || (s.indexOf("12345") != -1) || (s.indexOf("23456") != -1)) {
/* 34 */       count = 3;
/*    */     }
/*    */ 
/* 37 */     if ((s.indexOf("012345") != -1) || (s.indexOf("123456") != -1)) {
/* 38 */       count = 2;
/*    */     }
/*    */ 
/* 41 */     if (s.indexOf("0123456") == 0) {
/* 42 */       count = 1;
/*    */     }
/* 44 */     return count;
/*    */   }
/*    */ 
/*    */   public static Boolean validateNumber(String seven) {
/* 48 */     if (seven.length() != 7) {
/* 49 */       System.out.println("号码长度不对");
/* 50 */       return Boolean.valueOf(false);
/*    */     }
/*    */     try {
/* 53 */       Integer.parseInt(seven);
/*    */     } catch (Exception e) {
/* 55 */       System.out.println("no");
/* 56 */       return Boolean.valueOf(false);
/*    */     }
/* 58 */     return Boolean.valueOf(true);
/*    */   }
/*    */ 
/*    */   public static Boolean validateData(String data)
/*    */   {
/* 69 */     String regex = "^(19||20)\\d{2}-(0?\\d||1[012])-(0?\\d||[12]\\d||3[01])$";
/* 70 */     if (data.matches(regex)) {
/* 71 */       return Boolean.valueOf(true);
/*    */     }
/* 73 */     return Boolean.valueOf(false);
/*    */   }
/*    */ }

/* Location:           C:\Develop_file\Java Decompiler\mrcpdao\
 * Qualified Name:     com.dao.LotteryValidate
 * JD-Core Version:    0.6.0
 */