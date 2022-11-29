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

public class DrinkOrderPanel extends JPanel {
	private JPanel selection;
	private JTabbedPane tappedPane;
	JPanel panel;
	JScrollPane scrollPane;
	JPanel drinkList;
	JPanel drink;
	JLabel image;
	JLabel name;
	JPanel search;
	JTextField searchBar;
	JButton searchButton;
	private JPanel confirmation;
	private JTextArea orderList;
	private JLabel cost;
	private JButton orderButton;

	public DrinkOrderPanel() {
		setLayout(new BorderLayout());

		selection = new JPanel(new BorderLayout());
		add(selection, BorderLayout.CENTER);
		selection.setBackground(Color.WHITE);

		tappedPane = new JTabbedPane();
		selection.add(tappedPane, BorderLayout.CENTER);
		tappedPane.setForeground(Color.WHITE);
		tappedPane.setBackground(Main.THEMECOLOR);
		tappedPane.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));

		ArrayList<String> tabLabels = new ArrayList<>();

		for (Drink drink : Cafe.drinkManager.managees) {
			String drinkType = drink.type;

			if (tabLabels.contains(drinkType))
				continue;

			tabLabels.add(drinkType);
		}

		for (String tabLabel : tabLabels) {
			panel = new JPanel(new BorderLayout());
			tappedPane.addTab(tabLabel, panel);
			JPanel drinkList = new JPanel();
			drinkList.setBackground(Color.WHITE);
			drinkList.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.LEADING));
			scrollPane = new JScrollPane(drinkList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);

			for (Drink drink : Cafe.drinkManager.findAll(tabLabel)) {
				this.drink = new JPanel(new BorderLayout());
				drinkList.add(this.drink);
				this.drink.setName(drink.name);
				this.drink.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
				this.drink.addMouseListener(new MouseListener() {
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
						orderList.append(String.format("%s\t%s\t%d\n", drink.type, drink.name, drink.price));
						Cafe.cost += drink.price;
						cost.setText(String.format("총 금액: %d원", Cafe.cost));
					}
				});

				ImageIcon imageIcon = new ImageIcon(String.format("img/drink/%s.jpg", drink.name));
				Image imaged = imageIcon.getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT);
				ImageIcon imageIcon2 = new ImageIcon(imaged);

				image = new JLabel(imageIcon2);
				this.drink.add(image, BorderLayout.CENTER);

				name = new JLabel(drink.name);
				this.drink.add(name, BorderLayout.SOUTH);
				name.setForeground(Color.WHITE);
				name.setBackground(Main.THEMECOLOR);
				name.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
				name.setHorizontalAlignment(JLabel.RIGHT);
				name.setOpaque(true);
				name.setSize(220, 0);
				name.setBorder(BorderFactory.createLineBorder(name.getBackground(), 2));
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
					JPanel drink;
					Drink realdrink;

					for (int index = 0; index < drinkList.getComponentCount(); index++) {
						drink = (JPanel) drinkList.getComponent(index);
						drink.setVisible(false);
						realdrink = Cafe.drinkManager.find(drink.getName());

						for (String searchWord : searchWords) {
							if (realdrink.matches(searchWord)) {
								drink.setVisible(true);
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

		cost = new JLabel();
		confirmation.add(cost, BorderLayout.NORTH);
		cost.setOpaque(true);
		cost.setForeground(Color.WHITE);
		cost.setBackground(Main.THEMECOLOR);
		cost.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
		cost.setText(String.format("총 금액: %6d원", Cafe.cost));
		cost.setPreferredSize(new Dimension(0, 50));
		cost.setBorder(BorderFactory.createLineBorder(cost.getBackground(), 10));

		orderButton = new JButton("주문");
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
