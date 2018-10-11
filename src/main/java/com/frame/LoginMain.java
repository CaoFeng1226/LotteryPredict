package com.frame;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;

public class LoginMain extends JFrame {// ��¼����

	private JPanel contentPane;// �������

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// ���õ�¼������
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// ʵ������¼����
					LoginMain frame = new LoginMain();
					// ʹ��¼����ɼ�
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginMain() {// ��¼����Ĺ��췽��
		setTitle("���ղ�ƱԤ��ϵͳ");// ��¼����ı���
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginMain.class.getResource("/imgs/log.png")));// ��¼����ı���ͼ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �Ե�¼���巢��close��ʱ���˳�Ӧ�ó���
		setBounds(200, 100, 1100, 620);// ��¼�����λ�ü����
		
		contentPane = new JPanel();// �������
		setContentPane(contentPane);// �������������¼������
		contentPane.setLayout(new BorderLayout(0, 0));// �����������Ĳ���Ϊ�߽粼��
		
		JButton btnNewButton = new JButton("");// ʵ�������ı����ݵİ�ť
		btnNewButton.addActionListener(new ActionListener() {// Ϊ��ť��Ӷ����¼��ļ���
			public void actionPerformed(ActionEvent e) {// �����¼��ļ����ķ�����
				do_btnNewButton_actionPerformed(e);// ��ť���������¼��ļ���ʱִ�еķ���
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginMain.class.getResource("/imgs/login1.jpg")));// ���ð�ť��ͼ��
		contentPane.add(btnNewButton, BorderLayout.CENTER);// ��ť���������������м�
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {// ��ť���������¼��ļ���ʱִ�еķ���
		this.setVisible(false);// ��¼���岻�ɼ�
		MainFrame t=new MainFrame();// ����������
		t.setVisible(true);// ʹ������ɼ�
	}
}
