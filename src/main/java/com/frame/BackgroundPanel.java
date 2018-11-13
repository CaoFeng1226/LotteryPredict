 package com.frame;
 
 import java.awt.Graphics;
 import java.awt.Image;
 import javax.swing.JPanel;
 
 public class BackgroundPanel extends JPanel
 {
   private Image image;
 
   public BackgroundPanel()
   {
     setOpaque(false);
     setLayout(null);
   }
 
   public void setImage(Image image) {
     this.image = image;
   }
 
   protected void paintComponent(Graphics g)
   {
     if (this.image != null) {
       int width = getWidth();
       int height = getHeight();
       g.drawImage(this.image, 0, 0, width, height, this);
     }
     super.paintComponent(g);
   }
 }




