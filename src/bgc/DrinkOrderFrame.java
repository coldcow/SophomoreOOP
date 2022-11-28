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

public class DrinkOrderFrame extends JFrame {
	private JPanel contentPane;
			private JPanel selection;
				private JPanel logo;
				private JTabbedPane tappedPane;
					JPanel panel;
						JScrollPane scrollPane;
						//JPanel drinkList;
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

	public static void main(String[] args) {
		/*Cafe.drinkManager.readAll(Main.scanFile("drink.txt"), new Factory<Drink>() {
			public Drink create() {
				return new Drink();
			}
		});*/

		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrinkOrderFrame frame = new DrinkOrderFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	public DrinkOrderFrame() {
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
			drinkList.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.LEADING));
			scrollPane = new JScrollPane(drinkList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);

			for (Drink drink : Cafe.drinkManager.findAll(tabLabel)) {
				this.drink = new JPanel(new BorderLayout());
				drinkList.add(this.drink);
				this.drink.setName(drink.name);
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
				Image imaged = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
				ImageIcon imageIcon2 = new ImageIcon(imaged);

				image = new JLabel(imageIcon2);
				this.drink.add(image, BorderLayout.CENTER);

				name = new JLabel(drink.name);
				this.drink.add(name, BorderLayout.SOUTH);
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
		contentPane.add(confirmation, BorderLayout.EAST);

		orderList = new JTextArea(0, 50);
		confirmation.add(orderList, BorderLayout.CENTER);
		
		cost = new JLabel();
		confirmation.add(cost, BorderLayout.NORTH);
		cost.setText(String.format("총 금액: %d원", Cafe.cost));

		orderButton = new JButton("주문");
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