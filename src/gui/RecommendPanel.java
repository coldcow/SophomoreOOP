package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import layout.ModifiedFlowLayout;
import mng.Factory;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;

import bgc.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class RecommendPanel extends JPanel {
	String username = Cafe.user.identifier;
	
	public RecommendPanel() {
		setLayout(null);
		setBackground(Color.WHITE);
		
		JLabel label = new JLabel(username + "님의 데이터 기반 추천 목록입니다.");
		label.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(12, 770, 1176, 30);
		add(label);

		JPanel panel = new JPanel();
		panel.setBounds(606, 28, 582, 45);
		panel.setBackground(Main.THEMECOLOR);
		JLabel drink = new JLabel("음료");
		drink.setForeground(Color.WHITE);
		drink.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));
		panel.add(drink);
		add(panel);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(150);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(606, 110, 582, 660);
		add(panel_1);

		JPanel panel_7 = new JPanel();
		JLabel drink1 = new JLabel("1.");
		drink1.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		panel_7.add(drink1);
		JLabel drink1_img = new JLabel();
		drink1_img.setSize(230,230);
		// drink1 이미지 추가
		panel_7.add(drink1_img);
		panel_7.setBackground(Color.WHITE);
		panel_1.add(panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_1.add(panel_8);

		JLabel drink2 = new JLabel("2.");
		drink2.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		panel_8.add(drink2);

		JLabel drink2_img = new JLabel();
		drink2_img.setSize(230,230);
		// drink2 이미지 추가
		panel_8.add(drink2_img);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_1.add(panel_9);

		JLabel drink3 = new JLabel("3.");
		drink3.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		panel_9.add(drink3);

		JLabel drink3_img = new JLabel();
		drink3_img.setSize(230,230);
		// drink3 이미지 추가
		panel_9.add(drink3_img);

		JPanel panel_1_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1_1.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(150);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(12, 110, 582, 660);
		add(panel_1_1);

		JPanel panel_6 = new JPanel();
		JLabel board1 = new JLabel("1.");
		board1.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		panel_6.add(board1);
		JLabel board1_img = new JLabel();
		board1_img.setSize(230,230);
		// board1 이미지 추가
		panel_6.add(board1_img);
		panel_6.setBackground(Color.WHITE);
		panel_1_1.add(panel_6);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_1_1.add(panel_10);

		JLabel board2 = new JLabel("2.");
		board2.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		panel_10.add(board2);

		JLabel board2_img = new JLabel();
		board2_img.setSize(230,230);
		// board2 이미지 추가
		panel_10.add(board2_img);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_1_1.add(panel_11);

		JLabel board3 = new JLabel("3.");
		board3.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		panel_11.add(board3);

		JLabel board3_img = new JLabel();
		board3_img.setSize(230,230);
		// board3 이미지 추가
		panel_11.add(board3_img);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 28, 582, 45);
		panel_2.setBackground(Main.THEMECOLOR);
		JLabel board = new JLabel("보드게임");
		board.setForeground(Color.WHITE);
		board.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));
		panel_2.add(board);
		add(panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(599, 5, 2, 95);
		add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Main.THEMECOLOR);
		panel_5.setBounds(599, 110, 2, 660);
		add(panel_5);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 1200, 107);
		panel_3.setBackground(Main.THEMECOLOR);
		add(panel_3);

	}
}
