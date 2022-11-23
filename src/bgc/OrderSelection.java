package bgc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import mng.Factory;


public class OrderSelection extends JFrame{
	OrderSelection() {
		super("Order");
		JPanel pane = makeOrderPane();
		add(pane); // JFrame에 jp라는 패널 추가
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JPanel makeOrderPane() {
		// TODO Auto-generated method stub
				JPanel pane = new JPanel();

				JButton jbBoardGame = new JButton("보드게임 주문");
				jbBoardGame.addActionListener(event -> {
					orderEventHandler(event);			
				});
				pane.add(jbBoardGame); // pane이라는 패널에 jb라는 버튼 추가
				
				JButton jbDrink = new JButton("음료 주문");
				jbDrink.addActionListener(event -> {
					orderEventHandler(event);
				});
				pane.add(jbDrink); // pane이라는 패널에 jb라는 버튼 추가

				JButton jbEnd = new JButton("퇴실");	jbEnd.addActionListener(event -> {
					System.exit(0);
				});
				
				pane.add(jbEnd); // pane이라는 패널에 jb라는 버튼 추가

				FlowLayout fLay = new FlowLayout();
				pane.setLayout(fLay);

				setSize(800, 600); // 윈도우의 크기 가로x세로
				return pane;
	}

	private void orderEventHandler(ActionEvent event) {
		// TODO Auto-generated method stub
		String order = null;
		order = event.getActionCommand();
		
		if (order.equals("퇴실")) {
			new CheckOut();
			setVisible(false);
			setSize(0, 0);
			// System.exit(0);
		}
		
		if (order.equals("보드게임 주문")) {
			System.out.println("보드게임 주문창 실행");
			//new BoardGameTableSelection();
			setVisible(false);
		}
		
		if (order.equals("음료 주문")) {
			System.out.println("음료 주문창 실행");
			
		}	
	}
}
