 package com.dao;
 
 //import java.io.PrintStream;
 
 public class LotteryValidate
 {
   public int computeBonus(int[] s1, int[] s2)
   {
     String s = "";
     for (int i = 0; i < s1.length; i++) {
       if (s1[i] == s2[i]) {
         s = s + i;
       }
     }
     int count = 0;
 
     if ((s.indexOf("01") != -1) || (s.indexOf("12") != -1) || (s.indexOf("23") != -1) || (s.indexOf("34") != -1) || 
       (s.indexOf("45") != -1) || (s.indexOf("56") != -1)) {
       count = 6;
     }
 
     if ((s.indexOf("012") != -1) || (s.indexOf("123") != -1) || (s.indexOf("234") != -1) || (s.indexOf("345") != -1) || 
       (s.indexOf("456") != -1)) {
       count = 5;
     }
 
     if ((s.indexOf("0123") != -1) || (s.indexOf("1234") != -1) || (s.indexOf("2345") > 0) || 
       (s.indexOf("3456") != -1)) {
       count = 4;
     }
 
     if ((s.indexOf("01234") != -1) || (s.indexOf("12345") != -1) || (s.indexOf("23456") != -1)) {
       count = 3;
     }
 
     if ((s.indexOf("012345") != -1) || (s.indexOf("123456") != -1)) {
       count = 2;
     }
 
     if (s.indexOf("0123456") == 0) {
       count = 1;
     }
     return count;
   }
 
   public static Boolean validateNumber(String seven) {
     if (seven.length() != 7) {
       System.out.println("号码长度不对");
       return Boolean.valueOf(false);
     }
     try {
       Integer.parseInt(seven);
     } catch (Exception e) {
       System.out.println("no");
       return Boolean.valueOf(false);
     }
     return Boolean.valueOf(true);
   }
 
   public static Boolean validateData(String data)
   {
     String regex = "^(19||20)\\d{2}-(0?\\d||1[012])-(0?\\d||[12]\\d||3[01])$";
     if (data.matches(regex)) {
       return Boolean.valueOf(true);
     }
     return Boolean.valueOf(false);
   }
 }

