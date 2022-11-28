package bgc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import layout.ModifiedFlowLayout;

import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class BoardGameOrderFrame extends JFrame {
	private JPanel contentPane;
		private JPanel selection;
			private JPanel logo;
			private JTabbedPane tappedPane;
				JPanel panel;
					JScrollPane scrollPane;
						//JPanel boardGameList;
							JPanel boardGame;
								JLabel image;
								JLabel name;
					JPanel search;
						JTextField searchBar;
						JButton searchButton;
		private JPanel confirmation;
			private JTextArea orderList;
			private JButton orderButton;

	public static void main(String[] args) {
		/*Cafe.boardGameManager.readAll(Main.scanFile("boardgame.txt"), new Factory<BoardGame>() {
			public BoardGame create() {
				return new BoardGame();
			}
		});*/

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardGameOrderFrame boardGameOrder = new BoardGameOrderFrame();
					boardGameOrder.setVisible(true);
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BoardGameOrderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);

		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);

		selection = new JPanel(new BorderLayout());
		contentPane.add(selection, BorderLayout.CENTER);
		
		logo = new JPanel();
		selection.add(logo, BorderLayout.NORTH);
		
		tappedPane = new JTabbedPane();
		selection.add(tappedPane, BorderLayout.CENTER);
		
		ArrayList<String> tabLabels = new ArrayList<>();
		
		for(BoardGame boardGame : Cafe.boardGameManager.managees) {
			String[] boardGameGenres = boardGame.genre.split(",");
			
			for (String boardGameGenre : boardGameGenres)
			{
				if(tabLabels.contains(boardGameGenre))
					continue;
			
				tabLabels.add(boardGameGenre);
			}
		}
		
		for (String tabLabel : tabLabels) {
			panel = new JPanel(new BorderLayout());
			tappedPane.addTab(tabLabel, panel);
			JPanel boardGameList = new JPanel();
			boardGameList.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.LEADING));
			scrollPane = new JScrollPane(boardGameList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);
			
			for (BoardGame boardGame : Cafe.boardGameManager.findAll(tabLabel)) {
				this.boardGame = new JPanel(new BorderLayout());
				boardGameList.add(this.boardGame);
				this.boardGame.setName(boardGame.name);
				this.boardGame.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent exception) {
					}

					@Override
					public void mousePressed(MouseEvent exception) {
					}

					@Override
					public void mouseExited(MouseEvent exception) {
					}

					@Override
					public void mouseEntered(MouseEvent exception) {
					}

					@Override
					public void mouseClicked(MouseEvent exception) {
						orderList.append(String.format("%s\t%s\t%s\t%s\t%s\n", boardGame.name, boardGame.genre,
								boardGame.level, boardGame.numberOfPlayer, boardGame.time));
					}
				});

				ImageIcon imageIcon = new ImageIcon(String.format("img/board game/%s.jpg", boardGame.name));
				Image imaged = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
				ImageIcon imageIcon2 = new ImageIcon(imaged);

				image = new JLabel(imageIcon2);
				this.boardGame.add(image, BorderLayout.CENTER);
				
				name = new JLabel(boardGame.name);
				this.boardGame.add(name, BorderLayout.SOUTH);
				name.setHorizontalAlignment(JLabel.RIGHT);
				name.setSize(300, 50);
			}
			
			JPanel search = new JPanel(new BorderLayout());
			panel.add(search, BorderLayout.SOUTH);
			
			JTextField searchBar = new JTextField();
			search.add(searchBar, BorderLayout.CENTER);

			JButton searchButton = new JButton("검색");
			search.add(searchButton, BorderLayout.EAST);
			searchButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent exception) {
					String[] searchWords = searchBar.getText().split(" ");
					JPanel boardGame;
					BoardGame realBoardGame;

					for (int index = 0; index < boardGameList.getComponentCount(); index++) {
						boardGame = (JPanel) boardGameList.getComponent(index);
						boardGame.setVisible(false);
						realBoardGame = Cafe.boardGameManager.find(boardGame.getName());

						for (String searchWord : searchWords) {
							if (realBoardGame.matches(searchWord)) {
								boardGame.setVisible(true);
								break;
							}
						}
					}
				}
			});
		}

		confirmation = new JPanel(new BorderLayout());
		contentPane.add(confirmation, BorderLayout.EAST);

		orderList = new JTextArea(0, 50);
		confirmation.add(orderList, BorderLayout.CENTER);

		orderButton = new JButton("대여");
		confirmation.add(orderButton, BorderLayout.SOUTH);
		orderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent exception) {
				for (String string : orderList.getText().split("\n")) {
					Cafe.order.orderedName.add(string.split("\t")[0]);
					setVisible(false);
				}
			}
		});
	}
}
