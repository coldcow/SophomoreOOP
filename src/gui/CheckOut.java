package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CheckOut extends JFrame {
	CheckOut() {
		super("CheckOut");
		JPanel pane = makeCheckOutPane();
		add(pane); // JFrame에 jp라는 패널 추가
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JPanel makeCheckOutPane() {
		JPanel pane = new JPanel();

		JButton jbPayment = new JButton("결제");
		jbPayment.addActionListener(event -> {
			checkOutEventHandler(event);
		});
		pane.add(jbPayment); // pane이라는 패널에 jb라는 버튼 추가

		JButton jbPoint = new JButton("적립금 사용");
		jbPoint.addActionListener(event -> {
			checkOutEventHandler(event);
		});
		pane.add(jbPoint); // pane이라는 패널에 jb라는 버튼 추가

		JButton jbEnd = new JButton("퇴실");
		jbEnd.addActionListener(event -> {
			System.exit(0);
		});

		pane.add(jbEnd); // pane이라는 패널에 jb라는 버튼 추가

		FlowLayout fLay = new FlowLayout();
		pane.setLayout(fLay);

		setSize(800, 600); // 윈도우의 크기 가로x세로
		return pane;
	}

	private void checkOutEventHandler(ActionEvent event) {
		// TODO Auto-generated method stub
		String num = null;
		num = event.getActionCommand();
		JFrame jf = new JFrame();
		jf.setLocation(700, 400);
		jf.setSize(380, 180);

		if (num.equals("end")) {
			System.exit(0);
		}

		if (num.equals("결제")) {
			// if(Cafe.RoomManager.find(num).availability == 1) {
			JLabel label = new JLabel("결제 버튼입니다.");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			jf.add(label);
			jf.setVisible(true);
			return;
			// }
		}
		if (num.equals("적립금 사용")) {
			// if(Cafe.RoomManager.find(num).availability == 1) {
			JLabel label = new JLabel("적립금 사용 버튼입니다.");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			jf.add(label);
			jf.setVisible(true);
			return;
			// }
		}

		// txt 파일 확인 후 룸을 제대로 입력받았으면 파일에 입력하는 기능 추가해야함
		// . . .
		setVisible(false);
		setSize(0, 0);
	}
}
