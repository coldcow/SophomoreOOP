package bgc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import mng.Factory;
import mng.Manager;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Flow;

import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BoardGameSelection extends JFrame {
	private JPanel contentPane;
	private JTextField searchBox;
	
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	public static void main(String[] args) {		
		Cafe.boardGameManager.readAll(Main.scanFile("boardgame.txt"), new Factory<BoardGame>() {
			public BoardGame create() {
				return new BoardGame();
			}
		}); // Cafe로 옮길 땐 없앨 것
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardGameSelection frame = new BoardGameSelection();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BoardGameSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topBar = new JPanel();
		contentPane.add(topBar, BorderLayout.NORTH);
		
		JPanel select = new JPanel();
		contentPane.add(select, BorderLayout.CENTER);
		select.setLayout(new BorderLayout(0, 0));
		
		JPanel confirm = new JPanel();
		contentPane.add(confirm, BorderLayout.EAST);
		confirm.setLayout(new BorderLayout(0, 0));
		
		searchBox = new JTextField();
		select.add(searchBox, BorderLayout.NORTH);
		searchBox.setColumns(10);
		
		JPanel boardGameList = new JPanel();
		boardGameList.setLayout(new GridLayout(0, 3));

		JScrollPane scrollPane = new JScrollPane(boardGameList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		select.add(scrollPane);
		
		JTextArea orderList = new JTextArea(0, 50);
		confirm.add(orderList, BorderLayout.CENTER);
		
		for (BoardGame boardGame : Cafe.boardGameManager.managees) {
			panel = new JPanel();
			boardGameList.add(panel);
			panel.setLayout(new BorderLayout());
			panel.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
				@Override
				public void mousePressed(MouseEvent e) {
				}
				@Override
				public void mouseExited(MouseEvent e) {
				}
				@Override
				public void mouseEntered(MouseEvent e) {
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					orderList.append(String.format("%s\t%s\t%s\t%s\t%s\n"
							, boardGame.name, boardGame.genre, boardGame.level, boardGame.numberOfPlayer, boardGame.time));
				}
			});
			
			
			ImageIcon imageIcon = new ImageIcon(String.format("img/board game/%s.jpg", boardGame.name));
			Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
			ImageIcon imageIcon2 = new ImageIcon(image);
			label = new JLabel(imageIcon2);
			panel.add(label, BorderLayout.CENTER);
			
			label = new JLabel(boardGame.name);
			panel.add(label, BorderLayout.SOUTH);
			label.setHorizontalAlignment(JLabel.RIGHT);
			label.setSize(300, 50);
		}
		
		JButton order = new JButton("대여");
		confirm.add(order, BorderLayout.SOUTH);
		order.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				for(String string : orderList.getText().split("\n")) {
					Cafe.order.orderedName.add(string.split("\t")[0]);
					System.exit(0);
				}
			}
		});
	}
}
