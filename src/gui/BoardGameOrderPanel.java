package gui;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.*;

import bgc.*;

import layout.*;

public class BoardGameOrderPanel extends JPanel {
	private JPanel selection;
	private JTabbedPane tappedPane;
	JPanel panel;
	JScrollPane scrollPane;
	JPanel boardGameList;
	JPanel boardGame;
	JLabel image;
	JLabel name;
	JPanel search;
	JTextField searchBar;
	JButton searchButton;
	private JPanel confirmation;
	private JTextArea orderList;
	private JButton orderButton;

	public BoardGameOrderPanel() {
		setLayout(new BorderLayout());

		selection = new JPanel(new BorderLayout());
		add(selection, BorderLayout.CENTER);
		selection.setBackground(Color.WHITE);

		tappedPane = new JTabbedPane();
		selection.add(tappedPane, BorderLayout.CENTER);
		tappedPane.setForeground(Color.WHITE);
		tappedPane.setBackground(Main.THEMECOLOR);
		tappedPane.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));

		String[] tabLabels = { "전체", "추천", "전략", "추리", "순발력", "카드" };
		// ArrayList<String> tabLabels = new ArrayList<>();

		/*
		 * for (BoardGame boardGame : Cafe.boardGameManager.managees) { String[]
		 * boardGameGenres = boardGame.genre.split(",");
		 * 
		 * for (String boardGameGenre : boardGameGenres) { if
		 * (tabLabels.contains(boardGameGenre)) continue;
		 * 
		 * tabLabels.add(boardGameGenre); } }
		 */

		for (String tabLabel : tabLabels) {
			panel = new JPanel(new BorderLayout());
			tappedPane.addTab(tabLabel, panel);

			JPanel boardGameList = new JPanel();
			boardGameList.setBackground(Color.WHITE);
			boardGameList.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.LEADING));
			scrollPane = new JScrollPane(boardGameList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);

			for (BoardGame boardGame : Cafe.boardGameManager.findAll(tabLabel)) {
				this.boardGame = new JPanel(new BorderLayout());
				boardGameList.add(this.boardGame);
				this.boardGame.setName(boardGame.name);
				this.boardGame.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
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
						orderList.append(String.format("%s\t%s\t%s    %s\t%s\n", boardGame.name, boardGame.genre,
								boardGame.level, boardGame.numberOfPlayer, boardGame.time));
					}
				});

				ImageIcon imageIcon = new ImageIcon(String.format("img/board game/%s.jpg", boardGame.name));
				Image imaged = imageIcon.getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT);
				ImageIcon imageIcon2 = new ImageIcon(imaged);

				image = new JLabel();
				this.boardGame.add(image, BorderLayout.CENTER);
				image.setIcon(imageIcon2);

				name = new JLabel(boardGame.name);
				this.boardGame.add(name, BorderLayout.SOUTH);
				name.setForeground(Color.WHITE);
				name.setBackground(Main.THEMECOLOR);
				name.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
				name.setHorizontalAlignment(JLabel.RIGHT);
				name.setBorder(BorderFactory.createLineBorder(name.getBackground(), 2));
				name.setOpaque(true);
				name.setSize(220, 0);
			}

			JPanel search = new JPanel(new BorderLayout());
			panel.add(search, BorderLayout.SOUTH);

			JTextField searchBar = new JTextField();
			search.add(searchBar, BorderLayout.CENTER);
			searchBar.setFont(new Font("나눔고딕", Font.PLAIN, 16));

			JButton searchButton = new JButton("검색");
			search.add(searchButton, BorderLayout.EAST);
			searchButton.setForeground(Color.WHITE);
			searchButton.setBackground(Main.THEMECOLOR);
			searchButton.setBorderPainted(false);
			searchButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
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
		add(confirmation, BorderLayout.EAST);

		orderList = new JTextArea(0, 36);
		confirmation.add(orderList, BorderLayout.CENTER);
		orderList.setFont(new Font("나눔고딕", Font.PLAIN, 12));

		orderButton = new JButton("대여");
		confirmation.add(orderButton, BorderLayout.SOUTH);
		orderButton.setForeground(Color.WHITE);
		orderButton.setBackground(Main.THEMECOLOR);
		orderButton.setBorderPainted(false);
		orderButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
		orderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent exception) {
				for (String string : orderList.getText().split("\n")) {
					Cafe.order.orderedName.add(string.split("\t")[0]);
					setVisible(false);
					orderList.setText(null);
				}
			}
		});
	}
}
