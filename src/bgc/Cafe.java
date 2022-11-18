package bgc;

import javax.swing.JFrame;

import mng.Factory;
import mng.Manager;

<<<<<<< Updated upstream
import java.util.*;

public class Cafe {
	static Manager<BoardGame> BoardGameManager = new Manager<>();
	Manager<Drink> DrinkManager = new Manager<>();
	Manager<Room> RoomManager = new Manager<>();
	Manager<User> UserManager = new Manager<>();

	int menuState = 0;
	int menu = 0;
	boolean condition = false;
	HashMap<String, Integer> orderList = null;
	User user = new User();
	Room room = null;
	Order order = null;
	Payment payment = new Payment();

	void run() {
		BoardGameManager.readAll(Main.openFile("boardgame.txt"), new Factory<BoardGame>() {
=======
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Cafe {
	static Manager<BoardGame> boardGameManager = new Manager<>();
	Manager<Drink> drinkManager = new Manager<>();
	static Manager<Room> roomManager = new Manager<>();
	Manager<User> userManager = new Manager<>();

	void run() {
		boardGameManager.readAll(Main.scanFile("boardgame.txt"), new Factory<BoardGame>() {
>>>>>>> Stashed changes
			public BoardGame create() {
				return new BoardGame();
			}
		});

<<<<<<< Updated upstream
		DrinkManager.readAll(Main.openFile("drink.txt"), new Factory<Drink>() {
=======
		drinkManager.readAll(Main.scanFile("drink.txt"), new Factory<Drink>() {
>>>>>>> Stashed changes
			public Drink create() {
				return new Drink();
			}
		});

<<<<<<< Updated upstream
		RoomManager.readAll(Main.openFile("room.txt"), new Factory<Room>() {
=======
		roomManager.readAll(Main.scanFile("room.txt"), new Factory<Room>() {
>>>>>>> Stashed changes
			public Room create() {
				return new Room();
			}
		});

<<<<<<< Updated upstream
		// 로그인 메뉴(최상위 메뉴) 시작
		while (true) {
			do {
				UserManager.readAll(Main.openFile("user.txt"), new Factory<User>() {
					public User create() {
						return new User();
					}
				});
=======
		userManager.readAll(Main.scanFile("user.txt"), new Factory<User>() {
			public User create() {
				return new User();
			}
		});

		// 키오스크 시작
		while (true) {
			int menu = 0;
			boolean condition = false;

			HashMap<String, Integer> orderList = null;

			User user = new User();
			Room room = new Room();
			BoardGame boardGame = new BoardGame();
			Drink drink = new Drink();
			Order order = new Order(null);

			String userIdentifier = null;
			String userPassword = null;
			int userAge = 0;
			String roomNumber = null;
			String boardGameInformation = null;
			String drinkName = null;
			int cost = 0;
			int mileageToUse = 0;
			
			System.out.println("키오스크 종료를 원하시면 0을 입력해주세요.");
			menu = Main.scanner.nextInt();

			if (menu == 0) {
				try {
					BufferedWriter temporary = new BufferedWriter(new FileWriter(new File("user.txt"), false));
					temporary.write("");
					temporary.close();
				}

				catch (IOException exception) {
					exception.printStackTrace();
				}

				userManager.writeAll(new File("user.txt"));
				break;
			}
			// 계정 시작
			while (true) {
				if (condition)
					break;
>>>>>>> Stashed changes

				System.out.println("1. 로그인 2. 회원가입");
				System.out.print("메뉴를 입력하세요: ");
				menu = Main.scanner.nextInt();

				switch (menu) {
<<<<<<< Updated upstream
				// 로그인 시작
				case 1:
					while (true) {
						System.out.print("아이디를 입력하세요: ");
						user = UserManager.find(Main.scanner.next());
=======
				// 계정-로그인 시작
				case 1:
					while (true) {
						System.out.print("아이디를 입력하세요: ");
						user = userManager.find(Main.scanner.next());
>>>>>>> Stashed changes

						if (user == null) {
							System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
							continue;
						}

						break;
					}

					condition = false;

					for (int count = 1; count <= 5; count++) {
						System.out.print("비밀번호를 입력하세요 (5회 오류시 초기화): ");

						if (user.password.equals(Main.scanner.next())) {
							System.out.println("로그인 성공");
							condition = true;
							order = new Order(user.identifier);
							break;
						}

<<<<<<< Updated upstream
						System.out.printf("비밀번호가 틀립니다. (%d회)\n", count);
					}

					break;
				// 로그인 종료
				case 2:
					System.out.println("<뒤로가기 = 0>");
					System.out.print("아이디 : ");
					String newId = Main.scanner.next();
					if (newId.equals("0")) {
						break;
					}

					System.out.print("비밀번호 : ");
					String newPassword = Main.scanner.next();

					System.out.print("나이 : ");
					int newAge = Main.scanner.nextInt();

					user.createUser(Main.openJustFile("user.txt"), newId, newPassword, newAge);
					break;
				// 회원가입 종료
				default:
					break;
				}

				if (!condition)
					continue;
<<<<<<< Updated upstream

				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						createAndShowGUI2();
					}
				});
=======
				
				/* 작업 중
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						createAndShowGUI();
					}
				});*/

>>>>>>> Stashed changes
				System.out.print("입장하실 방의 번호를 입력하세요: ");
				String numIn = Main.scanner.next();
				if (numIn.equals("end"))
					break;
				room = RoomManager.find(numIn);
=======
						System.out.printf("비밀번호가 틀립니다. 다시 입력해주세요. (오류: %d회)\n", count);
					}

					break;
				// 계정-로그인 종료
				// 계정-회원가입 시작
				case 2:
					while (true) {
						System.out.println("<뒤로가기 = 0>");
						System.out.print("아이디: ");
						userIdentifier = Main.scanner.next();

						if (userIdentifier.equals("0"))
							break;

						if (userManager.find(userIdentifier) != null) {
							System.out.println("해당 아이디가 이미 존재합니다. 다른 아이디를 입력하세요.");
							continue;
						}

						System.out.print("비밀번호: ");
						userPassword = Main.scanner.next();

						System.out.print("나이 : ");
						userAge = Main.scanner.nextInt();

						user = new User();
						user.read(userIdentifier, userPassword, userAge);
						userManager.managees.add(user);
						break;
					}

					break;
				// 계정-회원가입 종료
				default:
					break;
				}
			}
			// 계정 종료
			/* 여기서 오류, 난 틀렸어... 뒤를 부탁해...
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					createAndShowGUI();
				}
			});*/
			// 입장 시작
			while (true) {
				System.out.print("입장하실 방의 번호를 입력하세요: ");
				roomNumber = Main.scanner.next();
				room = roomManager.find(roomNumber);
>>>>>>> Stashed changes

				if (room == null) {
					System.out.println("존재하지 않는 방입니다. 다시 입력해주세요.");
					continue;
				}

<<<<<<< Updated upstream
<<<<<<< Updated upstream
				if (!room.availability) {
=======
				if (room.availability == 1) {
>>>>>>> Stashed changes
=======
				if (!room.availability) {
>>>>>>> Stashed changes
					System.out.println("이미 사용중인 방입니다. 다시 입력해주세요.");
					continue;
				}

<<<<<<< Updated upstream
<<<<<<< Updated upstream
				room.availability = false;
=======
				room.availability = 1;
>>>>>>> Stashed changes
				menuState = 1;
				break;
			}
			// 입장 종료
			// 메인 메뉴(차상위 메뉴) 시작
			while (menuState != 1);
			int totalPrice = 0;
			while (menuState == 1) {
=======
				room.availability = false;
				break;
			}
			// 입장 종료
			// 메인 시작
			cost = 0;
			while (true) {
				if (!condition)
					break;
>>>>>>> Stashed changes
				System.out.println("1. 퇴장 2. 주문 3. 검색 4. 추천");
				System.out.print("메뉴를 입력하세요: ");
				menu = Main.scanner.nextInt();

				switch (menu) {
<<<<<<< Updated upstream
				// 퇴장 시작
				case 1:
					while (true) {
						System.out.print("퇴장하실 방의 번호를 입력하세요: ");
						String numOut = Main.scanner.next();
						if (numOut.equals("end"))
							break;
						room = RoomManager.find(numOut);

						if (room == null) {
							System.out.println("존재하지 않는 방입니다. 다시 입력해주세요.");
							continue;
						}

<<<<<<< Updated upstream
						if (room.availability) {
=======
						if (room.availability == 0) {
>>>>>>> Stashed changes
							System.out.println("이미 퇴장 처리된 방입니다. 다시 입력해주세요.");
							continue;
						}

						System.out.format("1. 결제 2. 적립금 사용 (사용가능 적립금 : %d원)", payment.showMileage(user));
						if (user.age < 20) {
							totalPrice -= 3000;
						}
						int paymentMenu = Main.scanner.nextInt();
						switch (paymentMenu) {
						case 1:
							System.out.println("총 결제금액은 : " + totalPrice + "입니다.");
							payment.giveMileage(user, totalPrice);
							order.addOrderToFile(Main.openJustFile("order.txt"));
							menuState = 0;
							System.out.println("이용해주셔서 감사합니다. 안녕히가세요.");
<<<<<<< Updated upstream
							room.availability = true;
=======
							room.availability = 0;
>>>>>>> Stashed changes
							break;
						case 2:
							if (payment.showMileage(user) == 0) {
								System.out.print("사용가능한 마일리지가 없습니다.");
								continue;
							}
							System.out.print("사용하실 적립금 액수를 입력해주세요 : ");
							int finalTotalPrice = payment.useMileage(user, totalPrice, Main.scanner.nextInt());
							if (finalTotalPrice == totalPrice) {
								System.out.println("마일리지가 부족합니다");
								continue;
							}
							user.updateUser(UserManager, Main.openJustFile("user.txt"));
							System.out.println("총 결제금액은 : " + finalTotalPrice + "입니다.");
							order.addOrderToFile(Main.openJustFile("order.txt"));
							menuState = 0;
							System.out.println("이용해주셔서 감사합니다. 안녕히가세요.");
<<<<<<< Updated upstream
							room.availability = true;
=======
							room.availability = 0;
>>>>>>> Stashed changes
							break;
						default:
							System.out.println("지정된 메뉴가 없습니다 다시 시도해 주세요");
							continue;
						}
						break;

					}

					break;
				// 퇴장 종료

				// 주문 시작, 주문 메뉴(차차상위 메뉴) 시작
=======
				// 메인-퇴장 시작
				case 1:
					// 메인-퇴장-퇴장 시작
					room.availability = true;
					condition = false;
					// 메인-퇴장-퇴장 종료
					// 메인-퇴장-결제 시작
					if (user.age < 20)
						cost *= 0.9;
					Payment.giveMileage(user, cost);

					while (true) {
						System.out.printf("1. 일반 결제 2. 적립금 사용 (사용 가능 적립금: %d원)", user.mileage);
						System.out.print("메뉴를 입력하세요: ");
						menu = Main.scanner.nextInt();

						switch (menu) {
						// 메인-퇴장-결제-일반 결제 시작
						case 1:
							order.addOrderToFile(Main.openFile("order.txt"));
							break;
						// 메인-퇴장-결제-일반 결제 종료
						// 메인-퇴장-결제-적립금 사용 시작
						case 2:
							while (true) {
								if (user.mileage == 0) {
									System.out.println("적립된 마일리지가 없습니다.");
									break;
								}

								System.out.print("사용할 마일리지를 입력하세요: ");
								mileageToUse = Main.scanner.nextInt();

								if (user.mileage < mileageToUse) {
									System.out.println("마일리지가 부족합니다.");
									continue;
								}

								Payment.useMileage(user, cost, mileageToUse);
								break;
							}

							System.out.printf("%d마일리지가 성공적으로 사용되었습니다!\n", mileageToUse);
							break;
						// 메인-퇴장-결제-적립금 사용 종료
						default:
							System.out.println("지정된 메뉴가 없습니다 다시 시도해 주세요");
							break;
						}

						System.out.printf("결제하실 금액은 총 %d원입니다.\n", cost);
						break;
					}
					// 메인-퇴장-결제 종료

					System.out.println("이용해주셔서 감사합니다.");
					break;
				// 메인-퇴장 종료
				// 메인-주문 시작
>>>>>>> Stashed changes
				case 2:
					System.out.println("1. 보드게임 대여 2. 음료 주문");
					System.out.print("메뉴를 입력하세요: ");
					menu = Main.scanner.nextInt();

					switch (menu) {
<<<<<<< Updated upstream
					// 보드게임 대여 시작
					case 1:
						// System.out.println("이름 난이도(1~7) 장르 인원수 게임시간");
						// BoardGameManager.printAll();
<<<<<<< Updated upstream

						javax.swing.SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								createAndShowGUI();
							}
						});
=======
						/*
						javax.swing.SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								createAndShowGUI0();
							}
						});*/
>>>>>>> Stashed changes

						while (true) {
							System.out.print("사용하실 보드게임을 입력해주세요: ");
							String Board = Main.scanner.next();

							if (Board.equals("end"))
								break;

							BoardGame boardGame = BoardGameManager.find(Board);
=======
					// 메인-주문-보드게임 대여 시작
					case 1:
						boardGameManager.printAll();
						System.out.print("대여하실 보드게임을 입력해주세요(end로 종료): ");

						while (true) {
							boardGameInformation = Main.scanner.next();

							if (boardGameInformation.equals("end"))
								break;

							boardGame = boardGameManager.find(boardGameInformation);
>>>>>>> Stashed changes

							if (boardGame == null) {
								System.out.println("존재하지 않는 보드게임입니다. 다시 입력해주세요.\n");
								continue;
							}
<<<<<<< Updated upstream
							order.orderedName.add(boardGame.name);
							break;
						}

						break;
					// 보드게임 대여 종료

					// 음료 주문 시작
					case 2:
						DrinkManager.printAll();
						System.out.print("주문하실 음료수를 모두 입력하신 후 0을 입력해주세요: ");

						while (true) {
							String drinkName = Main.scanner.next();
							Drink drink = DrinkManager.find(drinkName);

							if (drinkName.equals("0"))
=======

							order.orderedName.add(boardGame.name);
						}

						System.out.println("보드게임이 대여되었습니다.");
						break;
					// 메인-주문-보드게임 대여 종료
					// 메인-주문-음료 주문 시작
					case 2:
						drinkManager.printAll();
						System.out.print("주문하실 음료수를 모두 입력해주세요(end로 종료): ");

						while (true) {
							drinkName = Main.scanner.next();
							drink = drinkManager.find(drinkName);

							if (drinkName.equals("end"))
>>>>>>> Stashed changes
								break;

							if (drink == null) {
								System.out.println("존재하지 않는 음료입니다. 다시 입력해주세요.");
								continue;
							}
<<<<<<< Updated upstream
							order.orderedName.add(drink.name);
							totalPrice += drink.price;
						}

						System.out.printf("지불하실 금액은 %d원 입니다.\n", totalPrice);
						System.out.println("즐거운 시간 보내세요.");
						break;
					// 음료 주문 종료

					default:
						System.out.println("지정된 메뉴가 없습니다 다시 시도해 주세요");
						continue;
					}

					break;
				// 주문 종료, 주문 메뉴(차차상위 메뉴) 종료

				// 검색 시작, 검색 메뉴(차차상위 메뉴) 시작
=======

							order.orderedName.add(drink.name);
							cost += drink.price;
						}

						System.out.println("음료가 주문되었습니다.");
						break;
					// 메인-주문-음료 주문 종료

					default:
						System.out.println("지정된 메뉴가 없습니다 다시 시도해 주세요");
						break;
					}

					break;
				// 메인-주문 종료
				// 메인-검색 시작
>>>>>>> Stashed changes
				case 3:
					System.out.println("1. 보드 게임 검색 2. 음료 검색");
					System.out.print("메뉴를 입력하세요: ");
					menu = Main.scanner.nextInt();

					switch (menu) {
<<<<<<< Updated upstream
					// 보드게임 검색 시작
					case 1:
						BoardGameManager.search();
						break;
					// 보드게임 검색 종료

					// 음료 검색 시작
					case 2:
						DrinkManager.search();
						break;
					// 음료 검색 종료

=======
					// 메인-검색-보드게임 검색 시작
					case 1:
						boardGameManager.search();
						break;
					// 메인-검색-보드게임 검색 종료
					// 메인-검색-음료 검색 시작
					case 2:
						drinkManager.search();
						break;
					// 메인-검색-음료 검색 종료
>>>>>>> Stashed changes
					default:
						break;
					}

					break;
<<<<<<< Updated upstream
				// 검색 종료, 검색 메뉴(차차상위 메뉴) 종료
				case 4:
					orderList = order.getOrderFromFile(Main.openFile("order.txt"));
					HashMap<String, Integer> boardGameMap = new HashMap<>();
					HashMap<String, Integer> drinkMap = new HashMap<>();

					for (String order : orderList.keySet()) {
						if (BoardGameManager.find(order) != null) {
							boardGameMap.put(order, orderList.get(order));
						} else {
							drinkMap.put(order, orderList.get(order));
=======
				// 메인-검색 종료
				// 메인-추천 시작
				case 4:
					orderList = order.getOrderFromFile(Main.scanFile("order.txt"));
					HashMap<String, Integer> boardGameMap = new HashMap<>();
					HashMap<String, Integer> drinkMap = new HashMap<>();

					for (String orderName : orderList.keySet()) {
						if (boardGameManager.find(orderName) != null) {
							boardGameMap.put(orderName, orderList.get(orderName));
						} else {
							drinkMap.put(orderName, orderList.get(orderName));
>>>>>>> Stashed changes
						}
					}

					System.out.print("(1) 보드게임 추천 (2) 음료 추천");
					int numberOfRecomand = Main.scanner.nextInt();

					switch (numberOfRecomand) {
<<<<<<< Updated upstream
					case 1:
						order.recomand(BoardGameManager.sortMap(boardGameMap));
						break;
					case 2:
						order.recomand(DrinkManager.sortMap(drinkMap));
						break;
					}
					break;
=======
					// 메인-추천-보드게임 추천 시작
					case 1:
						order.recomand(boardGameManager.sortMap(boardGameMap));
						break;
					// 메인-추천-보드게임 추천 종료
					// 메인-추천-음료 추천 시작
					case 2:
						order.recomand(drinkManager.sortMap(drinkMap));
						break;
					// 메인-추천-음료 추천 종료
					default:
						break;
					}

					break;
				// 메인-추천 종료
>>>>>>> Stashed changes
				default:
					break;
				}
			}
<<<<<<< Updated upstream
			// 메인 메뉴(차상위 메뉴) 종료
		}
=======
			// 메인 종료
		}
		// 키오스크 종료
>>>>>>> Stashed changes
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
<<<<<<< Updated upstream
<<<<<<< Updated upstream
		JFrame frame = new JFrame("BoardGameTableSelection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		BoardGameTableSelection newContentPane = new BoardGameTableSelection();
		newContentPane.setOpaque(true); // content panes must be opaque
=======
=======
>>>>>>> Stashed changes
		JFrame frame = new JFrame("RoomSelection");
//		JFrame frame = new JFrame("BoardGameTableSelection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		RoomSelection newContentPane = new RoomSelection();
//		BoardGameTableSelection newContentPane = new BoardGameTableSelection();
		frame.setLocationRelativeTo(null); // 프레임을 화면 가운데에 배치
		newContentPane.setOpaque(true); // content panes must be opaque

<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
<<<<<<< Updated upstream
<<<<<<< Updated upstream

	private static void createAndShowGUI2() {
		// Create and set up the window.
		JFrame frame = new JFrame("RoomSelection");
//		JFrame frame = new JFrame("BoardGameTableSelection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		RoomSelection newContentPane = new RoomSelection();
//		BoardGameTableSelection newContentPane = new BoardGameTableSelection();
		frame.setLocationRelativeTo(null); // 프레임을 화면 가운데에 배치
		newContentPane.setOpaque(true); // content panes must be opaque

=======
	
	
	/*
	private static void createAndShowGUI0() {
		// Create and set up the window.
		JFrame frame = new JFrame("BoardGameTableSelection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		BoardGameTableSelection newContentPane = new BoardGameTableSelection();
		newContentPane.setOpaque(true); // content panes must be opaque
>>>>>>> Stashed changes
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
<<<<<<< Updated upstream
	}

=======
	}*/
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}