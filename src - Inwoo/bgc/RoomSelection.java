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

public class RoomSelection extends JPanel implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;
	JTable table = null;
	JButton jb = null;
	JTextField edits[] = new JTextField[5];

	public RoomSelection() {
		// super(new BorderLayout());
		RoomTableInit();
		JPanel pane = makeRoomPane();
		add(pane); // JFrame에 jp라는 패널 추가
	}

	private JPanel makeRoomPane() {
		// TODO Auto-generated method stub
		JPanel pane = new JPanel();

		JButton jb1 = new JButton("1번방");
		jb1.addActionListener(event -> {
			roomEventHandler(event);			
		});
		pane.add(jb1); // pane이라는 패널에 jb라는 버튼 추가
		
		JButton jb2 = new JButton("2번방");
		jb2.addActionListener(event -> {
			roomEventHandler(event);
		});
		pane.add(jb2); // pane이라는 패널에 jb라는 버튼 추가
		
		JButton jb3 = new JButton("3번방");
		jb3.addActionListener(event -> {
			roomEventHandler(event);
		});
		pane.add(jb3); // pane이라는 패널에 jb라는 버튼 추가
		
		JButton jb4 = new JButton("4번방");
		jb4.addActionListener(event -> {
			roomEventHandler(event);
		});
		pane.add(jb4); // pane이라는 패널에 jb라는 버튼 추가
		
		// end 버튼 추가
		JButton jbEnd = new JButton("end");
//		jbEnd.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.exit(0);
//			}
//		});
		jbEnd.addActionListener(event -> {
			System.exit(0);
		});
		
		pane.add(jbEnd); // pane이라는 패널에 jb라는 버튼 추가

		FlowLayout fLay = new FlowLayout();
		pane.setLayout(fLay);

		setSize(800, 600); // 윈도우의 크기 가로x세로
		return pane;
	}

	private void roomEventHandler(ActionEvent event) {
		// TODO Auto-generated method stub
		String num = null;
		num = event.getActionCommand();
		
		if (num.equals("end")) {
			System.exit(0);
		}
		
		if (num.equals("3번방")) {
			// . . ..
		}
		
		// txt 파일 확인 후 룸을 제대로 입력받았으면 파일에 입력하는 기능 추가해야함  
		// . . . 
		new OrderSelection();
		setVisible(false);
		setSize(0, 0);
	}

	void RoomTableInit() {
		Cafe.RoomManager.readAll(Main.openFile("room.txt"), new Factory<Room>() {
			public Room create() {
				return new Room();
			}
		});

	}

	

	int selectedIndex = -1;

	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		if (!lsm.isSelectionEmpty()) {
			selectedIndex = lsm.getMinSelectionIndex();
			moveSelectedToEdits();
		}
	}

	private void moveSelectedToEdits() {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		DefaultTableModel data = (DefaultTableModel) (table.getModel());
		if (e.getActionCommand().equals("end")) {
			System.exit(0);

		} else if (e.getActionCommand().equals("1번방")) {
			
		} else if (e.getActionCommand().equals("2번방")) {
			
		} else if (e.getActionCommand().equals("3번방")) {
		} else if (e.getActionCommand().equals("4번방")) {

		}
	}
}

// 버튼을 다 구현해놓고 


