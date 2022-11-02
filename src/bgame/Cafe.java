package bgame;

import mgr.Factory;
import mgr.Manager;

public class Cafe {
    Manager<BoardGame> BoardGameManager = new Manager<>();
    Manager<Drink> DrinkManager = new Manager<>();
    Manager<Room> RoomManager = new Manager<>();

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
                    while (true) {
                        System.out.print("입장하실 방의 번호를 입력하세요: ");
                        room = RoomManager.find(Main.scanner.next());

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

                    break;

                case 2:
                    while (true) {
                        System.out.print("퇴장하실 방의 번호를 입력하세요: ");
                        String roomNum = Main.scanner.next();
                        if (roomNum.equals("0")) break;

                        room = RoomManager.find(roomNum);

                        if (room == null) {
                            System.out.println("존재하지 않는 방입니다. 다시 입력해주세요.");
                            continue;
                        }

                        if (room.availability) {
                            System.out.println("이미 퇴장 처리된 방입니다. 다시 입력해주세요.");
                            continue;
                        }

                        room.availability = true;
                        break;
                    }
                    break;

                case 3:
                    System.out.println("1. 보드게임 대여 2. 음료 주문");
                    System.out.print("메뉴를 입력하세요: ");
                    menu = Main.scanner.nextInt();

                    switch (menu) {
                        case 1:
                            BoardGameManager.printAll();

                            while (true) {
                                System.out.print("사용하실 보드게임을 입력해주세요: ");
                                BoardGame boardGame = BoardGameManager.find(Main.scanner.next());
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

                                if (drinkName.equals("0")) break;

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

                default:
                    break;
            }
        }
    }
}