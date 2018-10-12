/*    */ package com.allchart;
/*    */ 
/*    */ import com.db.ConnMySQL;
/*    */ import com.frame.SparBuoy;
/*    */ import com.model.History;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Font;
/*    */ import java.awt.Toolkit;
/*    */ import java.util.List;
/*    */ import javax.swing.JFrame;
/*    */ import org.jfree.chart.ChartFactory;
/*    */ import org.jfree.chart.ChartPanel;
/*    */ import org.jfree.chart.JFreeChart;
/*    */ import org.jfree.chart.axis.CategoryAxis;
/*    */ import org.jfree.chart.axis.ValueAxis;
/*    */ import org.jfree.chart.labels.ItemLabelAnchor;
/*    */ import org.jfree.chart.labels.ItemLabelPosition;
/*    */ import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
/*    */ import org.jfree.chart.plot.CategoryPlot;
/*    */ import org.jfree.chart.plot.PlotOrientation;
/*    */ import org.jfree.chart.renderer.category.LineAndShapeRenderer;
/*    */ import org.jfree.chart.title.LegendTitle;
/*    */ import org.jfree.chart.title.TextTitle;
/*    */ import org.jfree.data.category.DefaultCategoryDataset;
/*    */ import org.jfree.ui.TextAnchor;
/*    */ 
/*    */ public class ELineChart extends JFrame
/*    */ {
/*    */   public ELineChart(String applicationTitle, String chartTitle)
/*    */   {
/* 36 */     super(applicationTitle);
/* 37 */     setResizable(false);
/* 38 */     setIconImage(Toolkit.getDefaultToolkit().getImage(SparBuoy.class.getResource("/imgs/log.png")));
/* 39 */     JFreeChart lineChart = ChartFactory.createLineChart(
/* 40 */       chartTitle, 
/* 41 */       "开奖期数", 
/* 42 */       "第五位开奖号码", 
/* 43 */       createDataset(), 
/* 44 */       PlotOrientation.VERTICAL, 
/* 45 */       true, 
/* 46 */       true, 
/* 47 */       false);
/* 48 */     ChartPanel chartPanel = new ChartPanel(lineChart);
/* 49 */     chartPanel.setPreferredSize(new Dimension(850, 300));
/* 50 */     setContentPane(chartPanel);
/*    */ 
/* 52 */     TextTitle textTitle = lineChart.getTitle();
/* 53 */     textTitle.setFont(new Font("黑体", 0, 20));
/*    */ 
/* 55 */     LegendTitle legendTitle = lineChart.getLegend();
/* 56 */     if (legendTitle != null) {
/* 57 */       legendTitle.setItemFont(new Font("黑体", 0, 12));
/*    */     }
/*    */ 
/* 60 */     CategoryPlot plot = (CategoryPlot)lineChart.getPlot();
/*    */ 
/* 62 */     CategoryAxis xAxis = plot.getDomainAxis();
/* 63 */     xAxis.setLabelFont(new Font("黑体", 0, 12));
/* 64 */     xAxis.setTickLabelFont(new Font("黑体", 0, 12));
/*    */ 
/* 66 */     ValueAxis yAxis = plot.getRangeAxis();
/* 67 */     yAxis.setLabelFont(new Font("黑体", 0, 12));
/* 68 */     yAxis.setTickLabelFont(new Font("黑体", 0, 12));
/*    */ 
/* 70 */     LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();
/* 71 */     renderer.setBaseShapesVisible(true);
/* 72 */     renderer.setBaseShapesFilled(true);
/* 73 */     renderer.setBaseItemLabelsVisible(true);
/* 74 */     renderer.setBasePositiveItemLabelPosition(
/* 75 */       new ItemLabelPosition(ItemLabelAnchor.OUTSIDE2, TextAnchor.BASELINE_CENTER));
/* 76 */     renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
/* 77 */     renderer.setBaseItemLabelFont(new Font("黑体", 0, 12));
/*    */ 
/* 79 */     setDefaultCloseOperation(2);
/*    */   }
/*    */ 
/*    */   private DefaultCategoryDataset createDataset() {
/* 83 */     ConnMySQL con = new ConnMySQL();
/* 84 */     List list = ConnMySQL.getFirstTenData();
/* 85 */     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/*    */ 
/* 87 */     dataset.addValue(((History)list.get(0)).getE(), "第五位开奖号码走势线", "第" + ((History)list.get(0)).getNumber() + "期");
/* 88 */     dataset.addValue(((History)list.get(1)).getE(), "第五位开奖号码走势线", "第" + ((History)list.get(1)).getNumber() + "期");
/* 89 */     dataset.addValue(((History)list.get(2)).getE(), "第五位开奖号码走势线", "第" + ((History)list.get(2)).getNumber() + "期");
/* 90 */     dataset.addValue(((History)list.get(3)).getE(), "第五位开奖号码走势线", "第" + ((History)list.get(3)).getNumber() + "期");
/* 91 */     dataset.addValue(((History)list.get(4)).getE(), "第五位开奖号码走势线", "第" + ((History)list.get(4)).getNumber() + "期");
/* 92 */     dataset.addValue(((History)list.get(5)).getE(), "第五位开奖号码走势线", "第" + ((History)list.get(5)).getNumber() + "期");
/* 93 */     dataset.addValue(((History)list.get(6)).getE(), "第五位开奖号码走势线", "第" + ((History)list.get(6)).getNumber() + "期");
/* 94 */     dataset.addValue(((History)list.get(7)).getE(), "第五位开奖号码走势线", "第" + ((History)list.get(7)).getNumber() + "期");
/* 95 */     dataset.addValue(((History)list.get(8)).getE(), "第五位开奖号码走势线", "第" + ((History)list.get(8)).getNumber() + "期");
/* 96 */     dataset.addValue(((History)list.get(9)).getE(), "第五位开奖号码走势线", "第" + ((History)list.get(9)).getNumber() + "期");
/* 97 */     return dataset;
/*    */   }
/*    */ }

/* Location:           C:\Develop_file\Java Decompiler\linechartgraph\
 * Qualified Name:     com.allchart.ELineChart
 * JD-Core Version:    0.6.0
 */