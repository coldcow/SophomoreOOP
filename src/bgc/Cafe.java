package bgc;

import javax.swing.JFrame;

import mng.Factory;
import mng.Manager;

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

        // 로그인 메뉴(최상위 메뉴) 시작
        while (true) {
            do {
                UserManager.readAll(Main.openFile("user.txt"), new Factory<User>() {
                    public User create() {
                        return new User();
                    }
                });

                System.out.println("1. 로그인 2. 회원가입");
                System.out.print("메뉴를 입력하세요: ");
                menu = Main.scanner.nextInt();

                switch (menu) {
                    // 로그인 시작
                    case 1:
                        while (true) {
                            System.out.print("아이디를 입력하세요: ");
                            user = UserManager.find(Main.scanner.next());

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
                    //회원가입 종료
                    default:
                        break;
                }

                if (!condition)
                    continue;
                System.out.print("입장하실 방의 번호를 입력하세요: ");
                String numIn = Main.scanner.next();
                if (numIn.equals("end"))
                    break;
                room = RoomManager.find(numIn);

                if (room == null) {
                    System.out.println("존재하지 않는 방입니다. 다시 입력해주세요.");
                    continue;
                }

                if (!room.availability) {
                    System.out.println("이미 사용중인 방입니다. 다시 입력해주세요.");
                    continue;
                }

                room.availability = false;
                menuState = 1;
                break;
            }
            // 입장 종료
            // 메인 메뉴(차상위 메뉴) 시작
            while (menuState != 1);
            int totalPrice = 0;
            while (menuState == 1) {
                System.out.println("1. 퇴장 2. 주문 3. 검색 4. 추천");
                System.out.print("메뉴를 입력하세요: ");
                menu = Main.scanner.nextInt();

                switch (menu) {
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

                            if (room.availability) {
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
                                    room.availability = true;
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
                                    room.availability = true;
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
                    case 2:
                        System.out.println("1. 보드게임 대여 2. 음료 주문");
                        System.out.print("메뉴를 입력하세요: ");
                        menu = Main.scanner.nextInt();

                        switch (menu) {
                            // 보드게임 대여 시작
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
                                        break;

                                    if (drink == null) {
                                        System.out.println("존재하지 않는 음료입니다. 다시 입력해주세요.");
                                        continue;
                                    }
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
                    case 3:
                        System.out.println("1. 보드 게임 검색 2. 음료 검색");
                        System.out.print("메뉴를 입력하세요: ");
                        menu = Main.scanner.nextInt();

                        switch (menu) {
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

                            default:
                                break;
                        }

                        break;
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
                            }
                        }

                        System.out.print("(1) 보드게임 추천 (2) 음료 추천");
                        int numberOfRecomand = Main.scanner.nextInt();

                        switch (numberOfRecomand) {
                            case 1:
                                order.recomand(BoardGameManager.sortMap(boardGameMap));
                                break;
                            case 2:
                                order.recomand(DrinkManager.sortMap(drinkMap));
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
            // 메인 메뉴(차상위 메뉴) 종료
        }
    }


    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("BoardGameTableSelection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        BoardGameTableSelection newContentPane = new BoardGameTableSelection();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}