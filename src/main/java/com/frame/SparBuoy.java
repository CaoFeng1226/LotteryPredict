package com.frame;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.allpanel.Apanel;
import com.allpanel.Bpanel;
import com.allpanel.Cpanel;
import com.allpanel.Dpanel;
import com.allpanel.Epanel;
import com.allpanel.Fpanel;
import com.allpanel.Gpanel;

public class SparBuoy extends JDialog {// 号码走势对话框
	JTabbedPane tp = new JTabbedPane();// 创建选项卡面板
	public SparBuoy() {// 号码走势对话框的构造方法
		setTitle("号码走势");// 设置号码走势对话框的标题
		setResizable(false);// 不可改变号码走势对话框的大小
		setIconImage(Toolkit.getDefaultToolkit().getImage(SparBuoy.class.getResource("/imgs/log.png")));// 设置号码走势对话框的窗体图标
		// 把显示第一位~第七位开奖号码的走势面板添加到选项卡面板中
		tp.add("第一位",new Apanel());
		tp.add("第二位",new Bpanel());
		tp.add("第三位",new Cpanel());
		tp.add("第四位",new Dpanel());
		tp.add("第五位",new Epanel());
		tp.add("第六位",new Fpanel());
		tp.add("第七位",new Gpanel());
		this.getContentPane().add(tp);// 把选项卡面板添加到号码走势对话框的内容面板中
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 这是号码走势对话框的关闭方式
		this.setBounds(450, 100, 563, 593);// 设置号码走势对话框的位置和宽高
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");// 设置号码走势对话框的样式
		} catch (Throwable e) {
			e.printStackTrace();
		}
		new SparBuoy();// 创建号码走势对话框对象
	}

}
