package bgc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import layout.ModifiedFlowLayout;
import mng.Factory;

import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.JTextField;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DrinkOrderFrame extends JFrame {
	private JPanel contentPane = new JPanel();

	private JPanel information;
	private JPanel selection;
	private JPanel confirmation;

	private JPanel search;
	private JScrollPane scrollPane;
	private JTextArea orderList;
	private JButton orderButton;

	private JTextField searchBar;
	private JButton searchButton;
	private JPanel drinkList;
	
	private JPanel drink;

	private JLabel image;
	private JLabel name;

	public static void main(String[] args) {
		Cafe.drinkManager.readAll(Main.scanFile("drink.txt"), new Factory<Drink>() {
			public Drink create() {
				return new Drink();
			}
		});

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrinkOrderFrame frame = new DrinkOrderFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DrinkOrderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		information = new JPanel();
		contentPane.add(information, BorderLayout.NORTH);

		selection = new JPanel();
		contentPane.add(selection, BorderLayout.CENTER);
		selection.setLayout(new BorderLayout());

		confirmation = new JPanel();
		contentPane.add(confirmation, BorderLayout.EAST);
		confirmation.setLayout(new BorderLayout());

		search = new JPanel();
		selection.add(search, BorderLayout.NORTH);
		search.setLayout(new BorderLayout());

		searchBar = new JTextField();
		search.add(searchBar, BorderLayout.CENTER);

		searchButton = new JButton("검색");
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

		drinkList = new JPanel();
		scrollPane = new JScrollPane(drinkList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		selection.add(scrollPane);
		drinkList.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.LEADING));

		orderList = new JTextArea(0, 50);
		confirmation.add(orderList, BorderLayout.CENTER);

		for (Drink drink : Cafe.drinkManager.managees) {
			this.drink = new JPanel();
			drinkList.add(this.drink);
			this.drink.setLayout(new BorderLayout());
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
				}
			});

			this.drink.setName(drink.name);

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

		orderButton = new JButton("주문");
		confirmation.add(orderButton, BorderLayout.SOUTH);
		orderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent exception) {
				for (String string : orderList.getText().split("\n")) {
					Drink drink = Cafe.drinkManager.find(string.split("\t")[1]);
					Cafe.order.orderedName.add(drink.name);
					Cafe.cost += drink.price;
					System.exit(0);
				}
			}
		});
	}
}
