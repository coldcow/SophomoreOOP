package bgc;

import javax.swing.JFrame;

import layout.LoginFrame;
import mng.Factory;
import mng.Manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Cafe {
	static Manager<BoardGame> boardGameManager = new Manager<>();
	static Manager<Drink> drinkManager = new Manager<>();
	static Manager<Room> roomManager = new Manager<>();
	public static Manager<User> userManager = new Manager<>();
	public static User user = new User();
	static Room room = new Room();
	static BoardGame boardGame = new BoardGame();
	static Drink drink = new Drink();
	public static Order order;// = new Order(null);
	static String userIdentifier = null;
	static String userPassword = null;
	static int userAge = 0;
	static String roomNumber = null;
	static String boardGameInformation = null;
	static String drinkName = null;
	static int cost = 0;
	static int mileageToUse = 0;

	void run() {
		boardGameManager.readAll(Main.scanFile("boardgame.txt"), new Factory<BoardGame>() {
			public BoardGame create() {
				return new BoardGame();
			}
		});

		drinkManager.readAll(Main.scanFile("drink.txt"), new Factory<Drink>() {
			public Drink create() {
				return new Drink();
			}
		});

		roomManager.readAll(Main.scanFile("room.txt"), new Factory<Room>() {
			public Room create() {
				return new Room();
			}
		});

		/*userManager.readAll(Main.scanFile("user.txt"), new Factory<User>() {
			public User create() {
				return new User();
			}
		});*/

		// 키오스크 시작
		while (true) {
			int menu = 0;
			boolean condition = false;

			HashMap<String, Integer> orderList = null;


			LoginFrame loginFrame = new LoginFrame();
			/*System.out.println("키오스크 종료를 원하시면 0을 입력해주세요.");
			menu = Main.scanner.nextInt();

			if (menu == 0) {
				try {
					BufferedWriter temporary = new BufferedWriter(new FileWriter(new File("user.txt"), false));
					temporary.write("");
					temporary.close();
					break;
				}

				catch (IOException exception) {
					exception.printStackTrace();
				}

				break;
			}
			// 계정 시작
			while (true) {
				if (condition)
					break;
				System.out.println("1. 로그인 2. 회원가입");
				System.out.print("메뉴를 입력하세요: ");
				menu = Main.scanner.nextInt();

				switch (menu) {
				// 계정-로그인 시작
				case 1:
					while (true) {
						System.out.print("아이디를 입력하세요: ");
						user = userManager.find(Main.scanner.next());

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
						userManager.writeAll(new File("user.txt"));
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

				if (room == null) {
					System.out.println("존재하지 않는 방입니다. 다시 입력해주세요.");
					continue;
				}

				if (!room.availability) {
					System.out.println("이미 사용중인 방입니다. 다시 입력해주세요.");
					continue;
				}

				room.availability = false;
				break;
			}
			// 입장 종료
			// 메인 시작
			cost = 0;
			while (true) {
				if (!condition)
					break;
				System.out.println("1. 퇴장 2. 주문 3. 검색 4. 추천");
				System.out.print("메뉴를 입력하세요: ");
				menu = Main.scanner.nextInt();

				switch (menu) {
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
					case 2:
						System.out.println("1. 보드게임 대여 2. 음료 주문");
						System.out.print("메뉴를 입력하세요: ");
						menu = Main.scanner.nextInt();

						switch (menu) {
							// 메인-주문-보드게임 대여 시작
							case 1:
								boardGameManager.printAll();
								System.out.print("대여하실 보드게임을 입력해주세요(end로 종료): ");

								while (true) {
									boardGameInformation = Main.scanner.next();

									if (boardGameInformation.equals("end"))
										break;

									boardGame = boardGameManager.find(boardGameInformation);

									if (boardGame == null) {
										System.out.println("존재하지 않는 보드게임입니다. 다시 입력해주세요.\n");
										continue;
									}

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
										break;

									if (drink == null) {
										System.out.println("존재하지 않는 음료입니다. 다시 입력해주세요.");
										continue;
									}

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
					case 3:
						System.out.println("1. 보드 게임 검색 2. 음료 검색");
						System.out.print("메뉴를 입력하세요: ");
						menu = Main.scanner.nextInt();

						switch (menu) {
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
							default:
								break;
						}

						break;
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
							}
						}

						System.out.print("(1) 보드게임 추천 (2) 음료 추천");
						int numberOfRecomand = Main.scanner.nextInt();

						switch (numberOfRecomand) {
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
					default:
						break;
				}
			}
			// 메인 종료
		}
		// 키오스크 종료
	}

	public static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("RoomSelection");
//		JFrame frame = new JFrame("BoardGameTableSelection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		RoomSelection newContentPane = new RoomSelection();
//		BoardGameTableSelection newContentPane = new BoardGameTableSelection();
		frame.setLocationRelativeTo(null); // 프레임을 화면 가운데에 배치
		//newContentPane.setOpaque(true); // content panes must be opaque

		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
}