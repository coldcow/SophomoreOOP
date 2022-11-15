package bgc;

import javax.swing.JFrame;

import mng.Factory;
import mng.Manager;

public class Cafe {
	static Manager<BoardGame> BoardGameManager = new Manager<>();
	Manager<Drink> DrinkManager = new Manager<>();
	static Manager<Room> RoomManager = new Manager<>();

	void run() {
		BoardGameManager.readAll(Main.openFile("boardgame.txt"), new Factory<BoardGame>() {
			public BoardGame create() {
				return new BoardGame();
			}
		});

		DrinkManager.readAll(Main.openFile("drink.txt"), new Factory<Drink>() {
			public Drink create() {
				return new Drink();
			}
		});

		RoomManager.readAll(Main.openFile("room.txt"), new Factory<Room>() {
			public Room create() {
				return new Room();
			}
		});

		Room room = new Room();

		while (true) {
			System.out.println("1. 입장 2. 퇴장 3. 주문 4. 검색");
			System.out.print("메뉴를 입력하세요: ");
			int menu = Main.scanner.nextInt();

			switch (menu) {
			case 1:
				
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						createAndShowGUI();
					}
				});
//				
				while (true) {
					System.out.print("입장하실 방의 번호를 입력하세요: ");
					String num = Main.scanner.next();
					if (num.equals("end"))
						break;
					room = RoomManager.find(num);

					if (room == null) {
						System.out.println("존재하지 않는 방입니다. 다시 입력해주세요.");
						continue;
					}

					if (room.availability == 1) {
						System.out.println("이미 사용중인 방입니다. 다시 입력해주세요.");
						continue;
					}

					room.availability = 1;
					break;
				}

				break;

			case 2:
				while (true) {
					System.out.print("퇴장하실 방의 번호를 입력하세요: ");
					String num = Main.scanner.next();
					if (num.equals("end"))
						break;
					room = RoomManager.find(num);

					if (room == null) {
						System.out.println("존재하지 않는 방입니다. 다시 입력해주세요.");
						continue;
					}

					if (room.availability == 0) {
						System.out.println("이미 퇴장 처리된 방입니다. 다시 입력해주세요.");
						continue;
					}

					room.availability = 0;
					System.out.println("이용해주셔서 감사합니다. 안녕히가세요.");
					break;
				}

				break;

			case 3:
				System.out.println("1. 보드게임 대여 2. 음료 주문");
				System.out.print("메뉴를 입력하세요: ");
				menu = Main.scanner.nextInt();

				switch (menu) {
				case 1:
					// System.out.println("이름 난이도(1~7) 장르 인원수 게임시간");
					// BoardGameManager.printAll();
					
					javax.swing.SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							createAndShowGUI();
						}
					});

					while (true) {
						System.out.print("사용하실 보드게임을 입력해주세요: ");
						String Board = Main.scanner.next();
						if (Board.equals("end"))
							break;
						BoardGame boardGame = BoardGameManager.find(Board);
						if (boardGame == null) {
							System.out.println("존재하지 않는 보드게임입니다. 다시 입력해주세요.\n");
							continue;
						}

						/*
						 * if (boardGame.사용가능여부 or 사용가능수량 == 조건) {
						 * System.out.println("이미 사용중인 보드게임입니다. 다시 입력해주세요."); continue }
						 */

						// boardGame.사용가능여부 or 사용가능수량을 변경;

						break;
					}

					break;

				case 2:
					DrinkManager.printAll();
					System.out.print("주문하실 음료수를 모두 입력하신 후 0을 입력해주세요: ");
					int totalPrice = 0;

					while (true) {
						String drinkName = Main.scanner.next();
						Drink drink = DrinkManager.find(drinkName);

						if (drinkName.equals("0"))
							break;

						if (drink == null) {
							System.out.println("존재하지 않는 음료입니다. 다시 입력해주세요.");
							continue;
						}

						totalPrice += drink.price;
					}

					System.out.printf("지불하실 금액은 %d원 입니다.\n", totalPrice);
					System.out.println("즐거운 시간 보내세요.");
					break;

				default:
					break;
				}

				break;

			case 4:
				System.out.println("1. 보드 게임 검색 2. 음료 검색");
				System.out.print("메뉴를 입력하세요: ");
				menu = Main.scanner.nextInt();

				switch (menu) {
				case 1:
					BoardGameManager.search();
					break;

				case 2:
					DrinkManager.search();
					break;

				default:
					break;
				}

				break;

			default:
				break;
			}
		}
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("RoomSelection");
//		JFrame frame = new JFrame("BoardGameTableSelection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		RoomSelection newContentPane = new RoomSelection();
//		BoardGameTableSelection newContentPane = new BoardGameTableSelection();
		frame.setLocationRelativeTo(null); // 프레임을 화면 가운데에 배치
		newContentPane.setOpaque(true); // content panes must be opaque
		
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
}
