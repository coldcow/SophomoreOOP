package bgc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import layout.ModifiedFlowLayout;
<<<<<<< Updated upstream
import mng.Factory;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Image;
import java.awt.Insets;
=======

import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.Image;
>>>>>>> Stashed changes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
<<<<<<< Updated upstream
=======
import java.util.ArrayList;
>>>>>>> Stashed changes

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
<<<<<<< Updated upstream
=======
import javax.swing.JTabbedPane;
>>>>>>> Stashed changes
import javax.swing.JTextArea;

public class BoardGameOrderFrame extends JFrame {
	private JPanel contentPane;
<<<<<<< Updated upstream

	private JPanel information;
	private JPanel selection;
	private JPanel confirmation;

	private JPanel search;
	private JScrollPane scrollPane;
	private JTextArea orderList;
	private JButton orderButton;

	private JTextField searchBar;
	private JButton searchButton;
	private JPanel boardGameList;
	
	private JPanel boardGame;

	private JLabel image;
	private JLabel name;
	
	public static void main(String[] args) {
		Cafe.boardGameManager.readAll(Main.scanFile("boardgame.txt"), new Factory<BoardGame>() {
			public BoardGame create() {
				return new BoardGame();
			}
		}); // Cafe로 옮길 땐 없앨 것
=======
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
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		information = new JPanel();
		contentPane.add(information, BorderLayout.NORTH);

		selection = new JPanel();
		contentPane.add(selection, BorderLayout.CENTER);
		selection.setLayout(new BorderLayout(0, 0));

		confirmation = new JPanel();
		contentPane.add(confirmation, BorderLayout.EAST);
		confirmation.setLayout(new BorderLayout(0, 0));

		search = new JPanel();
		selection.add(search, BorderLayout.NORTH);
		search.setLayout(new BorderLayout());
=======
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
>>>>>>> Stashed changes

		orderList = new JTextArea(0, 50);
		confirmation.add(orderList, BorderLayout.CENTER);

		orderButton = new JButton("대여");
		confirmation.add(orderButton, BorderLayout.SOUTH);
		orderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent exception) {
				for (String string : orderList.getText().split("\n")) {
					Cafe.order.orderedName.add(string.split("\t")[0]);
<<<<<<< Updated upstream
					System.exit(0);
				}
			}
		});

		searchBar = new JTextField();
		search.add(searchBar, BorderLayout.CENTER);

		searchButton = new JButton("검색");
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

		boardGameList = new JPanel();
		boardGameList.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.LEADING));
		scrollPane = new JScrollPane(boardGameList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		selection.add(scrollPane);

		for (BoardGame boardGame : Cafe.boardGameManager.managees) {
			this.boardGame = new JPanel();
			boardGameList.add(this.boardGame);
			this.boardGame.setName(boardGame.name);
			this.boardGame.setLayout(new BorderLayout());
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
=======
					setVisible(false);
				}
			}
		});
>>>>>>> Stashed changes
	}
}
