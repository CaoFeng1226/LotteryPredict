/*    */ package com.frame;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class BackgroundPanel extends JPanel
/*    */ {
/*    */   private Image image;
/*    */ 
/*    */   public BackgroundPanel()
/*    */   {
/* 14 */     setOpaque(false);
/* 15 */     setLayout(null);
/*    */   }
/*    */ 
/*    */   public void setImage(Image image) {
/* 19 */     this.image = image;
/*    */   }
/*    */ 
/*    */   protected void paintComponent(Graphics g)
/*    */   {
/* 24 */     if (this.image != null) {
/* 25 */       int width = getWidth();
/* 26 */       int height = getHeight();
/* 27 */       g.drawImage(this.image, 0, 0, width, height, this);
/*    */     }
/* 29 */     super.paintComponent(g);
/*    */   }
/*    */ }

/* Location:           C:\Develop_file\Java Decompiler\BackgroundImage\
 * Qualified Name:     com.frame.BackgroundPanel
 * JD-Core Version:    0.6.0
 */