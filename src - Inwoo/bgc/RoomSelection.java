package bgc;

import java.awt.*;
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

		JButton jb1 = new JButton("1");
		jb1.addActionListener(event -> {
			roomEventHandler(event);			
		});
		pane.add(jb1); // pane이라는 패널에 jb라는 버튼 추가
		
		JButton jb2 = new JButton("2");
		jb2.addActionListener(event -> {
			roomEventHandler(event);
		});
		pane.add(jb2); // pane이라는 패널에 jb라는 버튼 추가
		
		JButton jb3 = new JButton("3");
		jb3.addActionListener(event -> {
			roomEventHandler(event);
		});
		pane.add(jb3); // pane이라는 패널에 jb라는 버튼 추가
		
		JButton jb4 = new JButton("4");
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

		setSize(450, 300); // 윈도우의 크기 가로x세로
		return pane;
	}

	private void roomEventHandler(ActionEvent event) {
		// TODO Auto-generated method stub
		String num = null;
		num = event.getActionCommand();
		JFrame jf = new JFrame();
		jf.setLocation(100,100);
        jf.setSize(450,300);
		
		if (num.equals("end")) {
			System.exit(0);
		}
		
		if (num.equals("1")) {
			if(Cafe.roomManager.find(num).availability == false) {
				JLabel label = new JLabel("사용할 수 없는 방입니다.");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				jf.add(label);
				jf.setVisible(true);
				return;
			}
		}
		if (num.equals("2")) {
			if(Cafe.roomManager.find(num).availability == false) {
				JLabel label = new JLabel("사용할 수 없는 방입니다.");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				jf.add(label);
				jf.setVisible(true);
				return;
			}
		}
		if (num.equals("3")) {
				if(Cafe.roomManager.find(num).availability == false) {
				JLabel label = new JLabel("사용할 수 없는 방입니다.");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				jf.add(label);
				jf.setVisible(true);
				return;
			}
		}
		if (num.equals("4")) {
			if(Cafe.roomManager.find(num).availability == false) {
				JLabel label = new JLabel("사용할 수 없는 방입니다.");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				jf.add(label);
				jf.setVisible(true);
				return;
			}
		}
		
		
		// txt 파일 확인 후 룸을 제대로 입력받았으면 파일에 입력하는 기능 추가해야함  
		// . . . 
		//new NewOrderSelection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewOrderSelection window = new NewOrderSelection();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		setVisible(false);
	}

	void RoomTableInit() {
		Cafe.roomManager.readAll(Main.scanFile("room.txt"), new Factory<Room>() {
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

		} else if (e.getActionCommand().equals("1")) {
			
		} else if (e.getActionCommand().equals("2")) {
			
		} else if (e.getActionCommand().equals("3")) {
		} else if (e.getActionCommand().equals("4")) {

		}
	}
}

// 버튼을 다 구현해놓고