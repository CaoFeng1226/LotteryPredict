 package com.allchart;
 
 import com.db.ConnMySQL;
 import com.frame.SparBuoy;
 import com.model.History;
 import java.awt.Dimension;
 import java.awt.Font;
 import java.awt.Toolkit;
 import java.util.List;
 import javax.swing.JFrame;
 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.chart.axis.CategoryAxis;
 import org.jfree.chart.axis.ValueAxis;
 import org.jfree.chart.labels.ItemLabelAnchor;
 import org.jfree.chart.labels.ItemLabelPosition;
 import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
 import org.jfree.chart.plot.CategoryPlot;
 import org.jfree.chart.plot.PlotOrientation;
 import org.jfree.chart.renderer.category.LineAndShapeRenderer;
 import org.jfree.chart.title.LegendTitle;
 import org.jfree.chart.title.TextTitle;
 import org.jfree.data.category.DefaultCategoryDataset;
 import org.jfree.ui.TextAnchor;
 
 public class FLineChart extends JFrame
 {
   public FLineChart(String applicationTitle, String chartTitle)
   {
     super(applicationTitle);
     setResizable(false);
     setIconImage(Toolkit.getDefaultToolkit().getImage(SparBuoy.class.getResource("/imgs/log.png")));
     JFreeChart lineChart = ChartFactory.createLineChart(
       chartTitle, 
       "开奖期数", 
       "第六位开奖号码", 
       createDataset(), 
       PlotOrientation.VERTICAL, 
       true, 
       true, 
       false);
     ChartPanel chartPanel = new ChartPanel(lineChart);
     chartPanel.setPreferredSize(new Dimension(850, 300));
     setContentPane(chartPanel);
 
     TextTitle textTitle = lineChart.getTitle();
     textTitle.setFont(new Font("黑体", 0, 20));
 
     LegendTitle legendTitle = lineChart.getLegend();
     if (legendTitle != null) {
       legendTitle.setItemFont(new Font("黑体", 0, 12));
     }
 
     CategoryPlot plot = (CategoryPlot)lineChart.getPlot();
 
     CategoryAxis xAxis = plot.getDomainAxis();
     xAxis.setLabelFont(new Font("黑体", 0, 12));
     xAxis.setTickLabelFont(new Font("黑体", 0, 12));
 
     ValueAxis yAxis = plot.getRangeAxis();
     yAxis.setLabelFont(new Font("黑体", 0, 12));
     yAxis.setTickLabelFont(new Font("黑体", 0, 12));
 
     LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();
     renderer.setBaseShapesVisible(true);
     renderer.setBaseShapesFilled(true);
     renderer.setBaseItemLabelsVisible(true);
     renderer.setBasePositiveItemLabelPosition(
       new ItemLabelPosition(ItemLabelAnchor.OUTSIDE2, TextAnchor.BASELINE_CENTER));
     renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
     renderer.setBaseItemLabelFont(new Font("黑体", 0, 12));
 
     setDefaultCloseOperation(2);
   }
 
   private DefaultCategoryDataset createDataset() {
     ConnMySQL con = new ConnMySQL();
     List list = ConnMySQL.getFirstTenData();
     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
 
     dataset.addValue(((History)list.get(0)).getF(), "第六位开奖号码走势线", "第" + ((History)list.get(0)).getNumber() + "期");
     dataset.addValue(((History)list.get(1)).getF(), "第六位开奖号码走势线", "第" + ((History)list.get(1)).getNumber() + "期");
     dataset.addValue(((History)list.get(2)).getF(), "第六位开奖号码走势线", "第" + ((History)list.get(2)).getNumber() + "期");
     dataset.addValue(((History)list.get(3)).getF(), "第六位开奖号码走势线", "第" + ((History)list.get(3)).getNumber() + "期");
     dataset.addValue(((History)list.get(4)).getF(), "第六位开奖号码走势线", "第" + ((History)list.get(4)).getNumber() + "期");
     dataset.addValue(((History)list.get(5)).getF(), "第六位开奖号码走势线", "第" + ((History)list.get(5)).getNumber() + "期");
     dataset.addValue(((History)list.get(6)).getF(), "第六位开奖号码走势线", "第" + ((History)list.get(6)).getNumber() + "期");
     dataset.addValue(((History)list.get(7)).getF(), "第六位开奖号码走势线", "第" + ((History)list.get(7)).getNumber() + "期");
     dataset.addValue(((History)list.get(8)).getF(), "第六位开奖号码走势线", "第" + ((History)list.get(8)).getNumber() + "期");
     dataset.addValue(((History)list.get(9)).getF(), "第六位开奖号码走势线", "第" + ((History)list.get(9)).getNumber() + "期");
     return dataset;
   }
 }




