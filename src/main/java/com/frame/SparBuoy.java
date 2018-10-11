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

public class SparBuoy extends JDialog {// �������ƶԻ���
	JTabbedPane tp = new JTabbedPane();// ����ѡ����
	public SparBuoy() {// �������ƶԻ���Ĺ��췽��
		setTitle("��������");// ���ú������ƶԻ���ı���
		setResizable(false);// ���ɸı�������ƶԻ���Ĵ�С
		setIconImage(Toolkit.getDefaultToolkit().getImage(SparBuoy.class.getResource("/imgs/log.png")));// ���ú������ƶԻ���Ĵ���ͼ��
		// ����ʾ��һλ~����λ������������������ӵ�ѡ������
		tp.add("��һλ",new Apanel());
		tp.add("�ڶ�λ",new Bpanel());
		tp.add("����λ",new Cpanel());
		tp.add("����λ",new Dpanel());
		tp.add("����λ",new Epanel());
		tp.add("����λ",new Fpanel());
		tp.add("����λ",new Gpanel());
		this.getContentPane().add(tp);// ��ѡ������ӵ��������ƶԻ�������������
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���Ǻ������ƶԻ���Ĺرշ�ʽ
		this.setBounds(450, 100, 563, 593);// ���ú������ƶԻ����λ�úͿ��
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");// ���ú������ƶԻ������ʽ
		} catch (Throwable e) {
			e.printStackTrace();
		}
		new SparBuoy();// �����������ƶԻ������
	}

}
